/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecoana.model;

import java.util.Date;

public class SolicitudReserva {
    private Cliente cliente;
    private Date fechaIngreso;
    private Date fechaSalida;
    private int cantidadPersonas;
    private String tipoPago;
    private boolean terminosAceptados;

    // Constructor
    public SolicitudReserva(Cliente cliente, Date fechaIngreso, Date fechaSalida,
                            int cantidadPersonas, String tipoPago, boolean terminosAceptados) {
        this.cliente = cliente;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.cantidadPersonas = cantidadPersonas;
        this.tipoPago = tipoPago;
        this.terminosAceptados = terminosAceptados;
    }

    // Getters
    public Cliente getCliente() { return cliente; }
    public Date getFechaIngreso() { return fechaIngreso; }
    public Date getFechaSalida() { return fechaSalida; }
    public int getCantidadPersonas() { return cantidadPersonas; }
    public String getTipoPago() { return tipoPago; }
    public boolean isTerminosAceptados() { return terminosAceptados; }
}
