//esta clase observa al receptor y cuando recibe manda por broadcast el cuadrado

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Enviador implements IObserverDatagrama {
    int puertoEnvio;
    DatagramSocket socketBroadcast;

    public Enviador(int puertoEnvio) {
        try {
            socketBroadcast = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.puertoEnvio = puertoEnvio;
    }

    // este metodo es lo que hace cuando hay un cambio en el receptor
    @Override
    public void indicarCambioDatagram(String datosFigura) {
        String cuadrado = GeneradorCuadrado.generarCuadrado(datosFigura);
        enviar(cuadrado);

    }

    public void enviar(String cuadrado) {
        try {
            socketBroadcast.setBroadcast(true);
            byte buffer[] = cuadrado.getBytes();
            String ip = "192.168.1.255";
            DatagramPacket paquete = new DatagramPacket(
                    buffer,
                    buffer.length,
                    InetAddress.getByName(ip),
                    puertoEnvio);

            socketBroadcast.send(paquete);
            System.out.println("Figura enviada");
            // socketBroadcast.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
