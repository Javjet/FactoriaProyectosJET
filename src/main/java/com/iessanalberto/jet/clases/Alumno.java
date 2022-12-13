package com.iessanalberto.jet.clases;

import jakarta.xml.bind.annotation.XmlElement;

public class Alumno extends Usuario {
    private String centro;
    @XmlElement(name="centro")
    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public Alumno(String rol, String nombre, String contraseña, String familiaProfesional, String email, String[] gustos) {
        super(rol, nombre, contraseña, familiaProfesional, email, gustos);
    }
}
