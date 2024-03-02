package EjemploExamenEmail.demo.src.main.java.com.example;

public class PrincipalEmail {
    public static void main(String[] args) {
        String direccionMensajes = args[0];
        String direccionCorreos = args[1];
        String constrasenia = args[2];
        String usuarioSTMP = args[3];
        LectorEmail miLector = new LectorEmail(direccionMensajes, direccionCorreos);
        EnviadorEmail miEnviador = new EnviadorEmail(miLector, usuarioSTMP, constrasenia);
        miLector.anadirObserver(miEnviador);
        miLector.leer();
    }

}
