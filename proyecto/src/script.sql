CREATE DATABASE ciencia;
USE ciencia;

CREATE TABLE administrador (
	id INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
	nombre	VARCHAR(30) NOT NULL,
	apellido VARCHAR(30) NOT NULL,
	username VARCHAR(30) NOT NULL,
	correo VARCHAR(100) NOT NULL UNIQUE,
	clave	VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE publicaciones (
	id	INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
	id_admin INTEGER,
	titulo	VARCHAR(100) NOT NULL,
	resumen	VARCHAR(250) NOT NULL,
	descripcion	TEXT NOT NULL,
	categoria 	VARCHAR(50) NOT NULL,
	estado	VARCHAR(2) NOT NULL,
	imagen	LONGBLOB,
	FOREIGN KEY(id_admin) REFERENCES administrador(id),
	PRIMARY KEY(id)
);

CREATE TABLE comentarios (
	id	INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
	id_publicacion INTEGER,
	nombre	VARCHAR(30) NOT NULL,
	apellido	VARCHAR(30) NOT NULL,
	correo	VARCHAR(100) NOT NULL,
	comentario	VARCHAR(250) NOT NULL,
	estado	VARCHAR(2) NOT NULL,
	FOREIGN KEY(id_publicacion) REFERENCES publicaciones(id),
	PRIMARY KEY(id)
);