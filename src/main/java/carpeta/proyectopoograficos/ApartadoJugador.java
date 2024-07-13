package carpeta.proyectopoograficos;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class ApartadoJugador {
    ControlCartas acceder = new ControlCartas();
    private Scanner entrada = new Scanner(System.in);

    public ControlCartas getAcceder() {
        return acceder;
    }

    private int num=0;
    public void setAcceder(ControlCartas acceder) {
        this.acceder = acceder;
    }

    /**
     * Cuando el jugador 1 juegue, aqui podra seleccionar que carta tirar, ver su mazo y ver la informacion
     * de la carta que debe igualar, tanto por color, numero o accion, de manera manual
     *
     * @author Miguel Canache
     */

    /*public void condicionesJugador() {
        int cartaElegida = 0;
        String color;

        // Verificar si el jugador tiene alguna carta que pueda jugar
        boolean puedeJugar = false;
        CartaBlanca cartaMontana = acceder.mazoMontana.getFirst();
        for (CartaBlanca carta : acceder.mazoJugador) {
            if (carta.puedeSerJugada(cartaMontana, acceder.mazoJugador.size())) {
                puedeJugar = true;
                break;
            }
        }

        // Si no puede jugar ninguna carta, debe robar una del mazo
        if (!puedeJugar) {
            System.out.println("No posees ninguna carta para jugar, agarra una del mazo.");
            robarCartasJugador(usar.mazo);
            return;
        }

        while (true) {
            int tamano = acceder.mazoJugador.size();
            System.out.println("Teniendo tu mano a la vista:\n");

            mostrarBarajaJugador();
            System.out.println("\n");
            System.out.print("Del 1 al " + tamano + " eligue tu carta (de izquierda a derecha)= ");

            cartaElegida = acceder.controlErrores(tamano) - 1;

            System.out.print("Carta elegida: ");
            mostrarUnaCartaJugador(cartaElegida);

            CartaBlanca cartaSeleccionada = acceder.mazoJugador.get(cartaElegida);

            if (cartaSeleccionada.puedeSerJugada(acceder.mazoMontana.getFirst(), acceder.mazoJugador.size())) {
                if (cartaSeleccionada instanceof CartaComodin) {
                    System.out.print("Que color quieres poner?= ");
                    color = entrada.nextLine();
                    if (cartaSeleccionada.getAccion().equals("CT4")) {
                        tomarCuatroCartasRival(color);
                    }
                    descartarCartasJugador(cartaElegida);
                    acceder.cambiarDeColor(color);
                } else if (cartaSeleccionada instanceof CartaAccion) {
                    if (cartaSeleccionada.getAccion().equals("CT2")) {
                        tomaDosCartasRival();
                    } else if (cartaSeleccionada.getAccion().equals("S")) {
                        // cambiarSentido(cartaSeleccionada, cartaElegida);
                        cambiarElSentidoJugador(cartaElegida);
                    } else if (cartaSeleccionada.getAccion().equals("V")) {
                        //  cancelarTurno(cartaSeleccionada, cartaElegida);
                        bloquearElTurnoJugador(cartaElegida);
                    }
                    descartarCartasJugador(cartaElegida);
                } else if (cartaSeleccionada instanceof CartaNumerica) {
                    descartarCartasJugador(cartaElegida);
                }
                break;
            }

            System.out.println("\n");
        }
    }*/

    /**
     * funciona con recursividad simple, descarta la carta del jugador y
     * luego llama el void condicionesJugador, saltando el turno
     * rival, la misma logica se aplica para la siguiente
     *
     * @param cartaElegida lo pide descartarCartasJugador
     * @author Marco Argonis
     */
    /*public void cambiarElSentidoJugador(int cartaElegida) {
        System.out.println("El jugador 1 (usted) a jugado cambiar el sentido");
        System.out.println("vuelves a jugar");
        descartarCartasJugador(cartaElegida);
        condicionesJugador();
    }*/

    /**
     * funciona con recursividad simple, descarta la carta del jugador y
     * luego llama el void condicionesJugador, saltando el turno
     * rival
     *
     * @param cartaElegida lo pide descartarCartasJugador
     * @author Marco Argonis
     */
    /*public void bloquearElTurnoJugador(int cartaElegida) {
        System.out.println("El jugador 1 (usted) a jugado bloquear el turno al rival");
        System.out.println("vuelves a jugar");
        descartarCartasJugador(cartaElegida);
        condicionesJugador();
    }*/

    /**
     * Un metodo para que el jugador pueda ver su mazo
     *
     * @author Miguel Canache
     */

    public void mostrarBarajaJugador(LinkedList<CartaBlanca> mazoJugador) {
        for (int i = 0; i < mazoJugador.size(); i++) {
            if (mazoJugador.get(i).getAccion() == null) {
                System.out.print(mazoJugador.get(i).getContadorCarta() + "-" + mazoJugador.get(i).getColor() + " | ");
            }

            if (mazoJugador.get(i).getAccion() != null && mazoJugador.get(i).getAccion() != "T4" && mazoJugador.get(i).getAccion() != "C") {
                System.out.print(mazoJugador.get(i).getAccion() + "-" + mazoJugador.get(i).getColor() + " | ");
            }

            if (mazoJugador.get(i).getAccion() == "T4" || mazoJugador.get(i).getAccion() == "C") {
                System.out.print(mazoJugador.get(i).getAccion() + " | ");
            }
        }
        System.out.println();
    }

    /**
     * Un metodo para que el jugador pueda encontrar la carta que busca en base su posicion numeral
     *
     * @author Miguel Canache
     */

    public int rastrearCarta2(LinkedList<CartaBlanca> mazoJugador,String numero,String color,String accion) {//aquiiiiiiii
        for (int i = 0; i < mazoJugador.size(); i++) {
            if (mazoJugador.get(i).getContadorCarta()==Integer.parseInt(numero) ) {
                return i;
            }
            if (mazoJugador.get(i).getAccion()==accion){
                return i;
            }


        }
        return -5;
    }

    public int rastrearCarta(LinkedList<CartaBlanca> mazoJugador,String numero,String color,String accion) {//aquiiiiiiii
        System.out.println("carta info= "+color+" "+numero+" "+accion);

        for (int i = 0; i < mazoJugador.size(); i++) {

            if(Objects.equals(mazoJugador.get(i).getAccion(), accion) && Objects.equals(mazoJugador.get(i).getColor(), color)&&Objects.equals(mazoJugador.get(i).getContadorCarta(), numero))
            {
                return i;
            }

            if(Objects.equals(mazoJugador.get(i).getAccion(), accion)){
                return i;
            }


        }

        if(numero!=""){
            for (int i = 0; i < mazoJugador.size(); i++) {


                if (Objects.equals(mazoJugador.get(i).getContadorCarta(), Integer.parseInt(numero)) ){
                    return i;
                }
            }

        }

        return-5;
    }



    /**
     * Un metodo para estar al tanto de cuantas cartas quedan en mazo del jugador 1
     *
     * @return Devuelve el estado del mazo jugador, falso si esta lleno y verdadero si esta lleno
     * @author Miguel Canache
     */

    public boolean estadoMazoJugador() {
        if (acceder.mazoJugador.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * En caso de que se use una carta de toma 2, este metodo le agregara cartas al jugador 2
     *
     * @author Miguel Canache
     */

    public void robarCartasJugador(ControlCartas contenido) {
        CartaBlanca numero =contenido.mazo.get(0);
        contenido.mazoJugador.addLast(numero);
        contenido.mazo.remove(numero);

    }

    /**
     * Al final del turno del jugador 1, descarta una carta y la deja en el mazo de descarte
     *
     * @author Miguel Canache
     */

    public void descartarCartasJugador(ControlCartas contenido, int numeroID) {
        int i=numeroID;
        CartaBlanca numero = contenido.mazoJugador.get(i);
        contenido.mazoMontana.addFirst(numero);
        contenido.mazoJugador.remove(i);
    }

    public void descartarCartasMazo(ControlCartas contenido, int numeroID) {
        int i=numeroID;
        CartaBlanca numero = contenido.mazo.get(i);
        contenido.mazoMontana.addFirst(numero);
        contenido.mazo.remove(i);
    }

    /**
     * para ver la carta seleccionada por el jugador 1
     *
     * @param i Con esto, sabremos que carta estamos viendo
     * @author Miguel Canache
     */

    public void mostrarUnaCartaJugador(int i) {

        if (acceder.mazoJugador.get(i).getAccion() == null) {
            System.out.println(acceder.mazoJugador.get(i).getContadorCarta() + "-" + acceder.mazoJugador.get(i).getColor());
        }

        if (acceder.mazoJugador.get(i).getAccion() != null && acceder.mazoJugador.get(i).getAccion() != "CT4" && acceder.mazoJugador.get(i).getAccion() != "CC") {
            System.out.println(acceder.mazoJugador.get(i).getAccion() + "-" + acceder.mazoJugador.get(i).getColor());
        }

        if (acceder.mazoJugador.get(i).getAccion() == "CT4" || acceder.mazoJugador.get(i).getAccion() == "CC") {
            System.out.println(acceder.mazoJugador.get(i).getAccion());
        }

    }


    /**
     * Si una carta de toma 2 se usa, el jugador 2 roba 2 cartas
     *
     * @author Miguel Canache
     */

    public void tomaDosCartasRival() {
        int tomar = 0;

        while (tomar != 2) {
            CartaBlanca n2 = acceder.mazo.get(0);
            acceder.mazoRival.add(n2);
            acceder.mazo.remove(n2);
            tomar++;
        }
    }


    /**
     * Si una carta de toma 4 se usa, el jugador 2 toma 4 cartas,
     * se le agregan 4 cartas al mazo del rival antes de eso, le pregunta
     * al jugador 1 que color quiere jugar ahora.
     * Dependiendo de la opcion que elija, se cambia el atributo color
     * de la carta al color que quiera el jugador
     *
     * @param option se usa para pasarle al metodo y
     *               dependiendo de la opcion que eligiera el jugador, se cambia de color
     * @author Marco Argonis
     */
    public void tomarCuatroCartasRival(String option) {
        int tomar = 0;

        while (tomar != 4) {
            CartaBlanca n = acceder.mazo.get(0);
            acceder.mazoRival.add(n);
            acceder.mazo.remove(n);
            tomar++;
        }

    }

    /**
     * Cuando el jugador 1 tenga dos cartas, debe presionar "1" en su teclado antes de lanzar la penultima
     * si hace eso le quedara una carta y cumplira la condicion del uno, sin embargo, sino cumple esto ultimo
     * roba 2 cartas
     *
     * @param estadoUno Enviando desde el metodo de turnoJugador, esto sera un indicativo para poner en marcha los if
     * @param nombre    Previamente recogido del menu, sera como el programa
     *                  se dirija al usuario
     * @return Siempre retornara un false, ya que si el jugador 2 tiene un toma 2 o toma 4, haciendo que el jugador 1
     * no pueda ganar, provocando que cuando llegue a solo 2 cartas otra vez, deba una vez mas
     * hacer que estadoUno vuelva estar en true, siempre estando pendiente de ese detalle por parte del jugador,
     * como el juego de verdad
     * @author Miguel Canache
     */

    public boolean cartaFinal(boolean estadoUno, String nombre) {
        if (acceder.mazoJugador.size() == 1 && estadoUno != true) {
            castigo();
            return false;
        }

        if (acceder.mazoJugador.size() == 1 && estadoUno == true) {
            System.out.println("El jugador: " + nombre + " solo le queda una carta");
            return false;
        }
        return false;
    }


    /**
     * Parecido a un roba 2, pero aplicando unicamente para cuando el jugador no grite "UNO!"
     *
     * @author Miguel Canache
     */


    public void castigo() {
        int tomar = 0;

        while (tomar != 2) {
            CartaBlanca n2 = acceder.mazo.get(0);
            acceder.mazoRival.add(n2);
            acceder.mazo.remove(n2);
            tomar++;
        }
    }



}