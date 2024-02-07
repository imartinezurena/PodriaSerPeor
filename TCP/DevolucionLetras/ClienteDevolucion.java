package TCP.DevolucionLetras;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ClienteDevolucion
 */
public class ClienteDevolucion {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1234);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF("Hola mundo de los sockets!!!\n");
            String cadenaVuelta = in.readUTF();
            System.out.println(cadenaVuelta);
            out.close();
            in.close();
            socket.close();
            // cerramos los recursos

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // creamos el socket
    }

}