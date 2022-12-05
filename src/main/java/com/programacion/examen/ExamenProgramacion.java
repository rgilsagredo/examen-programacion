package com.programacion.examen;

public class ExamenProgramacion {
    public static void main(String[] args) {

        // creamos jugadores
        final char ORDENADOR = 'O';
        final char USUARIO = 'U';

        // creamos tablero
        final int TAMAÑ0 = 10;
        final char[] TABLERO = new char[TAMAÑ0];

        // empate = no hay ganador y no hay huecos
        // creamos arrays para testeo

        // T1 -- hay ganador con huecos
        final char[] T1 = new char[TAMAÑ0];
        T1[2] = USUARIO;
        T1[3] = USUARIO;
        T1[4] = USUARIO;
        T1[0] = ORDENADOR;
        T1[9] = ORDENADOR;

        // T2 -- hay ganador sin huecos
        final char[] T2 = { USUARIO, USUARIO, ORDENADOR, ORDENADOR, ORDENADOR, USUARIO, ORDENADOR, USUARIO, ORDENADOR,
                USUARIO };

        // T3 -- no hay ganador con huecos
        final char[] T3 = new char[TAMAÑ0];
        T3[2] = USUARIO;
        T3[3] = ORDENADOR;
        T3[4] = USUARIO;
        T3[0] = ORDENADOR;
        T3[9] = ORDENADOR;

        // T4 -- no hay ganador sin huecos
        final char[] T4 = { USUARIO, USUARIO, ORDENADOR, USUARIO, ORDENADOR, USUARIO, ORDENADOR, USUARIO, ORDENADOR,
                USUARIO };

        // detectamos empates
        boolean hayEmpate = hayEmpate(ORDENADOR, USUARIO, TAMAÑ0, TABLERO);
        System.out.println("T1: " + hayEmpate);

         
        hayEmpate = hayEmpate(ORDENADOR, USUARIO, TAMAÑ0, T2);
        System.out.println("T2: " + hayEmpate);

        hayEmpate = hayEmpate(ORDENADOR, USUARIO, TAMAÑ0, T3);
        System.out.println("T3: " + hayEmpate);

        hayEmpate = hayEmpate(ORDENADOR, USUARIO, TAMAÑ0, T4);
        System.out.println("T4: " + hayEmpate);

    } // main

    private static boolean hayEmpate(final char ORDENADOR, final char USUARIO, final int TAMAÑ0, final char[] TABLERO) {
        boolean hayEmpate = false;
        if(!hayGanador(TABLERO, TAMAÑ0, ORDENADOR, USUARIO) && !hayHuecos(ORDENADOR, USUARIO, TABLERO)){
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
