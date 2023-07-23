DROP database IF EXISTS packandtravel;
create database PackAndTravel;
use PackAndTravel;

CREATE TABLE accountuser (
  email varchar(40) primary key NOT NULL,
  passw varchar(500) NOT NULL,
  nome varchar(30) NOT NULL,
  cognome varchar(30) NOT NULL,
  indirizzo varchar(100) NOT NULL,
  telefono varchar(15) NOT NULL,
  _admin boolean default 0 not null
);

create table ordine(
	codice int auto_increment primary key not null,
    data_effettuazione date  not null,
    prezzo_tot double not null,
    account_email varchar(40) not null,
    foreign key(account_email) references accountuser(email) on update cascade on delete cascade
);


create table categoria(
	nome varchar(50) primary key not null
);


CREATE TABLE `prodotto` (
  `codice` int NOT NULL AUTO_INCREMENT,
  `descrizione` text NOT NULL,
  `prezzo` double NOT NULL,
  `nome` varchar(50) NOT NULL,
  `categoria_nome` varchar(50) NOT NULL,
  `photo` longblob,
  PRIMARY KEY (`codice`),
  KEY `categoria_nome` (`categoria_nome`),
  CONSTRAINT `prodotto_ibfk_1` FOREIGN KEY (`categoria_nome`) REFERENCES `categoria` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



create table articolo(
	codice int auto_increment not null,
    nome varchar(50) not null,
    quantità int not null,
    prezzo double not null,
    ordine_codice int not null,
    prodotto_codice int ,
    primary key (codice,ordine_codice),
    foreign key (ordine_codice) references ordine(codice) on update cascade on delete cascade,
    foreign key(prodotto_codice) references prodotto(codice) on update cascade on delete set null
);









