package com.programacion.examen;

public class ExamenProgramacion {
    public static void main(String[] args) {

        // creamos jugadores
        final char ORDENADOR = 'O';
        final char USUARIO = 'U';

        // creamos tablero
        final int TAMAÑ0 = 10;
        final char[] TABLERO = new char[TAMAÑ0];

    } // main

    private static boolean hayEmpate(final char ORDENADOR, final char USUARIO, final int TAMAÑ0, final char[] TABLERO) {
        boolean hayEmpate = false;
        if (!hayGanador(TABLERO, TAMAÑ0, ORDENADOR, USUARIO) && !hayHuecos(ORDENADOR, USUARIO, TABLERO)) {
            hayEmpate = true;
        }
        return hayEmpate;
    }

    public static boolean hayGanador(final char[] TABLERO, final int TAMAÑ0, final char ORDENADOR, final char USUARIO) {
        boolean hayGanador = false;
        char posicionActual;
        for (int i = 0; i < TAMAÑ0 - 2; i++) {
            posicionActual = TABLERO[i];
            if (posicionActual != ORDENADOR && posicionActual != USUARIO) {
                continue;
            }
            if (TABLERO[i + 1] == posicionActual && TABLERO[i + 2] == posicionActual) {
                hayGanador = true;
                break;
            }
        } // recorrer tablero

        return hayGanador;
    } // hayGanador

    public static boolean hayHuecos(final char ORDENADOR, final char USUARIO, final char[] TABLERO) {
        boolean hayHuecos = false;
        for (char c : TABLERO) {
            if (c != ORDENADOR && c != USUARIO) {
                hayHuecos = true;
                break;
            }
        }
        return hayHuecos;
    } // hayHuecos

} // ExamenProgramacion
