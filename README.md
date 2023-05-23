# ✨ Presentación del Proyecto Museo ✨

¡Bienvenidos a nuestra presentación del proyecto Museo! En este proyecto, hemos desarrollado un sistema para gestionar el registro de visitantes en un museo y mostrar su información en tablas interactivas.

El objetivo principal de nuestro proyecto es proporcionar una herramienta eficiente y fácil de usar para el control y seguimiento de los visitantes de un museo. Con nuestro sistema, los administradores del museo pueden realizar un seguimiento de los datos de los visitantes, como su cédula, nombre, apellidos, género, profesión, ciudad de origen y código del museo al que pertenecen.

La arquitectura de nuestro proyecto se basa en el paradigma de Programación Orientada a Objetos (POO), aprovechando los conceptos de encapsulamiento y polimorfismo para lograr un diseño modular y escalable. Hemos utilizado el lenguaje de programación Java y el framework JDBC para interactuar con la base de datos.  

## 🤝 Grupo de Desarrollo 🤝

Nuestro grupo de desarrollo está conformado por:

- Juan Arguello - Estudiante con el número de identificación 1152178. Juan se ha encargado del diseño de la interfaz de usuario y la implementación de las tablas interactivas que muestran la información de los visitantes. También ha trabajado en la validación de datos y en la usabilidad del sistema. 

- Julian Ascanio - Estudiante con el número de identificación 1151865. Julian ha trabajado en la implementación de la lógica de negocio del sistema, incluyendo el manejo de consultas a la base de datos y la manipulación de los registros de visitantes.

- Diego Espinoza - Estudiante con el número de identificación 1151783. Diego ha contribuido en la configuración de la base de datos y en la creación de las tablas necesarias para almacenar la información de los visitantes. También ha colaborado en el desarrollo de consultas SQL eficientes para la recuperación de datos.

En conjunto, hemos trabajado de manera colaborativa y coordinada para lograr el éxito de este proyecto. Estamos orgullosos de presentar nuestro trabajo, el cual es evaluado como parte del segundo parcial de la materia de Programación Orientada a Objetos II.

## 💻 Tecnologías utilizadas 💻

- Java
- JDBC (Java Database Connectivity): Se trabajó siguiendo el estándar de JDBC para la conexión y manipulación de la base de datos.
- MVC (Modelo-Vista-Controlador): Se implementó el patrón de diseño MVC para lograr una estructura modular y escalable en el proyecto.

## 📋 El modelo JDBC 📋

El modelo JDBC (*Java Database Connectivity*) es una API estándar de Java que proporciona un conjunto de interfaces y clases para interactuar con bases de datos relacionales. JDBC permite establecer conexiones con bases de datos, enviar consultas SQL, obtener resultados y administrar transacciones.

El modelo JDBC se basa en el concepto de **controladores** (drivers) de bases de datos, que son implementaciones específicas proporcionadas por los fabricantes de bases de datos para permitir la comunicación entre una aplicación Java y una base de datos particular.

Las principales características y componentes del modelo JDBC son:

1. **Controladores (Drivers)**: Los controladores JDBC se utilizan para establecer la conexión con la base de datos. Hay cuatro tipos de controladores: Tipo 1 (JDBC-ODBC Bridge), Tipo 2 (JDBC-Native API), Tipo 3 (JDBC-Net Protocol) y Tipo 4 (JDBC-Native Protocol).

2. **Interfaz Connection**: La interfaz Connection representa una conexión individual con una base de datos. Se utiliza para establecer la conexión, crear y ejecutar consultas SQL, administrar transacciones y cerrar la conexión.

3. **Interfaz Statement**: La interfaz Statement se utiliza para enviar consultas SQL a la base de datos y recibir los resultados. Hay diferentes tipos de objetos Statement, como Statement, PreparedStatement y CallableStatement, que se utilizan para diferentes tipos de consultas.

4. **Interfaz ResultSet**: La interfaz ResultSet se utiliza para almacenar los resultados de una consulta SQL. Permite acceder y manipular los datos recuperados de la base de datos.

5. **Transacciones**: JDBC admite el manejo de transacciones, que son unidades lógicas de trabajo que pueden contener una o más operaciones de base de datos. Las transacciones garantizan la consistencia y la integridad de los datos al permitir operaciones atómicas (todas o ninguna) y la recuperación en caso de errores.

El modelo JDBC proporciona una forma estándar y eficiente de interactuar con bases de datos desde aplicaciones Java. Es ampliamente utilizado en el desarrollo de aplicaciones empresariales y permite a los desarrolladores aprovechar todo el potencial de las bases de datos relacionales en sus aplicaciones.

[![jdbc.png](https://i.postimg.cc/qvmSPXFX/jdbc.png)](https://postimg.cc/0zwVmmPb)

