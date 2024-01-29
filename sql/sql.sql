drop database naruto_nicolas_ruiz;
create database
if not exists ninjaKonoha;
use ninjaKonoha;

CREATE TABLE `tbl_mision`
(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre` VARCHAR
(30) NOT NULL,
    `descripcion` VARCHAR
(80) NOT NULL,
    `rango` CHAR
(1) NOT NULL,
    `recompensa` VARCHAR
(30) NOT NULL,
    `finalizada` BOOLEAN NOT NULL
);
CREATE TABLE `tbl_ninja`
(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre` VARCHAR
(30) NOT NULL,
    `rango` CHAR
(1) NOT NULL,
    `aldea` VARCHAR
(20) NOT NULL
);
CREATE TABLE `tbl_habilidad`
(
    `id_ninja` INT UNSIGNED NOT NULL,
    `nombre` VARCHAR
(30) NOT NULL,
    `descripcion` VARCHAR
(80) NOT NULL
);
CREATE TABLE `tbl_mision_ninja`
(
    `id_ninja` INT UNSIGNED NOT NULL,
    `id_mision` INT UNSIGNED NOT NULL,
    `fehcaInicio` DATE NOT NULL,
    `fechaFinal` DATE NULL
);
ALTER TABLE
    `tbl_mision_ninja`
ADD CONSTRAINT `tbl_mision_ninja_id_mision_foreign` FOREIGN KEY
(`id_mision`) REFERENCES `tbl_mision`
(`id`);
ALTER TABLE
    `tbl_mision_ninja`
ADD CONSTRAINT `tbl_mision_ninja_id_ninja_foreign` FOREIGN KEY
(`id_ninja`) REFERENCES `tbl_ninja`
(`id`);
ALTER TABLE
    `tbl_habilidad`
ADD CONSTRAINT `tbl_habilidad_id_ninja_foreign` FOREIGN KEY
(`id_ninja`) REFERENCES `tbl_ninja`
(`id`);


INSERT INTO tbl_mision
    (nombre, descripcion, rango,recompensa,finalizada)
VALUES
    ("Cazar lobos", "Ir al bosque y cazar lobos negros", "A", "Dientes de lobo", false),
    ("Ladron de ovejas", "Atrapar al ladron de ovejas del este em mitsuri", "C", "Lana de oveja blanca", false),
    ("Cumpleaños Del lider", "Preparar un paste de cumpleaños para el lider del grupo", "D", "Mucha comida rica", false);

INSERT INTO tbl_ninja
    (nombre, rango, aldea)
VALUES
    ("Ninja Naruto", "A", "La zapatona"),
    ("Ninja pancito Gordo", "C", "El buen comer"),
    ("Ninja Patas peludas", "D", "El gato consentido"),
    ("Ninja cola de loro", "B", "El pajaro boracho");

INSERT INTO tbl_habilidad
    (id_ninja, nombre, descripcion )
VALUES
    (1, "Glotoneria", "Habilidad perfecta para devorar lobos "),
    (2, "Sigilo de gato tierno", "Habilidad perfecta para trapar ladrones"),
    (3, "Pasteleria", "Habilidad perfecta para hacerle un pastel de cumpleaños al lider"),
    (4, "Cola apestosa de rata negra", "Habilidad especial para hiur de la pelea");

INSERT INTO tbl_mision_ninja
    (id_ninja, id_mision, fehcaInicio)
VALUES
    (1, 1, "2024-01-29"),
    (2, 2, "2024-02-01"),
    (3, 3, "2024-03-02");