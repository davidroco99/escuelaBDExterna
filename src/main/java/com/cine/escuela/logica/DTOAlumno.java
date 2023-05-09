
package com.cine.escuela.logica;

public class DTOAlumno {
    private String legajo;
    private String dni;
    private String nombre;
    private String apellido;

    public DTOAlumno() {
    }

    public DTOAlumno(String legajo, String dni, String nombre, String apellido) {
        this.legajo = legajo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    
    
    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
}
