package com.example.blackjack.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuView extends VBox{

    private Button nuevaPartida;
    private Button pedirCarta;
    private Button plantarse;
    private Button salir;

    //Fichas
    private Button ficha10;
    private Button ficha20;
    private Button ficha50;
    private Button ficha100;
    private Button limpiarApuesta;

    public MenuView(){

        //Botones de acción
        nuevaPartida=new Button("DEAL");
        pedirCarta=new Button("Pedir carta");
        plantarse=new Button("Plantarse");
        salir=new Button("Salir");

        //Fichas
        ficha10=new Button("10");
        ficha20=new Button("20");
        ficha50=new Button("50");
        ficha100=new Button("100");
        limpiarApuesta=new Button("Limpiar");

        //Tamaño de los botones
        nuevaPartida.setPrefSize(140,48);
        pedirCarta.setPrefSize(140,48);
        plantarse.setPrefSize(140,48);
        salir.setPrefSize(140,48);

        ficha10.setPrefSize(70,48);
        ficha20.setPrefSize(70,48);
        ficha50.setPrefSize(70,48);
        ficha100.setPrefSize(70,48);
        limpiarApuesta.setPrefSize(90,48);

        //Tamaño de letra
        nuevaPartida.setStyle("-fx-font-size:16px; -fx-font-weight:bold;");
        pedirCarta.setStyle("-fx-font-size:15px;");
        plantarse.setStyle("-fx-font-size:15px;");
        salir.setStyle("-fx-font-size:15px;");

        ficha10.setStyle("-fx-font-size:16px; -fx-background-color:#4fc3f7;");
        ficha20.setStyle("-fx-font-size:16px; -fx-background-color:#ab47bc;");
        ficha50.setStyle("-fx-font-size:16px; -fx-background-color:#66bb6a;");
        ficha100.setStyle("-fx-font-size:16px; -fx-background-color:#ef5350;");
        limpiarApuesta.setStyle("-fx-font-size:14px;");

        //Contenedor de fichas
        HBox fichas=new HBox(12);
        fichas.setAlignment(Pos.CENTER);
        fichas.getChildren().addAll(ficha10,ficha20,ficha50,ficha100,limpiarApuesta);

        //Contenedor de botones de juego
        HBox acciones=new HBox(12);
        acciones.setAlignment(Pos.CENTER);
        acciones.getChildren().addAll(nuevaPartida,pedirCarta,plantarse,salir);

        setSpacing(14);
        setAlignment(Pos.CENTER);
        getChildren().addAll(fichas,acciones);
    }

    public Button getNuevaPartida(){
        return nuevaPartida;
    }

    public Button getPedirCarta(){
        return pedirCarta;
    }

    public Button getPlantarse(){
        return plantarse;
    }

    public Button getSalir(){
        return salir;
    }

    public Button getFicha10(){
        return ficha10;
    }

    public Button getFicha20(){
        return ficha20;
    }

    public Button getFicha50(){
        return ficha50;
    }

    public Button getFicha100(){
        return ficha100;
    }

    public Button getLimpiarApuesta(){
        return limpiarApuesta;
    }
}