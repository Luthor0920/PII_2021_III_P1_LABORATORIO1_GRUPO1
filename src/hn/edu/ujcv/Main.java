package hn.edu.ujcv;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        int i=0, opcion, numero = 0;
        String respuesta;
        String[] diario = new String[20];
        int[][] Numeros = new int[20][5];
        String[] nombresVenderSemanal = new String[20];
        int[][] numerosVenderSemanal = new int[20][2];
        String[] nombresVenderMensual = new String[100];

        try {
            do {
                System.out.println("Elija una opcion");
                System.out.println("1 - Vender Diario");
                System.out.println("2 - Vender Semanal");
                System.out.println("3 - Vender Mensual");
                System.out.println("4 - Juego Diario");
                System.out.println("5 - Juego Semanal");
                System.out.println("6 - Juego Mensual");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        venderDiario(i, Numeros, diario);
                        i++;
                        break;
                    case 2:
                        VenderSemana(i, numerosVenderSemanal, nombresVenderSemanal);
                        i++;
                        break;
                    case 3:
                        venderMensual(nombresVenderMensual, numero);
                        i++;
                        break;
                    case 4:
                        JuegoDiario(i, Numeros, diario);
                        break;
                    case 5:
                        JuegoSemana(i, numerosVenderSemanal, nombresVenderSemanal);
                        break;
                    case 6:
                        JuegoMensual(nombresVenderMensual, numero);
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }

                System.out.print("Desea continuar? S/N ");
                respuesta = teclado.next();
            } while (respuesta.equalsIgnoreCase("S"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void venderDiario(int i, int[][] numeros, String[] vector) {
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        try {

            System.out.print("Ingrese su nombre: ");
            vector[i] = entrada.next();
            int repetido;

            //Guardar 5 numeros
            for (int l = 0; l < 5; l++) {
                repetido = 0;
                System.out.print("Ingrese un numero (1-100): ");
                int numero = entrada.nextInt();

                for (int j = 0; j < 20; j++) {
                    for (int k = 0; k < 5; k++) {
                        //System.out.println("posicion " + j + " " + k + ": " + numeros[j][k]);

                        if (numeros[j][k] == numero) {
                            repetido = 1;
                            l--;   //variable que controla que solo se guarden 5

                            System.out.println("El numero " + numero + " ya esta tomado.");
                        }
                    }
                }
                if (repetido != 1)
                    numeros[i][l] = numero;

            }


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void VenderSemana(int i, int[][] boleto,String[] cliente) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Ingrese su nombre: ");
        cliente[i] = teclado.next();
        int repetido;

        for (int l = 0; l < 2; l++) {
            repetido = 0;
            System.out.print("Ingrese un numero (1-100): ");
            int numero = teclado.nextInt();

            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 2; k++) {
                    //System.out.println("posicion " + j + " " + k + ": " + numeros[j][k]);

                    if (boleto[j][k] == numero) {
                        repetido = 1;
                        l--;
                        System.out.println("El numero " + numero + " ya esta tomado.");
                    }
                }
            }
            if (repetido != 1)
                boleto[i][l] = numero;

        }

    }

    private static void venderMensual(String[] nombres, int numero) {
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        String nombre;
        int ingresado = 0;
        System.out.print("Ingrese su nombre: ");
        nombre = entrada.next();

        do {
            System.out.print("Ingrese un numero (0-100): ");
            numero = entrada.nextInt();

            if (nombres[numero] == null) {
                nombres[numero] = nombre;
                ingresado = 1;
            } else {
                System.out.println("El numero " + numero + " ya esta tomado.");
            }
        } while (ingresado == 0);
        //for (int i = 0; i < 100; i++)
        //  System.out.println("posicion " + i + ": " + nombres[i]);


    }

    public static void JuegoDiario(int contador, int[][] numeros, String[] vector) {
        int[][] generadosDiario = new int[10][10];
        if (vector[0] == null) {
            System.out.println("No existen boletos");
        }else {
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < 5; j++) {
                    generadosDiario[i][j] = obtenerNumeroAzar();
                }
            }
            for (int i = 0; i < 1; i++) {
                System.out.println("Numeros Ganadores");
                for (int j = 0; j < 5; j++) {
                    System.out.print(generadosDiario[i][j] + " ");
                }
                System.out.println();
            }
            if (generadosDiario == numeros) {
                contador++;
            } else {
                contador = contador;
            }
            if (contador == 3) {
                for (int i = 0; i < contador; i++) {
                    System.out.println(vector[i]);
                    for (int j = 0; j < 5; j++) {
                        System.out.print(numeros[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Usted acerto 3 numero, GANÓ 5,000");
            } else if (contador == 4) {
                for (int i = 0; i < contador; i++) {
                    System.out.println(vector[i]);
                    for (int j = 0; j < 5; j++) {
                        System.out.print(numeros[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Usted ha acertado 4 numeros, GANÓ 10,000");
            } else if (contador == 5) {
                for (int i = 0; i < contador; i++) {
                    System.out.println(vector[i]);
                    for (int j = 0; j < 5; j++) {
                        System.out.print(numeros[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Usted ha acertado 5 numeros, GANÓ 100,000");
            } else {
                System.out.println("No ha acertado numero, Intenta de nuevo");
            }
        }
    }

    public static void JuegoSemana(int contador, int[][] boleto,String[] cliente) {
        int[][] generadosSemana = new int[10][10];
        int w=0; boolean acertado=false;
        if (cliente[0] == null) {
            System.out.println("No existen boletos");
        }else {
            //Genera 2 numeros al azar del 1 al 100
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < 2; j++) {
                    generadosSemana[i][j] = obtenerNumeroAzar();
                    if (generadosSemana[0][0] == generadosSemana[0][1]) {
                        i--;
                    }
                }
            }

            for (int i = 0; i < 1; i++) {
                System.out.println("Numeros Ganadores");
                for (int j = 0; j < 2; j++) {
                    System.out.print(generadosSemana[i][j] + " ");
                }
                System.out.println();
            }

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 2; j++) {
                    if (generadosSemana[0][0] == boleto[i][j]) {
                        contador = 1;
                    } else if (generadosSemana[0][1] == boleto[i][j]) {
                        contador = 1;
                    } else if ((generadosSemana[0][0] == boleto[i][j]) && (generadosSemana[0][1] == boleto[i][j])) {
                        contador = 2;
                        w=i;
                    }
                }
            }


            if (contador==1) {
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 1; j++) {
                        if (generadosSemana[0][0] == boleto[i][j]) {
                            w=i;
                            acertado=true;
                        }
                    }
                }
                if (acertado==true){
                    System.out.println(cliente[w]);
                    System.out.println("Usted acerto el 1er numero, GANÓ 10,000");
                }

                w=0;acertado=false;
                for (int i = 0; i < 20; i++) {
                    for (int j = 1; j < 2; j++) {
                        if (generadosSemana[0][1] == boleto[i][j]) {
                            w=i;
                            acertado=true;
                        }
                    }
                }
                if (acertado==true){
                    System.out.println(cliente[w]);
                    System.out.println("Usted acerto el 2do numero, GANÓ 1,000");
                }


            } else if (contador == 2)
            {
                System.out.println(cliente[w]);
                System.out.println("Usted ha acertado 2 numeros, GANÓ 100,000");
            } else {
                System.out.println("No ha acertado numero, Intenta de nuevo");
            }

        }
    }

    private static void JuegoMensual(String[] nombres, int numero){
        int generadoMensual;
        int vacio=0;

        for (int i = 0; i < 100; i++) {
            if (nombres[i] == null)
                vacio++;
        }
        if (vacio==100) {
            System.out.println("No existen boletos.");
        } else {
            generadoMensual = obtenerNumeroAzar();
            System.out.println("El numero ganador es " + generadoMensual);
            if (generadoMensual == numero) {
                System.out.println("Felicidades " + nombres[numero]);
                System.out.println("Usted ha ganado 10,000");
            } else {
                System.out.println("Usted no ha acertado, intente de nuevo");
            }
        }

    }

    public static int obtenerNumeroAzar() {
        return (int) (Math.random()*(100-0)+1) + 0;
    }
}