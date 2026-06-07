package com.dayana.calidad;

public class ValidadorContrasena {

    private static final String CARACTERES_ESPECIALES =
            "@#!$%^&*()-_+=[]{}|;:,.<>?";

    public boolean esLongitudValida(String contrasena) {
        return contrasena != null && contrasena.length() >= 8;
    }

    public boolean contieneNumero(String contrasena) {
        if (contrasena == null) {
            return false;
        }

        for (char caracter : contrasena.toCharArray()) {
            if (Character.isDigit(caracter)) {
                return true;
            }
        }

        return false;
    }

    public boolean contieneMayuscula(String contrasena) {
        if (contrasena == null) {
            return false;
        }

        for (char caracter : contrasena.toCharArray()) {
            if (Character.isUpperCase(caracter)) {
                return true;
            }
        }

        return false;
    }

    public boolean contieneCaracterEspecial(String contrasena) {
        if (contrasena == null) {
            return false;
        }

        for (char caracter : contrasena.toCharArray()) {
            if (CARACTERES_ESPECIALES.indexOf(caracter) >= 0) {
                return true;
            }
        }

        return false;
    }

    public boolean esValida(String contrasena) {
        return esLongitudValida(contrasena)
                && contieneNumero(contrasena)
                && contieneMayuscula(contrasena)
                && contieneCaracterEspecial(contrasena);
    }
    
    public boolean ContieneEspacios(String contrasena) {
        return contrasena != null && contrasena.contains(" ");
    }
}