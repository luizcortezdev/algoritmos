/* 
Dada uma pilha de n cartas enumeradas de 1 até n com a carta 1 no topo e a carta n na base.  A seguinte operação é ralizada enquanto tiver 2 ou mais cartas na pilha.

Jogue fora a carta do topo e mova a próxima carta (a que ficou no topo) para a base da pilha.

Sua tarefa é encontrar a sequência de cartas descartadas e a última carta remanescente.

Cada linha de entrada (com exceção da última) contém um número n ≤ 50. A última linha contém 0 e não deve ser processada. Cada número de entrada produz duas linhas de saída. A primeira linha apresenta a sequência de cartas descartadas e a segunda linha apresenta a carta remanescente.

Entrada
A entrada consiste em um número indeterminado de linhas contendo cada uma um valor de 1 até 50. A última linha contém o valor 0.

Saída
Para cada caso de teste, imprima duas linhas. A primeira linha apresenta a sequência de cartas descartadas, cada uma delas separadas por uma vírgula e um espaço. A segunda linha apresenta o número da carta que restou. Nenhuma linha tem espaços extras no início ou no final. Veja exemplo para conferir o formato esperado.

*/

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class jogando-cartas-fora {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n;
        while ((n = sc.nextInt()) != 0) {
            Deque<Integer> deck = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                deck.add(i);
            }
            StringBuilder sb = new StringBuilder();
            while (deck.size() >= 2) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(deck.poll());
                deck.add(deck.poll());
            }
            System.out.println("Discarded cards: " + sb.toString());
            System.out.println("Remaining card: " + deck.peek());
        }
    }
}
