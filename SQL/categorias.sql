/*
Quando os dados foram migrados de Banco de Dados, houve um pequeno mal-entendido por parte do antigo DBA.

Seu chefe precisa que você exiba o código e o nome dos produtos, cuja categoria inicie com 'super'.
*/


select pd.id, pd.name
from products pd
join categories cg
on pd.id_categories = cg.id
where cg.name like 'super%'
group by pd.id, pd.name;
