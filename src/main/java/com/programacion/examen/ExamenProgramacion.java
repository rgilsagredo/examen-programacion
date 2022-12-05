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

        // metodo para jugar
        // ver que jugadr juega
        // comprobar restricciones
        // poner ficha
        char jugador = ORDENADOR;        
        tablero = jugar(jugador, tablero, ORDENADOR, TAMAÑ0);

        jugador = USUARIO;
        tablero = jugar(jugador, tablero, ORDENADOR, TAMAÑ0);
        System.out.println(Arrays.toString(tablero));

    } // main

    public static char[] jugar(char jugador, char[] tablero, final char ORDENADOR, final int TAMAÑ0) {

        int posicion;
        if (jugador == ORDENADOR) {
            posicion = juegaOrdenador(TAMAÑ0);
        } else {
            posicion = juegaUsuario(tablero);
        }
        tablero[posicion] = jugador;
        return tablero;

    } // jugar

    public static int juegaUsuario(char[] tablero) {
        int posicion;
        System.out.println(Arrays.toString(tablero));
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce posición: ");
        posicion = sc.nextInt();
        sc.close();
        return posicion;
    }

    public static int juegaOrdenador(final int TAMAÑ0) {
        Random rnd = new Random();
        return rnd.nextInt(TAMAÑ0);
    } // juegaOrdenador

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
