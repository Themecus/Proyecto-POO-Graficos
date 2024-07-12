package carpeta.proyectopoograficos;

public class CartaNumerica extends CartaBlanca {

    public CartaNumerica(int contadorCarta, String color, String accion, int numeroOriginal) {
        super(contadorCarta, color, accion,numeroOriginal);
    }

    public CartaNumerica() {
    }

    @Override
    public boolean puedeSerJugada(CartaBlanca cartaMontana, int tamanoMazoJugador) {
        return this.getColor().equals(cartaMontana.getColor()) || this.getContadorCarta() == cartaMontana.getContadorCarta();
    }
}