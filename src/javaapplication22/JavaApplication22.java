package javaapplication22;

import java.util.Scanner;
// libreria

public class JavaApplication22 {

    public static int ingresarValor() {
        Scanner teclado = new Scanner(System.in);
        // pedir el tamaño de pila
        System.out.println("Ingresa el tamaño de la pila");
        int tampila = teclado.nextInt();
        if (!"Integer".equals(((Object) tampila).getClass().getSimpleName())) {
            System.out.println(((Object) tampila).getClass().getSimpleName());
            ingresarValor();
        }
        return tampila;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int algoMas, tampila;

        try {
            // pedir el tamaño de la pila
            System.out.println("Ingresa el tamaño de la pila");
            tampila = teclado.nextInt();
            int pila[] = new int[tampila];
            // llena todos los valores del arreglo en -1
            for (int i = 0; i < pila.length; i++) {
                pila[i] = -1;
            }

            // creamos un ciclo 
            do {
                System.out.println("Elige una opcion: \n1.-Agregar \n2.-Mostrar \n3.-Eliminar \n4.-Llenar \n5.-Salir");
                int opcion = teclado.nextInt();
                switch (opcion) {
                    case 1 ->
                        pila = agregar(pila);
                    case 2 ->
                        mostar(pila);
                    case 3 ->
                        salir();
                    default ->
                        System.out.println("opcion no valida");

                }
                System.out.println("\nDeseas hacer algo mas? \n0.-Si \n1.-no");
                algoMas = teclado.nextInt();
            } while (algoMas == 0);
        } catch (Exception e) {
            System.out.println("No es una opcion valida");
        }
    }
// metodo de tipo arreglo y entero, como es un arreglo tiene que regresar un arreglo y asi con cualquier tipo de dato
    //como parametro estoy pidiendo un arreglo "(int pila[])"

    public static int[] agregar(int pila[]) {
        // el try catch sirve para que si se ingresa un dato distinto al esperado el programa no deje de funcionar
        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Agrega un valor");
            int agregarValor = teclado.nextInt();

            //agregar una validacion para que no se pueda ingresar el 0
            for (int i = 0; i < pila.length; i++) {
                if (pila[i] < 0) {
                    pila[i] = agregarValor;
                    break;
                }
            }
            if (pila[pila.length - 1] > -1) {
                System.out.println("La pila ya esta llena");
            }
        } catch (Exception e) {
            System.out.println("No es un valor valido");
        }
        //regresa el arreglo ya modificado
        return pila;
    }

    // es void porque ya no se modifica nada, solo se va a mostar
    public static void mostar(int[] pila) {
        for (int i = pila.length - 1; i >= 0; i--) {
            if (pila[i] > 0) {
                System.out.print("[" + pila[i] + "]");
            }
        }

    }

    public static void salir() {
        System.exit(0);
    }

}
