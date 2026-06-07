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
        assertTrue(validador.esValida("Calidad1#"));
    }

    @Test
    void deberiaRechazarContrasenaNula() {
        assertFalse(validador.esValida(null));
    }

    @Test
    void deberiaRechazarContrasenaCorta() {
        assertFalse(validador.esValida("Cal1#"));
    }

    @Test
    void deberiaRechazarContrasenaSinNumero() {
        assertFalse(validador.esValida("Calidad#"));
    }

    @Test
    void deberiaRechazarContrasenaSinMayuscula() {
        assertFalse(validador.esValida("calidad1#"));
    }

    @Test
    void deberiaRechazarContrasenaSinCaracterEspecial() {
        assertFalse(validador.esValida("Calidad12"));
    }

    @Test
    void deberiaRechazarContrasenaConEspacio() {
        assertFalse(validador.esValida("Calidad 1#"));
    }

    @Test
    void deberiaDetectarEspaciosDuplicados() {
        assertTrue(validador.tieneEspaciosDuplicados("Calidad  1#"));
    }

    @Test
    void deberiaRetornarFalsoSiNoTieneEspaciosDuplicados() {
        assertFalse(validador.tieneEspaciosDuplicados("Calidad1#"));
    }
}
