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
        mostrarCartaInicialEnPila();
        usar.repartirCartas();

        repartirGraficos();
        //agregarCartaInicialAlMazo();


        usarJugador.mostrarBarajaJugador(usar.mazoJugador);

    }


    private void repartirGraficos2() {//para hacer que lo que salga por consola tenga sentido en la pantalla, rojas rojas y asi

        for (int i = 0; i < 7; i++) {
            ImageView nuevoImageView = new ImageView();
            Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazoInicial(i)+".jpg")));
            nuevoImageView.setImage(nuevaCarta);
            nuevoImageView.setOnMouseClicked(event -> descartarCarta(nuevoImageView));
            nuevoImageView.setFitHeight(100);
            nuevoImageView.setFitWidth(50);
            nuevoImageView.setId(desencriptarMazoInicial(i));
            contador++;
            HBOXJugador.getChildren().add(nuevoImageView);
        }
    }
    private void repartirGraficosMazo(){
        ImageView nuevoImageView = new ImageView();
        Image nuevaImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+desencriptarMazo()+".jpg")));
        cartaActual.setImage(nuevaImage);
        HBOXMazo.getChildren().add(cartaActual);
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

    public void agregarCartaInicialAlMazo(){
        ImageView nuevoImageView = new ImageView();
        Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/" + desencriptarMazo() + ".jpg")));
        nuevoImageView.setImage(nuevaCarta);
        nuevoImageView.setOnMouseClicked(event -> descartarCartaMazo(nuevoImageView));
        nuevoImageView.setFitHeight(100);
        nuevoImageView.setFitWidth(50);
        nuevoImageView.setId(String.valueOf(0)); // Asignar el índice como ID
        contador++;
        HBOXJugador.getChildren().add(nuevoImageView);
    }
    // En algún lugar apropiado (por ejemplo, en el método de inicialización):
    /*private void agregarCartaInicialAlMazo() {
        CartaBlanca cartaInicial = usar.mazoJugador.getFirst(); // Toma la primera carta del mazo
        ImageView cartaInicialView = new ImageView();
        Image imagenCartaInicial = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/" + desencriptarMazoInicial(0) + ".jpg")));
        cartaInicialView.setImage(imagenCartaInicial);
        cartaInicialView.setOnMouseClicked(event -> descartarCarta(cartaInicialView)); // Asigna el evento de clic
        cartaInicialView.setFitHeight(100);
        cartaInicialView.setFitWidth(50);
        cartaInicialView.setId(String.valueOf(0)); // Asignar el índice como ID
        contador++;
        HBOXMazo.getChildren().add(cartaInicialView); // Agrega al HBOXMazo
    }*/



    @FXML
    public String desencriptarMazo()
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
            //usarJugador.mostrarBarajaJugador(usar.mazoJugador);

            return nombre;

    }

    @FXML
    public String desencriptarMazoInicial(int i)//una copia cuando iniciamos
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
        //usarJugador.mostrarBarajaJugador(usar.mazoJugador);
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
        String IDCarta=desencriptarMazo();
        ImageView nuevoImageView = new ImageView();
        Image nuevaCarta = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CartasUno/"+IDCarta+".jpg")));
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
     * @author Marco Argonis
     */
    private void descartarCarta2(ImageView carta) {
        int numeroID;
        HBOXJugador.getChildren().remove(carta);
        if (cartaActual != null) {
            HBOXMazo.getChildren().remove(cartaActual);
        }
        cartaActual = carta;
        HBOXMazo.getChildren().add(cartaActual);
        numeroID=cifrarCartas(cartaActual.getId());
        usarJugador.descartarCartasJugador(usar,numeroID);
        usarJugador.mostrarBarajaJugador(usar.mazoJugador);
        System.out.println("Bandera"+numeroID);
        //System.out.println(+"\n");

    }
    private void descartarCarta(ImageView carta) {
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
    }

    private void descartarCartaMazo(ImageView carta) {
        int numeroID = Integer.parseInt(carta.getId());
        usarJugador.descartarCartasMazo(usar, numeroID);
        actualizarIdsCartas(); // Actualizar los IDs después de eliminar una carta

        if (cartaActual != null) {
            HBOXMazo.getChildren().remove(cartaActual);
        }
        cartaActual = carta;
        HBOXMazo.getChildren().add(cartaActual);

        //usarJugador.mostrarBarajaJugador(usar.mazoJugador);
        System.out.println("Bandera " + numeroID);
    }


    private int cifrarCartas(String id) {
        String numero="" ,color="",accion="";
        int resultado = 0;
        int contador=1;

        while(contador!=id.length()){
            if((id.charAt(contador)=='B'||id.charAt(contador)=='R'||id.charAt(contador)=='G'||id.charAt(contador)=='Y'))
            {
                color= String.valueOf(id.charAt(contador));
            }

            if (id.charAt(contador) >= '0' && id.charAt(contador) <= '9'&& id.charAt(contador-1) !='T') {
                numero=String.valueOf(id.charAt(contador));
            }

            if(((id.charAt(contador)=='T')&&(id.charAt(contador+1)=='2'))){
                accion=String.valueOf(id.charAt(contador));
                if(id.charAt(contador)=='T')
                {
                    accion=accion+"2";
                }
            }
            if(id.charAt(contador)=='S'){
                accion=String.valueOf(id.charAt(contador));
            }
            if(id.charAt(contador)=='V'){
                accion=String.valueOf(id.charAt(contador));

            }

            if(id.charAt(contador)=='T'&&(id.charAt(contador+1)=='4'))
            {
                accion=String.valueOf(id.charAt(contador));
                if(id.charAt(contador)=='T')
                {
                    accion=accion+"4";
                }

            }

            if(id.charAt(contador)=='C')
            {
                accion=String.valueOf(id.charAt(contador));

            }

          contador++;
        }


        resultado=usarJugador.rastrearCarta(usar.mazoJugador,numero,color,accion);
        System.out.println("Posicion= "+resultado+"\n");
        usarJugador.mostrarBarajaJugador(usar.mazoJugador);
        System.out.println("\n");
        return resultado;

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




}
