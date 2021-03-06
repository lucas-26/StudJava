SELECT * FROM itens_notas_fiscais;

SELECT * FROM notas_fiscais;

SELECT * FROM notas_fiscais AS NF
INNER JOIN itens_notas_fiscais AS INF 
ON NF.NUMERO = INF.NUMERO;

/*CONSULTA COM VENDAS DE CLIENTES POR MES */
SELECT NF.CPF, date_format(NF.DATA_VENDA,'%Y - %m') AS MES_ANO,
SUM(INF.QUANTIDADE) AS QUANTIDADE_VENDAS FROM notas_fiscais AS NF
INNER JOIN itens_notas_fiscais AS INF 
ON NF.NUMERO = INF.NUMERO
GROUP BY NF.CPF,date_format(NF.DATA_VENDA,'%Y - %m');

/* LIMITE DE COMPRE POR CLIENTE */
SELECT * FROM TABELA_DE_CLIENTES TC;

SELECT TC.CPF, TC.NOME, TC.VOLUME_DE_COMPRA AS QUANTIDADE_LIMITE 
FROM tabela_de_clientes TC;

SELECT X.CPF, X.NOME, X.MES_ANO, X.QUANTIDADE_VENDAS, X.QUANTIDADE_LIMITE,
X.QUANTIDADE_LIMITE - X.QUANTIDADE_VENDAS AS DIFERENCA,
CASE WHEN(X.QUANTIDADE_LIMITE - X.QUANTIDADE_VENDAS) < 0 THEN 'INVALIDA'
ELSE 'VALIDA' END AS STATUS_VENDA	
FROM(
SELECT NF.CPF, TC.NOME,  date_format(NF.DATA_VENDA,'%Y - %m') AS MES_ANO,
SUM(INF.QUANTIDADE) AS QUANTIDADE_VENDAS,
MAX(TC.VOLUME_DE_COMPRA) AS QUANTIDADE_LIMITE
FROM notas_fiscais AS NF
INNER JOIN itens_notas_fiscais AS INF 
ON NF.NUMERO = INF.NUMERO
INNER JOIN tabela_de_clientes AS TC
ON TC.CPF = NF.CPF
GROUP BY NF.CPF,date_format(NF.DATA_VENDA,'%Y - %m')) AS X;