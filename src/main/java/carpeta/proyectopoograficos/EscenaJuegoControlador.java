package carpeta.proyectopoograficos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class EscenaJuegoControlador {
    public ListView mazoEnemigo;
    public ListView mazoDescarte;
    public Button btoRobo;
    public Button btoLanzar;

    @FXML
    private ListView<String> mazoJugador;

    private ObservableList<String> mazoDeCartas;

    @FXML
    public void initialize() {
        mazoDeCartas = FXCollections.observableArrayList();
        mazoJugador.setItems(mazoDeCartas);
        mazoJugador.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.MULTIPLE);
    }

    @FXML
    private void agregarCarta() {
        mazoDeCartas.add("Carta " + (mazoDeCartas.size() + 1));
    }

    @FXML
    private void quitarCarta() {
        ObservableList<String> cartasSeleccionadas = mazoJugador.getSelectionModel().getSelectedItems();
        mazoDeCartas.removeAll(cartasSeleccionadas);
    }

}
//crea un boton que cree todas las carstas y las almacenamos aqui