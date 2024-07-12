package carpeta.proyectopoograficos;

public class CartaComodin extends CartaBlanca{

    public CartaComodin(int contadorCarta, String color, String accion, int numeroOriginal) {
        super(contadorCarta, color, accion,numeroOriginal);
    }

    public CartaComodin() {
    }
    
    @Override 
    public boolean puedeSerJugada(CartaBlanca cartaMontana, int tamanoMazoJugador) {
        return tamanoMazoJugador > 1;
    }
}
