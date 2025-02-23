package test;
import Main_Package.*;
import org.junit.jupiter.api.*;

public class CittaTest {
    static Citta citta;

    @BeforeAll
    @DisplayName("Impostazioni")
    static void setup(){
        citta = new Citta();
    }

    //________________________________________________________________________________________________________________
    // TEST DEL GRANAIO
    //________________________________________________________________________________________________________________

    @RepeatedTest(20)
    @DisplayName("Test Granaio cittadino:  Funzionamento PRODUZIONE e AUMENTO Risorse ")
    void PRodRisorseTest() {
        int RisorseV = citta.granaioGetRisorse();
        int Aumento = citta.granaioProduciRisorse();
        citta.granaioAumRisorse(Aumento);
        Assertions.assertTrue(Aumento >= 1 && Aumento <= 20);
        Assertions.assertEquals(RisorseV + Aumento,citta.granaioGetRisorse());
    }

    @Test
    @DisplayName("Test Granaio cittadino: Funzionamento DIMINUZIONE Risorse ")
    void DimRisorseTest() {
        int n = citta.granaioGetRisorse();
        citta.granaioDimRisorse(10);
        Assertions.assertEquals(n-10,citta.granaioGetRisorse());
    }
    @Test
    @DisplayName("Test Granaio cittadino: Azzeramento risorse")
    void ZeroRisorseTest() {
        citta.granaioZeroRisorse();
        Assertions.assertEquals(0,citta.granaioGetRisorse());
    }

    //________________________________________________________________________________________________________________
    // TEST DELLA CASERMA
    //________________________________________________________________________________________________________________

    @RepeatedTest(3)
    @DisplayName("Test Caserma cittadina: Funzionamento ADDESTRAMENTO e AUMENTO soldati ")
    void AddSoldatiTest() {
        int SoldatiV = citta.casermaGetSoldati();
        int Aumento = citta.casermaAddestraSoldati();
        citta.casermaAumSoldati(Aumento);
        Assertions.assertTrue(Aumento >= 1 && Aumento <= 3);
        Assertions.assertEquals(SoldatiV + Aumento, citta.casermaGetSoldati());
    }

    @RepeatedTest(5)
    @DisplayName("Test Caserma cittadina: Funzionamento DIMINUZIONE Soldati")
    void DimSoldatiTest() {
        int n = citta.casermaGetSoldati();
        citta.casermaDimSoldati(10);
        Assertions.assertEquals(n/2,
                citta.casermaGetSoldati());
        citta.casermaAumSoldati(10);
    }
    //________________________________________________________________________________________________________________
    // TEST DEL PORTO COMMERCIALE
    //________________________________________________________________________________________________________________

    @RepeatedTest(35)
    @DisplayName("Test del porto commerciale cittadino: invio delle risorse ad altri porti")
    public void InviamentoRisorseTest(){
        int i = citta.portoInviaRisorse();
        Assertions.assertTrue(i >= 15 && i <= 50);
    }

    @RepeatedTest(35)
    @DisplayName("Test del porto commerciale cittadino: arrivo delle risorse da altri porti")
    public void RicezioneRisorseTest(){
        int i = citta.portoRiceviRisorse();
        Assertions.assertTrue(i >= 15 && i <= 50);
    }

}

