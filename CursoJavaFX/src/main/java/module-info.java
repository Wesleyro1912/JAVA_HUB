module com.app.cursojavafx {

    requires javafx.controls;
    requires javafx.fxml;

    // GERADOR DE SENHA
    opens com.app.geradorSenha to javafx.fxml;
    exports com.app.geradorSenha;

    opens com.app.geradorSenha.controller to javafx.fxml;
    exports com.app.geradorSenha.controller;

    // JOKENPO
    opens com.app.jokenpo to javafx.fxml;
    exports com.app.jokenpo;

    opens com.app.jokenpo.controller to javafx.fxml;
    exports com.app.jokenpo.controller;

    // Relogio Digital
    opens com.app.relogioDigital to javafx.fxml;
    exports com.app.relogioDigital;

    opens com.app.relogioDigital.controller to javafx.fxml;
    exports com.app.relogioDigital.controller;
}