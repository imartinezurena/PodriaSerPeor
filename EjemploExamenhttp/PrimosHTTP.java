package EjemploExamenhttp;

import java.net.Socket;
import java.util.ArrayList;

//esta clase está siendo observada por Logger, cunado un numero sea primo lanza el observer
public class PrimosHTTP {

    Socket socket;
    int inicial;
    int cantidad;

    ArrayList<PrimosListener> listeners;

    PrimosHTTP(Socket socket, int inicial, int cantidad) {
        this.socket = socket;
        this.inicial = inicial;
        this.cantidad = cantidad;
        listeners = new ArrayList<>();
    }

    public interface PrimosListener {
        public void primoEncontrado(int primo);
    }

    public void addListener(PrimosListener listener) {
        listeners.add(listener);
    }

    public void generarPrimos() {
        int n = inicial;
        int restantes = cantidad;
        while (restantes > 0) {
            if (esPrimo(n)) {
                for (PrimosListener listener : listeners) {
                    listener.primoEncontrado(n);
                }
                restantes--;
            }
            n++;
        }
    }

    public boolean esPrimo(int n) {
        if (n == 2 || n == 1) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}