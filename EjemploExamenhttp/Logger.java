package EjemploExamenhttp;

import java.io.FileWriter;

import EjemploExamenhttp.PrimosHTTP.PrimosListener;

public class Logger implements PrimosListener {

    private static final String RUTA_LOG = "/home/goku/PodriaSerPeor/EjemploExamenhttp/texto.txt";

    @Override
    public void primoEncontrado(int primo) {

        try (FileWriter writer = new FileWriter(RUTA_LOG, true)) {
            writer.write(Integer.toString(primo));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}