SELECT * FROM tabela_de_vendedores;
SELECT * FROM notas_fiscais;

SELECT * FROM tabela_de_vendedores AS A 
INNER JOIN notas_fiscais AS B
ON A.MATRICULA = B.MATRICULA;


SELECT A.MATRICULA, A.NOME, COUNT(*) 
FROM tabela_de_vendedores AS A 
INNER JOIN notas_fiscais AS B
ON A.MATRICULA = B.MATRICULA
GROUP BY A.MATRICULA, A.NOME;

select A.MATRICULA, A.NOME, B.CPF, B.IMPOSTO
FROM tabela_de_vendedores AS A 
inner join notas_fiscais as B 
on A.MATRICULA = B.MATRICULA;