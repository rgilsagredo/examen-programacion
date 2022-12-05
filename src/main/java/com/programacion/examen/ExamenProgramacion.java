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
        final char[] T5 = {USUARIO,ORDENADOR,USUARIO,USUARIO,ORDENADOR,USUARIO,USUARIO,ORDENADOR,USUARIO,USUARIO};

    } // main
} // ExamenProgramacion
