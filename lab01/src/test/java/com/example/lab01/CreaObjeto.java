package com.example.lab01;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class CreaObjeto {
    public static void main (String[] args){
        Usuario miusuario = new Usuario ("Valeria", "1234");
        System.out.println(miusuario);
        try{
            //se crea un objeto ObjectOutputStream para serializar el objeto miusuario
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("user.out"));
            o.writeObject(miusuario);
            o.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
