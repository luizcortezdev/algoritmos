import java.util.Scanner;

public class manipulacao_matriz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int f = 0;
        int[] S = null;
        int N = 0;
        int[][] M = null;
        int w = 0;
        int cont = 0;
        boolean valida = true;

        while(true) {
            System.out.print("(1)Ler matriz\n" +
                    "(2)Exibir matriz da primeira à última linha, da esquerda para direita\n" +
                    "(3)Exibir matriz da primeira à última linha, da direita para esquerda\n" +
                    "(4)Exibir a matriz transposta em relação à matriz original\n" +
                    "(5)Busca elemento em todas as linhas\n" +
                    "(6)Busca elemento em todas as colunas\n" +
                    "(7)Exibir os elementos da diagonal principal\n" +
                    "(8)SAIR\n");

            System.out.println("Escolha uma opção: ");
            int opcao = in.nextInt();

            if (opcao == 1) {
                System.out.println("Informe a ordem da matriz quadrada: ");
                N = in.nextInt();

                M = leMatriz(N);
                S = new int[N * N];
            }

            if (opcao == 2) {
                S = new int[N * N];

                f = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        S[f] = M[i][j];
                        f++;
                    }
                }
                f = 0;

                exibeSequenciaEsquerdaDireita(S);
            }

            if (opcao == 3) {
                S = new int[N];
                f = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        S[j] = M[i][j];
                    }
                    exibeSequenciaDireitaEsquerda(S);
                }
                f = 0;
            }

            if (opcao == 4) {
                S = new int[N * N];
                M = transposta(M);
                f=0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        S[f] = M[i][j];
                        f++;
                    }
                }
                f = 0;
                exibeSequenciaEsquerdaDireita(S);
            }

            if (opcao == 5) {
                System.out.println("informe o elemento a ser buscado: ");
                w = in.nextInt();
                int[] bc = new int[N];
                f=0;
                for (int i = 0; i < M.length; i++) {
                    for (int j = 0; j < M[0].length; j++) {
                        bc[f] = M[i][j];
                        f++;
                    }
                    if (buscaElemento(bc, w) == 0){
                        valida = false;
                    }
                    f=0;
                }
                f=0;

                if (valida == false){
                    System.out.println("w nao esta presente em todas as linhas");
                } else{
                    System.out.println("w esta presente em todas as linhas!!");
                }
                valida = true;
            }

            if (opcao == 6) {
                System.out.println("informe o elemento a ser buscado: ");
                w = in.nextInt();
                int[] bc = new int[N];
                f=0;
                for (int i = 0; i < M.length; i++) {
                    for (int j = 0; j < M[0].length; j++) {
                        bc[f] = M[j][i];
                        f++;
                    }
                    if (buscaElemento(bc, w) == 0){
                        valida = false;
                    }
                    f=0;
                }
                f=0;

                if (valida == false){
                    System.out.println("w nao esta presente em todas as colunas");
                } else{
                    System.out.println("w esta presente em todas as colunas!!");
                }
                valida = true;
            }

            if (opcao == 7) {
                S = diagonalPrincipal(M);
                exibeSequenciaEsquerdaDireita(S);
            }

            if (opcao == 8) {
                break;
            }
        }

    }

    public static int[][] leMatriz(int N){
        Scanner in = new Scanner(System.in);
        int matriz[][] = new int[N][N];

        System.out.println("Informe os elementos da matriz: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = in.nextInt();
            }
        }

        return matriz;
    }

    public static int buscaElemento(int[] s, int x){
        int cont = 0;

        for (int i = 0; i < s.length; i++) {
            if (x == s[i]){
                cont++;
            }
        }

        return cont;
    }

    public static void exibeSequenciaEsquerdaDireita(int[] S){
        for (int i = 0; i < S.length; i++) {
            System.out.print(S[i] + " ");
        }
        System.out.println();
    }

    public static void exibeSequenciaDireitaEsquerda(int[] s){
        for (int i = s.length - 1; i > -1 ; i--) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }

    public static int[] diagonalPrincipal(int[][] M){
        int[] DP = new int[M.length];

        for (int i = 0; i < DP.length; i++) {
            DP[i] = M[i][i];
        }

        return DP;
    }

    public static int[][] transposta(int[][] M){
        int[][] T = new int[M[0].length][M.length];

        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[0].length; j++) {
                T[i][j] = M[j][i];
            }
        }

        return T;
    }

}
