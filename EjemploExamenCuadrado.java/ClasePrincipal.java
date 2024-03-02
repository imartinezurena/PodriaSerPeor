
public class ClasePrincipal {

    public static void main(String[] args) {
        int puertoEscucha = 9876;// Integer.valueOf(args[0]);
        int puertoEnvio = 9875;// Integer.valueOf(args[1]);

        Receptor miReceptor = new Receptor(puertoEscucha);
        Enviador miEnviador = new Enviador(puertoEnvio);
        miReceptor.setCambioDatagramaListener(miEnviador);
        while (miReceptor.recibir())
            ;
    }

}