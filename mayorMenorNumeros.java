package com.mycompany.examen;

import java.awt.Color;

public class almacenar10numeros {

    int mayor, menor;
    int numeros[] = new int[3];

    public static void main(String args[]) {

        int contador = 0;
        int rpta;
        int opc;
        almacenar10numeros objx = new almacenar10numeros();// creacion del objeto

        String texto = "------- Menu de opciones calculo mayor y menor de un grupo de numeros--------\n"
                + "[1] Ingresar datos\n"
                + "[2] Mostrar datos\n"
                + "[9] Finalizar\n"
                + "--------------------------------------\n"
                + "Ingrese la opción\n";

        do {
            opc = LE.leerInt(texto);

            switch (opc) {
                case 1:
                    // Ingresar datos
                    do {
                        objx.ingresarDatos(contador);// invocacion del metodo ingresar datos recibe parametro contador
                        contador++;
                        rpta = LE.mostrarPreguntaOpcion2("Deseas continua?");
                    } while (rpta == 0 && contador <= 2);// si es que quiere continuar y si son menos de la cantidad indicada

                    break;
                case 2:
                    // Mostrar datos
                    objx.calcularMenor();
                    objx.calcularMayor();
                    objx.mostrarDatos();

                    break;

                case 9:
                    break;
                default:
                    LE.mostrarAdvertencia("Opcion no valida...reintente");
            }

        } while (opc != 9);

    }

    // Metodo constructor
    almacenar10numeros() {

        mayor = 0; // inicializacion de variables
        menor = 999999;

    }

    // Metodos de instancia
    void ingresarDatos(int contador) {
        numeros[contador] = LE.leerInt("Ingresa numero: ");
    }

    void calcularMayor() {
        for (int i = 0; i < 3; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
    }

    void calcularMenor() {
        for (int i = 0; i < 3; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }
    }

    void mostrarDatos() {
        String datos = "",
                letra;
        for (int i = 0; i < 3; i++) {

            datos = datos + numeros[i] + "\n";
        }
        datos = datos + "Total de estudiantes: " + 3 + "\n";
        LE.mostrarInformacion("Los numeros ingresados son: " + "\n" + datos);
        LE.mostrarInformacion("El mayor es : " + mayor);
        LE.mostrarInformacion("el menor es: " + menor);

    }
}
