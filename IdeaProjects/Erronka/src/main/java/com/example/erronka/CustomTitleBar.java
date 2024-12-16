package com.example.erronka;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CustomTitleBar {
    private final Stage stage;
    private final Region titleBar;

    public CustomTitleBar(Stage stage, Region parent) {
        this.stage = stage;
        this.titleBar = createTitleBar();
    }

    public Region getTitleBar() {
        return titleBar;
    }

    private Region createTitleBar() {

        HBox titleBar = new HBox();
        titleBar.setStyle("-fx-background-color: #081b26;");
        titleBar.setPadding(new Insets(5, 10, 5, 10));
        titleBar.setSpacing(10);


        Label titleLabel = new Label(stage.getTitle());
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");

        Button closeButton = new Button("X");
        closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 14px;");
        closeButton.setOnMouseClicked(event -> stage.close());

        titleBar.getChildren().addAll(titleLabel, new Region(), closeButton);
        HBox.setHgrow(titleBar.getChildren().get(1), Priority.ALWAYS);


        titleBar.setOnMousePressed(event -> handleMousePressed(event));
        titleBar.setOnMouseDragged(event -> handleMouseDragged(event));

        return titleBar;
    }

    private double xOffset = 0;
    private double yOffset = 0;

    private void handleMousePressed(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    private void handleMouseDragged(MouseEvent event) {
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }
}
