
package modelo;

import java.sql.Date;


/**
 *
 * @author familiahurtado
 */
public class Persona {
    
    private int id;
    private String dni;
    private String nombre;
    private Date fn;
    
    public Persona() {
    }
    
    public Persona(int id) {
        this.id = id;
    }

    public Persona(int id, String nombre, Date fn) {
        this.id = id;
        this.nombre = nombre;
        this.fn = fn;
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Persona(String nombre, Date fn) {
        this.nombre = nombre;
        this.fn = fn;
    }
    
    public Persona(int id, String dni, String nombre) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
    }

    public Persona(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    
    
    //Getters

  
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

    public Date getFn() {
        return fn;
    }

    public void setFn(Date fn) {
        this.fn = fn;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    @Override
    public String toString() {
        return "\n\nPersona{" + "id=" + id + ", nom=" + nombre + ", fn=" + fn + '}';
    }
    
    
    
}
