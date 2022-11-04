package com.iessanalberto.jet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iessanalberto.jet.clases.Usuario;
import com.iessanalberto.jet.clases.Usuarios;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("src/main/resources/usuarios.xml");

        JAXBContext contexto;
        try {
            //para leer el documento
            contexto = JAXBContext.newInstance(Usuario.class);
            //unmarshaller para pasar de xml a java
            Unmarshaller objetoUnmarshaller = contexto.createUnmarshaller();
            Usuario usuario;
            Usuarios usuarios;
            if(archivo.exists()) {
                usuarios = (Usuarios) objetoUnmarshaller.unmarshal(archivo);
                System.out.println(usuarios.getListaUsuarios().get(0).getNombre());
                Marshaller objetoMarshaller=contexto.createMarshaller();
                objetoMarshaller.marshal(usuarios,new FileWriter("target/Usuarios.json"));
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}