package com.iessanalberto.jet.clases;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement (name="instituto")
@XmlType(propOrder ={"rol","nombre","contraseña","puntuacion","familiaProfesional","email","telefono","gustos","comentariosPersonales","comentariosExternos","historial","proyectosFavoritos"})
public class Usuario {


    private String rol;
    private String nombre;
    private String contraseña;
    private Double puntuacion;

    private String familiaProfesional;
    private String email;
    private String telefono;
    private String[] gustos;
    private String[] comentariosPersonales;
    private String[] comentariosExternos;
    private Proyecto[] historial;
    private Proyecto[] proyectosFavoritos;

    public Usuario(String rol, String nombre,String contraseña,String familiaProfesional,String email,String[] gustos){
        this.rol=rol;
        this.nombre=nombre;
        this.contraseña=contraseña;
        this.familiaProfesional=familiaProfesional;
        this.email=email;
        this.gustos=gustos;
    }
    public Usuario(){};
    @XmlElement(name="rol")
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    @XmlElement(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getFamiliaProfesional() {
        return familiaProfesional;
    }

    public void setFamiliaProfesional(String familiaProfesional) {
        this.familiaProfesional = familiaProfesional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String[] getGustos() {
        return gustos;
    }

    public void setGustos(String gustos[]) {
        this.gustos = gustos;
    }

    public String[] getComentariosPersonales() {
        return comentariosPersonales;
    }

    public void setComentariosPersonales(String[] comentariosPersonales) {
        this.comentariosPersonales = comentariosPersonales;
    }

    public String[] getComentariosExternos() {
        return comentariosExternos;
    }

    public void setComentariosExternos(String[] comentariosExternos) {
        this.comentariosExternos = comentariosExternos;
    }
}
