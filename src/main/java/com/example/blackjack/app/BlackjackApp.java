package com.example.blackjack.app;

import com.example.blackjack.controlador.GameController;
import java.util.Scanner;

//Clase principal del BLACKJACK
public class BlackjackApp{

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        GameController juego=new GameController();

        int opcion;

        do{

            System.out.println("\nBLACKJACK 21");
            System.out.println("1.- Nueva partida");
            System.out.println("2.- Pedir carta");
            System.out.println("3.- Plantarse");
            System.out.println("4.- Ver cartas");
            System.out.println("5.- Salir");
            System.out.print("Selecciona una opcion: ");

            opcion=scanner.nextInt();

            switch(opcion){

                case 1:

                    juego.iniciarPartida();
                    System.out.println("Nueva partida.");
                    break;

                case 2:

                    juego.repartirCarta();

                    System.out.println("Carta repartida.");
                    System.out.println("Tus cartas: "+juego.getCartasJugador());
                    System.out.println("Puntos: "+juego.getPuntosJugador());

                    //Si se pasa termina
                    if(juego.getPuntosJugador()>21){

                        System.out.println("Te pasaste de 21.");
                        System.out.println(juego.getResultado());
                    }

                    break;

                case 3:

                    juego.jugarDealer();

                    System.out.println("\nCartas del dealer: "+juego.getCartasDealer());
                    System.out.println("Puntos dealer: "+juego.getPuntosDealer());

                    System.out.println("\nTus cartas: "+juego.getCartasJugador());
                    System.out.println("Puntos jugador: "+juego.getPuntosJugador());

                    System.out.println("\n"+juego.getResultado());

                    break;

                case 4:

                    System.out.println("\nTus cartas: "+juego.getCartasJugador());
                    System.out.println("Puntos jugador: "+juego.getPuntosJugador());

                    //Solo muestra la primera carta del dealer
                    System.out.println("Carta visible del dealer: "
                            +juego.getCartasDealer().get(0));

                    break;

                case 5:

                    System.out.println("Gracias por jugar.");
                    break;

                default:

                    System.out.println("Opcion no valida.");
            }

        }while(opcion!=5);

        scanner.close();
    }
}