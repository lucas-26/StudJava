SELECT * FROM tabela_de_clientes;

select ESTADO, LIMITE_DE_CREDITO from tabela_de_clientes;

select ESTADO, SUM(LIMITE_DE_CREDITO) AS LIMITE_TOTAL from tabela_de_clientes GROUP BY ESTADO;

select Embalagem, preco_de_lista from tabela_de_produtos;

select Embalagem, max(preco_de_lista) as maior_preco from tabela_de_produtos group by embalagem;

select Embalagem, count(preco_de_lista) as contador from tabela_de_produtos group by embalagem;

select BAIRRO, SUM(LIMITE_DE_CREDITO) AS LIMITE FROM tabela_de_clientes group by BAIRRO;

select BAIRRO, SUM(LIMITE_DE_CREDITO) AS LIMITE FROM tabela_de_clientes where 
CIDADE = 'Rio de Janeiro' group by BAIRRO;

select ESTADO,BAIRRO, SUM(LIMITE_DE_CREDITO) AS LIMITE FROM tabela_de_clientes where 
CIDADE = 'Rio de Janeiro' group by ESTADO,BAIRRO;

select ESTADO,BAIRRO, SUM(LIMITE_DE_CREDITO) AS LIMITE FROM tabela_de_clientes where 
CIDADE = 'Rio de Janeiro' group by ESTADO,BAIRRO ORDER BY BAIRRO;
