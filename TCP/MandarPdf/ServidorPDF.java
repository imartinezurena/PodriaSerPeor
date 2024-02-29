package TCP.MandarPdf;
/*Crea un cliente y un servidor TCP. 
El servidor mandará un fichero PDF a cada cliente que se conecte. 
El PDF estará en el disco del servidor y su ruta estará almacenada en una constante. */

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import TCP.TareaMultithread.Tarea1.HiloClientesNum;

public class ServidorPDF {
    public static final String RUTA_ARCHIVO = "TCP/MandarPdf/Foto.pdf";
    private static int DATABYTE = 1024;

    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(1234);
            while (true) {
                // Espera cliente
                Socket socket = server.accept();

                FileInputStream file_in = new FileInputStream(RUTA_ARCHIVO);
                byte[] fileBytes = file_in.readAllBytes();

                new Thread(() -> {
                    try {
                        OutputStream out = socket.getOutputStream();
                        out.write(fileBytes);
                        socket.close();
                    } catch (Exception e) {
                    }

                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}