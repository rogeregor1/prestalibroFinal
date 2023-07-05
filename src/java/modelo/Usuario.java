/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author familiahurtado
 */
public class Usuario extends Persona{
    
    private String direccion;
    private String telefono;
    private String estado;

    public Usuario() {
    }

    public Usuario(int id) {
        super(id);
    }

    public Usuario(int id, String nombre) {
        super(id, nombre);
    }

    public Usuario(int id, String nombre, String estado) {
        super(id, nombre);
        this.estado = estado;
    }

    public Usuario(int id, String dni, String nombre, String direccion, String telefono, String estado) {
        super(id, dni, nombre);
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public void setId(int id) {
        super.setId(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int getId() {
        return super.getId(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getNombre() {
        return super.getNombre(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
   
   
}
