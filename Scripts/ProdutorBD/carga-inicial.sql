INSERT INTO Propriedades (nome, cnpj) VALUES ('Fazenda do meu pai', '96485116000137'), ('Fazenda São Pedro', '03443504000174'),('Fazenda SL', '50782319000194'),('Fazenda Joinville', '70987637000107');

INSERT INTO Racas (nome) VALUES ('Jersey'), ('Nelore'),('Holandesa');

INSERT INTO Vacas (id_propriedade, nome, peso, id_raca, observacao, data_nascimento, doente, prenha) VALUES 
(1, 'Rubia', 300.00, 1, null,   '2006-06-25', 0, 0),
(4, 'Mimosa', 300.00, 3, null,  '2006-06-25', 0, 0),
(2, 'Malhada', 300.00, 3, null, '2007-02-21', 0, 0),
(3, 'Cris', 300.00, 3, null,    '2008-06-22', 0, 0),
(4, 'Leti', 300.00, 3, null,    '2010-05-23', 0, 0),
(4, 'Mimi', 300.00, 2, null,    '2011-10-24', 0, 0);

INSERT INTO Usuarios (login, nome, senha, id_propriedade) VALUES ('login', 'Joao Pedrão', md5('12345'), 1);
INSERT INTO Usuarios (login, nome, senha, id_propriedade) VALUES ('arion', 'Arion Kamitani', md5('12345'), 2);
INSERT INTO Usuarios (login, nome, senha, id_propriedade) VALUES ('camilla', 'Camilla', md5('12345'), 3);
INSERT INTO Usuarios (login, nome, senha, id_propriedade) VALUES ('joaov', 'Joao Victor', md5('12345'), 4);

INSERT INTO Ordenhas (data_hora, id_propriedade, id_usuario) VALUES ('2018-06-25 06:30:00', 1, 1);
INSERT INTO Ordenhas (data_hora, id_propriedade, id_usuario) VALUES ('2018-06-21 05:30:00', 4, 4);
INSERT INTO Ordenhas (data_hora, id_propriedade, id_usuario) VALUES ('2018-06-22 05:30:00', 4, 4);
INSERT INTO Ordenhas (data_hora, id_propriedade, id_usuario) VALUES ('2018-06-23 05:30:00', 4, 4);
INSERT INTO Ordenhas (data_hora, id_propriedade, id_usuario) VALUES ('2018-06-24 05:30:00', 4, 4);
INSERT INTO Ordenhas (data_hora, id_propriedade, id_usuario) VALUES ('2018-06-25 05:30:00', 4, 4);

INSERT INTO VacasOrdenhadas (id_vaca, id_ordenha, quantidade_leite) VALUES (1, 1, 400);
INSERT INTO VacasOrdenhadas (id_vaca, id_ordenha, quantidade_leite) VALUES (1, 1, 500);
INSERT INTO VacasOrdenhadas (id_vaca, id_ordenha, quantidade_leite) VALUES (1, 1, 600);
INSERT INTO VacasOrdenhadas (id_vaca, id_ordenha, quantidade_leite) VALUES (2, 2, 100);
INSERT INTO VacasOrdenhadas (id_vaca, id_ordenha, quantidade_leite) VALUES (5, 2, 50);
INSERT INTO VacasOrdenhadas (id_vaca, id_ordenha, quantidade_leite) VALUES (6, 2, 50);


