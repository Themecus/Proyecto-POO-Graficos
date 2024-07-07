package carpeta.proyectopoograficos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        primaryStage.setTitle("Cambios");
        escenaPrimera();
    }

    public void escenaPrimera() throws Exception {
        Parent mainRoot = FXMLLoader.load(getClass().getResource("EscenaMenu.fxml"));
        Scene mainScene = new Scene(mainRoot);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("UNO");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void escenaSegunda() throws Exception {
        //Menu acceder2= new Menu();
        //acceder2.menu();

        Parent segundoRoot = FXMLLoader.load(getClass().getResource("EscenaJuego.fxml"));
        Scene segundoScene = new Scene(segundoRoot);
        primaryStage.setScene(segundoScene);
        primaryStage.setTitle("UNO");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void escenaTercera() throws Exception {

        Parent tercerRoot = FXMLLoader.load(getClass().getResource("EscenaEstadistica.fxml"));
        Scene tercerScene = new Scene(tercerRoot);
        primaryStage.setScene(tercerScene);
        primaryStage.setTitle("UNO");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
