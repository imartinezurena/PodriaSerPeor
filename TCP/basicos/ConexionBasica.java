package TCP.basicos;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * ConexionBasica
 */
public class ConexionBasica {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1234);// creamos el socket
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());// en este caso el cliente manda, asi
                                                                                  // que el stream es de salida
            out.writeUTF("Hola mundo de los sockets!!!\n");
            out.close();
            socket.close();
            // cerramos los recursos
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}