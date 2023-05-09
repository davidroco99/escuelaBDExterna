
package com.cine.escuela.logica;
import com.cine.escuela.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;


public class Controladora {
    ControladoraPersistencia persistencia = new ControladoraPersistencia();
        
    public void guardar(String nombre, String apellido, String dni) {
       
        Alumno alu = new Alumno();
        alu.setApellido(apellido);
        alu.setNombre(nombre);
        alu.setDni(dni);
        /*
        System.out.println("---------------------------------------------------------");
        System.out.println("-----------------ControladoraLogica----------------------");
        System.out.println(alu.toString());
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");
        */
        persistencia.guardar(alu);
        
        
    }
    
    public List <Alumno> buscarAlumnos(){
        List <Alumno> listaAlumnos = persistencia.buscarAlumnos();
        
        /*
        System.out.println("---------------------------------------------------------");
        System.out.println("-----------------ControladoraLogica----------------------");*/
        for (Alumno alu: listaAlumnos){
            System.out.println(alu.toString());
        }
        /*
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");*/
        return listaAlumnos;
    }

    
    public List<DTOAlumno> traerAlumnos() {
        List <Alumno> listaAlumnos = persistencia.buscarAlumnos();
        ArrayList <DTOAlumno> listaDTOalumno;
        listaDTOalumno = new ArrayList<>();
       
        int index = 0;
        //relleno la lista de DTOAlumnos
        for (Alumno alu: listaAlumnos){
            //creo el dto
            DTOAlumno dtoAlu = new DTOAlumno();
            
            String legajo = String.valueOf(alu.getLegajo());
            dtoAlu.setLegajo(legajo);
            
            String apellido = alu.getApellido();
            dtoAlu.setApellido(apellido);

            String nombre = alu.getNombre();
            dtoAlu.setNombre(nombre);

            String dni = alu.getDni();
            dtoAlu.setDni(dni);
            /*
            System.out.println("---------------------------------------------------------");
            System.out.println("---------------DTO ALUMNO COTROLADORA--------------------");
            System.out.println(alu.toString());
            System.out.println("---------------------------------------------------------");
            System.out.println("---------------------------------------------------------");
            */
            listaDTOalumno.add(index,dtoAlu);
            index = index +1;
        }
       // System.out.println("---------------FIN carga lista DTOALUMNO-----------------");
        return listaDTOalumno;
    }

    public void borrarAlumno(int legajoAlumno) {
        persistencia.borrarAlumno(legajoAlumno);
        
    }

    public DTOAlumno buscarAlumno(int legajo) {
        DTOAlumno dtoAlu = new DTOAlumno();
        Alumno alu = new Alumno();
        alu = persistencia.buscarAlumno(legajo);
        //Falta funcionalidad editar
        dtoAlu.setLegajo( String.valueOf(alu.getLegajo()));
        dtoAlu.setNombre(alu.getNombre());
        dtoAlu.setApellido(alu.getApellido());
        dtoAlu.setDni(alu.getDni());
        
        return dtoAlu;
    }

    public void editarAlumno(DTOAlumno dtoAlu) {
        Alumno alu = new Alumno();
        alu.setLegajo(Integer.parseInt(dtoAlu.getLegajo()));
        alu.setApellido(dtoAlu.getApellido());
        alu.setNombre(dtoAlu.getNombre());
        alu.setDni(dtoAlu.getDni());
        persistencia.modificarAlumno(alu);
    }

    
}
