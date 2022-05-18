import java.util.Scanner;

public class Matriz {
    Scanner sc = new Scanner(System.in);
    private char[][] matriz;

    public Matriz() {
        this.matriz = new char[5][5];

        rellenarMatriz(limpiarClave().replaceAll(" ", ""));
    }

    public String limpiarClave() {
        String limpia = "";
        System.out.println("Escribe la palabra con la que quieres empezar:");
        String palabra = sc.nextLine().toUpperCase();

        for (int i = 0; i < palabra.length() ; i++) {
            int contpa = 0;
            for (int j = 0; j < limpia.length(); j++) {
                if (limpia.charAt(j) == palabra.charAt(i)) {
                    contpa++;
                }
            }
            if (contpa <= 0) {
                limpia += palabra.charAt(i);
            }
        }
        return limpia;
    }

    public void rellenarMatriz(String limpia) {
        int x = 0;
        char letra = 'A';
        int cont = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                //mete la palabra limpia
                if (x < limpia.length()) {
                    if(limpia.charAt(x) == 'J'){
                        matriz[i][j] = 'I';
                        x++;
                    }
                    matriz[i][j] = limpia.charAt(x);
                    x++;
                }else{
                    // Despues de meter la palabra limpia
                        while (checkRepetidos(limpia, letra) || letra == 'J' ) {
                        letra++;
                    }
                        matriz[i][j] = letra;
                        letra++;
                }
            }
                
        }
    }
    
    public boolean checkRepetidos(String limpia, char letra) {
        boolean esta = false;

        for (int i = 0; i < limpia.length(); i++) {
            if (limpia.charAt(i) == letra) {
                esta = true;
                return esta;
            }
        }
        
        return esta;
    }

    public String CifrarMensaje() {
        Scanner sc= new Scanner(System.in);
        String msjCif = "";
        System.out.println("Dime el mensaje que quieras cifrar");
        String msj = sc.nextLine();

        if (msj.length()/2 != 0) {
            msj += 'X';
        }

        char a1,a2;
        char b1,b2;

        for (int i = 0; i < msj.length(); i+=2) {
            for (int x = 0; x < matriz.length; x++) {
                for (int y = 0; y < matriz.length; y++) {
                    if (msj.charAt(i) == matriz[x][y]) {
                        a1 = matriz[x][y];
                    }
                    System.out.println(x+","+y);
                }
            }
        }       
        return msjCif;
    }

    @Override
    public String toString() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
        return null;
    }

}