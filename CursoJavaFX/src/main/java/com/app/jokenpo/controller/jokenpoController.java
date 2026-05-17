package com.app.jokenpo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.util.Random;

public class jokenpoController {

    @FXML
    private CheckBox checkTesoura, checkPedra, checkPapel;

    @FXML
    private Label labTesoura, labPedra, labPapel, labPlacar;

    private Alert alerta = new Alert(Alert.AlertType.ERROR);
    private Alert alertaInfor = new Alert(Alert.AlertType.INFORMATION);
    private Random random = new Random();

    private int vitoriaUser = 0;
    private int vitoriaComput = 0;

    @FXML
    public void jokenpo() {

        if (!checkTesoura.isSelected() && !checkPedra.isSelected() && !checkPapel.isSelected()) {
            alerta.setTitle("ERRO");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione pelo menos uma das opções!");
            alerta.showAndWait();
            return;
        }

        int cont = 0;
        int escolhaUser = 0;


        if (checkTesoura.isSelected()) {
            escolhaUser = 1;
            cont++;
        }
        if (checkPedra.isSelected()) {
            escolhaUser = 2;
            cont++;
        }
        if (checkPapel.isSelected()) {
            escolhaUser = 3;
            cont++;
        }

        if (cont > 1) {
            alerta.setTitle("ERRO");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione apenas uma das opções!");
            alerta.showAndWait();
            return;
        }

        labTesoura.setVisible(false);
        labPedra.setVisible(false);
        labPapel.setVisible(false);

        int escolhaComput = random.nextInt(3) + 1;

        if (escolhaComput == 1) {
            labTesoura.setVisible(true);

        } else if (escolhaComput == 2) {
            labPedra.setVisible(true);

        } else if (escolhaComput == 3) {
            labPapel.setVisible(true);

        } else {
            alerta.setTitle("ERRO");
            alerta.setHeaderText(null);
            alerta.setContentText("Erro de processamento!");
            alerta.showAndWait();
            return;
        }

        if (escolhaComput == escolhaUser) {
            alertaInfor.setTitle("Empate");
            alertaInfor.setHeaderText(null);
            alertaInfor.setContentText("Empate! A escolha foi a mesma!");
            alertaInfor.showAndWait();
            return;
        }

        if ((escolhaUser == 1 && escolhaComput == 3) || // Tesoura vence Pape
                (escolhaUser == 2 && escolhaComput == 1) || // Pedra vence Tesoura
                (escolhaUser == 3 && escolhaComput == 2)    // Papel vence Pedra
        ) {
            vitoriaUser++;
            alertaInfor.setTitle("Vitória");
            alertaInfor.setHeaderText(null);
            alertaInfor.setContentText("Você venceu!");
            alertaInfor.showAndWait();

        } else {
            vitoriaComput++;
            alerta.setTitle("Derrota");
            alerta.setHeaderText(null);
            alerta.setContentText("Você perdeu!");
            alerta.showAndWait();
        }

        if (vitoriaUser < 10 || vitoriaComput < 10) {
            if (vitoriaUser < 10 && vitoriaComput < 10) {
                labPlacar.setText("Jogador 0" + vitoriaUser + " X " + "Computador 0" + vitoriaComput );
            }

        } else {
            labPlacar.setText("Jogador " + vitoriaUser + " X " + "Computador " + vitoriaComput );
        }

    }

    @FXML
    public void setBtnResetar() {
        checkTesoura.setSelected(false);
        checkPedra.setSelected(false);
        checkPapel.setSelected(false);

        labTesoura.setVisible(false);
        labPedra.setVisible(false);
        labPapel.setVisible(false);

    }

    @FXML
    public void setBtnResetarPlacar() {
        vitoriaUser = 0;
        vitoriaComput = 0;

        checkTesoura.setSelected(false);
        checkPedra.setSelected(false);
        checkPapel.setSelected(false);

        labTesoura.setVisible(false);
        labPedra.setVisible(false);
        labPapel.setVisible(false);

        labPlacar.setText("Jogador 00 x Computador 00");
    }
}
