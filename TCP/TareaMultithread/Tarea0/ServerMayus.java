package TCP.TareaMultithread.Tarea0;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * El servidor crea un hilo por cada cliente para gestionar: 
 * la lectura del mensaje, convertirlo a mayuculas y finalmente devolverlo al cliente. 
 * Deben poder conectarse dos clientes o más. 
 * (Añadido el cliente envia infinitos mensajes)
 */
public class ServerMayus {
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
                HiloClientes miGestor = new HiloClientes(socket);
                Thread atencionCliente = new Thread(miGestor);

                atencionCliente.start();
            }
            // socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
