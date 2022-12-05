package com.programacion.examen;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ExamenProgramacion {
    public static void main(String[] args) {

        // creamos jugadores
        final char ORDENADOR = 'O';
        final char USUARIO = 'U';

        // creamos tablero
        final int TAMAÑO = 10;
        char[] tablero = new char[TAMAÑO];

        // controladores de fin de juego
        boolean acabarJuego = false;

        // jugador inicial
        char jugador = ORDENADOR;

        // jugar
        while (!acabarJuego) {
            acabarJuego = jugar(jugador, tablero, ORDENADOR, USUARIO, TAMAÑO);
            if (jugador == ORDENADOR && !acabarJuego) {
                jugador = USUARIO;
            } else if (jugador == USUARIO && !acabarJuego) {
                jugador = ORDENADOR;
            }
        }

        // mostrar resultado final
        mostrarResultado(jugador, tablero, ORDENADOR, USUARIO, TAMAÑO);

    } // main

    private static void mostrarResultado(char jugador, char[] tablero, final char ORDENADOR, final char USUARIO,
            final int TAMAÑO) {

        if (hayEmpate(tablero, ORDENADOR, USUARIO, TAMAÑO)) {
            System.out.println("Empate!");
        } else {
            System.out.println("Ganó " + jugador);
        }

        System.out.println(Arrays.toString(tablero));
    } // mostrarResultado

    public static boolean jugar(char jugador, char[] tablero, final char ORDENADOR, final char USUARIO,
            final int TAMAÑO) {

        tablero = hacerJugada(jugador, tablero, ORDENADOR, USUARIO, TAMAÑO);
        return acabarJuego(tablero, ORDENADOR, USUARIO, TAMAÑO);

    } // jugar

    public static boolean acabarJuego(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO) {

        return hayGanador(tablero, TAMAÑO, ORDENADOR, USUARIO) || hayEmpate(tablero, ORDENADOR, USUARIO, TAMAÑO);

    } // acabarJuego

    public static char[] hacerJugada(char jugador, char[] tablero, final char ORDENADOR, final char USUARIO,
            final int TAMAÑO) {

        int posicion;

        if (jugador == ORDENADOR) {
            posicion = juegaOrdenador(tablero, ORDENADOR, USUARIO, TAMAÑO);
        } else {
            posicion = juegaUsuario(tablero, ORDENADOR, USUARIO, TAMAÑO);
        }

        tablero[posicion] = jugador;
        return tablero;

    } // hacerJugada

    public static int juegaUsuario(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO) {

        int posicion;

        System.out.println(Arrays.toString(tablero));
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce posición: ");

        posicion = esPosicionBuena(tablero, ORDENADOR, USUARIO, TAMAÑO, sc);
        return posicion;

    } // juegaUsuario

    public static int esPosicionBuena(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO,
            Scanner sc) {

        int posicion = 0;

        boolean dentroLimites = false;
        boolean noOcupada = false;
        boolean posicionOK = dentroLimites && noOcupada;

        while (!posicionOK) {

            posicion = sc.nextInt();
            dentroLimites = !(posicion < 0 || posicion >= TAMAÑO);

            if (dentroLimites) {
                noOcupada = !(tablero[posicion] == ORDENADOR || tablero[posicion] == USUARIO);
            }

            posicionOK = dentroLimites && noOcupada;
            if (!posicionOK) {
                System.out.println("Posición inválida, introduce una nueva: ");
            }
        }

        return posicion;
    }

    public static int juegaOrdenador(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO) {

        Random rnd = new Random();
        return esPosicionBuena(tablero, ORDENADOR, USUARIO, TAMAÑO, rnd);

    } // juegaOrdenador

    public static int esPosicionBuena(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO,
            Random rnd) {

        boolean posicion_ok = false;
        int posicion = 0;

        while (!posicion_ok) {
            posicion = rnd.nextInt(TAMAÑO);
            posicion_ok = !(tablero[posicion] == ORDENADOR || tablero[posicion] == USUARIO);
        }

        return posicion;

    } // esPosicionBuena

    public static boolean hayEmpate(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO) {

        return !hayGanador(tablero, TAMAÑO, ORDENADOR, USUARIO) && !hayHuecos(ORDENADOR, USUARIO, tablero);

    } // hayEmpate

    public static boolean hayGanador(char[] tablero, final int TAMAÑO, final char ORDENADOR, final char USUARIO) {

        boolean hayGanador = false;
        char posicionActual;

        for (int i = 0; i < TAMAÑO - 2; i++) {

            posicionActual = tablero[i];

            boolean esHueco = (posicionActual != ORDENADOR) && (posicionActual != USUARIO);
            if (esHueco) {
                continue;
            }

            hayGanador = (tablero[i + 1] == posicionActual) && (tablero[i + 2] == posicionActual);
            if (hayGanador) {
                break;
            }
        } // recorrer tablero

        return hayGanador;

    } // hayGanador

    public static boolean hayHuecos(final char ORDENADOR, final char USUARIO, char[] tablero) {

        boolean hayHuecos = false;

        for (char c : tablero) {
            hayHuecos = (c != ORDENADOR && c != USUARIO);
            if (hayHuecos) {
                break;
            }
        }

        return hayHuecos;

    } // hayHuecos

} // ExamenProgramacion
