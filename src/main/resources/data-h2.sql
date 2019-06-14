
DROP TABLE IF EXISTS vehiculo;

CREATE TABLE vehiculo (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  marca VARCHAR(250) NOT NULL,
  modelo VARCHAR(250) NOT NULL,
  preciorent VARCHAR(250) DEFAULT NULL
);

INSERT INTO vehiculo (marca, modelo, preciorent) VALUES
  ('toyota','Corolla','59.9'),
  ('mazda' ,'Familia','70.0'),
  ('tesla' ,'Auto S' ,'140.0');