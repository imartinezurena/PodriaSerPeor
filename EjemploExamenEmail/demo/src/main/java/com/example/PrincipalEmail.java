package com.example;

public class PrincipalEmail {
    public static void main(String[] args) {
        String direccionMensajes = args[0];// "/home/goku/PodriaSerPeor/EjemploExamenEmail/data/mensajes.txt";
        String direccionCorreos = args[1];// "/home/goku/PodriaSerPeor/EjemploExamenEmail/data/dirs.txt";
        String constrasenia = args[2];// "Jamboree2003";
        String usuarioSTMP = args[3];// "imartinezurena@educa.madrid.org";
        LectorEmail miLector = new LectorEmail(direccionMensajes, direccionCorreos);
        EnviadorEmail miEnviador = new EnviadorEmail(miLector, usuarioSTMP, constrasenia);
        miLector.anadirObserver(miEnviador);
        miLector.leer();
    }

}
