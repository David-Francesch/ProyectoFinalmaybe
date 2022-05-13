

import java.util.ArrayList;
import java.util.Scanner;

public class Mainfinal {
    public static void main(String[] args) throws Exception {

        // Cuadrado();
        // Matrices();
        // Abecedario2();
        conPalabra();
    }

    public static void Cuadrado() {
        Scanner sc= new Scanner(System.in);
        Scanner sci= new Scanner(System.in);

        System.out.println("Introduce la letra con la que quieres formar el cuadrado: ");
        String letra = sc.nextLine();

        System.out.println("Introduce tamaño del lado del cuadrado: ");
        int lado = sci.nextInt();

        for (int i = 0; lado > i; i++) {
            for (int j = 0; j < lado; j++) {
                System.out.print(letra+" ");
            }
            System.out.println();
        }
    }
    
    public static void Matrices() {
        String[][] matriz = new String[5][5];
        char a = 'A';
        // int unicode = a.charAt(0);

        // System.out.println(unicode);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                // matriz[i][j].add(Integer.toString(unicode));
                // matriz[i][j].add("w");

                matriz[i][j] = Character.toString(a);
                a++;
                // unicode++;
            }
        }
        // System.out.println(matriz);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void Abecedario2() {
        String[][] matriz = new String[5][5];
        Scanner sc= new Scanner(System.in);

        System.out.println("Desde que letra quieres empezar:");
        String letra = sc.nextLine().toLowerCase();
        char a = letra.charAt(0);
        // char a = 'A';
        // int unicode = a.charAt(0);

        // System.out.println(unicode);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {

                if (a == 'x') {
                    a++;
                }
                              
                if (a > 'z') {
                    a = 'a';
                    matriz[i][j] = Character.toString(a);
                    a++;
                }else{
                    matriz[i][j] = Character.toString(a);
                    a++;
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void conPalabra() {
        Scanner sc= new Scanner(System.in);

        char[][] matriz = new char[5][5];
        String limpia = "";
        int x = 0;
        
        System.out.println("Escribe la palabra con la que quieres empezar:");
        String palabra = sc.nextLine().toUpperCase();
        
        for(int i = 0; i < palabra.length()-1; i++) {
            int contpa = 0;
            for (int j = 0; j < limpia.length(); j++) {
                if (limpia.charAt(j) == palabra.charAt(i)) {
                    contpa ++;
                }
            }
            if (contpa <= 0) {
                limpia += palabra.charAt(i);
            }
        }
        
        // for (int i = 0; i < palabra.length(); i++) {
            //     for (int j = 0; j < matriz.length-1; j++) {
                //         if (palabra.charAt(i) != palabra.charAt(j)) {
                    //             limpia += palabra.charAt(j);
                    //         }
                    //     }
                    // }
                    
                    System.out.println(limpia);
                    
                    // mete la palabra en la matriz
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz.length; j++) {
                            if(x < limpia.length()){
                                matriz[i][j] = limpia.charAt(x);
                                x++;
                            }
                        }
                    }
                    
                    //mete el abecedario
                    char letra = 'A';
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz.length; j++) {
                            
                            // matriz[i][j] = palabra.toCharArray()[i];
                            // if(matriz[i][j]){
                                
                                // }
                                for (int j2 = 0; j2 < limpia.length(); j2++) {
                                    if(limpia.charAt(j2) != letra){
                                        if (matriz[i][j] == 0) {
                                            if (letra == 'X') {
                                                letra++;
                                }
                                            
                                if (letra > 'Z') {
                                    letra = 'A';
                                    matriz[i][j] = letra;
                                    letra++;
                                }else{
                                    matriz[i][j] = letra;
                                    letra++;
                                }
                            }


                        }else{
                            letra++;
                        }
                }
            }
        }

        // muestra matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
}


