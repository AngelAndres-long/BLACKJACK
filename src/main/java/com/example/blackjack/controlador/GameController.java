package com.example.blackjack.controlador;

import com.example.blackjack.modelo.Modelo;
import com.example.blackjack.componentes.CartaInglesa;
import java.util.ArrayList;

public class GameController{

    //Modelo del juego
    private Modelo modelo;

    //Constructor
    public GameController(){
        modelo=new Modelo();
    }

    //Nueva partida
    public void iniciarPartida(){
        modelo.iniciarPartida();
    }

    //Reparte carta al jugador
    public void repartirCarta(){
        modelo.repartirCartaJugador();
    }

    //Hace jugar al dealer
    public void jugarDealer(){
        modelo.jugarDealer();
    }

    //Cartas del jugador
    public ArrayList<CartaInglesa> getCartasJugador(){
        return modelo.getCartasJugador();
    }

    //Cartas del dealer
    public ArrayList<CartaInglesa> getCartasDealer(){
        return modelo.getCartasDealer();
    }

    //Puntos del jugador
    public int getPuntosJugador(){
        return modelo.getPuntosJugador();
    }

    //Puntos del dealer
    public int getPuntosDealer(){
        return modelo.getPuntosDealer();
    }

    //Resultado de la partida
    public String getResultado(){
        return modelo.obtenerResultado();
    }
}