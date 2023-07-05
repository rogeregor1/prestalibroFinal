/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

/**
 *
 * @author familiahurtado
 */
public class Libro {
    private int libro_id;
    private String titulo;
    private String isbn;
    private Category category;
    private int categoria_id;
    private String categoria;
    private List<Autor> listaAutores;
    private String estado;
    
    public Libro() {
    }

    public Libro(int libro_id) {
        this.libro_id = libro_id;
    }

    public Libro(int libro_id, String titulo) {
        this.libro_id = libro_id;
        this.titulo = titulo;
    }

    public Libro(int libro_id, String titulo, String isbn) {
        this.libro_id = libro_id;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public Libro(String titulo, String isbn, Category category) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.category = category;
    }

    public Libro(int libro_id, String titulo, String isbn, Category category) {
        this.libro_id = libro_id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.category = category;
    }
    
    public Libro(int libro_id, String titulo, String isbn, Category category, List<Autor> listaAutores) {
        this.libro_id = libro_id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.category = category;
        this.listaAutores = listaAutores;
    }

    public Libro(int libro_id, String titulo, String isbn, Category category, String estado) {
        this.libro_id = libro_id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.category = category;
        this.estado = estado;
    }

    public Libro(int libro_id, String titulo, String isbn, int categoria_id, String estado) {
        this.libro_id = libro_id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.categoria_id = categoria_id;
        this.estado = estado;
    }

    public Libro(String titulo, String isbn, int categoria_id) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.categoria_id = categoria_id;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setCategoria(Category category) {
        this.category = category;
    }

    public int getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setAutores(List<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
