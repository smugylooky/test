CREATE TABLE Proveedores (
id_proveedor varchar(10) NOT NULL,
nombre varchar(60),
fecha_de_alta date,
id_cliente varchar(10) NOT NULL,
PRIMARY KEY (id_proveedor)
);

INSERT INTO Proveedores (id_proveedor, nombre, fecha_de_alta, id_cliente)
VALUES ('1', 'Coca Cola', '2022-10-20', '5'),
('2', 'Pepsi', '2022-10-21', '5'),
('3', 'Redbull', '2021-11-20', '6');

SELECT * FROM Proveedores WHERE id_cliente = '';