package com.example.blackjack.app;

import com.example.blackjack.vista.GameView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BlackjackGUI extends Application{

    @Override
    public void start(Stage stage){

        GameView vista=new GameView();

        Scene escena=new Scene(vista,1000,750);

        stage.setTitle("Blackjack 21");
        stage.setScene(escena);

        stage.setMinWidth(900);
        stage.setMinHeight(650);

        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}