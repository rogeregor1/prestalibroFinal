/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author familiahurtado
 */
public class Prestamo {
    private int prestamo_id;
    private Ejemplar ejemplar;
    private Usuario usuario;
    private Date fechaInicio;
    private Date fechaTermino;
    private String estado;

    public Prestamo() {
    }

    public Prestamo(int prestamo_id) {
        this.prestamo_id = prestamo_id;
    }

    public Prestamo(int prestamo_id, Ejemplar ejemplar, Usuario usuario, java.util.Date fechaInicio, java.util.Date fechaTermino, String estado) {
        this.prestamo_id = prestamo_id;
        this.ejemplar = ejemplar;
        this.usuario = usuario;
        this.fechaInicio = (Date) fechaInicio;
        this.fechaTermino = (Date) fechaTermino;
        this.estado = estado;
    }

    public int getPrestamo_id() {
        return prestamo_id;
    }

    public void setPrestamo_id(int prestamo_id) {
        this.prestamo_id = prestamo_id;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
