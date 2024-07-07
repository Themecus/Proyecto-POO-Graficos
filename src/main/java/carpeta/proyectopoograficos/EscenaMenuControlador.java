package carpeta.proyectopoograficos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EscenaMenuControlador {
    public Button botonJugar;
    public Button botonCargar;
    public Button botonEstadisticas;
    public Button botonSalir;
    public Label tituloApertura;

    public void cerrarPorgrama()
    {
     System.exit(0);
    }

    public void jugarJuego() throws Exception {
        Main acceder = new Main();
        acceder.escenaSegunda();
    }


    public void estadistica() throws Exception {
        Main acceder = new Main();
        acceder.escenaTercera();
    }
}
