select current_timestamp();

select concat('o dia de hoje é:', current_timestamp());

select concat('o dia de hoje é:', date_format(current_timestamp(), '%y'));

select concat('o dia de hoje é: ', date_format(current_timestamp(), '%W ,%d/%c/%y  - %U'));

Select convert(23.3, char)



SELECT CONCAT('O cliente ', TC.NOME, ' faturou ', 
CAST(SUM(INF.QUANTIDADE * INF.preco) AS char (20))
 , ' no ano ', CAST(YEAR(NF.DATA_VENDA) AS char (20))) AS SENTENCA FROM notas_fiscais NF
INNER JOIN itens_notas_fiscais INF ON NF.NUMERO = INF.NUMERO
INNER JOIN tabela_de_clientes TC ON NF.CPF = TC.CPF
WHERE YEAR(DATA_VENDA) = 2016
GROUP BY TC.NOME, YEAR(DATA_VENDA) = “O cliente João da Silva faturou 120000 no ano de 2016”.