package TCP.TareaMultithread.Tarea1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import TCP.TareaMultithread.Tarea0.HiloClientes;

/*El servidor espera a un cliente, y este al conectarse le manda una cadena. 
Si el servidor recibe como cadena una 'N' envia al cliente un numero aleatroio, 
si recibe cualquier otra cadena nviara un mensaje "no entiendo la peticion" 
y si recibe 'salir' cierra el socket. */
public class ServidorNum {
    public static void main(String[] args) {

        ServerSocket server;

        try {
            server = new ServerSocket(1234);
            while (true) {
                System.out.println("Espero un cliente...");

                // Espera cliente
                Socket socket = server.accept();

                // cada vez que reciba un cliente en el accept le pasa ese socket al constructor
                // del hilo que hemos creado
                // y como implementa runnable se lo podemos pasar al constructor de Thread y lo
                // iniciamos con .star();
                HiloClientesNum miGestor = new HiloClientesNum(socket);
                Thread atencionCliente = new Thread(miGestor);

                atencionCliente.start();
            }
            // socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
