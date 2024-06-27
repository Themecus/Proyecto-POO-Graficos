package carpeta.proyectopoograficos;

import java.util.Scanner;
public class ReglasDeSimbolos {
    Scanner entrada= new Scanner(System.in);
    public void instrucciones()
    {
      System.out.println("Esta en una version del Juego del UNO pero de forma basica, aqui una guida de cada simbolo:\n");
      System.out.println("+Los colores son representados por:");
      System.out.println("Azules=B, Rojas=R, Amarillas=Y, Verdes=G\n");
      System.out.println("+El juego se rigue por cartas del 0-9\n");
      System.out.println("+Las cartas de accion son: ");
      System.out.println("Reversa=V, Saltar turno=S, Toma 2=CT2\n");
      System.out.println("+Las cartas comodines son: ");
      System.out.println("Cambio de color=CC, Toma 4=CT4\n");
      System.out.println("+Aclaracion: Las cartas V y S, ambas solo saltan el turno al solo ser un 1VS1\n");
      System.out.println("Presione cualquier tecla despues de leer todo esto");
      entrada.nextLine();
    }
}
