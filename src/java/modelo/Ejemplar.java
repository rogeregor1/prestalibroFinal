/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author familiahurtado
 */
public class Ejemplar {
    private int ejemplar_id;
    private Libro libro;
    private int inventory_in_stock;
    private String estado;

    public Ejemplar() {
    }

    public Ejemplar(int ejemplar_id) {
        this.ejemplar_id = ejemplar_id;
    }

    public Ejemplar(int ejemplar_id, Libro libro) {
        this.ejemplar_id = ejemplar_id;
        this.libro = libro;
    }

    public Ejemplar(int ejemplar_id, Libro libro, int inventory_in_stock, String estado) {
        this.ejemplar_id = ejemplar_id;
        this.libro = libro;
        this.inventory_in_stock = inventory_in_stock;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEjemplar_id() {
        return ejemplar_id;
    }

    public void setEjemplar_id(int ejemplar_id) {
        this.ejemplar_id = ejemplar_id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getInventory_in_stock() {
        return inventory_in_stock;
    }

    public void setInventory_in_stock(int inventory_in_stock) {
        this.inventory_in_stock = inventory_in_stock;
    }
    
    
}
