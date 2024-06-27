package carpeta.proyectopoograficos;

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
     * Si una carta de toma 4, es usada por el rival, el jugador 1 toma 4 cartas,
     * se le agregan 4 cartas al mazo del jugador, antes de eso, le pregunta
     * al jugador rival que color quiere jugar ahora.
     * Dependiendo de la opcion que elija, se cambia el atributo color
     * de la carta al color que quiera el rival
     *
     * @param option se usa para pasarle al metodo y
     *               dependiendo de la opcion que eligiera el jugador, se cambia de color
     *               en teoria, el parametro option es elegido por la maquina, es decir
     *               deberia ser aleatorio.
     * @author Marco Argonis
     */
    public void tomarCuatroCartasJugador(String option) {
        int tomar = 0;
        //cambiarDeColor(option);
        while (tomar != 4) {
            CartaBlanca n = acceder.mazo.get(0);
            acceder.mazoJugador.add(n);
            acceder.mazo.remove(n);
            tomar++;
        }

    }

    /**
     * Un metodo para estar al tanto de cuantas cartas quedan en mazo del jugador 2
     *
     * @return Devuelve el estado del mazo jugador, falso si esta lleno y verdadero si esta lleno
     * @author Miguel Canache
     */

    public boolean estadoMazoRival() {
        if (acceder.mazoRival.size() == 0) {
            return true;
        } else {

            return false;
        }
    }


    /**
     * En caso de que se use una carta de toma 2, este metodo le agregara 2 cartas al jugador 1
     *
     * @author Miguel Canache
     */

    public void robarCartasRival() {
        CartaBlanca numero = acceder.mazo.get(0);
        acceder.mazoRival.addLast(numero);
        acceder.mazo.remove(numero);
    }


    /**
     * Al final del turno del jugador 2, descarta una carta y la deja en el mazo de descarte
     *
     * @param i Desde el metodo condicionesRival, se enviara que carta se saca
     * @author Miguel Canache
     */

    public void descartarCartasRival(int i) {
        CartaBlanca numero = acceder.mazoRival.get(i);
        acceder.mazoMontana.addFirst(numero);
        acceder.mazoRival.remove(i);
    }


    /**
     * Cuando el jugador 2 juegue, aqui podra seleccionar que carta tirar, ver su mazo y ver la informacion
     * de la carta que debe igualar, tanto por color, numero o accion, pero automatizado
     *
     * @author Miguel Canache
     */

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
                        // cambiarSentido(carta, i);
                        cambiarElSentidoRival(i);
                    } else if (carta.getAccion().equals("r")) {
                        // cancelarTurno(carta, i);
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


    /**
     * funciona con recursividad simple, descarta la carta del jugador y
     * luego llama el void condicionesJugador, saltando el turno
     * rival, la misma logica se aplica para la siguiente
     *
     * @param cartaElegida lo pide descartarCartasJugador
     * @author Marco Argonis
     */

    public void cambiarElSentidoRival(int cartaElegida) {
        System.out.println("El jugador 2 (maquina) a jugado cambiar el sentido");
        System.out.println("vuelve a jugar el computador");
        descartarCartasRival(cartaElegida);
        condicionesRival();
    }

    /**
     * funciona con recursividad simple, descarta la carta del jugador y
     * luego llama el void condicionesJugador, saltando el turno
     * rival
     *
     * @param cartaElegida lo pide descartarCartasJugador
     * @author Marco Argonis
     */

    public void bloquearElTurnoRival(int cartaElegida) {
        System.out.println("El jugador 2 (maquina) a jugado bloquear el turno al rival");
        System.out.println("vuelve a jugar el computador");
        descartarCartasRival(cartaElegida);
        condicionesRival();
    }
}
