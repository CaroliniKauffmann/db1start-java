package passwordMeter.decremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeMinusculasConsecutivasTest {

    VerificadorDeMinusculasConsecutivas verificadorDeMinusculasConsecutivas;

    @BeforeEach
    void setUp() {
        verificadorDeMinusculasConsecutivas = new VerificadorDeMinusculasConsecutivas("aaaddd");

    }

    @Test
    void verificar() {
        verificadorDeMinusculasConsecutivas.verificar();
        assertEquals(Long.valueOf(6), verificadorDeMinusculasConsecutivas.score);
    }
}