package com.example.blackjack.modelo;

import com.example.blackjack.componentes.CartaInglesa;
import com.example.blackjack.componentes.Mazo;
import java.util.ArrayList;

public class Modelo{

    //Mazo del juego
    private Mazo mazo;

    //Cartas del jugador
    private ArrayList<CartaInglesa> cartasJugador;

    //Cartas del dealer
    private ArrayList<CartaInglesa> cartasDealer;

    //Saldo y apuesta
    private int saldo;
    private int apuesta;

    //Constructor
    public Modelo(){
        saldo=500;
        apuesta=0;
        cartasJugador=new ArrayList<>();
        cartasDealer=new ArrayList<>();
        mazo=new Mazo();
    }

    //Inicia una nueva partida (solo limpia)
    public void iniciarPartida(){
        mazo=new Mazo();
        cartasJugador=new ArrayList<>();
        cartasDealer=new ArrayList<>();
        //no reparte todavía
    }

    //Reparte las 4 cartas iniciales
    public void repartirIniciales(){
        repartirCartaJugador();
        repartirCartaJugador();
        repartirCartaDealer();
        repartirCartaDealer();
    }

    //Reparte una carta al jugador
    public void repartirCartaJugador(){
        CartaInglesa carta=mazo.obtenerUnaCarta();
        if(carta!=null){
            cartasJugador.add(carta);
        }
    }

    //Reparte una carta al dealer
    public void repartirCartaDealer(){
        CartaInglesa carta=mazo.obtenerUnaCarta();
        if(carta!=null){
            cartasDealer.add(carta);
        }
    }

    //Calcula los puntos de una mano
    private int calcularPuntos(ArrayList<CartaInglesa> mano){
        int puntos=0;
        int ases=0;
        for(CartaInglesa carta:mano){
            int valor=carta.getValor();
            //J,Q,K valen 10
            if(valor>=11 && valor<=13){
                puntos+=10;
            }
            //As vale 11 al inicio
            else if(valor==14){
                puntos+=11;
                ases++;
            }
            //Cartas normales
            else{
                puntos+=valor;
            }
        }
        //Si se pasa de 21 cambia As a 1
        while(puntos>21 && ases>0){
            puntos-=10;
            ases--;
        }
        return puntos;
    }

    //Puntos del jugador
    public int getPuntosJugador(){
        return calcularPuntos(cartasJugador);
    }

    //Puntos del dealer
    public int getPuntosDealer(){
        return calcularPuntos(cartasDealer);
    }

    //Turno del dealer
    public void jugarDealer(){
        //El dealer pide hasta llegar a 17
        while(getPuntosDealer()<17){
            repartirCartaDealer();
        }
    }

    //Obtiene el resultado
    public String obtenerResultado(){
        int jugador=getPuntosJugador();
        int dealer=getPuntosDealer();
        if(jugador>21){
            return "Perdiste, te pasaste de 21.";
        }
        if(dealer>21){
            return "Ganaste, el dealer se paso de 21.";
        }
        if(jugador>dealer){
            return "Ganaste la partida.";
        }
        if(dealer>jugador){
            return "Perdiste la partida.";
        }
        return "Empate.";
    }

    //Regresa las cartas del jugador
    public ArrayList<CartaInglesa> getCartasJugador(){
        return cartasJugador;
    }

    //Regresa las cartas del dealer
    public ArrayList<CartaInglesa> getCartasDealer(){
        return cartasDealer;
    }

    //Dinero
    public int getSaldo(){
        return saldo;
    }

    public int getApuesta(){
        return apuesta;
    }

    //Suma ficha a la apuesta
    public void sumarApuesta(int valor){
        if(apuesta+valor<=saldo){
            apuesta+=valor;
        }
    }

    //Limpia la apuesta
    public void limpiarApuesta(){
        apuesta=0;
    }

    //Resuelve la apuesta al final
    public void resolverApuesta(boolean gano, boolean empate){
        if(empate){
            //no cambia el saldo
        }else if(gano){
            saldo+=apuesta;
        }else{
            saldo-=apuesta;
        }
        apuesta=0;
    }
}