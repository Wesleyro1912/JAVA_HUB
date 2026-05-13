package com.app.geradorSenha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class Initialization extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Initialization.class.getResource("GeradorSenhasView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 443, 500);
        stage.setTitle("Gerador de Senhas");
        stage.setScene(scene);
        stage.show();
    }
}
