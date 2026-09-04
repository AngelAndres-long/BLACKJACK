package com.example.blackjack.vista;

import com.example.blackjack.componentes.CartaInglesa;
import com.example.blackjack.controlador.GameController;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameView extends BorderPane{

    private GameController juego;

    private Label titulo;
    private Label puntosDealer;
    private Label puntosJugador;
    private Label mensaje;
    private Label lblSaldo;
    private Label lblApuesta;

    private HBox cartasDealer;
    private HBox cartasJugador;

    private MenuView menu;

    private boolean partidaActiva;
    private boolean cartasVisibles;

    public GameView(){

        juego=new GameController();
        partidaActiva=false;
        cartasVisibles=false;

        titulo=new Label("BLACKJACK 21");
        puntosDealer=new Label();
        puntosJugador=new Label();
        mensaje=new Label("Haz tu apuesta");
        lblSaldo=new Label();
        lblApuesta=new Label();

        cartasDealer=new HBox(12);
        cartasJugador=new HBox(12);

        menu=new MenuView();

        crearInterfaz();
        configurarBotones();
        actualizarInterfaz();
    }

    //Crea la interfaz
    private void crearInterfaz(){

        //Fondo de mesa
        setStyle("-fx-background-color:#0d5c3d;");

        titulo.setStyle("-fx-font-size:30px; -fx-font-weight:bold; -fx-text-fill:white;");

        puntosDealer.setStyle("-fx-font-size:20px; -fx-text-fill:white;");
        puntosJugador.setStyle("-fx-font-size:20px; -fx-text-fill:white;");

        mensaje.setStyle("-fx-font-size:22px; -fx-font-weight:bold; -fx-text-fill:#ffeb3b;");

        lblSaldo.setStyle("-fx-font-size:18px; -fx-text-fill:white; -fx-font-weight:bold;");
        lblApuesta.setStyle("-fx-font-size:18px; -fx-text-fill:#ffeb3b; -fx-font-weight:bold;");

        cartasDealer.setAlignment(Pos.CENTER);
        cartasJugador.setAlignment(Pos.CENTER);

        //Parte del dealer
        Label textoDealer=new Label("DEALER");
        textoDealer.setStyle("-fx-font-size:22px; -fx-font-weight:bold; -fx-text-fill:white;");

        VBox parteDealer=new VBox(10);
        parteDealer.setAlignment(Pos.CENTER);
        parteDealer.getChildren().addAll(textoDealer,puntosDealer,cartasDealer);

        //Parte del jugador
        Label textoJugador=new Label("JUGADOR");
        textoJugador.setStyle("-fx-font-size:22px; -fx-font-weight:bold; -fx-text-fill:white;");

        VBox parteJugador=new VBox(10);
        parteJugador.setAlignment(Pos.CENTER);
        parteJugador.getChildren().addAll(textoJugador,cartasJugador,puntosJugador);

        //Zona central de apuesta
        VBox zonaApuesta=new VBox(6);
        zonaApuesta.setAlignment(Pos.CENTER);
        zonaApuesta.getChildren().addAll(lblApuesta,mensaje);

        //Centro de la mesa
        VBox centro=new VBox(28);
        centro.setAlignment(Pos.CENTER);
        centro.getChildren().addAll(parteDealer,zonaApuesta,parteJugador);

        //Barra superior con saldo a la izquierda y título centrado
        HBox barraSuperior=new HBox();
        barraSuperior.setPadding(new Insets(10,20,10,20));
        barraSuperior.setAlignment(Pos.CENTER);

        //Espacio izquierdo (saldo)
        HBox izq=new HBox();
        izq.setAlignment(Pos.CENTER_LEFT);
        izq.getChildren().add(lblSaldo);
        HBox.setHgrow(izq,javafx.scene.layout.Priority.ALWAYS);

        //Título centrado
        HBox cen=new HBox();
        cen.setAlignment(Pos.CENTER);
        cen.getChildren().add(titulo);
        HBox.setHgrow(cen,javafx.scene.layout.Priority.ALWAYS);

        //Espacio derecho vacío (para que quede realmente centrado)
        HBox der=new HBox();
        HBox.setHgrow(der,javafx.scene.layout.Priority.ALWAYS);

        barraSuperior.getChildren().addAll(izq,cen,der);
        setTop(barraSuperior);
        setCenter(centro);
        setBottom(menu);

        BorderPane.setAlignment(titulo,Pos.CENTER);
        setPadding(new Insets(15));

        BorderPane.setMargin(menu,new Insets(15,0,10,0));
    }

    //Configura los botones
    private void configurarBotones(){

        //DEAL
        menu.getNuevaPartida().setOnAction(e->deal());

        //Pedir carta
        menu.getPedirCarta().setOnAction(e->pedirCarta());

        //Plantarse
        menu.getPlantarse().setOnAction(e->plantarse());

        //Salir
        menu.getSalir().setOnAction(e->Platform.exit());

        //Fichas
        menu.getFicha10().setOnAction(e->agregarFicha(10));
        menu.getFicha20().setOnAction(e->agregarFicha(20));
        menu.getFicha50().setOnAction(e->agregarFicha(50));
        menu.getFicha100().setOnAction(e->agregarFicha(100));
        menu.getLimpiarApuesta().setOnAction(e->limpiarApuesta());
    }

    //Agrega ficha a la apuesta
    private void agregarFicha(int valor){
        if(partidaActiva){
            return;
        }
        juego.sumarApuesta(valor);
        actualizarInterfaz();
    }

    //Limpia la apuesta
    private void limpiarApuesta(){
        if(partidaActiva){
            return;
        }
        juego.limpiarApuesta();
        actualizarInterfaz();
    }

    //Botón DEAL
    private void deal(){
        if(partidaActiva){
            return;
        }
        if(juego.getApuesta()<=0){
            mensaje.setText("Debes apostar primero");
            return;
        }
        if(juego.getApuesta()>juego.getSaldo()){
            mensaje.setText("Apuesta mayor al saldo");
            return;
        }

        juego.iniciarPartida();
        juego.repartirIniciales();

        partidaActiva=true;
        cartasVisibles=true;

        mensaje.setText("Tu turno");
        menu.getPedirCarta().setDisable(false);
        menu.getPlantarse().setDisable(false);
        menu.getNuevaPartida().setDisable(true);

        //Deshabilita fichas
        menu.getFicha10().setDisable(true);
        menu.getFicha20().setDisable(true);
        menu.getFicha50().setDisable(true);
        menu.getFicha100().setDisable(true);
        menu.getLimpiarApuesta().setDisable(true);

        actualizarInterfaz();
    }

    //Pide una carta al jugador
    private void pedirCarta(){
        if(!partidaActiva){
            return;
        }
        juego.repartirCarta();
        actualizarInterfaz();

        //Si se pasa termina la partida
        if(juego.getPuntosJugador()>21){
            mensaje.setText("Te pasaste de 21");
            finalizarRonda(false,false);
        }
    }

    //Termina el turno del jugador
    private void plantarse(){
        if(!partidaActiva){
            return;
        }
        juego.jugarDealer();
        actualizarInterfaz();

        String res=juego.getResultado();
        mensaje.setText(res);

        boolean gano=res.contains("Ganaste");
        boolean empate=res.contains("Empate");
        finalizarRonda(gano,empate);
    }

    //Finaliza la ronda y resuelve dinero
    private void finalizarRonda(boolean gano, boolean empate){
        juego.resolverApuesta(gano,empate);
        partidaActiva=false;
        cartasVisibles=true; //se quedan visibles

        menu.getPedirCarta().setDisable(true);
        menu.getPlantarse().setDisable(true);
        menu.getNuevaPartida().setDisable(false);

        //Habilita fichas otra vez
        menu.getFicha10().setDisable(false);
        menu.getFicha20().setDisable(false);
        menu.getFicha50().setDisable(false);
        menu.getFicha100().setDisable(false);
        menu.getLimpiarApuesta().setDisable(false);

        actualizarInterfaz();
    }

    //Actualiza los datos de la pantalla
    private void actualizarInterfaz(){

        lblSaldo.setText("Saldo: $"+juego.getSaldo());
        lblApuesta.setText("Apuesta: $"+juego.getApuesta());

        if(cartasVisibles){
            puntosDealer.setText("Puntos: "+juego.getPuntosDealer());
            puntosJugador.setText("Puntos: "+juego.getPuntosJugador());
            mostrarCartasDealer();
            mostrarCartasJugador();
        }else{
            puntosDealer.setText("");
            puntosJugador.setText("");
            cartasDealer.getChildren().clear();
            cartasJugador.getChildren().clear();
        }
    }

    //Muestra las cartas del dealer
    private void mostrarCartasDealer(){
        cartasDealer.getChildren().clear();
        for(CartaInglesa carta:juego.getCartasDealer()){
            //Muestra la carta
            carta.makeFaceUp();
            Label cartaLabel=crearCarta(carta);
            cartasDealer.getChildren().add(cartaLabel);
        }
    }

    //Muestra las cartas del jugador
    private void mostrarCartasJugador(){
        cartasJugador.getChildren().clear();
        for(CartaInglesa carta:juego.getCartasJugador()){
            Label cartaLabel=crearCarta(carta);
            cartasJugador.getChildren().add(cartaLabel);
        }
    }

    //Crea la apariencia de una carta
    private Label crearCarta(CartaInglesa carta){
        Label label=new Label(carta.toString());
        label.setPrefSize(85,120);
        label.setMinSize(85,120);
        label.setMaxSize(85,120);
        label.setAlignment(Pos.CENTER);
        label.setStyle(
                "-fx-background-color:white;"+
                        "-fx-border-color:black;"+
                        "-fx-border-width:2px;"+
                        "-fx-border-radius:8px;"+
                        "-fx-background-radius:8px;"+
                        "-fx-font-size:26px;"
        );
        //Efecto al pasar el mouse
        label.setOnMouseEntered(e->{
            label.setScaleX(1.07);
            label.setScaleY(1.07);
            label.setTranslateY(-6);
        });
        label.setOnMouseExited(e->{
            label.setScaleX(1);
            label.setScaleY(1);
            label.setTranslateY(0);
        });
        return label;
    }
}