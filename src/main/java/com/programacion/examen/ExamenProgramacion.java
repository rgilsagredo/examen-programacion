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
        final int TAMAÑ0 = 10;
        char[] tablero = new char[TAMAÑ0];

        char jugador = USUARIO;
        for (int i = 0; i < 5; i++) {
            tablero = jugar(jugador, tablero, ORDENADOR, USUARIO, TAMAÑ0);
        }

    } // main

    public static char[] jugar(char jugador, char[] tablero, final char ORDENADOR, final char USUARIO,
            final int TAMAÑO) {

        int posicion;
        if (jugador == ORDENADOR) {
            posicion = juegaOrdenador(tablero, ORDENADOR, USUARIO, TAMAÑO);
        } else {
            posicion = juegaUsuario(tablero, ORDENADOR, USUARIO, TAMAÑO);
        }
        tablero[posicion] = jugador;
        return tablero;

    } // jugar

    public static int juegaUsuario(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑ0) {
        int posicion;
        System.out.println(Arrays.toString(tablero));
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce posición: ");
        posicion = esPosicionBuena(tablero, ORDENADOR, USUARIO, TAMAÑ0, sc);
        return posicion;
    } // juegaUsuario

    public static int esPosicionBuena(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑ0,
            Scanner sc) {

        int posicion = 0;
        boolean posicionOK = false;
        boolean dentroLimites = false;
        boolean noOcupada = false;

        while (!posicionOK) {
            posicion = sc.nextInt();
            dentroLimites = !(posicion < 0 || posicion >= TAMAÑ0);

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
        int posicion = esPosicionBuena(tablero, ORDENADOR, USUARIO, TAMAÑO, rnd);
        return posicion;

    } // juegaOrdenador

    public static int esPosicionBuena(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO,
            Random rnd) {
        boolean posicion_ok = false;
        int posicion = 0;
        while (!posicion_ok) {
            posicion = rnd.nextInt(TAMAÑO);
            if (!(tablero[posicion] == ORDENADOR || tablero[posicion] == USUARIO)) {
                posicion_ok = true;
            }
        }
        return posicion;
    } // esPosicionBuena

    public static boolean hayEmpate(final char ORDENADOR, final char USUARIO, final int TAMAÑ0, char[] tablero) {
        boolean hayEmpate = false;
        if (!hayGanador(tablero, TAMAÑ0, ORDENADOR, USUARIO) && !hayHuecos(ORDENADOR, USUARIO, tablero)) {
            hayEmpate = true;
        }
        return hayEmpate;
    }

    public static boolean hayGanador(char[] tablero, final int TAMAÑ0, final char ORDENADOR, final char USUARIO) {
        boolean hayGanador = false;
        char posicionActual;
        for (int i = 0; i < TAMAÑ0 - 2; i++) {
            posicionActual = tablero[i];
            if (posicionActual != ORDENADOR && posicionActual != USUARIO) {
                continue;
            }
            if (tablero[i + 1] == posicionActual && tablero[i + 2] == posicionActual) {
                hayGanador = true;
                break;
            }
        } // recorrer tablero

        return hayGanador;
    } // hayGanador

    public static boolean hayHuecos(final char ORDENADOR, final char USUARIO, char[] tablero) {
        boolean hayHuecos = false;
        for (char c : tablero) {
            if (c != ORDENADOR && c != USUARIO) {
                hayHuecos = true;
                break;
            }
        }
        return hayHuecos;
    } // hayHuecos

} // ExamenProgramacion
