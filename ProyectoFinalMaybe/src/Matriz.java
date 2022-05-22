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
        String msj = sc.nextLine().toUpperCase();

        if (msj.length()%2 != 0) {
            msj += 'X';
        }

        int x_letra1,y_letra1;
        int x_letra2,y_letra2;
        int new_x_letra1, new_y_letra1, new_x_letra2, new_y_letra2;

        for (int i = 0; i < msj.length() - 1; i+=2) {
            x_letra1 = EncuentraX(msj.charAt(i));
            y_letra1 = EncuentraY(msj.charAt(i));
            System.out.println("letra: "+msj.charAt(i)+x_letra1+","+y_letra1);

            x_letra2 = EncuentraX(msj.charAt(i + 1));
            y_letra2 = EncuentraY(msj.charAt(i + 1));
            System.out.println("letra: "+msj.charAt(i+1)+x_letra2+","+y_letra2);

            new_x_letra1 = EncuentraX1(x_letra1, y_letra1, x_letra2, y_letra2);
            new_y_letra1 = EncuentraY1(x_letra1, y_letra1, x_letra2, y_letra2);
            System.out.println("letra  C: "+msj.charAt(i)+new_x_letra1+","+new_y_letra1);

            new_x_letra2 = EncuentraX1(x_letra1, y_letra1, x_letra2, y_letra2);
            new_y_letra2 = EncuentraY1(x_letra1, y_letra1, x_letra2, y_letra2);
            System.out.println("letra  C: "+msj.charAt(i+1)+new_x_letra2+","+new_y_letra2);
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

    public int EncuentraX(char letra) {
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz.length; y++) {
                if (matriz[x][y] == letra) {
                    return x;
                }
            }
        }
        return 0;
    }

    public int EncuentraY(char letra) {
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz.length; y++) {
                if (matriz[x][y] == letra) {
                    return y;
                }
            }
        }
        return 0;
    }

    public int EncuentraX1(int x_letra1, int y_letra1, int x_letra2, int y_letra2) {
        
        int Coordx;

        if (x_letra1 == x_letra2) {
            if (x_letra1 == 4) {
                Coordx = 0;
            }else{
                Coordx = x_letra1 +1;
            }
        }else if(y_letra1 == y_letra2) {
            if (y_letra1 == 4) {
                Coordx = 0;
            }else{
                Coordx = x_letra1;
            }
        }else{
            Coordx = y_letra2;
        }
        return Coordx;
    }

    public int EncuentraY1(int x_letra1, int y_letra1, int x_letra2, int y_letra2) {
        
        int Coordy;

        if (x_letra1 == x_letra2) {
            if (x_letra1 == 4) {
                Coordy = 0;
            }else{
                Coordy = y_letra1 + 1;
            }
        }else if(y_letra1 == y_letra2) {
            if (y_letra1 == 4) {
                Coordy = 0;
            }else{
                Coordy = y_letra1 +1;
            }
        }else{
            Coordy = x_letra2;
        }
        return Coordy;
    }
}