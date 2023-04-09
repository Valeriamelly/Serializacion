package com.example.lab01;

import java.io.Serializable;

public class Usuario implements Serializable { //convertir el objeto en un montón de bytes, es decir en un formato que se pueda almacenar o transportar
    private String nombre;
    private transient String password; //variable no se va a serializar, la información no se guarda ni se transfiere.
    // el campo password está marcado como transient, por lo que su información no se guarda en el archivo "user.out"
    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String toString(){
        //Si la contraseña no está disponible, se muestra "(n/a)".
        //condición ? valor_si_verdadero : valor_si_falso; --> operación ternaria: concisa expersión if-else

        String pwd = (password == null) ? "(n/a)" : password;
        return "Información Usuario: \n Nombre:  " + nombre + "\n Contraseña:" + pwd;


    }

}
