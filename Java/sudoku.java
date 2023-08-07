import java.util.*;
public class sudoku {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int[][] matriz = new int[9][9];
            int[] nove = {1,2,3,4,5,6,7,8,9};
            int[] temp = {1,2,3,4,5,6,7,8,9};
            int[] temp2 = {1,2,3,4,5,6,7,8,9};
            int[] temp3 = {1,2,3,4,5,6,7,8,9};
            int cont=0, cont1=0, cont2=0, cont3=0;
            boolean valida = true;
            for (int j = 0; j < 9; j++) {
                nove = new int[] {1,2,3,4,5,6,7,8,9};
                for (int k = 0; k < 9; k++) {
                    matriz[j][k] = in.nextInt();
                    if(nove[matriz[j][k]-1] == matriz[j][k]) cont++;
                    nove[matriz[j][k]-1] = 0;
                }

                if(cont != 9){
                    valida = false;
                }
                cont=0;

                for (int k = 0; k < 9; k++) {
                    if(k>=0 && k<3){
                        nove = temp;
                        if(nove[matriz[j][k]-1] == matriz[j][k]) cont1++;
                        nove[matriz[j][k]-1] = 0;
                        temp = nove;
                    }

                    if(k>=3 && k<6){
                        nove = temp2;
                        if(nove[matriz[j][k]-1] == matriz[j][k]) cont2++;
                        nove[matriz[j][k]-1] = 0;
                        temp2 = nove;
                    }

                    if(k>=6 && k<9){
                        nove = temp3;
                        if(nove[matriz[j][k]-1] == matriz[j][k]) cont3++;
                        nove[matriz[j][k]-1] = 0;
                        temp3 = nove;
                    }
                }

                if(j == 2 || j == 5 || j == 8){
                    if (cont1 != 9 || cont2 != 9 || cont3 != 9) valida = false;
                    cont1=0; cont2=0; cont3=0;
                    temp = new int[] {1,2,3,4,5,6,7,8,9};
                    temp2 = new int[] {1,2,3,4,5,6,7,8,9};
                    temp3 = new int[] {1,2,3,4,5,6,7,8,9};
                }
            }

            int cont5=0;
            for (int j = 0; j < 9; j++) {
                nove = new int[] {1,2,3,4,5,6,7,8,9};
                for (int k = 0; k < 9; k++) {
                    if(nove[matriz[k][j]-1] == matriz[k][j]) cont5++;
                    nove[matriz[k][j]-1] = 0;
                }

                if(cont5 != 9){
                    valida = false;
                }
                cont5=0;
            }




            System.out.printf(valida == true? "Instancia %d%nSIM%n%n" : "Instancia %d%nNAO%n%n", (i+1));

        }

    }
}
