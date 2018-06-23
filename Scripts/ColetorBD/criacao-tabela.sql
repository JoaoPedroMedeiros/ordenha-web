CREATE TABLE IF NOT EXISTS Estados (
  id        int               NOT NULL AUTO_INCREMENT,
  nome      varchar(90)       NOT NULL,
  sigla     varchar(2)        NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS Cidades (        
  id        int               NOT NULL AUTO_INCREMENT,
  nome      varchar(90)       NOT NULL,
  id_estado int               NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_Cidades_Estados FOREIGN KEY (id_estado) REFERENCES Estados(id)
);
CREATE TABLE IF NOT EXISTS Propriedades (
  id              int         NOT NULL AUTO_INCREMENT,
  nome            varchar(90) NOT NULL,
  cnpj            varchar(90) NOT NULL,
  id_cidade       int         NOT NULL,
  endereco        varchar(90) NOT NULL,
  bairro          varchar(90) NOT NULL,
  numero          varchar(20) NOT NULL,
  complemento     varchar(90)     NULL,
  proprietario    varchar(90) NOT NULL,
  telefone        varchar(15) NOT NULL,
  email           varchar(90) NOT NULL,
  periodicidade   int         NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_Propriedades_Cidades FOREIGN KEY (id_cidade) REFERENCES Cidades(id)
);
CREATE TABLE IF NOT EXISTS Coletas (
  id              int         NOT NULL AUTO_INCREMENT,
  id_propriedade  int         NOT NULL,
  quantidade      decimal     NOT NULL,
  data_hora       datetime    NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_Coletas_Proprietario FOREIGN KEY (id_propriedade) REFERENCES Propriedades(id)
);
CREATE TABLE IF NOT EXISTS Usuarios (
  id        int               NOT NULL AUTO_INCREMENT,
  nome      varchar(90)       NOT NULL,
  login     varchar(90)       NOT NULL,
  senha     varchar(90)       NOT NULL,
  PRIMARY KEY (id)
);
