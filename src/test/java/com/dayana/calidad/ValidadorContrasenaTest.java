package com.dayana.calidad;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidadorContrasenaTest {

    private ValidadorContrasena validador;

    @BeforeEach
    void configurarPrueba() {
        validador = new ValidadorContrasena();
    }

    @Test
    void deberiaAceptarContrasenaValida() {
        boolean resultado = validador.esValida("Calidad1#");

        assertTrue(resultado);
    }

    @Test
    void deberiaRechazarContrasenaNula() {
        boolean resultado = validador.esValida(null);

        assertFalse(resultado);
    }
}