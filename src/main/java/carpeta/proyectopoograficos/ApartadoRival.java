package carpeta.proyectopoograficos;

import java.util.LinkedList;

public class ApartadoRival {
    ControlCartas acceder = new ControlCartas();

    public ControlCartas getAcceder() {
        return acceder;
    }

    public void setAcceder(ControlCartas acceder) {
        this.acceder = acceder;
    }

    /**
     * Si una carta de toma 2 se usa, el jugador 1 roba 2 cartas
     *
     * @author Miguel Canache
     */
    public void tomaDosCartasJugador() {
        int tomar = 0;
        while (tomar != 2) {
            CartaBlanca n = acceder.mazo.get(0);
            acceder.mazoJugador.add(n);
            acceder.mazo.remove(n);
            tomar++;
        }
    }

    /**
     * Mostrar la baraja del rival
     *
     * @param mazoRival El mazo del rival
     */
    public void mostrarBarajaRival(LinkedList<CartaBlanca> mazoRival) {
        for (int i = 0; i < mazoRival.size(); i++) {
            CartaBlanca carta = mazoRival.get(i);
            if (carta.getAccion() == null) {
                System.out.print(carta.getContadorCarta() + "-" + carta.getColor() + " | ");
            } else if (!carta.getAccion().equals("T4") && !carta.getAccion().equals("C")) {
                System.out.print(carta.getAccion() + "-" + carta.getColor() + " | ");
            } else {
                System.out.print(carta.getAccion() + " | ");
            }
        }
        System.out.println();
    }

    /**
     * Si una carta de toma 4 se usa, el jugador 1 toma 4 cartas y cambia de color
     *
     * @param option El color seleccionado por el rival
     * @author Marco Argonis
     */
    public void tomarCuatroCartasJugador(String option) {
        int tomar = 0;
        while (tomar != 4) {
            CartaBlanca n = acceder.mazo.get(0);
            acceder.mazoJugador.add(n);
            acceder.mazo.remove(n);
            tomar++;
        }
        // Aquí deberías cambiar el color de la carta
        // acceder.cambiarDeColor(option); // Asegúrate de que este método exista y funcione correctamente
    }

    /**
     * Verificar si el mazo del rival está vacío
     *
     * @return Verdadero si el mazo del rival está vacío, falso de lo contrario
     * @author Miguel Canache
     */
    public boolean estadoMazoRival() {
        return acceder.mazoRival.size() == 0;
    }

    /**
     * Robar cartas para el rival
     *
     * @author Miguel Canache
     */
    public void robarCartasRival() {
        CartaBlanca numero = acceder.mazo.get(0);
        acceder.mazoRival.addLast(numero);
        acceder.mazo.remove(numero);
    }

    /**
     * Descartar una carta del rival
     *
     * @param contenido El control de cartas
     * @param numeroID El índice de la carta a descartar
     * @author Miguel Canache
     */
    public void descartarCartasRival(ControlCartas contenido, int numeroID) {
        CartaBlanca numero = contenido.mazoRival.get(numeroID);
        contenido.mazoMontana.addFirst(numero);
        contenido.mazoRival.remove(numeroID);
    }

    /**
     * Método de condiciones del rival (comentado, requiere revisión y adaptación)
     */
    /*
    public void condicionesRival() {
        int tamanoAntes = acceder.mazoRival.size();
        String color;

        for (int i = 0; i < acceder.mazoRival.size(); i++) {
            CartaBlanca carta = acceder.mazoRival.get(i);

            if (carta.puedeSerJugada(acceder.mazoMontana.getFirst(), acceder.mazoRival.size())) {
                if (carta instanceof CartaComodin) {
                    color = acceder.ruletaColores();
                    if (carta.getAccion().equals("CT4")) {
                        tomarCuatroCartasJugador(color);
                    }
                    descartarCartasRival(i);
                    acceder.cambiarDeColor(color);
                } else if (carta instanceof CartaAccion) {
                    if (carta.getAccion().equals("CT2")) {
                        tomaDosCartasJugador();
                    } else if (carta.getAccion().equals("S")) {
                        cambiarElSentidoRival(i);
                    } else if (carta.getAccion().equals("r")) {
                        bloquearElTurnoRival(i);
                    }
                    descartarCartasRival(i);
                } else if (carta instanceof CartaNumerica) {
                    descartarCartasRival(i);
                }
                break;
            }
        }

        if (acceder.mazoRival.size() == tamanoAntes) {
            robarCartasRival();
        }
    }
    */

    /**
     * Funciona con recursividad simple, descarta la carta del jugador y
     * luego llama el void condicionesJugador, saltando el turno rival
     *
     * @param cartaElegida La carta elegida para cambiar el sentido
     * @author Marco Argonis
     */
    /*
    public void cambiarElSentidoRival(int cartaElegida) {
        System.out.println("El jugador 2 (maquina) ha jugado cambiar el sentido");
        System.out.println("vuelve a jugar el computador");
        descartarCartasRival(cartaElegida);
        condicionesRival();
    }
    */

    /**
     * Funciona con recursividad simple, descarta la carta del jugador y
     * luego llama el void condicionesJugador, saltando el turno rival
     *
     * @param cartaElegida La carta elegida para bloquear el turno
     * @author Marco Argonis
     */
    /*
    public void bloquearElTurnoRival(int cartaElegida) {
        System.out.println("El jugador 2 (maquina) ha jugado bloquear el turno al rival");
        System.out.println("vuelve a jugar el computador");
        descartarCartasRival(cartaElegida);
        condicionesRival();
    }
    */
}
