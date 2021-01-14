select tp.sabor, nf.DATA_VENDA, inf.QUANTIDADE from tabela_de_produtos as tp
inner join itens_notas_fiscais as inf on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais as nf on nf.NUMERO = inf.numero;

select Venda_sabor.sabor, venda_sabor.ano, 
(venda_sabor.QUANTIDADE/venda_total.QUANTIDADE * 100) as participacao from 
/*quantidade vendida por sabor ano 2016*/
(select tp.sabor, YEAR(nf.DATA_VENDA) AS ANO, SUM(inf.QUANTIDADE) AS QUANTIDADE 
from tabela_de_produtos as tp
inner join itens_notas_fiscais as inf 
on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais as nf 
on nf.NUMERO = inf.numero
WHERE YEAR(nf.data_venda) = 2016
group by  tp.sabor, YEAR(nf.DATA_VENDA) 
order by inf.QUANTIDADE desc) as Venda_sabor
inner join 
(select YEAR(nf.DATA_VENDA) AS ANO, SUM(inf.QUANTIDADE) AS QUANTIDADE 
from tabela_de_produtos as tp
inner join itens_notas_fiscais as inf 
on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais as nf 
on nf.NUMERO = inf.numero
WHERE YEAR(nf.data_venda) = 2016
group by YEAR(nf.DATA_VENDA) 
order by inf.QUANTIDADE desc) as Venda_total
on venda_sabor.ano = venda_Total.ano
order by venda_sabor.QUANTIDADE desc;

select tp.sabor, YEAR(nf.DATA_VENDA) AS ANO, SUM(inf.QUANTIDADE) AS QUANTIDADE 
from tabela_de_produtos as tp
inner join itens_notas_fiscais as inf 
on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais as nf 
on nf.NUMERO = inf.numero
WHERE YEAR(nf.data_venda) = 2016
group by  tp.sabor, YEAR(nf.DATA_VENDA) 
order by inf.QUANTIDADE desc);