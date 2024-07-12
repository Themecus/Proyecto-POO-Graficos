package carpeta.proyectopoograficos;

public class CartaAccion extends  CartaBlanca{

    public CartaAccion(int contadorCarta, String color, String accion, int numeroOriginal) {
        super(contadorCarta, color, accion,numeroOriginal);
    }

    public CartaAccion() {
    }

    @Override
    public boolean puedeSerJugada(CartaBlanca cartaMontana, int tamanoMazoJugador) {
        return (this.getColor().equals(cartaMontana.getColor()))&&(tamanoMazoJugador>1);
    }
    
}