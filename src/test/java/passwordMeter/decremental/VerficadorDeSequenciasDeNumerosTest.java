package passwordMeter.decremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class VerficadorDeSequenciasDeNumerosTest {

    VerficadorDeSequenciasDeNumeros verficadorDeSequenciasDeNumeros;

    @BeforeEach
    void setUp() {
        verficadorDeSequenciasDeNumeros = new VerficadorDeSequenciasDeNumeros("123123456");

    }

    @Test
    void verificar() {
        verficadorDeSequenciasDeNumeros.verificar();
        assertEquals(12, verficadorDeSequenciasDeNumeros.score);
    }
}