package TCP.MandarPdf;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientePDF {
    private static final String ARCHIVO = "TCP/MandarPdf/FotoRecibida.pdf";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1234);

            InputStream in = socket.getInputStream();
            FileOutputStream fileOut = new FileOutputStream(ARCHIVO);

            int currByte;
            // while ((currByte = in.read()) != -1) {
            // fileOut.write(currByte);
            // }TODO asi se hace byte por byte
            fileOut.write(in.readAllBytes());
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
