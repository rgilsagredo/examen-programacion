package com.programacion.examen;

public class ExamenProgramacion {
    public static void main(String[] args) {

        // creamos jugadores
        final char ORDENADOR = 'O';
        final char USUARIO = 'U';

        // creamos tablero
        final int TAMAÑ0 = 10;
        final char[] TABLERO = new char[TAMAÑ0];

        // añado tableros "test" a mano para probar que mi metodo de victoria funciona
        final char[] T1 = new char[TAMAÑ0];
        final char[] T2 = new char[TAMAÑ0];
        final char[] T3 = new char[TAMAÑ0];
        final char[] T4 = new char[TAMAÑ0];

        // T1 -- victoria en un extremo
        T1[0] = ORDENADOR;
        T1[1] = ORDENADOR;
        T1[2] = ORDENADOR;

        // T2 -- victoria en medio
        T2[3] = USUARIO;
        T2[4] = USUARIO;
        T2[5] = USUARIO;

        // T3 -- victoria en otro extremo
        T3[9] = ORDENADOR;
        T3[8] = ORDENADOR;
        T3[7] = ORDENADOR;

        // T4 -- sin victoria, con huecos
        T4[0] = ORDENADOR;
        T4[1] = USUARIO;
        T4[2] = ORDENADOR;
        T4[3] = ORDENADOR;
        T4[6] = USUARIO;
        T4[9] = USUARIO;

        // T5 -- sin victoria, sin huecos
        final char[] T5 = { USUARIO, ORDENADOR, USUARIO, USUARIO, ORDENADOR, USUARIO, USUARIO, ORDENADOR, USUARIO,
                USUARIO };

        // victoria = encontrar 3 iguales seguidas
        // recorer tablero hasta TAMAÑO-2, ver posicion actual, si esa es igual a las 2
        // siguientes, hay ganador
        boolean hayGanador = hayGanador(T1, TAMAÑ0);
        System.out.println("T1: " + hayGanador);

        hayGanador = hayGanador(T2, TAMAÑ0);
        System.out.println("T2: " + hayGanador);

        hayGanador = hayGanador(T3, TAMAÑ0);
        System.out.println("T3: " + hayGanador);

        hayGanador = hayGanador(T4, TAMAÑ0);
        System.out.println("T4: " + hayGanador);

        hayGanador = hayGanador(T5, TAMAÑ0);
        System.out.println("T5: " + hayGanador);

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
    }
} // ExamenProgramacion
