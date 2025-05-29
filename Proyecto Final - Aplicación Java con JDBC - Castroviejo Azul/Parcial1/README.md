
Funcionamiento : Se crearon dos entidades relacionadas Auto y Cliente (tiene el auto_id que representa el auto que tiene el Cliente).
Se persisten los datos en la DB concesionaria en MySQL. Se crean las querys en DataBaseManager y la conexion de la DB concesionaria.
Se muestra el logger.info que nos da la informacion de que el proyecto ha dado inicio.
Se corre el proyecto y comienza el menu el cual aparece hasta que se finalice el programa por decision del usuario. Menu podemos elegir : 
Crear Auto : con los datos necesarios de este y se crea en AutoDAOImplement y se persiste en la DB. 
Crear Cliente : el cual se piden los datos y es necesario tener un auto creado previamente ClienteDAOImplement y se persiste en la DB.
Buscar Auto por id : Se ingresa el id y este buscara si existe un auto con ese id.
Listar Autos : En AutoDAOImplement se realiza la conexion con base de datos y listamos todos los autos en esta.
Listar Autos : En ClienteDAOImplement se realiza la conexion con base de datos y listamos todos los clientes en esta.Tambien buscamos por id el auto y mostramos sus datos.
Actualizar auto :  En AutoDAOImplement se realiza la conexion con base de datos y se cambian los datos de este objeto.
Eliminar auto : En AutoDAOImplement se realiza la conexion con base de datos y se busca la fila de este objeto y se elimina de la base de datos.
Método generico se llama tipo : se envia cualquier tipo de objeto y se muestra el toString() de cada objeto describiendo su tipo.

Scripts: 

String sql = "CREATE TABLE IF NOT EXISTS autos (" +
                    "auto_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "modelo VARCHAR(100) NOT NULL, " +
                    "marca VARCHAR(255), " +
                    "color VARCHAR(100), " +
                    "patente VARCHAR(10), " +
                    "numeroSerie INT, " +
                    "precio DECIMAL(10,2) NOT NULL )";


String sqlClientes = "CREATE TABLE IF NOT EXISTS clientes (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nombre VARCHAR(100) NOT NULL, " +
                    "auto_id INT ," +
                    " FOREIGN KEY (auto_id) REFERENCES autos(auto_id))";

