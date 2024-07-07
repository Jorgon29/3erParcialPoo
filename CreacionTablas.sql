CREATE DATABASE BCN;
USE BCN;

CREATE TABLE Facilitador(
    id INT IDENTITY CONSTRAINT PK_Facilitador PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL
);

CREATE TABLE Cliente(
    id INT IDENTITY CONSTRAINT PK_Cliente PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    telefono VARCHAR(10)
);

CREATE TABLE Tarjeta(
    id INT IDENTITY CONSTRAINT PK_Tarjeta PRIMARY KEY,
    numero VARCHAR(16) NOT NULL,
    fecha_exp DATE NOT NULL,
    tipo VARCHAR(7) NOT NULL,
    id_cliente INT NOT NULL CONSTRAINT FK_Tarjeta_Cliente FOREIGN KEY REFERENCES Cliente(id) ON DELETE CASCADE,
    id_facilitador INT NOT NULL CONSTRAINT FK_Tarjeta_Facilitador FOREIGN KEY REFERENCES Facilitador(id) ON DELETE CASCADE 
);

CREATE TABLE Transaccion(
    id INT IDENTITY CONSTRAINT PK_Transaccion PRIMARY KEY,
    total DECIMAL(20,2) NOT NULL,
    fecha DATE NOT NULL,
    descripcion VARCHAR(50),
    id_tarjeta INT NOT NULL CONSTRAINT FK_Transaccion_Tarjeta FOREIGN KEY REFERENCES Tarjeta(id) ON DELETE CASCADE
);

insert into Cliente (nombre, direccion, telefono) VALUES ('Marco','6ta avenida','78122854');
INSERT into Facilitador (nombre) values ('Nayib');
insert into Tarjeta (numero, fecha_exp, tipo, id_cliente, id_facilitador) values (7829290865431234,'2004-12-12','Visa',1,1);
insert into Transaccion(total, fecha, descripcion, id_tarjeta) VALUES (20.89,'2004-12-12','Trata de blancas',1);
select * from Cliente
use master
drop database BCN
select c.nombre as nombre from Cliente c where c.id =1;
select T.total as total, T.fecha as fecha, T.descripcion as descripcion, C.nombre as nombre from Transaccion T inner join Tarjeta T2 on T2.id = T.id_tarjeta INNER JOIN Cliente C on C.id = 1 where T.fecha between '1999-10-10' AND '2024-10-10';

select sum(T.total) as total from Transaccion T inner join Tarjeta T2 on T2.id = T.id_tarjeta where T2.id_cliente = 1 and datepart(month,fecha) = 12 and datepart(year,fecha) = 2004;

select * from Tarjeta
update Tarjeta set tipo = 'credito' where id = 1
