import java.util.Scanner;

public class damas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] tabuleiro = {{1, 0, 1, 0, 1, 0, 1, 0},
                            {0, 1, 0, 1, 0, 1, 0, 1},
                            {1, 0, 1, 0, 1, 0, 1, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {2, 0, 2, 0, 2, 0, 2, 0},
                            {0, 2, 0, 2, 0, 2, 0, 2},
                            {2, 0, 2, 0, 2, 0, 2, 0}};

        int[] peça = new int[2];
        int[] jogadas = new int[2];
        int jogador = 1;

        while(true){
            System.out.println("Digite a Coordenada da peça a ser movimentada: ");
            peça[0] = in.nextInt();
            peça[1] = in.nextInt();

            System.out.println("Digite a Coordenada para onde a peça ira: ");
            jogadas[0] = in.nextInt();
            jogadas[1] = in.nextInt();

            if (verificador(tabuleiro, peça, jogadas, jogador) == true){
                break;
            }

            jogador = jogador == 1? 2 : 1;
        }
    }

    public static boolean verificador(int[][] tabuleiro, int[] peça, int[] jogada, int jogador){
        if (verificador_jogada(tabuleiro, peça, jogada) == true){
            movimento(tabuleiro, peça, jogada);
            if (verificador_vitoria(tabuleiro) == false){
                System.out.printf("O Jogador %d Venceu!!", jogador == 1? 1 : 2);
                return false;
            }
            return true;
        }else {
            return false;
        }
    }
    public static boolean verificador_jogada(int[][] damas, int[] peça, int[] jogada){
        if (damas[peça[0]][peça[1]] == 0){
            return false;
        } else if (damas[jogada[0]][jogada[1]] != 0){
            return false;
        }

        return true;
    }

    public static void movimento(int[][] tabuleiro, int[] peça, int[] jogada){
        tabuleiro[jogada[0]][jogada[1]] = tabuleiro[peça[0]][peça[1]];
        tabuleiro[peça[0]][peça[1]] = 0;
    }

    public static boolean verificador_vitoria(int[][] damas){
        for (int i = 0; i < 7; i++) {
            if (damas[0][i] == 2 || damas[7][i] == 1){
                return false;
            }
        }
        return true;
    }
}
