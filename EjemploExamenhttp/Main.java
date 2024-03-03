package EjemploExamenhttp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    private static final int RESOURCE_POSITION = 1;

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(9876)) {
            // Integer.parseInt(args[0])

            Logger logger = new Logger();

            while (true) {
                Socket connCliente = server.accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(connCliente.getInputStream()));

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connCliente.getOutputStream()));

                // Obtener la petición. Por ejemplo: GET /index.html HTTP/1.1
                String peticion = reader.readLine();

                int inicial;
                int cantidad;
                try {

                    // Obtener el recurso (ej: /index.html) y separarlo por "/"
                    String[] argumentosRecurso = extraeRecurso(peticion).split("/");

                    inicial = Integer.parseInt(argumentosRecurso[1]);
                    cantidad = Integer.parseInt(argumentosRecurso[2]);
                } catch (Exception e) {
                    continue;
                }

                PrimosHTTP primosHTTP = new PrimosHTTP(connCliente, inicial, cantidad);
                primosHTTP.addListener(logger);

                String html = generaPagina(primosHTTP);
                writer.write("HTTP/1.1 200 OK\n");
                writer.write("\n");
                writer.write(html);
                writer.flush();
                connCliente.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String extraeRecurso(String header) {
        return header.split(" ")[RESOURCE_POSITION];
    }

    public static String generaPagina(PrimosHTTP primosHTTP) {
        StringBuilder builder = new StringBuilder();
        builder.append("<ul>\n");

        primosHTTP.addListener(primo -> {
            builder.append(String.format("<li> %d </li>\n", primo));
            System.out.println(primo);
        });

        primosHTTP.generarPrimos();

        builder.append("</ul>\n");

        return builder.toString();
    }
}
