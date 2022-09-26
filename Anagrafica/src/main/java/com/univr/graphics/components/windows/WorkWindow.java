package com.univr.graphics.components.windows;

import com.univr.anagrafica.Worker;
import com.univr.anagrafica.Manager;
import com.univr.graphics.components.custom.Events;
import com.univr.graphics.components.custom.SceneBuilder;
import com.univr.graphics.components.custom.ButtonCustom;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WorkWindow extends Window {
    @Override
    public void createWindow(Stage primaryStage, Worker worker, Worker old, Manager manager) {
        // Creazione finestra d'inserimento del lavoro stagionale
        BorderPane rootSelezionamento = setWindow(primaryStage, "Inserimento lavoro stagionale", 1200, 750);

        // Creazione gridPane Selezionamento
        final SceneBuilder gridPaneInsLavoro = new SceneBuilder( 25, 25);
        gridPaneInsLavoro.getGridPane().setAlignment(Pos.TOP_LEFT);
        gridPaneInsLavoro.getGridPane().setPadding(new Insets(10, 0, 0, 10));

        Object[] objectsLavoro = gridPaneInsLavoro.addFieldsInsertWork(primaryStage, worker);

        Events.indietroInsertEvent(((ButtonCustom) objectsLavoro[objectsLavoro.length - 1]).getButton(), primaryStage, worker);

        rootSelezionamento.setTop(gridPaneInsLavoro.getGridPane());
    }
}
