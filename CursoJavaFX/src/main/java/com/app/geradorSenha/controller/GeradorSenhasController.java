package com.app.geradorSenha.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.security.SecureRandom;

public class GeradorSenhasController {

    @FXML
    private TextField textSenhaGerada;

    @FXML
    private CheckBox checkLetrasMaiusculas;

    @FXML
    private CheckBox checkLetrasMinusculas;

    @FXML
    private CheckBox checkIncluNumeros;

    @FXML
    private CheckBox checkIncluSimbolos;

    private final SecureRandom senhaAleatoria =
            new SecureRandom();

    private static final String MAIUSCULAS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String LETRAS =
            "abcdefghijklmnopqrstuvwxyz";

    private static final String NUMEROS =
            "0123456789";

    private static final String SIMBOLOS =
            "!@#$%¨&*()_+-=§¹²³£¢¬|/?:;.,<>°ªº[]{}'~^";

    @FXML
    private void gerarSenha() {

        int tamanho = 8 + senhaAleatoria.nextInt(8);

        StringBuilder conjunto = new StringBuilder();

        if (checkLetrasMaiusculas.isSelected()) {
            conjunto.append(MAIUSCULAS);
        }

        if (checkLetrasMinusculas.isSelected()) {
            conjunto.append(LETRAS);
        }

        if (checkIncluNumeros.isSelected()) {
            conjunto.append(NUMEROS);
        }

        if (checkIncluSimbolos.isSelected()) {
            conjunto.append(SIMBOLOS);
        }

        if (conjunto.isEmpty()) {

            textSenhaGerada.setText(
                    "Selecione ao menos uma opção!"
            );

            return;
        }

        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {

            int indice =
                    senhaAleatoria.nextInt(conjunto.length());

            senha.append(
                    conjunto.charAt(indice)
            );
        }

        textSenhaGerada.setText(
                senha.toString()
        );
    }

    @FXML
    private void copiarSenha() {

        String senha =
                textSenhaGerada.getText();

        if (senha != null && !senha.isEmpty()) {

            ClipboardContent conteudo =
                    new ClipboardContent();

            conteudo.putString(senha);

            Clipboard.getSystemClipboard()
                    .setContent(conteudo);
        }
    }
}