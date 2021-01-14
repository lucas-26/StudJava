Select * from tabela_de_produtos where sabor = 'Manga' or TAMANHO = '470 ml';

Select * from tabela_de_produtos where sabor = 'Manga' and TAMANHO = '470 ml';

Select * from tabela_de_produtos where not(sabor = 'Manga' or TAMANHO = '470 ml');

Select * from tabela_de_produtos where not(sabor = 'Manga' and TAMANHO = '470 ml');

Select * from tabela_de_produtos where (sabor = 'Manga' or not(TAMANHO = '470 ml'));

Select * from tabela_de_produtos where sabor in ('Laranja', 'Manga');

Select * from tabela_de_clientes where cidade in ('Rio de Janeiro', 'São Paulo');

Select * from tabela_de_clientes where cidade in ('Rio de Janeiro', 'São Paulo') 
and (IDADE >= 20 and IDADE <= 22);
