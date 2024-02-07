package TCP.MandarDirectorioTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteDirectorio {
    static final int NUMERO_PUERTO = 1234;

    static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket(IP, NUMERO_PUERTO);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String salidaComando = in.readUTF();
            System.out.println(salidaComando);
            out.close();
            in.close();
            socket.close();
            // cerramos los recursos
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
