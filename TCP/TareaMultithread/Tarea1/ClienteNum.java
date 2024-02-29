package TCP.TareaMultithread.Tarea1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*El servidor espera a un cliente, y este al conectarse le manda una cadena. 
Si el servidor recibe como cadena una 'N' envia al cliente un numero aleatroio, 
si recibe cualquier otra cadena nviara un mensaje "no entiendo la peticion" 
y si recibe 'salir' cierra el socket. */
public class ClienteNum {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1234);
            while (true) {
                String frase;
                frase = sc.nextLine();
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                out.writeUTF(frase);
                String s = in.readUTF();
                System.out.println(s);
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
