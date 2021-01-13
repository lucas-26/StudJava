alter table tbcliente add primary key (cpf);

alter table tbcliente add column (DATA_NASCIMENTO date);


insert into tbcliente (
cpf, nome, endereco1, endereco2, bairro, cidade, estado, cep,  limite_credito, volume_compra, primeira_compra, DATA_NASCIMENTO)
values('25226661454', 'Lucas Aroldo Junior', 'Rua jundiaí numero 10', '', 'vila jacui', 'jordania', 'amazonas', '08114954', 10000.00, 2000, 0, '1989-10-05');
