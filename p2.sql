create table cliente(
idCliente int not null primary key,
nombre varchar(30)not null,
apellido varchar(30)not null,
email varchar(30)not null,
celular varchar(8)not null,
direccion varchar(50) not null
);

create table tipo(
idTipo int not null primary key,
descripcion varchar(30) not null
);

create table Bicicleta(
idBicicleta int not null primary key,
color varchar(10) not null,
modelo varchar(15) not null,
estado varchar(10) not null,
idTipo int not null,
foreign key(idTipo) references tipo(idTipo)
on delete cascade
on update cascade
);

create table notaAlquiler(
idNota int not null primary key,
fecha varchar(12) not null,
costo varchar(10) not null,
dias varchar(10) not null,
idCliente int not null,
foreign key(idCliente) references cliente(idCliente)
on delete no action
on update no action
);


create table detalleAlquiler(
idNota int not null,
idBicicleta int not null,
observacion varchar(50) not null,
primary key(idNota,idBicicleta),
foreign key(idNota) references notaAlquiler(idNota)
on delete cascade
on update cascade,
foreign key(idBicicleta) references bicicleta(idBicicleta)
on delete cascade
on update cascade
);

insert into cliente (idCliente, nombre, apellido, email, celular, direccion) values
(1,'Juan', 'Perez','juan_p@gmail.com','74112547','Av Beni 3er anillo'),
(2,'Maria', 'Lopez','lopez_maria@gmail.com','74589657','4to anillo'),
(3,'Pepito', 'Vasquez','vasq_p@gmail.com', '74120014','Av la salle');

insert into tipo (idTipo, descripcion) values
(1,'Electricas'),
(2,'Gravel'),
(3,'Circuito');

insert into bicicleta (idbicicleta, color, modelo, estado, idTipo) values
('1', 'blanco', 'Venzo ', 'Disponible',2),
('2', 'negro', 'BMX ', 'Disponible',1),
('3', 'naranja', 'BMX ', 'Disponible',3);

insert into notaalquiler (idnota, fecha, costo, dias, idcliente) values
(1,'28/10/2021','150','2',1),
(2,'08/09/2021','75','1',2),
(3,'18/10/2021','75','1',3);

insert into detallealquiler (idnota, idbicicleta , observacion) values
(2,3,'ninguno'),
(3,1,'ninguno'),
(1,2,'ninguno');
