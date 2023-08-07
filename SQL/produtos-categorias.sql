/* 
Produtos por Categorias

Como de costume o setor de vendas está fazendo uma análise de quantos produtos temos em estoque, e você poderá ajudar eles. 
Então seu trabalho será exibir o nome e a quantidade de produtos de cada uma categoria.
*/

select cg.name, sum(pd.amount)
from categories cg
join products pd
on cg.id = pd.id_categories
group by cg.name;
