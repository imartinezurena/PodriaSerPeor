package TCP.MandarDirectorioTCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorDirectorio {
    static final int NUMERO_PUERTO = 1234;

    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "dir");
        ServerSocket server;
        Socket socket = new Socket();

        try {
            server = new ServerSocket(NUMERO_PUERTO);
            socket = server.accept();

            // creamos el proceso para ejecutar el comando
            Process process = processBuilder.start();
            // Obtener el flujo de entrada del proceso y leerla
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            System.out.println(line);

            // Esperar a que el proceso termine y obtener el código de salida
            int exitCode = process.waitFor();
            while (true) {
                // Espera cliente
                socket = server.accept();// esta llamada es bloqueante

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                // creamos un flujo de entrada y otro de salida por cada iteracion
                // String s = in.readUTF();

                out.writeUTF(line);

                in.close();
                out.close();
                socket.close();

            }

        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
