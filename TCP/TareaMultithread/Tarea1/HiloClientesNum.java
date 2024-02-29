package TCP.TareaMultithread.Tarea1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

/*El servidor espera a un cliente, y este al conectarse le manda una cadena. 
Si el servidor recibe como cadena una 'N' envia al cliente un numero aleatroio, 
si recibe cualquier otra cadena nviara un mensaje "no entiendo la peticion" 
y si recibe 'salir' cierra el socket. */

public class HiloClientesNum implements Runnable {
    Socket miSocket;

    public HiloClientesNum(Socket misocket) {
        this.miSocket = misocket;
    }

    @Override
    public void run() {
        Random r = new Random();
        System.out.println("\tAtiendo a un cliente ");
        try {
            DataInputStream in = new DataInputStream(miSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(miSocket.getOutputStream());
            while (true) {
                String s = in.readUTF();
                if (s.equals("N")) {
                    out.writeUTF(Integer.toString(r.nextInt(100)));
                } else if (s.equals("salir")) {
                    miSocket.close();
                } else {
                    out.writeUTF("no entiendo la peticion");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
