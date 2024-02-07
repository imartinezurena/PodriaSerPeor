package TCP.basicos;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorBasico {
    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(1234);// creamos un socket

            while (true) {
                // Espera cliente
                Socket socket = server.accept();// esta llamada es bloqueante

                DataInputStream in = new DataInputStream(socket.getInputStream());// creamos
                // DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                /*
                 * String s = in.readLine();
                 * for (int x = 0; x < 32000; x++) {
                 * for (int i = 0; i < 1000; i++) {
                 * out.writeUTF(x + s.toUpperCase());
                 * }
                 * }
                 */
                System.out.print("He recibido: " + in.readUTF());

                in.close();
                // out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
