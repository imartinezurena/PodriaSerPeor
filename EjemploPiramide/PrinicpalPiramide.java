package EjemploPiramide;

public class PrinicpalPiramide {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Faltan parámetros");
            return;
        }

        int puertoEscucha = Integer.parseInt(args[0]);
        int puertoEnvio = Integer.parseInt(args[1]);
        System.out.println("Puerto de escucha: " + puertoEscucha + ", Puerto de envío: " + puertoEnvio);
        ReceptorPiramide receptor = new ReceptorPiramide(puertoEscucha, puertoEnvio);

        EnviadorPiramide enviador = new EnviadorPiramide(puertoEnvio);
        System.out.println("Registrando enviador como listener...");

        receptor.addListener(enviador);
        System.out.println("Comenzando la lectura...");

        receptor.comenzarLectura();
    }

}