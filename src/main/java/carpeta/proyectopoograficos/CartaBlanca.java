package carpeta.proyectopoograficos;
import org.json.JSONObject;
public abstract class CartaBlanca {

    private int contadorCarta = 0;
    private String color;
    private String accion;
    private int numeroOriginal=0;

    public CartaBlanca(int contadorCarta, String color, String accion, int numeroOriginal) {//coloque esta estupides para ver xomo resolver el problema de descarte de cartas
        this.contadorCarta = contadorCarta;
        this.color = color;
        this.accion = accion;
        this.numeroOriginal = numeroOriginal;
    }

    public CartaBlanca() {
    }

    public int getNumeroOriginal() {
        return numeroOriginal;
    }

    public void setNumeroOriginal(int numeroOriginal) {
        this.numeroOriginal = numeroOriginal;
    }

    public int getContadorCarta() {
        return contadorCarta;
    }

    public void setContadorCarta(int contadorCarta) {
        this.contadorCarta = contadorCarta;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    // Método abstracto que las subclases implementarán
    public abstract boolean puedeSerJugada(CartaBlanca cartaMontana, int tamanoMazoJugador);

    //Convertir en formato valido para JSON
    public String toJson() {
        JSONObject cartaJson = new JSONObject();
        cartaJson.put("contadorCarta", contadorCarta);
        cartaJson.put("color", color);
        cartaJson.put("accion", accion);
        return cartaJson.toString();
    }
    //Convertir en formato valido para JSON
}
