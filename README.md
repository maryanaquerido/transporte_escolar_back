# transporte_escolar_back
aplicação para gerenciar trasporte escolar

passo a passo para rodar

1. rodar o banco de dados local mysql. (verifique as credenciais/porta no application.properties)

2. certifique que o banco de dados está criado, ou crie (create database transporte_escolar).

3. rode o comando para criar as procedures no banco (
   DELIMITER $$

   CREATE PROCEDURE InsertDriver(
   IN p_name VARCHAR(100),
   IN p_telephone VARCHAR(20),
   IN p_cnh VARCHAR(30),
   IN p_vehiclePlate VARCHAR(10)
   )
   BEGIN
   INSERT INTO driver (name, telephone, cnh, vehicle_plate)
   VALUES (p_name, p_telephone, p_cnh, p_vehiclePlate);
   END $$

   DELIMITER ;

   DELIMITER $$

   CREATE PROCEDURE consultDriverOrdered()
   BEGIN
   SELECT
   id_driver,
   cnh,
   name,
   telephone,
   vehicle_plate
   FROM driver
   ORDER BY name ASC;
   END $$

   DELIMITER ;
   )

4. rodar o front e ajustar as urls