package com.example.p1programa.configuraciones;

public class transacciones {
    // NOMBRE DE LA BSE de Datos
    public static final String NameDatabase = "PM01DB";
    //crear las tablas de la base de datos
    public static final String tablaempleados ="empleados";

    //campos especificos de la tabla empleados
    public static final String id = "id";
    public static final String nombre = "nombre";
    public static final String apellido = "apellido";
    public static final String edad = "edad";
    public static final String correo = "correo";

    ///

    //transacciones DDL(Data definition leangue)//

    public static final String CreateTableEmpleados = "CREATE TABLE" + tablaempleados
            + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nombre TEXT, apellido TEXT, edad INTEGER, correo TEXT)";

    public static String DropTableEmpleados;
}
