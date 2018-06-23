DROP TABLE Propriedades;
DROP TABLE Racas;
DROP TABLE Vacas;
DROP TABLE Usuarios;
DROP TABLE Ordenhas;
DROP TABLE VacasOrdenhadas;

CREATE TABLE IF NOT EXISTS  Propriedades (
  id                INT AUTO_INCREMENT,
  nome              VARCHAR(90) NOT NULL,
  cnpj              VARCHAR(15) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS  Racas (
  id                INT AUTO_INCREMENT,
  nome              VARCHAR(90) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS  Vacas (
  id                INT AUTO_INCREMENT,
  nome              VARCHAR(90)  NOT NULL,
  peso              DECIMAL      NOT NULL,
  id_raca           INT          NOT NULL,
  observacao        VARCHAR(300)     NULL,
  data_nascimento   DATE         NOT NULL,
  doente            BIT          NOT NULL,
  prenha            BIT          NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_Vacas_Racas FOREIGN KEY (id_raca) REFERENCES Racas(id)
);

CREATE TABLE IF NOT EXISTS  Usuarios (
  id             INT          AUTO_INCREMENT,
  login          VARCHAR(90)  NOT NULL,
  nome           VARCHAR(90)  NOT NULL,
  senha          VARCHAR(300) NOT NULL,
  id_propriedade INT          NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_Usuarios_Propriedades FOREIGN KEY (id_propriedade) REFERENCES Propriedades(id)
);

CREATE TABLE IF NOT EXISTS  Ordenhas (
  id             INT      NOT NULL,
  data_hora      DATETIME NOT NULL,
  id_usuario     INT      NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_Ordenhas_Usuarios FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);

CREATE TABLE IF NOT EXISTS  VacasOrdenhadas (
  id                INT AUTO_INCREMENT,
  id_vaca           INT     NOT NULL,
  id_ordenha        INT     NOT NULL,
  quantidade_leite  DECIMAL NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_VacasOrdenhadas_Vacas    FOREIGN KEY (id_vaca)    REFERENCES Vacas(id),
  CONSTRAINT fk_VacasOrdenhadas_Ordenhas FOREIGN KEY (id_ordenha) REFERENCES Ordenhas(id)
);


