package carpeta.proyectopoograficos;

import java.util.Scanner;

public class ZonaDeJuego {
    ControlCartas usar = new ControlCartas();
    ApartadoJugador usarJugador = new ApartadoJugador();
    ApartadoRival usarRival = new ApartadoRival();
    private int infinito = 0;
    private boolean llaveJugador = false;
    private Scanner entrada = new Scanner(System.in);
    private int opciones;
    private boolean turno = true;
    private boolean negarJugador = false;
    private boolean voltearJugador = false;
    private boolean estadoUno = false;

    /**
     * Dentro de este tablero, el jugador y la maquina pelearan, alternado entre turnos para llegar a 0 sus barajas
     *
     * @param nombre Previamente recogido del menu, sera como el programa
     *               se dirija al usuario
     * @author Miguel Canache
     */
    public void tableroDeJuego(String nombre) {
        usar.crearCartas();
        usar.barajearBarajaDeCartas();
        usar.repartirCartas();


        while (infinito == 0) {
            if (turno == true && (negarJugador != true || voltearJugador != true)) {
                turnoJugador(nombre);
                turno = false;

                if (infinito == 1) {
                    System.out.println("HASTA PRONTO");
                    break;
                }
            }

            estadoUno = usarJugador.cartaFinal(estadoUno, nombre);

            if (turno == false && (negarJugador != true || voltearJugador != true)) {
                System.out.println("Turno de la maquina");
                System.out.println("\n");
                turnoRival();
                turno = true;
            }

            if (usarJugador.estadoMazoJugador() == true || usarRival.estadoMazoRival() == true) {
                resultadosPartidad(nombre);
                break;
            }

            usar.restaurarMazo();
        }

    }

    /**
     * Al concluir una partidad avisa quien de los dos gano en base a quien logro vaciar su mazo
     *
     * @param nombre Se enviara el nombre para diferenciar ambos jugadores 1 y 2
     * @author Miguel Canache
     */

    private void resultadosPartidad(String nombre) {
        if (usarJugador.estadoMazoJugador() == true) {
            System.out.println("El ganador fue " + nombre + "!");
        }

        if (usarRival.estadoMazoRival() == true) {
            System.out.println("El ganador fue la maquina!");
        }


    }

    /**
     * Si el jugador 1 selecciono lanzar carta, entonces podra ver su mazo y eleguir que lanzar y sino robar carta
     * usando cualquier numero dentro del rango especificado, pasando el turno en ambas
     *
     * @param nombre Previamente recogido del menu, sera como el programa
     *               se dirija al usuario
     * @author Miguel Canache
     */
    public void turnoJugador(String nombre) {
        usarJugador.setAcceder(usar);

        while (llaveJugador == false) {
            System.out.print("Tu turno " + nombre + ", la carta actual en el descarte es: ");
            usar.mostrarUnaCartaMontana();
            System.out.println("Actualmente tienes= " + usar.mazoJugador.size() + " cartas");
            System.out.println("Y el rival posee actualmente= " + usar.mazoRival.size() + " cartas\n");
            System.out.println("1) Gritar 'UNO!' (Usar con tu penultima carta) ");
            System.out.println("2) Lanzar una carta (Se saltara el turno si no hay cartas que enbonen)");
            System.out.println("3) Guardar partida");
            System.out.println("4) Volver al menu");
            System.out.print("Escribe tu accion= ");
            opciones = entrada.nextInt();
            entrada.nextLine();
            System.out.println("\n");
            switch (opciones) {
                case 2:
                    //usarJugador.condicionesJugador();
                    System.out.println("\n");
                    llaveJugador = true;
                    break;
                case 3:
                    usar.guardarNombre(nombre);
                    usar.guardarPartida();
                    System.out.println("Partida guardada correctamente");
                    break;
                case 4:

                    infinito = 1;
                    llaveJugador = true;
                    break;
                case 1:
                    estadoUno = true;
                    break;
                default:
                    System.out.println("Esto no es una opcion, vuelva a intentar");
                    System.out.println("\n");
                    break;
            }
        }
        llaveJugador = false;
    }

    /**
     * Si el jugador 2 selecciono lanzar carta,podra eleguir que lanzar y sino robar una carta
     * pasando el turno en ambas
     *
     * @author Miguel Canache
     */
    public void turnoRival() {
        usarRival.setAcceder(usar);
        usarRival.condicionesRival();
    }


}
