package TCP.MandarDirectorioTCP;

/*Crea un cliente y un servidor TCP. El servidor manda al cliente el listado del directorio /var/files/ como un String.
 Se puede hacer con el comando ls y ProcessBuilder
 o con las clases de Java para procesar ficheros y directorios */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class ClienteDirectorio {
    static final int NUMERO_PUERTO = 1234;

    static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket(IP, NUMERO_PUERTO);
            // creo que el output stream no hace falta
            // DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String salidaComando = "";
            try {
                while (salidaComando != null) {
                    salidaComando = in.readUTF();
                }
            } catch (EOFException e) {
                // TODO: handle exception
            }

            System.out.println(salidaComando);
            // out.close();
            in.close();
            socket.close();
            // cerramos los recursos
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
