-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.3.7-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para juegos_olimpicos
CREATE DATABASE IF NOT EXISTS `juegos_olimpicos` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `juegos_olimpicos`;

-- Volcando estructura para tabla juegos_olimpicos.acerca
CREATE TABLE IF NOT EXISTS `acerca` (
  `cod_acer` int(11) NOT NULL AUTO_INCREMENT,
  `imagen` varchar(50) DEFAULT NULL,
  `acerca` text DEFAULT NULL,
  PRIMARY KEY (`cod_acer`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para procedimiento juegos_olimpicos.ActualizarAcerca
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarAcerca`(
	IN `ca` INT,
	IN `i` VARCHAR(50),
	IN `ac` TEXT
)
BEGIN
	UPDATE acerca SET 
		acerca.imagen = i,
		acerca.acerca = ac
	
	WHERE acerca.cod_acer = ca;
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.ActualizarDescripcion
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarDescripcion`(
	IN `cd` INT,
	IN `t` VARCHAR(50),
	IN `i` VARCHAR(50),
	IN `d` VARCHAR(50)
)
BEGIN
	UPDATE descripcion SET 
		descripcion.cod_desc = cd,
		descripcion.titulo = t,
		descripcion.imagen = i,
		descripcion.descripcion = d
	
	WHERE descripcion.titulo = t;
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.ActualizarLogin
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarLogin`(
	IN `clog` INT,
	IN `c` VARCHAR(50),
	IN `contra` VARCHAR(50)
)
BEGIN
	UPDATE login SET 
		login.correo = c,
		login.contraseña = contra
	
	WHERE login.cod_log = clog;
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.ActualizarPais
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarPais`(
	IN `cod_pais` INT,
	IN `nom` CHAR(50),
	IN `oro` INT,
	IN `plata` INT,
	IN `bronce` INT




)
BEGIN
	UPDATE paises SET 
		paises.nombre = nom,
		paises.moro = oro,
		paises.mplata = plata,
		paises.mbronce = bronce
	
	WHERE paises.codpais = cod_pais;
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.ActualizarRegistro
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarRegistro`(
	IN `c` INT,
	IN `n` INT,
	IN `contra` INT
)
BEGIN
	UPDATE registro SET 
		registro.correo = c,
		registro.nombre = n,
		registro.contraseña = contra
	
	WHERE registro.correo = contra;
END//
DELIMITER ;

-- Volcando estructura para tabla juegos_olimpicos.descripcion
CREATE TABLE IF NOT EXISTS `descripcion` (
  `cod_desc` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) DEFAULT NULL,
  `imagen` varchar(50) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  PRIMARY KEY (`cod_desc`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para procedimiento juegos_olimpicos.EliminarAcerca
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarAcerca`(
	IN `ca` INT
)
BEGIN
	DELETE FROM acerca
	WHERE acerca.cod_acer = ca;
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.EliminarDescripcion
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarDescripcion`(
	IN `cd` INT
)
BEGIN
	DELETE FROM descripcion
	WHERE descripcion.cod_desc = cd;
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.EliminarLogin
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarLogin`(
	IN `clog` INT
)
BEGIN
 	DELETE FROM login
	WHERE login.cod_log = clog;
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.EliminarPais
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarPais`(
	IN `cod_pais` INT

)
BEGIN
	DELETE FROM paises
	WHERE paises.codpais = cod_pais;
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.EliminarRegistro
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarRegistro`(
	IN `c` VARCHAR(50)
)
BEGIN
	DELETE FROM registro
	WHERE registro.correo = c;
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.InsAcerca
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsAcerca`(
	IN `i` VARCHAR(50),
	IN `ac` TEXT
)
BEGIN
	insert into acerca (imagen, acerca)
	values (i,ac);
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.InsDescripcion
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsDescripcion`(
	IN `t` VARCHAR(50),
	IN `i` VARCHAR(50),
	IN `d` TEXT

)
BEGIN
	insert into descripcion (titulo, imagen, descripcion)
	values (t,i,d);
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.InsertarP
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarP`(
	IN `nm` CHAR(50),
	IN `mo` INT,
	IN `mp` INT,
	IN `mb` INT








)
BEGIN
	insert into paises (nombre, moro, mplata, mbronce)
	values (nm,mo,mp,mb);
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.InsertarPais
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarPais`(
	IN `cod_pais` INT,
	IN `nom` CHAR(50)
,
	IN `oro` INT,
	IN `plata` INT,
	IN `bronce` INT


)
BEGIN
	insert into pais (codpais, nombre, m_oro, m_plata, m_bronce)
	values (cod_pais, nom, oro, plata, bronce);
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.InsLogin
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsLogin`(
	IN `c` VARCHAR(50),
	IN `contra` VARCHAR(50)
)
BEGIN
	insert into login (correo, contraseña)
	values (c,contra);
END//
DELIMITER ;

-- Volcando estructura para procedimiento juegos_olimpicos.InsRegistro
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsRegistro`(
	IN `c` VARCHAR(50),
	IN `n` VARCHAR(50),
	IN `contra` VARCHAR(50)
)
BEGIN
	insert into registro (correo, nombre, contraseña)
	values (c,n,contra);
END//
DELIMITER ;

-- Volcando estructura para tabla juegos_olimpicos.login
CREATE TABLE IF NOT EXISTS `login` (
  `cod_log` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(50) DEFAULT NULL,
  `contraseña` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_log`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla juegos_olimpicos.paises
CREATE TABLE IF NOT EXISTS `paises` (
  `codpais` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` char(50) DEFAULT NULL,
  `moro` int(11) DEFAULT NULL,
  `mplata` int(11) DEFAULT NULL,
  `mbronce` int(11) DEFAULT NULL,
  PRIMARY KEY (`codpais`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla juegos_olimpicos.registrar
CREATE TABLE IF NOT EXISTS `registrar` (
  `correo` varchar(50) NOT NULL,
  `nombre` char(50) DEFAULT NULL,
  `contraseña` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla juegos_olimpicos.registro
CREATE TABLE IF NOT EXISTS `registro` (
  `correo` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `contraseña` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
