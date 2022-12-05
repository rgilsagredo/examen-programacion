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
        final char[] T2 = {USUARIO,USUARIO,ORDENADOR,ORDENADOR,ORDENADOR,USUARIO,ORDENADOR,USUARIO,ORDENADOR,USUARIO};

        // T3 -- no hay ganador con huecos
        final char[] T3 = new char[TAMAÑ0];
        T3[2] = USUARIO;
        T3[3] = ORDENADOR;
        T3[4] = USUARIO;
        T3[0] = ORDENADOR;
        T3[9] = ORDENADOR;

        // T4 -- no hay ganador sin huecos
        final char[] T4 = {USUARIO,USUARIO,ORDENADOR,USUARIO,ORDENADOR,USUARIO,ORDENADOR,USUARIO,ORDENADOR,USUARIO};

        // detectamos huecos
        boolean hayHuecos = false;
        for(char c: T1){
            hayHuecos = (c != ORDENADOR || c != USUARIO) ? true:false;
        }

        System.out.println(hayHuecos);


    } // main

    public static boolean hayGanador(final char[] TABLERO, final int TAMAÑ0) {
        boolean hayGanador = false;
        char posicionActual;
        for (int i = 0; i < TAMAÑ0 - 2; i++) {
            posicionActual = TABLERO[i];
            if (TABLERO[i + 1] == posicionActual && TABLERO[i + 2] == posicionActual) {
                hayGanador = true;
                break;
            }
        } // recorrer tablero

        return hayGanador;
    } // hayGanador
} // ExamenProgramacion
