/*
A locadora pretende fazer uma promoção para os clientes que ainda não fizeram nenhuma locação.

Seu trabalho é nos entregar o ID e o nome dos clientes que não realizaram nenhuma locação. Ordene a saída por ID.
*/

select cs.id, cs.name
from customers cs
left join locations ls
on cs.id = ls.id_customers
where ls.id is null
group by cs.id, cs.name;
