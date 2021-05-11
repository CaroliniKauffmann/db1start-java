package passwordMeter.decremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeNumerosConsecutivosTest {


    VerificadorDeNumerosConsecutivos verificadorDeNumerosConsecutivos;

    @BeforeEach
    void setUp() {
        verificadorDeNumerosConsecutivos = new VerificadorDeNumerosConsecutivos("111ddd");

    }

    @Test
    void verificar() {
        verificadorDeNumerosConsecutivos.verificar();
        assertEquals(4, verificadorDeNumerosConsecutivos.score);
    }
}