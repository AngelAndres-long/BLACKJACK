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

    //Nueva partida (limpia manos)
    public void iniciarPartida(){
        modelo.iniciarPartida();
    }

    //Reparte las 4 cartas iniciales
    public void repartirIniciales(){
        modelo.repartirIniciales();
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

    //Dinero
    public int getSaldo(){
        return modelo.getSaldo();
    }

    public int getApuesta(){
        return modelo.getApuesta();
    }

    public void sumarApuesta(int valor){
        modelo.sumarApuesta(valor);
    }

    public void limpiarApuesta(){
        modelo.limpiarApuesta();
    }

    public void resolverApuesta(boolean gano, boolean empate){
        modelo.resolverApuesta(gano,empate);
    }
}