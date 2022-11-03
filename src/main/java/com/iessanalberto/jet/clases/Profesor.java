package com.iessanalberto.jet.clases;

import com.iessanalberto.jet.clases.Usuario;

public class Profesor extends Usuario {
    private String centro;

    public Profesor(String rol, String nombre, String contraseña, String familiaProfesional, String email, String[] gustos) {
        super(rol, nombre, contraseña, familiaProfesional, email, gustos);
    }
}
