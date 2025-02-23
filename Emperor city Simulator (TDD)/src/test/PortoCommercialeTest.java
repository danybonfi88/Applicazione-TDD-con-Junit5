package test;
import Main_Package.*;
import org.junit.jupiter.api.*;

public class PortoCommercialeTest {

    @RepeatedTest(35)
    @DisplayName("Test Dell'invio delle risorse ad altri porti")
    public void InviamentoRisorseTest(){
        int i = PortoCommerciale.inviaRisorse();
        Assertions.assertTrue(i >= 15 && i <= 50);
    }

    @RepeatedTest(35)
    @DisplayName("Test Dell'arrivo delle risorse da altri porti")
    public void RicezioneRisorseTest(){
        int i = PortoCommerciale.riceviRisorse();
        Assertions.assertTrue(i >= 15 && i <= 50);
    }

}
