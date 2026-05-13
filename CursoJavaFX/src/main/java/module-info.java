module com.app.cursojavafx {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.app.geradorSenha to javafx.fxml;
    exports com.app.geradorSenha;
    exports com.app.geradorSenha.controller;
    opens com.app.geradorSenha.controller to javafx.fxml;
}