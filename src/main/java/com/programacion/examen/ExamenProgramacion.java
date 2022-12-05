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

        // controlador de posicion
        int posicion;
        int posicionUsuario = -1;

        // jugar
        while (!acabarJuego) {

            if (!acabarJuego && jugador == ORDENADOR) {

                posicion = juegaOrdenador(tablero, ORDENADOR, USUARIO, TAMAÑO, posicionUsuario);
                tablero[posicion] = jugador; 
                acabarJuego = acabarJuego(tablero, ORDENADOR, USUARIO, TAMAÑO);
                jugador = (acabarJuego) ? ORDENADOR : USUARIO;

            } else if (!acabarJuego && jugador == USUARIO) {

                posicionUsuario = juegaUsuario(tablero, ORDENADOR, USUARIO, TAMAÑO);
                tablero[posicionUsuario] = jugador;
                acabarJuego = acabarJuego(tablero, ORDENADOR, USUARIO, TAMAÑO);
                jugador = (acabarJuego) ? USUARIO : ORDENADOR;

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

    public static boolean acabarJuego(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO) {

        return hayGanador(tablero, ORDENADOR, USUARIO, TAMAÑO) || hayEmpate(tablero, ORDENADOR, USUARIO, TAMAÑO);

    } // acabarJuego

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

    public static boolean ponerEn(final int MASMENOSUNO, char[] tablero, final char ORDENADOR, final char USUARIO,
            int posicionUsuario, final int TAMAÑO) {

        boolean ponerEn = false;

        boolean posicionNoOcupada = false;
        boolean posicionDentroLimites = (posicionUsuario + MASMENOSUNO < TAMAÑO) && (posicionUsuario + MASMENOSUNO > 0);

        if (posicionDentroLimites) {
            posicionNoOcupada = !(tablero[posicionUsuario + MASMENOSUNO] == ORDENADOR
                    || tablero[posicionUsuario + MASMENOSUNO] == USUARIO);
        }

        if (posicionDentroLimites && posicionNoOcupada) {
            ponerEn = true;
        }

        return ponerEn;

    } // ponerEn

    public static int juegaOrdenador(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO,
            int posicionUsuario) {

        if (posicionUsuario != -1) {

            final int DERECHA = 1;
            final int IZQUIERDA = -1;

            if (ponerEn(DERECHA, tablero, ORDENADOR, USUARIO, posicionUsuario, TAMAÑO)) {
                return posicionUsuario + DERECHA;
            }

            if (ponerEn(IZQUIERDA, tablero, ORDENADOR, USUARIO, posicionUsuario, TAMAÑO)) {
                return posicionUsuario + IZQUIERDA;
            }
            
            Random rnd = new Random();
            return esPosicionBuena(tablero, ORDENADOR, USUARIO, TAMAÑO, rnd);

        } else {

            Random rnd = new Random();
            return esPosicionBuena(tablero, ORDENADOR, USUARIO, TAMAÑO, rnd);
        }

    } // juegaOrdenador

    public static int esPosicionBuena(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO,
            Random rnd) {

        boolean posicionOk = false;
        int posicion = 0;

        while (!posicionOk) {
            posicion = rnd.nextInt(TAMAÑO);
            posicionOk = !(tablero[posicion] == ORDENADOR || tablero[posicion] == USUARIO);
        }

        return posicion;

    } // esPosicionBuena

    public static boolean hayEmpate(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO) {

        return !hayGanador(tablero, ORDENADOR, USUARIO, TAMAÑO) && !hayHuecos(tablero, ORDENADOR, USUARIO);

    } // hayEmpate

    public static boolean hayGanador(char[] tablero, final char ORDENADOR, final char USUARIO, final int TAMAÑO) {

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

    public static boolean hayHuecos(char[] tablero, final char ORDENADOR, final char USUARIO) {

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
