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
    @FXML HBox HBOXRival;
    private ImageView cartaActual;
    public Button btoRobar;

    ControlCartas usar = new ControlCartas();
    ApartadoJugador usarJugador = new ApartadoJugador();
    ApartadoRival usarRival = new ApartadoRival();

    private int contador = 0;

    @FXML
    private void initialize() {
        usar.crearCartas();
        usar.barajearBarajaDeCartas();
        mostrarCartaInicialEnPila();
        usar.repartirCartas();

        repartirGraficos();
        repartirGraficosRival();

        usarJugador.mostrarBarajaJugador(usar.mazoJugador);
        System.out.println();
        usarRival.mostrarBarajaRival(usar.mazoRival);
    }


    private void repartirGraficos2() {//para hacer que lo que salga por consola tenga sentido en la pantalla, rojas rojas y asi

        for (int i = 0; i < 7; i++) {
            ImageView nuevoImageView = new ImageView();
            Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/" + desencriptarMazoInicial(i) + ".jpg")));
            nuevoImageView.setImage(nuevaCarta);
            nuevoImageView.setOnMouseClicked(event -> descartarCarta(nuevoImageView));
            nuevoImageView.setFitHeight(100);
            nuevoImageView.setFitWidth(50);
            nuevoImageView.setId(desencriptarMazoInicial(i));
            contador++;
            HBOXJugador.getChildren().add(nuevoImageView);
        }
    }

    private void repartirGraficos() {
        for (int i = 0; i < 7; i++) {
            ImageView nuevoImageView = new ImageView();
            Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/" + desencriptarMazoInicial(i) + ".jpg")));
            nuevoImageView.setImage(nuevaCarta);
            nuevoImageView.setOnMouseClicked(event -> descartarCarta(nuevoImageView));
            nuevoImageView.setFitHeight(100);
            nuevoImageView.setFitWidth(50);
            nuevoImageView.setId(String.valueOf(i)); // Asignar el índice como ID
            contador++;
            HBOXJugador.getChildren().add(nuevoImageView);
        }
    }
    private void repartirGraficosRival5() {
        for (int i = 0; i < 7; i++) {
            ImageView nuevoImageView = new ImageView();
            Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/ReversoCarta.jpg")));
            nuevoImageView.setImage(nuevaCarta);
            nuevoImageView.setFitHeight(100);
            nuevoImageView.setFitWidth(50);
            nuevoImageView.setId(String.valueOf(i));
            HBOXRival.getChildren().add(nuevoImageView);
        }
    }

    private void repartirGraficosRival() {
        for (int i = 0; i < usar.mazoRival.size(); i++) {
            ImageView nuevoImageView = new ImageView();
            Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/ReversoCarta.jpg")));
            nuevoImageView.setImage(nuevaCarta);
            nuevoImageView.setFitHeight(100);
            nuevoImageView.setFitWidth(50);
            nuevoImageView.setId(String.valueOf(i));
            HBOXRival.getChildren().add(nuevoImageView);
        }
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
        //usarJugador.mostrarBarajaJugador(usar.mazoJugador);
        return nombre;

    }

    /**
     * Metodo para robar cartas pero de manera dinamica, es la version 2, funciona de la siguiente manera,
     * primero creas un ImageView, para efectos practicos, llamado nuevoImageView, luego se configura la ruta creando
     * un objeto Image llamado nuevaCarta, que tiene de diferente? que se agrega una accion a la carta
     * por ultimo se agrega al HBox que es el HBox del jugador, es igual al anterior pero se le agrega lo de la accion
     * en las cartas dinamicas
     *
     * @author Marco Argonis
     */
    @FXML
    private void robar2() {
        String IDCarta = desencriptarMazo();
        ImageView nuevoImageView = new ImageView();
        Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/" + IDCarta + ".jpg")));
        nuevoImageView.setImage(nuevaCarta);
        nuevoImageView.setOnMouseClicked(event -> descartarCarta(nuevoImageView));
        nuevoImageView.setFitHeight(100);
        nuevoImageView.setFitWidth(50);
        nuevoImageView.setId(IDCarta);
        contador++;
        HBOXJugador.getChildren().add(nuevoImageView);
    }

    @FXML
    private void robar() {


        // Obtener la ID de la nueva carta robada
        String IDCarta = desencriptarMazo();
        ImageView nuevoImageView = new ImageView();
        Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/" + IDCarta + ".jpg")));
        nuevoImageView.setImage(nuevaCarta);
        nuevoImageView.setOnMouseClicked(event -> descartarCarta(nuevoImageView));
        nuevoImageView.setFitHeight(100);
        nuevoImageView.setFitWidth(50);
        nuevoImageView.setId(String.valueOf(HBOXJugador.getChildren().size())); // Asignar el índice actual como ID
        HBOXJugador.getChildren().add(nuevoImageView);

        usarJugador.mostrarBarajaJugador(usar.mazoJugador); // Mostrar el mazo actualizado por consola
    }


    /**
     * El metodo descartar cartas pero mejorado, ya que la carta que elimine la agrega en HBOXMazo, con la
     * peculiaridad que reemplaza la que ya este
     * Primero eliminas la carta del HBox jugador, y haces un si condicional para varificar si hay una carta ahi
     * en el HBOXMazo, si no hay, solo hace add, si la hay, un remove
     *
     * @author Marco Argonis
     */

    /*private void descartarCarta(ImageView carta) {
        int numeroID = Integer.parseInt(carta.getId());
        usarJugador.descartarCartasJugador(usar, numeroID);
        HBOXJugador.getChildren().remove(carta);
        actualizarIdsCartas(); // Actualizar los IDs después de eliminar una carta

        if (cartaActual != null) {
            HBOXMazo.getChildren().remove(cartaActual);
        }
        cartaActual = carta;
        HBOXMazo.getChildren().add(cartaActual);

        usarJugador.mostrarBarajaJugador(usar.mazoJugador);
        System.out.println("Bandera " + numeroID);
    }*/
    private void descartarCarta3(ImageView cartaView) {
        int numeroID = Integer.parseInt(cartaView.getId());
        CartaBlanca cartaSeleccionada = usar.mazoJugador.get(numeroID);
        CartaBlanca cartaActualMontana = usar.mazoMontana.peekFirst(); // Obtener la carta actual en la montaña

        // Verificar si la carta seleccionada puede ser jugada
        if (!cartaSeleccionada.puedeSerJugada(cartaActualMontana, usar.mazoJugador.size())) {
            // Mostrar un mensaje de error o feedback al jugador, pero solo lo manda por consola
            System.out.println("No puedes jugar esta carta.");
            return;
        }

        // Proceder a descartar la carta
        usarJugador.descartarCartasJugador(usar, numeroID);
        HBOXJugador.getChildren().remove(cartaView);
        actualizarIdsCartas(); // Actualizar los IDs después de eliminar una carta

        if (cartaActual != null) {
            HBOXMazo.getChildren().remove(cartaActual);
        }
        cartaActual = cartaView;
        HBOXMazo.getChildren().add(cartaActual);

        usarJugador.mostrarBarajaJugador(usar.mazoJugador);
        System.out.println("Bandera " + numeroID);
    }
    private void descartarCarta4(ImageView cartaView) {
        int numeroID = Integer.parseInt(cartaView.getId());
        CartaBlanca cartaSeleccionada = usar.mazoJugador.get(numeroID);
        CartaBlanca cartaActualMontana = usar.mazoMontana.peekFirst(); // Obtener la carta actual en la montaña

        // Verificar si la carta seleccionada puede ser jugada
        if (!puedeSerJugada(cartaSeleccionada, cartaActualMontana)) {
            // Mostrar un mensaje de error o feedback al jugador, pero solo lo manda por consola
            System.out.println("No puedes jugar esta carta.");
            return;
        }

        // Proceder a descartar la carta
        usarJugador.descartarCartasJugador(usar, numeroID);
        HBOXJugador.getChildren().remove(cartaView);
        actualizarIdsCartas(); // Actualizar los IDs después de eliminar una carta

        if (cartaActual != null) {
            HBOXMazo.getChildren().remove(cartaActual);
        }
        cartaActual = cartaView;
        HBOXMazo.getChildren().add(cartaActual);
        usar.mazoMontana.addFirst(cartaSeleccionada); // Añadir la carta a la pila

        usarJugador.mostrarBarajaJugador(usar.mazoJugador);
        System.out.println("Bandera " + numeroID);
    }
    private void descartarCarta(ImageView cartaView) {
        int numeroID = Integer.parseInt(cartaView.getId());
        CartaBlanca cartaSeleccionada = usar.mazoJugador.get(numeroID);
        CartaBlanca cartaActualMontana = usar.mazoMontana.peekFirst();

        if (!puedeSerJugada(cartaSeleccionada, cartaActualMontana)) {
            System.out.println("No puedes jugar esta carta.");
            return;
        }

        usarJugador.descartarCartasJugador(usar, numeroID);
        HBOXJugador.getChildren().remove(cartaView);
        actualizarIdsCartas();

        if (cartaActual != null) {
            HBOXMazo.getChildren().remove(cartaActual);
        }
        cartaActual = cartaView;
        HBOXMazo.getChildren().add(cartaActual);
        usar.mazoMontana.addFirst(cartaSeleccionada);

        usarJugador.mostrarBarajaJugador(usar.mazoJugador);
        System.out.println("Bandera " + numeroID);

        // Si la carta jugada requiere que el rival tome dos cartas
        if (cartaSeleccionada.getAccion() != null && cartaSeleccionada.getAccion().equals("T2")) {
            tomaDosCartasRival();
            usarRival.mostrarBarajaRival(usar.mazoRival);
        }
    }



    private void actualizarIdsCartas() {
        for (int i = 0; i < HBOXJugador.getChildren().size(); i++) {
            ImageView carta = (ImageView) HBOXJugador.getChildren().get(i);
            carta.setId(String.valueOf(i));
        }
    }

  /*  private void mostrarCartaInicialEnPila() {
        ImageView nuevoImageView = new ImageView();
        Image cartaInicial = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/" + desencriptarMazo() + ".jpg")));
        nuevoImageView.setImage(cartaInicial);
        nuevoImageView.setFitHeight(100);
        nuevoImageView.setFitWidth(50);
        cartaActual = nuevoImageView;
        HBOXMazo.getChildren().add(cartaActual);
    }*/
  private void mostrarCartaInicialEnPila() {
      CartaBlanca cartaInicial;
      do {
          cartaInicial = usar.mazo.remove(0); // Remover la primera carta del mazo
          usar.mazo.add(cartaInicial); // Añadirla al final del mazo
      } while (cartaInicial instanceof CartaAccion || cartaInicial instanceof CartaComodin);

      usar.mazoMontana.addFirst(cartaInicial); // Añadir la carta válida a la montaña

      ImageView nuevoImageView = new ImageView();
      Image cartaImagen = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/" + getCartaNombre(cartaInicial) + ".jpg")));
      nuevoImageView.setImage(cartaImagen);
      nuevoImageView.setFitHeight(100);
      nuevoImageView.setFitWidth(50);
      cartaActual = nuevoImageView;
      HBOXMazo.getChildren().add(cartaActual);
  }

    private String getCartaNombre(CartaBlanca carta) {
        String nombre = "";
        if (carta.getAccion() == null) {
            nombre = "C" + carta.getColor() + carta.getContadorCarta();
        } else if (!carta.getAccion().equals("T4") && !carta.getAccion().equals("C")) {
            nombre = "C" + carta.getColor() + carta.getAccion();
        } else if (carta.getAccion().equals("T4") || carta.getAccion().equals("C")) {
            nombre = "C" + carta.getAccion();
        }
        return nombre;
   }

    private boolean puedeSerJugada(CartaBlanca cartaSeleccionada, CartaBlanca cartaActualMontana) {
        if (cartaSeleccionada.getColor().equals(cartaActualMontana.getColor()) ||
                (cartaSeleccionada.getAccion() != null && cartaSeleccionada.getAccion().equals(cartaActualMontana.getAccion())) ||
                (cartaSeleccionada.getAccion() == null && cartaSeleccionada.getContadorCarta() == cartaActualMontana.getContadorCarta()) ||
                (cartaSeleccionada instanceof CartaComodin)) {
            return true;
        }
        return false;
    }
    @FXML
    public void tomaDosCartasRival() {
        int tomar = 0;

        while (tomar != 2) {
            CartaBlanca n2 = usar.mazo.get(0);
            usar.mazoRival.add(n2);
            usar.mazo.remove(n2);
            tomar++;

            // Crear el ImageView para la nueva carta del rival
            ImageView nuevoImageView = new ImageView();
            Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/ReversoCarta.jpg")));
            nuevoImageView.setImage(nuevaCarta);
            nuevoImageView.setFitHeight(100);
            nuevoImageView.setFitWidth(50);
            HBOXRival.getChildren().add(nuevoImageView);
        }

    }



}
