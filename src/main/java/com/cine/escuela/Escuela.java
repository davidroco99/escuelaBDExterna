

package com.cine.escuela;

import com.cine.escuela.igu.AdministrarAlumno;

public class Escuela {

    public static void main(String[] args) {
        AdministrarAlumno pantallaAlumnos = AdministrarAlumno.getInstance();
        pantallaAlumnos.setVisible(true);
        pantallaAlumnos.setLocationRelativeTo(null);
    }
}
