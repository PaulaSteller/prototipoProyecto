/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author kevin
 */
public class CifradoUtil {
    
    private static final int CLAVE = 3;

    public static String cifrar(String textoPlano) {
        StringBuilder sb = new StringBuilder();
        for (char c : textoPlano.toCharArray()) sb.append((char) (c + CLAVE));
        return sb.toString();
    }

    public static String descifrar(String textoCifrado) {
        StringBuilder sb = new StringBuilder();
        for (char c : textoCifrado.toCharArray()) sb.append((char) (c - CLAVE));
        return sb.toString();
    }
}

