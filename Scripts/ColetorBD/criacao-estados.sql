-- Create Table --

CREATE TABLE Estados (
    id       INT          NOT NULL,
    nome     VARCHAR (50) NOT NULL,
    uf       CHAR 	 (2)  NOT NULL,
    PRIMARY KEY (id)
);

-- Insert Data --

Insert into Estados (id, nome, uf) values (12, 'Acre', 'AC');
Insert into Estados (id, nome, uf) values (27, 'Alagoas', 'AL');
Insert into Estados (id, nome, uf) values (16, 'Amapá', 'AP');
Insert into Estados (id, nome, uf) values (13, 'Amazonas', 'AM');
Insert into Estados (id, nome, uf) values (29, 'Bahia', 'BA');
Insert into Estados (id, nome, uf) values (23, 'Ceará', 'CE');
Insert into Estados (id, nome, uf) values (53, 'Distrito Federal', 'DF');
Insert into Estados (id, nome, uf) values (32, 'Espírito Santo', 'ES');
Insert into Estados (id, nome, uf) values (52, 'Goiás', 'GO');
Insert into Estados (id, nome, uf) values (21, 'Maranhão', 'MA');
Insert into Estados (id, nome, uf) values (51, 'Mato Grosso', 'MT');
Insert into Estados (id, nome, uf) values (50, 'Mato Grosso do Sul', 'MS');
Insert into Estados (id, nome, uf) values (31, 'Minas Gerais', 'MG');
Insert into Estados (id, nome, uf) values (15, 'Pará', 'PA');
Insert into Estados (id, nome, uf) values (25, 'Paraíba', 'PB');
Insert into Estados (id, nome, uf) values (41, 'Paraná', 'PR');
Insert into Estados (id, nome, uf) values (26, 'Pernambuco', 'PE');
Insert into Estados (id, nome, uf) values (22, 'Piauí', 'PI');
Insert into Estados (id, nome, uf) values (33, 'Rio de Janeiro', 'RJ');
Insert into Estados (id, nome, uf) values (24, 'Rio Grande do Norte', 'RN');
Insert into Estados (id, nome, uf) values (43, 'Rio Grande do Sul', 'RS');
Insert into Estados (id, nome, uf) values (11, 'Rondônia', 'RO');
Insert into Estados (id, nome, uf) values (14, 'Roraima', 'RR');
Insert into Estados (id, nome, uf) values (42, 'Santa Catarina', 'SC');
Insert into Estados (id, nome, uf) values (35, 'São Paulo', 'SP');
Insert into Estados (id, nome, uf) values (28, 'Sergipe', 'SE');
Insert into Estados (id, nome, uf) values (17, 'Tocantins', 'TO');