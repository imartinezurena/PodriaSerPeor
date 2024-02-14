package TCP.DevolucionLetras;

/*Crea un cliente y un cliente y servidor TCP.
 El servidor contesta al cliente con el número de consonantes y vocales que tiene el mensaje */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorDevolucion {
    static final int NUMERO_PUERTO = 1234;

    public static void main(String[] args) {
        ServerSocket server;
        Socket socket = new Socket();
        int contadorMinusculas = 0, contadorMayusculas = 0;
        try {
            server = new ServerSocket(NUMERO_PUERTO);
            while (true) {
                // Espera cliente
                socket = server.accept();// esta llamada es bloqueante

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                // creamos un flujo de entrada y otro de salida por cada iteracion
                String s = in.readUTF();
                for (int i = 0; i < s.length(); i++) {
                    Character caracter;
                    caracter = s.charAt(i);
                    if (Character.isLowerCase(caracter)) {
                        contadorMinusculas++;
                    } else if (Character.isUpperCase(caracter)) {
                        contadorMayusculas++;
                    }
                }
                String devuelta = "la frase contenia " + contadorMayusculas + "mayusculas";
                out.writeUTF(devuelta);
                System.out.print("He recibido: " + s);

                in.close();
                out.close();
                socket.close();

            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
