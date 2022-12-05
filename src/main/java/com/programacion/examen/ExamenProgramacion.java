package com.programacion.examen;

public class ExamenProgramacion {
    public static void main(String[] args) {

        // creamos jugadores
        final char ORDENADOR = 'O';
        final char USUARIO = 'U';

        // creamos tablero
        final int TAMAÑ0 = 10;
        final char[] TABLERO = new char[TAMAÑ0];

        // creo casos de test a mano

        // T1 - hay ganador con huecos
        final char[] T1 = new char[TAMAÑ0];
        T1[0] = ORDENADOR;
        T1[1] = ORDENADOR;
        T1[2] = ORDENADOR;
        T1[3] = USUARIO;
        T1[9] = USUARIO;

        // T2 - hay ganador sin huecos
        final char[] T2 = { ORDENADOR, ORDENADOR, USUARIO, USUARIO, USUARIO, ORDENADOR, USUARIO, ORDENADOR, USUARIO,
                ORDENADOR };

        // T3 - no hay ganador con huecos
        final char[] T3 = new char[TAMAÑ0];
        T3[0] = ORDENADOR;
        T3[1] = USUARIO;
        T3[2] = ORDENADOR;
        T3[3] = USUARIO;
        T3[9] = USUARIO;

        // T4 - no hay ganador sin huecos
        final char[] T4 = { ORDENADOR, ORDENADOR, USUARIO, ORDENADOR, USUARIO, ORDENADOR, USUARIO, ORDENADOR, USUARIO,
                ORDENADOR };

        boolean hayGanador;

        hayGanador = hayGanador(T1, TAMAÑ0, ORDENADOR, USUARIO);
        System.out.println("T1: " + hayGanador);

        hayGanador = hayGanador(T2, TAMAÑ0, ORDENADOR, USUARIO);
        System.out.println("T2: " + hayGanador);

        hayGanador = hayGanador(T3, TAMAÑ0, ORDENADOR, USUARIO);
        System.out.println("T3: " + hayGanador);

        hayGanador = hayGanador(T4, TAMAÑ0, ORDENADOR, USUARIO);
        System.out.println("T4: " + hayGanador);

    } // main

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
} // ExamenProgramacion
