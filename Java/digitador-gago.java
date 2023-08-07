import java.util.Scanner;

public class digitador-gago {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linha = sc.nextLine();

        String[] palavras = linha.split(" ");
        String[] palavrasCorrigidas = new String[palavras.length];

        for (int i = 0; i < palavras.length; i++) {
            String palavra = palavras[i];
            if (palavra.length() <= 3 || !palavra.substring(0, 2).equals(palavra.substring(2, 4))) {
                palavrasCorrigidas[i] = palavra;
            } else {
                palavrasCorrigidas[i] = palavra.substring(2);
            }
        }

        String novaLinha = String.join(" ", palavrasCorrigidas);
        System.out.println(novaLinha);
    }
}
