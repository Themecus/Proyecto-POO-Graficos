module carpeta.proyectopoograficos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.json;

    opens carpeta.proyectopoograficos to javafx.fxml;
    exports carpeta.proyectopoograficos;
}