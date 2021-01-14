use sucos_vendas;

select * from tabela_de_produtos;

SELECT NOME_DO_PRODUTO, PRECO_DE_LISTA, 
CASE 
	WHEN PRECO_DE_LISTA >= 12 THEN 'Produto caro'
	WHEN PRECO_DE_LISTA >= 7 AND PRECO_DE_LISTA < 12 THEN 'PRODUTO EM CONTA'
	ELSE 'PRODUTO BARATO' 
END AS STATUS_PRECO
FROM TABELA_DE_PRODUTOS;

SELECT EMBALAGEM, 
CASE 
	WHEN PRECO_DE_LISTA >= 12 THEN 'Produto caro'
	WHEN PRECO_DE_LISTA >= 7 AND PRECO_DE_LISTA < 12 THEN 'PRODUTO EM CONTA'
	ELSE 'PRODUTO BARATO' 
END AS STATUS_PRECO, AVG(PRECO_DE_LISTA) AS PRECO_MEDIO
FROM TABELA_DE_PRODUTOS group by EMBALAGEM;
