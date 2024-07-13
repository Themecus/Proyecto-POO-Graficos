package carpeta.proyectopoograficos;

import java.util.Scanner;

public class Menu {
    ZonaDeJuego acceder = new ZonaDeJuego();
    ReglasDeSimbolos acceder1 = new ReglasDeSimbolos();
    Scanner entrada = new Scanner(System.in);
    ControlCartas acceder2 = new ControlCartas();

    /**
     * El metodo es un menu sencillo, la opcion 1 dara arranque a la operacion, llevandolo al metodo
     * el 2 cargara una partida que esta dentro de los archivos de guardado
     * la 3 para darle nombre al jugador, puede ser cualquier cosa
     * la 4 es solo para salir del programa
     *
     * @author Miguel Canache
     */
    public void menu() {
        int opcion;
        String nombre = "";
        boolean continuar = true;

        while (continuar){
            System.out.println("Bienvenido al Uno version 0.5");
            System.out.println("Por favor, elija una opcion:");
            System.out.println("1) Iniciar una nueva partida");
            System.out.println("2) Cargar una partida");
            System.out.println("3) Escribir un nombre");
            System.out.println("4) Guia de simbolos");
            System.out.println("5) Salir");
            System.out.print("Opcion: ");
            // Validación de la entrada
            while (!entrada.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, elija una opción del 1 al 5.");
                System.out.print("Opción: ");
                entrada.next();
            }

            opcion = entrada.nextInt();
            entrada.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    if (!nombre.isEmpty()) {
                        boolean crearPartida = true;
                        System.out.println("\n");
                        acceder.tableroDeJuego(nombre,crearPartida);

                    } else {
                        System.out.println("Por favor, escriba su nombre antes de iniciar una nueva partida.");
                    }
                    break;
                case 2:
                    boolean cargarPartida = false;
                    String aux = acceder2.cargarNombre();
                    System.out.println("Hola, que gusto verte de nuevo "+ aux);
                    acceder.tableroDeJuego(aux, cargarPartida);
                    //System.out.println("Funcionalidad de cargar partida aun no implementada.");
                    break;
                case 3:
                    System.out.print("Dime tu nombre: ");
                    nombre = entrada.nextLine();
                    System.out.println("Nombre guardado: " + nombre);
                    break;
                case 4:
                    acceder1.instrucciones();
                    break;
                case 5:
                    System.out.println("Gracias por jugar. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("No es una opcion valida, por favor elija otra vez.");
                    break;
            }

            System.out.println(); // Línea en blanco para separar las iteraciones del menú

        }
    }
}   