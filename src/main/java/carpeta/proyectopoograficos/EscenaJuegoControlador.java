package carpeta.proyectopoograficos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.util.LinkedList;
import java.util.Objects;



public class EscenaJuegoControlador {
    public ImageView carta1;
    public ImageView carta2;
    public ImageView carta3;
    public ImageView carta4;
    public ImageView carta5;
    public ImageView carta6;
    public ImageView carta7;
    public ImageView carta8;
    public ImageView descarte;
    public ImageView carta9;
    public ImageView carta11;
    public ImageView carta12;
    public ImageView carta10;
    public ImageView carta13;
    public ImageView carta14;
    public ImageView carta15;
    public ImageView carta16;
    public ImageView carta17;
    public ImageView carta18;
    public ImageView carta19;
    public ImageView carta20;
    LinkedList<ImageView> mazo = new LinkedList<ImageView>();

    ControlCartas usar = new ControlCartas();
    ApartadoJugador usarJugador = new ApartadoJugador();

    private int contador = 0;

    @FXML
    private void initialize() {//esto inicialiamos un juego estandar, osea 7 cartas
        usar.crearCartas();
        usar.barajearBarajaDeCartas();
        usar.repartirCartas();
        Image image;
        mazo.add(carta1);
        mazo.add(carta2);
        mazo.add(carta3);
        mazo.add(carta4);
        mazo.add(carta5);
        mazo.add(carta6);
        mazo.add(carta7);
        mazo.add(carta8);
        mazo.add(carta9);
        mazo.add(carta10);
        mazo.add(carta11);
        mazo.add(carta12);
        mazo.add(carta13);
        mazo.add(carta14);
        mazo.add(carta15);
        mazo.add(carta16);
        mazo.add(carta17);
        mazo.add(carta18);
        mazo.add(carta19);
        mazo.add(carta20);

        mazo.get(0).setImage(image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazo()+".jpg"))));
        mazo.get(1).setImage(image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazo()+".jpg"))));
        mazo.get(2).setImage(image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazo()+".jpg"))));
        mazo.get(3).setImage(image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazo()+".jpg"))));
        mazo.get(4).setImage(image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazo()+".jpg"))));
        mazo.get(5).setImage(image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazo()+".jpg"))));
        mazo.get(6).setImage(image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazo()+".jpg"))));

    }


    @FXML
    public String desencriptarMazo() {
        String nombre = "";

        if (usar.mazo.get(0).getAccion() == null) {
            nombre = "C" + usar.mazo.get(0).getColor() + usar.mazo.get(0).getContadorCarta();
        }

        if (usar.mazo.get(0).getAccion() != null && usar.mazo.get(0).getAccion() != "T4" && usar.mazo.get(0).getAccion() != "C") {
            nombre = "C" + usar.mazo.get(0).getColor() + usar.mazo.get(0).getAccion();
        }

        if (usar.mazo.get(0).getAccion() == "T4" || usar.mazo.get(0).getAccion() == "C") {
            nombre = "C" + usar.mazo.get(0).getAccion();
        }
        usarJugador.robarCartasJugador(usar);
        //usarJugador.mostrarBarajaJugador(usar.mazoJugador);

        return nombre;

    }

    @FXML
    public String desencriptarMazoInicial(int i)//una copia cuando iniciamos
    {
        String nombre = "";

        if (usar.mazoJugador.get(i).getAccion() == null) {
            nombre = "C" + usar.mazoJugador.get(i).getColor() + usar.mazoJugador.get(i).getContadorCarta();
        }

        if (usar.mazoJugador.get(i).getAccion() != null && usar.mazoJugador.get(i).getAccion() != "T4" && usar.mazoJugador.get(i).getAccion() != "C") {
            nombre = "C" + usar.mazoJugador.get(i).getColor() + usar.mazoJugador.get(i).getAccion();
        }

        if (usar.mazoJugador.get(i).getAccion() == "T4" || usar.mazoJugador.get(i).getAccion() == "C") {
            nombre = "C" + usar.mazoJugador.get(i).getAccion();
        }
        return nombre;

    }

    public void rellenar() {
        int contador=0;
        Image image;
        while(contador!=20)
        {
            if(mazo.get(contador).getImage()==null)
            {
                mazo.get(contador).setImage(image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazo()+".jpg"))));
                break;
            }

            contador++;
        }
    }

    public void descartar0() {
        if (mazo.get(0).getImage() != null) {
            descarte.setImage(mazo.get(0).getImage());
            mazo.get(0).setImage(null);
        }
    }

    public void descartar1() {
        if (mazo.get(1).getImage() != null) {
            descarte.setImage(mazo.get(1).getImage());
            mazo.get(1).setImage(null);
        }

    }

    public void descartar2() {
        if (mazo.get(2).getImage() != null) {
            descarte.setImage(mazo.get(2).getImage());
            mazo.get(2).setImage(null);
        }

    }

    public void descartar3() {
        if (mazo.get(3).getImage() != null) {
            descarte.setImage(mazo.get(3).getImage());
            mazo.get(3).setImage(null);
        }

    }

    public void descartar4() {
        if (mazo.get(4).getImage() != null) {
            descarte.setImage(mazo.get(4).getImage());
            mazo.get(4).setImage(null);
        }

    }

    public void descartar5() {
        if (mazo.get(5).getImage() != null) {
            descarte.setImage(mazo.get(5).getImage());
            mazo.get(5).setImage(null);
        }

    }

    public void descartar6() {
        if (mazo.get(6).getImage() != null) {
            descarte.setImage(mazo.get(6).getImage());
            mazo.get(6).setImage(null);
        }

    }

    public void descartar7() {
        if (mazo.get(7).getImage() != null) {
            descarte.setImage(mazo.get(7).getImage());
            mazo.get(7).setImage(null);
        }

    }

    public void descartar8() {
        if (mazo.get(8).getImage() != null) {
            descarte.setImage(mazo.get(8).getImage());
            mazo.get(8).setImage(null);
        }

    }

    public void descartar9() {
        if (mazo.get(9).getImage() != null) {
            descarte.setImage(mazo.get(9).getImage());
            mazo.get(9).setImage(null);
        }

    }

    public void descartar10() {
        if (mazo.get(10).getImage() != null) {
            descarte.setImage(mazo.get(10).getImage());
            mazo.get(10).setImage(null);
        }

    }

    public void descartar11() {
        if (mazo.get(11).getImage() != null) {
            descarte.setImage(mazo.get(11).getImage());
            mazo.get(11).setImage(null);
        }

    }

    public void descartar12() {
        if (mazo.get(12).getImage() != null) {
            descarte.setImage(mazo.get(12).getImage());
            mazo.get(12).setImage(null);
        }
    }

    public void descartar13() {
        if (mazo.get(13).getImage() != null) {
            descarte.setImage(mazo.get(13).getImage());
            mazo.get(13).setImage(null);
        }

    }

    public void descartar14() {
        if (mazo.get(14).getImage() != null) {
            descarte.setImage(mazo.get(14).getImage());
            mazo.get(14).setImage(null);
        }

    }

    public void descartar15() {
        if (mazo.get(15).getImage() != null) {
            descarte.setImage(mazo.get(15).getImage());
            mazo.get(15).setImage(null);
        }

    }

    public void descartar16() {
        if (mazo.get(16).getImage() != null) {
            descarte.setImage(mazo.get(16).getImage());
            mazo.get(16).setImage(null);
        }

    }

    public void descartar17() {
        if (mazo.get(17).getImage() != null) {
            descarte.setImage(mazo.get(17).getImage());
            mazo.get(17).setImage(null);
        }

    }

    public void descartar18() {
        if (mazo.get(18).getImage() != null) {
            descarte.setImage(mazo.get(18).getImage());
            mazo.get(18).setImage(null);
        }

    }

    public void descartar19() {
        if (mazo.get(19).getImage() != null) {
            descarte.setImage(mazo.get(19).getImage());
            mazo.get(19).setImage(null);
        }

    }
}