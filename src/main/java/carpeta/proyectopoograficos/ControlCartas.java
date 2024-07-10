package carpeta.proyectopoograficos;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ControlCartas {
    LinkedList<CartaBlanca> mazo = new LinkedList<CartaBlanca>();
    LinkedList<CartaBlanca> mazoMontana = new LinkedList<CartaBlanca>();
    LinkedList<CartaBlanca> mazoJugador = new LinkedList<CartaBlanca>();
    LinkedList<CartaBlanca> mazoRival = new LinkedList<CartaBlanca>();
    private Scanner entrada = new Scanner(System.in);

    /**
     * Este método se encarga de crear las 108 cartas del juego, con sus comodines, cartas de accion y numericas
     * moviendose por cada metodo dedicado a cada tipo de carta
     *
     * @author Miguel Canache
     */


    public void crearCartas() {
        // Crear cartas numéricas y de acción
        for (String color : new String[]{"Y", "B", "R", "G"}) {
            crearCartaNumerica(color);
            crearCartaAccion(color, "V");
            crearCartaAccion(color, "S");
            crearCartaAccion(color, "CT2");
        }
        // Crear cartas comodín
        crearCartaComodin("CC");
        crearCartaComodin("CT4");
    }

    /**
     * Crea las cartas numericas, siendo desde 0-9
     *
     * @param color le da su color a la carta
     * @author Miguel Canache
     */

    private void crearCartaNumerica(String color) {
        for (int i = 0; i < 10; i++) {
            CartaNumerica cartaAgregable = new CartaNumerica();
            cartaAgregable.setContadorCarta(i);
            cartaAgregable.setColor(color);
            if (i > 0) guardarCartas(cartaAgregable);
            ;
        }
    }

    /**
     * Crea las cartas accion, incluyendo los toma 2, anular turno y reversa
     *
     * @param color  le da su color a la carta
     * @param accion le agrega lo que hara esa carta
     * @author Miguel Canache
     */

    private void crearCartaAccion(String color, String accion) {
        for (int i = 0; i < 2; i++) {
            CartaAccion cartaAgregable = new CartaAccion();
            cartaAgregable.setAccion(accion);
            cartaAgregable.setColor(color);
            guardarCartas(cartaAgregable);
        }
    }

    /**
     * Crea las cartas comodin, incluyendo el cambio de color y el toma 4
     *
     * @param accion le agrega lo que hara esa carta
     * @author Miguel Canache
     */

    private void crearCartaComodin(String accion) {
        for (int i = 0; i < 4; i++) {
            CartaComodin cataAgregable = new CartaComodin();
            cataAgregable.setAccion(accion);
            guardarCartas(cataAgregable);
        }
    }

    /**
     * Todas las cartas previamente creadas, se guardaran en el mazo de robo
     *
     * @param cartasVarias representa a todas las cartas anteriormente creadas
     * @author Miguel Canache
     */

    public void guardarCartas(CartaBlanca cartasVarias) {
        mazo.add(cartasVarias);
    }


    /**
     * Un metodo para barajear el mazo y salgan todas las cartas aleatorias
     *
     * @author Marco Argonis
     */

    public void barajearBarajaDeCartas() {
        Collections.shuffle(mazo);
    }

    /**
     * Un metodo para repartir cartas a ambos jugadores, siendo  7 para ambos
     *
     * @author Miguel Canache
     */

    public void repartirCartas() {
        // Repartir 7 cartas al jugador
        for (int i = 0; i < 7; i++) {
            CartaBlanca carta = mazo.removeFirst();
            mazoJugador.add(carta);
        }

        // Repartir 7 cartas al rival
        for (int i = 0; i < 7; i++) {
            CartaBlanca carta = mazo.removeFirst();
            mazoRival.add(carta);
        }

        // Encontrar la primera carta válida para la pila (que no sea CT4, CC, o CT2)
        while (true) {
            CartaBlanca carta = mazo.removeFirst();
            String accion = carta.getAccion();
            if (accion == null || (!accion.equals("CT4") && !accion.equals("CC") && !accion.equals("CT2"))) {
                mazoMontana.add(carta);
                break;
            } else {
                // Si la carta es de acción no válida, se devuelve al mazo
                mazo.addLast(carta);
            }
        }
    }


    /**
     * Esto autura de manera que cuando tenga que eleguir color, lo haga al azar
     *
     * @return retornara la letra que caiga el numero
     * @author Miguel Canache
     */

    public String ruletaColores() {
        int numero = (int) (Math.random() * 4);
        if (numero == 0) {
            return "G";
        }
        if (numero == 1) {
            return "R";
        }
        if (numero == 2) {
            return "Y";
        }
        if (numero == 3) {
            return "B";
        }
        return "B";
    }


    /**
     * para ver la primera carta del mazo de descarte, pudiendo saber que cartas se podrian usar
     *
     * @author Miguel Canache
     */

    public void mostrarUnaCartaMontana() {
        int i = 0;
        if (mazoMontana.get(i).getAccion() == null) {
            System.out.println(mazoMontana.get(i).getContadorCarta() + "-" + mazoMontana.get(i).getColor());
        }

        if (mazoMontana.get(i).getAccion() != null && mazoMontana.get(i).getAccion() != "CT4" && mazoMontana.get(i).getAccion() != "CC") {
            System.out.println(mazoMontana.get(i).getAccion() + "-" + mazoMontana.get(i).getColor());
        }

        if (mazoMontana.get(i).getAccion() == "CT4" || mazoMontana.get(i).getAccion() == "CC") {
            System.out.println(mazoMontana.get(i).getAccion() + "-" + mazoMontana.get(i).getColor());
        }

    }


    /**
     * Este metodo se activara constantemente para que ambos jugadores no se queden si cartas
     *
     * @author Miguel Canache
     */

    public void restaurarMazo() {
        while (mazoMontana.size() != 1) {
            CartaBlanca numero = mazoMontana.get(1);
            mazo.addLast(numero);
            mazoMontana.remove(numero);
        }

    }

    /**
     * Este metodo se activa para impedir que el jugador 1 escriba un numero mas alla de lo que hay en su mazo
     * y salte error
     *
     * @param tamano se usara para saber cuantas cartas hay en el mazo
     * @return Si sale bien el try catch, se le devolvera el numero
     * en caso que no sera un ciclo infinito hasta que escriba un numero dentro del rango
     * @author Miguel Canache
     */

    public int controlErrores(int tamano) {
        int numero;
        RedDeErrores listaErrores = new RedDeErrores();
        while (true) {
            try {
                numero = entrada.nextInt();
                entrada.nextLine();
                listaErrores.errorMazo(numero, tamano);
                break;
            } catch (ArithmeticException e) {
                System.out.println("ERROR: Recuerda que son numeros entre 0 y " + tamano + ", vuelve a escribir");

            }
        }
        return numero;
    }


    /**
     * El jugador al lanzar esta carta, le pregunta que color quiere jugar ahora
     * dependiendo de la opcion que elija, se cambia el atributo color
     * de la carta al color que quiera el jugador, y esta dentro de un bucle que
     * si el usuario coloca una opcion no valida, debera agregar una nueva opcion
     * hasta que por fin coloque una valida.
     *
     * @param option se usa para pasarle al metodo y
     *               dependiendo de la opcion que eligiera el jugador, se cambia de color.
     *               cabe aclarar que le pregunta al usuario una nueva opcion casa que este coloca
     *               una opcion no valida, eso hasta que por fin se digne a colocar una opcion
     *               valida
     * @author Marco Argonis
     */
    public void cambiarDeColor(String option) {
        boolean valido = false;
        while (!valido) {
            switch (option.toLowerCase()) {

                case "b":
                    mazoMontana.get(0).setColor("B");
                    System.out.println("Haz cambiado el color a Azul");
                    System.out.println("Ahora los jugadores deberan jugar cartas color Azul");
                    valido = true;
                    break;
                case "r":
                    mazoMontana.get(0).setColor("R");
                    System.out.println("El color ha cambiado a Rojo");
                    System.out.println("Ahora los jugadores deberan jugar cartas color Rojo");
                    valido = true;
                    break;
                case "y":
                    mazoMontana.get(0).setColor("Y");
                    System.out.println("El color ha cambiado a Amarillo");
                    System.out.println("Ahora los jugadores deberan jugar cartas color Amarillo");
                    valido = true;
                    break;
                case "g":
                    mazoMontana.get(0).setColor("G");
                    System.out.println("El color ha cambiado a Verde");
                    System.out.println("Ahora los jugadores deberan jugar cartas color Verde");
                    valido = true;
                    break;
                default:
                    System.out.println("Opcion no valida, debe recordar que las opciones");
                    System.out.println("validas son B(Azul),R(Rojo),Y(Amarillo),G(Verde)");
                    System.out.println("Ingrese nuevamente la opcion");
                    option = entrada.nextLine();
                    break;
            }
        }
    }
    public void guardarNombre(String nombreJugador){
        JSONObject partida = new JSONObject();
        partida.put("nombreJugador", nombreJugador);
        try (FileWriter file = new FileWriter("datos/nombreJugador.json")) {
            file.write(partida.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String cargarNombre() {
        try (FileReader fileReader = new FileReader("datos/nombreJugador.json")) {
            JSONObject partida = new JSONObject(new JSONTokener(fileReader));
            return partida.getString("nombreJugador");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Un metodo para cambiar el sentido de turnos, funciona con recursividad por asi decirlo
     * ya que al lanzar la carta cambiar el sentido de turnos, primero descarta la carta
     * y luego el jugador vuelve a jugar, esto aplica tanto para jugador como para rival
     * ahora, dentro de ambos hay un if, y un metodo a parte llamado sePuedeJugarCarta
     * si retorna falso, entonces manda el mensaje y luego llama a la funcion robarCartasJugador
     * si es verdad, se ejecuta normal
     * @param mazoAuxiliar que es un LinkedList tipo carta blanca, basicamente
     * @param cartaElegida para el metodo descarteCartasJugador y descarteCartasRival
     * que esta a dentro del metodo
     * se le pasa el mazo del jugador/rival como parametro
     * @author Marco Argonis
     */
   /* private void cambiarSentido(int cartaElegida, LinkedList<CartaBlanca> mazoAuxiliar) {
        if (mazoAuxiliar==mazoJugador){
            System.out.println("El jugador 1 cambia el sentido de los turno");
            if (!sePuedeJugarCarta(mazoJugador)){
               descartarCartasJugador(cartaElegida);
               System.out.println("No posees ninguna carta para jugar, agarra una del mazo.");
               robarCartasJugador();
               return;
            }else {
                descartarCartasJugador(cartaElegida);
                condicionesJugador();
            }
        } else if(mazoAuxiliar==mazoRival){
            System.out.println("El jugador 2 cambia el sentido de los turno");

            if (!sePuedeJugarCarta(mazoRival)){
               descartarCartasRival(cartaElegida);
               System.out.println("No posees ninguna carta para jugar, agarra una del mazo.");
               robarCartasRival();

               return;

            }else {
                descartarCartasRival(cartaElegida);
                condicionesRival();
            }
        }

    }*/
    /**
     * Un metodo para bloquear turno, funciona con recursividad por asi decirlo
     * ya que al lanzar la carta bloquear turno, primero descarta la carta
     * y luego el jugador vuelve a jugar, esto aplica tanto para jugador como para rival
     * ahora, dentro de ambos hay un if, y un metodo a parte llamado sePuedeJugarCarta
     * si retorna falso, entonces manda el mensaje y luego llama a la funcion robarCartasJugador
     * si es verdad, se ejecuta normal
     * @param mazoAuxiliar que es un LinkedList tipo carta blanca, basicamente
     * @param cartaElegida para el metodo descarteCartasJugador y descarteCartasRival
     * que esta a dentro del metodo
     * se le pasa el mazo del jugador/rival como parametro
     * @author Marco Argonis
     */
    /*private void bloquearElTurno(int cartaElegida, LinkedList<CartaBlanca> mazoAuxiliar) {
        if (mazoAuxiliar==mazoJugador){
            System.out.println("El jugador 1 ha bloqueado al jugador 2");
            System.out.println("Vuelves a Jugar");

            if (!sePuedeJugarCarta(mazoJugador)){
               descartarCartasJugador(cartaElegida);
               System.out.println("No posees ninguna carta para jugar, agarra una del mazo.");
               robarCartasJugador();
               return;
            }else {
                descartarCartasJugador(cartaElegida);
                condicionesJugador();
            }
        } else if(mazoAuxiliar==mazoRival){
            System.out.println("El jugador 2 ha bloqueado al jugador 1");
            System.out.println("Vuelve a Jugar la maquina");
            if (!sePuedeJugarCarta(mazoRival)){
               descartarCartasRival(cartaElegida);
               System.out.println("No posees ninguna carta para jugar, agarra una del mazo.");
               robarCartasRival();
               return;
            }else {
                descartarCartasRival(cartaElegida);
                condicionesRival();
            }
        }

    }*/
    /**
     * Un metodo de prueba mas que nada, lo que hace es bucar en el mazo si se
     * puede jugar una carta, si lo hace, pues devuelve un bool dependiendo si
     * se puede o no jugar
     * @param mazoAuxiliar que es un LinkedList tipo carta blanca, basicamente
     * se le pasa el mazo del jugador/rival como parametro
     * @author Marco Argonis
     */
    /*private boolean sePuedeJugarCarta(LinkedList<CartaBlanca> mazoAuxiliar) {
    boolean puedeJugar = false;
        CartaBlanca cartaMontana = mazoMontana.getFirst();
        for (CartaBlanca carta : mazoJugador) {
            if (carta.puedeSerJugada(cartaMontana, mazoJugador.size())) {
                puedeJugar = true;
                break;
            }
        }
        return puedeJugar;
    }*/

     /*public void mostrarBarajaRival() {
        for (int i = 0; i < mazoRival.size(); i++) {
            if (mazoRival.get(i).getAccion() == null) {
                System.out.println(mazoRival.get(i).getContadorCarta() + "-" + mazoRival.get(i).getColor());
            }

            if (mazoRival.get(i).getAccion() != null && mazoRival.get(i).getAccion() != "CT4" && mazoRival.get(i).getAccion() != "CC") {
                System.out.println(mazoRival.get(i).getAccion() + "-" + mazoRival.get(i).getColor());
            }

            if (mazoRival.get(i).getAccion() == "CT4" || mazoRival.get(i).getAccion() == "CC") {
                System.out.println(mazoRival.get(i).getAccion());
            }
        }
    }*/
}

