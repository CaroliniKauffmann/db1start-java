package passwordMeter.decremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class VerficadorDeSequenciasDeLetrasTest {

    VerficadorDeSequenciasDeLetras verficadorDeSequenciasDeLetras;

    @BeforeEach
    void setUp() {
        verficadorDeSequenciasDeLetras = new VerficadorDeSequenciasDeLetras("abcabcdef");

    }

    @Test
    void verificar() {
        verficadorDeSequenciasDeLetras.verificar();
        assertEquals(12, verficadorDeSequenciasDeLetras.score);
    }
}