package carpeta.proyectopoograficos;

import javafx.scene.control.Button;

public class EscenaMenuControlador {
    public Button botonJugar;
    public Button botonCargar;
    public Button botonEstadisticas;
    public Button botonSalir;

    public void cerrarPorgrama()
    {
     System.exit(0);
    }

    public void jugarJuego() throws Exception {
        Main acceder = new Main();
        acceder.escenaSegunda();
    }

}
