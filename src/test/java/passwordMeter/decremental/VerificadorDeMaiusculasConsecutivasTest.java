package passwordMeter.decremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class VerificadorDeMaiusculasConsecutivasTest {


    VerificadorDeMaiusculasConsecutivas verificadorDeMaiusculasConsecutivas;

    @BeforeEach
    void setUp() {
        verificadorDeMaiusculasConsecutivas = new VerificadorDeMaiusculasConsecutivas("ABCDddd");

    }

    @Test
    void verificar() {
        verificadorDeMaiusculasConsecutivas.verificar();
        assertEquals(Long.valueOf(6), verificadorDeMaiusculasConsecutivas.score);
    }

}