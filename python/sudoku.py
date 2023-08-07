'''
O jogo de Sudoku espalhou-se rapidamente por todo o mundo, tornando-se hoje o passatempo mais popular em todo o planeta. Muitas pessoas, entretanto, preenchem a matriz de forma incorreta, desrespeitando as restrições do jogo. Sua tarefa neste problema é escrever um programa que verifica se uma matriz preenchida é ou não uma solução para o problema.

A matriz do jogo é uma matriz de inteiros 9 x 9 . Para ser uma solução do problema, cada linha e coluna deve conter todos os números de 1 a 9. Além disso, se dividirmos a matriz em 9 regiões 3 x 3, cada uma destas regiões também deve conter os números de 1 a 9. O exemplo abaixo mostra uma matriz que é uma solução do problema.

Entrada
São dadas várias instâncias. O primeiro dado é o número n > 0 de matrizes na entrada. Nas linhas seguintes são dadas as n matrizes. Cada matriz é dada em 9 linhas, em que cada linha contém 9 números inteiros.

Saída
Para cada instância seu programa deverá imprimir uma linha dizendo "Instancia k", onde k é o número da instância atual. Na segunda linha, seu programa deverá imprimir "SIM" se a matriz for a solução de um problema de Sudoku, e "NAO" caso contrário. Imprima uma linha em branco após cada instância.

'''


n = int(input())

for j in range(0,n):
    matriz = [list(map(int, input().split())) for i in range(0,9)]
    verif = True

    # Verificador de Linhas da Matriz
    for i in range(0,9):
        if set(range(1,10)) != set(matriz[i]):
            verif = False
            break

    # Verificador de Colunas da Matriz
    for i in range(0,9):
        if set(range(1, 10)) != set(matriz[y][i] for y in range(0,9)):
            verif = False
            break

    # Verificador de Sub-Regioes 3x3 da Matriz
    for i in range(0,9,3):
        for a in range(0,9,3):
            lista = [matriz[x][y] for x in range(i, i+3) for y in range(a, a+3)]
            if set(lista) != set(range(1, 10)):
                verif = False
                break

    # Resultado
    final = "SIM" if verif == True else "NAO"
    print(f"Instancia {j+1}\n{final}\n")
