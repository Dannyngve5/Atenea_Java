package modelo;

import java.sql.Date;
import java.sql.Time;

public class Curso {
    int id;
    String nombre;
    Date f_inicio;
    Time hora_inicio;
    int limite_estudiantes;
    int instructor_id;
    int monitor_id;   

    public Curso() {
    }

    public Curso(int id, String nombre, Date f_inicio, Time hora_inicio, int limite_estudiantes, int instructor_id, int monitor_id) {
        this.id = id;
        this.nombre = nombre;
        this.f_inicio = f_inicio;
        this.hora_inicio = hora_inicio;
        this.limite_estudiantes = limite_estudiantes;
        this.instructor_id = instructor_id;
        this.monitor_id = monitor_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(Date f_inicio) {
        this.f_inicio = f_inicio;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getLimite_estudiantes() {
        return limite_estudiantes;
    }

    public void setLimite_estudiantes(int limite_estudiantes) {
        this.limite_estudiantes = limite_estudiantes;
    }

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }

    public int getMonitor_id() {
        return monitor_id;
    }

    public void setMonitor_id(int monitor_id) {
        this.monitor_id = monitor_id;
    }
    
    
    
    
    
    
    
}
