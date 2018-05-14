dcc192-trabalho2-2018-1
usuario
senha

create table evento(
    codigoEvento integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    titulo varchar(500) not null,
    minimo decimal(10, 2) not null,
    dataInicial date not null,
    dataSorteio date not null
)

create table participante(
    codigoParticipante integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome varchar(500) not null,
    email varchar(500) not null,
    senha varchar(500) not null,
    fkid_codigoEvento integer,
    foreign key (fkid_codigoEvento) references evento (codigoEvento)
)

