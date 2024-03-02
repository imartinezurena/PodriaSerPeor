public class GeneradorCuadrado {

    public static void main(String[] args) {
        // Ejemplo de uso
        generarCuadrado("5 5 @");
    }

    // Método para generar un cuadrado
    public static String generarCuadrado(String formato) {
        StringBuilder miFigura = new StringBuilder();
        String[] datos = formato.split(" ");

        int altura = Integer.valueOf(datos[0]);
        int ancho = Integer.valueOf(datos[1]);
        char caracter = datos[2].charAt(0);

        System.out.println("CreandoFigura");

        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= ancho; j++) {
                if (i == 1 || i == altura) {
                    miFigura.append(caracter);
                } else {
                    if (j == 1 || j == ancho) {
                        miFigura.append(caracter);
                    } else {
                        miFigura.append(" ");
                    }
                }
            }
            miFigura.append("\n");
        }

        return miFigura.toString();

    }
}
