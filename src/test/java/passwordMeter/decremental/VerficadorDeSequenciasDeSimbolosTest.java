package passwordMeter.decremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class VerficadorDeSequenciasDeSimbolosTest {

    VerficadorDeSequenciasDeSimbolos verficadorDeSequenciasDeSimbolos;

    @BeforeEach
    void setUp() {
        verficadorDeSequenciasDeSimbolos = new VerficadorDeSequenciasDeSimbolos("@#$@#$%ˆ");

    }

    @Test
    void verificar() {
        verficadorDeSequenciasDeSimbolos.verificar();
        assertEquals(Long.valueOf(6), verficadorDeSequenciasDeSimbolos.score);
    }
}