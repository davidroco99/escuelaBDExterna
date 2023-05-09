
package com.cine.escuela.persistencia;

import com.cine.escuela.logica.Alumno;
import com.cine.escuela.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    AlumnoJpaController AlumnoJpa = new AlumnoJpaController(); 
    
    
    public void guardar(Alumno alu) {
        /*
        System.out.println("---------------------------------------------------------");
        System.out.println("-----------------ControladoraPersistencia----------------");
        System.out.println(alu.toString());
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");
        */
        try {
            AlumnoJpa.create(alu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public List<Alumno> buscarAlumnos() {
        List <Alumno> listaAlumnos = AlumnoJpa.findAlumnoEntities();
        return listaAlumnos;
    }

    public void borrarAlumno(int legajoAlumno) {
        try {
            AlumnoJpa.destroy(legajoAlumno);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Alumno buscarAlumno(int legajo) {
        Alumno alu = new Alumno();
        alu = AlumnoJpa.findAlumno(legajo);
        return alu;
    }

    public void modificarAlumno(Alumno alu) {
        try {
            AlumnoJpa.edit(alu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
