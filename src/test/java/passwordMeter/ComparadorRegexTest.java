package passwordMeter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorRegexTest {

    ComparadorRegex comparador;

    @BeforeEach
    void setUp() {
         comparador = new ComparadorRegex("([^A-Za-z])", "C#a34ro*");
    }

    @Test
    void obterContagem() {
        assertEquals(4, comparador.obterContagem());
    }

    @Test
    void combinaCom() {
        assertEquals(true, comparador.combina());
    }
}