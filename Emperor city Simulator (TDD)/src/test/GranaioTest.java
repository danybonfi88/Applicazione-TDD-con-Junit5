package test;
import Main_Package.*;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;

public class GranaioTest {
    static Granaio granaio;

    @BeforeAll
    @DisplayName("Impostazioni")
    static void setup(){
        granaio = new Granaio();
    }

    @RepeatedTest(20)
    @DisplayName("Test Funzionamento PRODUZIONE e AUMENTO Risorse del Granaio ")
    void PRodRisorseTest() {
        int RisorseV = granaio.getRisorse();
        int Aumento = granaio.produciRisorse();
        granaio.aumRisorse(Aumento);
        Assertions.assertTrue(Aumento >= 1 && Aumento <= 20);
        Assertions.assertEquals(RisorseV + Aumento,granaio.getRisorse());
    }

    @Test
    @DisplayName("Test Funzionamento DIMINUZIONE Risorse del Granaio ")
    void DimRisorseTest() {
        int n = granaio.getRisorse();
        granaio.dimRisorse(10);
        Assertions.assertEquals(n-10,granaio.getRisorse());
    }
    @Test
    @DisplayName("Test Azzeramento risorse Granaio ")
    void ZeroRisorseTest() {
        granaio.zeroRisorse();
        Assertions.assertEquals(0,granaio.getRisorse());
    }
}
