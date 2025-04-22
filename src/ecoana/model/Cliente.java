/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecoana.model;

import java.util.Date; // Usaremos java.util.Date

// Herencia Simple
public class Cliente extends Persona {
    private String cedula;
    private String telefono;
    private String correo;
    private Date fechaNacimiento;

    // Constructor
    public Cliente(String nombre, String primerApellido, String segundoApellido,
                   String cedula, String telefono, String correo, Date fechaNacimiento) {
        super(nombre, primerApellido, segundoApellido); // Llama al constructor padre
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters específicos
    public String getCedula() { return cedula; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
}
