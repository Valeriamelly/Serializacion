package com.example.lab01;

import jakarta.xml.bind.DatatypeConverter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CodeBase64 {
    public static void main(String[] args){
        Path originalPath = Paths.get("D:/LABORATORIO - ARQUITECTURA SOFTWARE/data", "doc.pdf");
        Path targetPath = Paths.get("D:/LABORATORIO - ARQUITECTURA SOFTWARE/data", "encoded.txt");
        Base64.Encoder mimeEncoder = Base64.getMimeEncoder();

        //url
        Base64.Encoder urlEnconde = Base64.getUrlEncoder();

        try(OutputStream output = Files.newOutputStream(targetPath))
        {
            //GUARDAR ARCHIVO DE MANERA LOCAL
            Files.copy(originalPath, mimeEncoder.wrap(output));
            //OutputStream encodedStream=mimeEncoder.wrap(output);

/*
            byte[] bytes = Files.readAllBytes(targetPath); //Leer el pdf
            String encodedString = Base64.getMimeEncoder().encodeToString(bytes); //codifico en base 64
           //System.out.println(encodedString); //IMPRIMIR POR CONSOLA

            //Generar HASH: mantener autenticidad de un archivo o contenido por criterior de seguridad
         MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(encodedString.getBytes(StandardCharsets.UTF_8));
            String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();

            System.out.println(sha256);
*/
            //CODIFICAR A BASE 64 --> URL'S
            //sirve para enmascarar información que se transporte entre front-end y backend
            String urlOriginal = "https://google.com";
            byte[] bytes = urlEnconde.encode(urlOriginal.getBytes());

            System.out.println(new String(bytes));

            //desencriptar
            String urlDecoder = new String(Base64.getUrlDecoder().decode(bytes));
            System.out.println(urlDecoder);


        } catch( IOException e)
        {
            System.out.println((e.getMessage()));
        } catch (Exception e) {
            System.out.println((e.getMessage()));
        }

    }
}
