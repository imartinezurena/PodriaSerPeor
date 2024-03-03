package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorEmail {
    String rutaMensajes;
    String rutaCorreos;
    ArrayList<ObserverEmail> misObservers = new ArrayList<>();

    public LectorEmail(String rutaMensajes, String rutaCorreos) {
        this.rutaMensajes = rutaMensajes;
        this.rutaCorreos = rutaCorreos;
    }

    public void anadirObserver(ObserverEmail unSuscriptor) {
        misObservers.add(unSuscriptor);
    }

    public void leer() {
        try (BufferedReader readerMensajes = new BufferedReader(new FileReader(rutaMensajes));

                BufferedReader readerDirecciones = new BufferedReader(new FileReader(rutaCorreos));) {

            String lineaMensaje;
            String lineaDireccion;

            while ((lineaMensaje = readerMensajes.readLine()) != null
                    && (lineaDireccion = readerDirecciones.readLine()) != null) {

                for (ObserverEmail listener : misObservers) {
                    listener.indicarCambioDatagram(lineaMensaje, lineaDireccion);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
