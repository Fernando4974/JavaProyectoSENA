Proyecto CRUD de Contactos en Java (Consola)
Desarrollado como parte de la materia de programación en Java en el SENA.

Descripción
Este proyecto es una aplicación de consola escrita en Java, desarrollada utilizando Apache NetBeans IDE 25, que permite gestionar una agenda de contactos con base de datos MySQL. Implementa operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y genera un informe en formato PDF con los contactos registrados.

Además, incluye la posibilidad de gestionar citas para los contactos, entendidas como reuniones futuras programadas (fecha, hora, lugar y descripción).

El sistema está estructurado bajo el patrón de arquitectura MVC (Modelo-Vista-Controlador), implementado con programación orientada a objetos (POO) y uso de interfaces para mejorar la modularidad, escalabilidad y mantenimiento del código.

Funcionalidades
Añadir nuevo contacto a la base de datos

Listar todos los contactos

Buscar contacto por ID

Actualizar información de un contacto

Eliminar contacto

Exportar la lista de contactos a un archivo PDF

Crear y consultar citas (reuniones) asociadas a los contactos

Tecnologías y Dependencias
Java SE 8+

MySQL

Apache NetBeans IDE 25

POO y patrón MVC

Interfaces para la lógica de operaciones

Dependencias requeridas
iText PDF 5.5.13.2 – para la generación de archivos PDF

MySQL Connector 5.1.46 – para la conexión a la base de datos
