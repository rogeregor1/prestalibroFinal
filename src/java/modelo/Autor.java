
package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author familiahurtado
 */
public class Autor extends Persona{
    List<Libro>librosAutor;
    private String fecha_nacimiento;
    
    public Autor() {
    }

    public Autor(int id) {
        super(id);
    }
    
    public Autor(int id, String nombre, Date fn) {
        super(id, nombre, fn);
    }

    public Autor(int id, String nombre) {
        super(id, nombre);
        librosAutor=new ArrayList<>();
    }

    public Autor(String fecha_nacimiento, String nombre) {
        super(nombre);
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Autor(int id, String nombre, String fecha_nacimiento) {
        super(id, nombre);
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    public Autor(String nombre, List<Libro> librosAutor) {
        super(nombre);
        this.librosAutor = librosAutor;
    }


    public Autor(int id, String nombre, String apellido, List<Libro> librosAutor) {
        super(id, nombre, apellido);
        this.librosAutor = librosAutor;
    }

    public Autor(List<Libro> librosAutor, String nombre, Date fn) {
        super(nombre, fn);
        this.librosAutor = librosAutor;
    }
    
    
    public Autor(String nombre, Date fn) {
        super(nombre, fn);
        librosAutor=new ArrayList<>();
    }
    
    public Boolean introlibro(Libro l){
        return librosAutor.add(l);
        
    }

    @Override
    public void setFn(Date fn) {
        super.setFn(fn);
    }

    @Override
    public Date getFn() {
        return super.getFn();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); 
    }

    @Override
    public String getNombre() {
        return super.getNombre(); 
    }

    @Override
    public void setId(int id) {
        super.setId(id); 
    }

    @Override
    public int getId() {
        return super.getId(); 
    }

    @Override
    public String toString() {
        return super.toString()+"\nAutor{" + "librosAutor=" + librosAutor + '}';
    }
    
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento=fecha_nacimiento;
    }
    
}
