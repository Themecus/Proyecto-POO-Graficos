package carpeta.proyectopoograficos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.Objects;

public class EscenaJuegoControlador {

    @FXML
    private HBox HBOXJugador;
    @FXML
    private HBox HBOXMazo;
    private ImageView cartaActual;
    public Button btoRobar;

    ControlCartas usar = new ControlCartas();
    ApartadoJugador usarJugador= new ApartadoJugador();

    private int contador=0;
    @FXML
    private void initialize() {//esto inicialiamos un juego estandar, osea 7 cartas
        usar.crearCartas();
        usar.barajearBarajaDeCartas();
        usar.repartirCartas();
        repartirGraficos();
    }

    private void repartirGraficos() {//para hacer que lo que salga por consola tenga sentido en la pantalla, rojas rojas y asi

        for (int i = 0; i < 7; i++) {
            ImageView nuevoImageView = new ImageView();
            Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazo2(i)+".jpg")));
            nuevoImageView.setImage(nuevaCarta);
            nuevoImageView.setOnMouseClicked(event -> descartarCarta2(nuevoImageView));
            nuevoImageView.setFitHeight(100);
            nuevoImageView.setFitWidth(50);
            nuevoImageView.setId(""+contador);
            contador++;
            HBOXJugador.getChildren().add(nuevoImageView);
        }
    }


    @FXML
    public String desencriptarMazo()//esto es clave para saber que graficos usar para las cartas
    {
        String nombre = "";

            if (usar.mazo.get(0).getAccion() == null) {
                nombre="C"+usar.mazo.get(0).getColor()+usar.mazo.get(0).getContadorCarta();
            }

            if (usar.mazo.get(0).getAccion() != null && usar.mazo.get(0).getAccion() != "T4" && usar.mazo.get(0).getAccion() != "C") {
                nombre="C"+usar.mazo.get(0).getColor()+usar.mazo.get(0).getAccion();
            }

            if (usar.mazo.get(0).getAccion() == "T4" || usar.mazo.get(0).getAccion() == "C") {
                nombre="C"+usar.mazo.get(0).getAccion();
            }
            usarJugador.robarCartasJugador(usar);
            usarJugador.mostrarBarajaJugador(usar.mazoJugador);
            System.out.println("\n");
            return nombre;

    }

    @FXML
    public String desencriptarMazo2(int i)//una copia cuando iniciamos
    {
        String nombre = "";

        if (usar.mazoJugador.get(i).getAccion() == null) {
            nombre="C"+usar.mazoJugador.get(i).getColor()+usar.mazoJugador.get(i).getContadorCarta();
        }

        if (usar.mazoJugador.get(i).getAccion() != null && usar.mazoJugador.get(i).getAccion() != "T4" && usar.mazoJugador.get(i).getAccion() != "C") {
            nombre="C"+usar.mazoJugador.get(i).getColor()+usar.mazoJugador.get(i).getAccion();
        }

        if (usar.mazoJugador.get(i).getAccion() == "T4" || usar.mazoJugador.get(i).getAccion() == "C") {
            nombre="C"+usar.mazoJugador.get(i).getAccion();
        }
        usarJugador.mostrarBarajaJugador(usar.mazoJugador);
        System.out.println("\n");
        return nombre;

    }

    /**
     * Metodo para robar cartas pero de manera dinamica, es la version 2, funciona de la siguiente manera,
     * primero creas un ImageView, para efectos practicos, llamado nuevoImageView, luego se configura la ruta creando
     * un objeto Image llamado nuevaCarta, que tiene de diferente? que se agrega una accion a la carta
     * por ultimo se agrega al HBox que es el HBox del jugador, es igual al anterior pero se le agrega lo de la accion
     * en las cartas dinamicas
     * @author Marco Argonis
     */
    @FXML
    private void robar2() {
        ImageView nuevoImageView = new ImageView();
        Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazo()+".jpg")));
        nuevoImageView.setImage(nuevaCarta);
        nuevoImageView.setOnMouseClicked(event -> descartarCarta2(nuevoImageView));
        nuevoImageView.setFitHeight(100);
        nuevoImageView.setFitWidth(50);
        nuevoImageView.setId(""+contador);
        contador++;
        HBOXJugador.getChildren().add(nuevoImageView);
    }



    /**
     * El metodo descartar cartas pero mejorado, ya que la carta que elimine la agrega en HBOXMazo, con la
     * peculiaridad que reemplaza la que ya este
     * Primero eliminas la carta del HBox jugador, y haces un si condicional para varificar si hay una carta ahi
     * en el HBOXMazo, si no hay, solo hace add, si la hay, un remove
     * @author Marco Argonis
     */
    private void descartarCarta2(ImageView carta) {
        HBOXJugador.getChildren().remove(carta);
        if (cartaActual != null) {
            HBOXMazo.getChildren().remove(cartaActual);
        }
        cartaActual = carta;
        HBOXMazo.getChildren().add(cartaActual);
        usarJugador.descartarCartasJugador(Integer.parseInt(cartaActual.getId()),usar);
        usarJugador.mostrarBarajaJugador(usar.mazoJugador);
        System.out.println("\n");
//aqui tenemos un problema, ya que, como demonios hacemos para que la carta que se elimine en la ventana, concuerde con el que se elimina en codigo?
    }
}
