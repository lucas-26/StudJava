SELECT LTRIM('           olá');

SELECT RTRIM('olá          ');

SELECT LTRIM('           olá');

SELECT TRIM('           olá          ');

SELECT concat('olá', '', 'Tudo bem? ');

SELECT lower('olá tudo bem');

SELECT upper('olá tudo bem');

select substring('Olá, tudo bem?', 6);

select substring('Olá, tudo bem?', 6, 4);

select concat(nome, '(' , cpf, ')') as resultado drom tabela_clientes;