package com.example.lab01;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;

public class LeeObjeto {
    public static void main(String[] args){
        try{
            //se crea un objeto ObjectInputStream para leer el objeto 'miusuario' serializado del archivo "user.out".
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.out"));
            //se imprime mostrando la fecha actual y la recuperación del objeto
            System.out.println("Recupero el objeto " + new Date());
            Usuario miusuario = (Usuario) in.readObject();
            System.out.println(miusuario);
            //Cuando se deserializa el objeto y se recupera, el campo password no tiene un valor asignado, por lo que su valor es null.


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
