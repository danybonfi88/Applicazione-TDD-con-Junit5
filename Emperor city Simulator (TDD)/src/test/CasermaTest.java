package test;
import Main_Package.*;
import org.junit.jupiter.api.*;

public class CasermaTest {
    static Caserma caserma;

    @BeforeAll
    @DisplayName("Impostazioni")
    static void setup(){
        caserma = new Caserma();
    }

    @RepeatedTest(3)
    @DisplayName("Test Funzionamento ADDESTRAMENTO e AUMENTO soldati ")
    void AddSoldatiTest() {
        int SoldatiV = caserma.getSoldati();
        int Aumento = caserma.addestraSoldati();
        caserma.aumSoldati(Aumento);
        Assertions.assertTrue(Aumento >= 1 && Aumento <= 3);
        Assertions.assertEquals(SoldatiV + Aumento, caserma.getSoldati());
    }

    @RepeatedTest(5)
    @DisplayName("Test Funzionamento DIMINUZIONE Soldati")
    void DimSoldatiTest() {
        int n = caserma.getSoldati();
        caserma.dimSoldati(10);
        Assertions.assertEquals(n/2,
                caserma.getSoldati());
        caserma.aumSoldati(10);
    }
}
