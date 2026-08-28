package com.example.blackjack.modelo;
import com.example.blackjack.componentes.CartaInglesa;
import com.example.blackjack.componentes.Mazo;
import java.util.ArrayList;

public class Modelo{
    //Mazo que se utiliza para jugar
    private Mazo mazo;
    //Cartas que tiene el jugador
    private ArrayList<CartaInglesa> cartasJugador;

    //Constructor del modelo
    public Modelo(){
        //Crea un nuevo mazo
        mazo=new Mazo();
        //Crea una lista vacía para las cartas del jugador
        cartasJugador=new ArrayList<>();
    }

    //Reparte una carta al jugador
    public void repartirCartaJugador(){
        //Obtiene una carta del mazo
        CartaInglesa carta=mazo.obtenerUnaCarta();
        //Comprueba que haya una carta disponible
        if(carta!=null){
            //Agrega la carta a las cartas del jugador
            cartasJugador.add(carta);
        }
    }

    //Regresa las cartas que tiene el jugador
    public ArrayList<CartaInglesa> getCartasJugador(){
        return cartasJugador;
    }
}