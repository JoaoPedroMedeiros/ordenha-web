INSERT INTO Propriedades (nome, cnpj) VALUES ('Fazenda do Zé', '12345'), ('Fazenda São Pedro', '12312930');
INSERT INTO Racas (nome) VALUES ('Jersey'), ('Nelore');
INSERT INTO Vacas (id_propriedade, nome, peso, id_raca, observacao, data_nascimento, doente, prenha) VALUES (1, 'Rubia', 300.00, 1, null, now(), 1, 1);
INSERT INTO Usuarios (login, nome, senha, id_propriedade) VALUES ('login', 'Joao Pedrão', md5('12345'), 1);
INSERT INTO Ordenhas (data_hora, id_propriedade, id_usuario) VALUES (now(), 1, 1); 
INSERT INTO VacasOrdenhadas (id_vaca, id_ordenha, quantidade_leite) VALUES (1, 1, 400);
INSERT INTO VacasOrdenhadas (id_vaca, id_ordenha, quantidade_leite) VALUES (1, 1, 500);
INSERT INTO VacasOrdenhadas (id_vaca, id_ordenha, quantidade_leite) VALUES (1, 1, 600);


