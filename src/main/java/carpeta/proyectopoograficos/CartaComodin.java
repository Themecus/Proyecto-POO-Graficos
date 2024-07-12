package carpeta.proyectopoograficos;

public class CartaComodin extends CartaBlanca{

    public CartaComodin(int contadorCarta, String color, String accion) {
        super(contadorCarta, color, accion);
    }

    public CartaComodin() {
    }
    
    @Override 
    public boolean puedeSerJugada(CartaBlanca cartaMontana, int tamanoMazoJugador) {
        return tamanoMazoJugador > 1;
    }
}
