package com.iessanalberto.jet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iessanalberto.jet.clases.Centros;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        crearUsuario();
        crearCentro();

    }
    public static void crearUsuario(){
        File archivo = new File("src/main/resources/usuarios.xml");
        File archivoJson= new File("target/Usuarios.json");
        JAXBContext contexto;
        try {
            //para leer el documento
            contexto = JAXBContext.newInstance(Usuarios.class);
            //unmarshaller para pasar de xml a java
            Unmarshaller objetoUnmarshaller = contexto.createUnmarshaller();

            Usuarios usuarios;
            List<String> textoAlumno =new ArrayList<>();
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            if(archivo.exists()) {
                usuarios = (Usuarios) objetoUnmarshaller.unmarshal(archivo);
                //Marshaller objetoMarshaller=contexto.createMarshaller();
                Files.write(archivoJson.toPath(), gson.toJson(usuarios).getBytes());


            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void crearCentro(){
        //Creamos un archivo que apunta a insti.xml
        File xmlCentros = new File("src/main/resources/centros.xml");
        Path archivo = Path.of("target/centros.json");
        try
        {
            //Creamos el contexto para trabajar con nuestra clase Instituto.
            JAXBContext contexto = JAXBContext.newInstance(Centros.class);

            //Con el objeto tipo Unmarshaller pasamos de XML a Java.
            Unmarshaller objetoUnmarshaller = contexto.createUnmarshaller();
            Centros centro;	//Creamos un objeto tipo Centros.

            //Pasamos de XML a Java y mostramos por pantalla el contenido de la etiqueta <nombre>.
            centro = (Centros) objetoUnmarshaller.unmarshal(xmlCentros);

            System.out.println(centro.getNombre());
            System.out.println("\n" + "\n");

            //Pasamos de objeto a archivo .json

            GsonBuilder builder = new GsonBuilder();

            Gson gson = builder.setPrettyPrinting().create();

            String texto = gson.toJson(centro);

            Files.writeString(archivo, texto);

        } catch (JAXBException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}