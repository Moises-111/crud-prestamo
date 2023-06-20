
CREATE TABLE IF NOT EXISTS CLIENTE
(
    num_cliente character varying(25) not null,
    id smallint NOT NULL,
    fecha character varying(25) NOT NULL,
    monto numeric(10,2) NOT NULL,
    estado character varying(25) NOT NULL,
    CONSTRAINT cliente_pkey PRIMARY KEY (num_cliente,id)
);

CREATE TABLE IF NOT EXISTS tasas
(
    plazo_min smallint not null,
    plazo_max smallint NOT NULL,
    tasa_interes numeric(10,2) NOT NULL,
    CONSTRAINT tasa_pkey PRIMARY KEY (tasa_interes)
);


insert into cliente(num_cliente,id,fecha,monto,estado) values('00103228',1,'10-ene-2021',37500.00,'Pendiente');
insert into cliente(num_cliente,id,fecha,monto,estado) values('00103228',2,'19-ene-2021',725.18,'Pendiente');
insert into cliente(num_cliente,id,fecha,monto,estado) values('00103228',3,'31-ene-2021',1578.22,'Pendiente');
insert into cliente(num_cliente,id,fecha,monto,estado) values('00103228',4,'04-feb-2021',380.00,'Pendiente');
insert into cliente(num_cliente,id,fecha,monto,estado) values('70099925',1,'07-ene-2021',2175.25,'Pagado');
insert into cliente(num_cliente,id,fecha,monto,estado) values('70099925',2,'13-ene-2021',499.99,'Pagado');
insert into cliente(num_cliente,id,fecha,monto,estado) values('70099925',3,'24-ene-2021',5725.18,'Pendiente');
insert into cliente(num_cliente,id,fecha,monto,estado) values('70099925',4,'07-feb-2021',876.13,'Pendiente');
insert into cliente(num_cliente,id,fecha,monto,estado) values('00298185',1,'04-feb-2021',545.55,'Pendiente');
insert into cliente(num_cliente,id,fecha,monto,estado) values('15000125',1,'31-dic-2020',15220,'Pagado');

insert into tasas values(1,1,7);
insert into tasas values(2,7,6.50);
insert into tasas values(8,15,6);
insert into tasas values(16,30,5.5);
insert into tasas values(31,360,5);
