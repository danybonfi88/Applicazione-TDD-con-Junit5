package test;
import Main_Package.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionsTest {

    private Citta citta;

    @BeforeEach
    void setUp() {
        citta = new Citta();
    }

    @Test
    @DisplayName("Test Eccezione rivolta Fallita ")
    void RivoltaFallitaTest() {
        citta.casermaAumSoldati(10);

        Exception e = assertThrows(RivoltaAvvenutaException.class, () -> Main.checkSoldatiRivolta(citta));
        assertEquals("Non è possibile difendersi dalla rivolta, soldati insufficienti!", e.getMessage());
    }

    @Test
    @DisplayName("Test Invasione Avvenuta ")
    void InvasioneAvvenutaTest() {
        citta.casermaAumSoldati(30);

        Exception e = assertThrows(InvasioneAvvenutaException.class, () -> Main.checkSoldatiInvasione(citta));
        assertEquals("Non è possibile difendersi dall'invasione barbarica, soldati insufficienti!", e.getMessage());
    }

    @Test
    @DisplayName("Test Addestramento Soldati Fallito ")
    void AddestramentoSoldatiTest()  {
        citta.granaioAumRisorse(50);
        int soldatiAddestrati = 50;

        Exception e = assertThrows(AddestramentoFallitoException.class,() -> Main.checkAddestraSoldati(citta, soldatiAddestrati));
        assertEquals("Non è stato possibile addestrare alcuni soldati, risorse insufficienti!", e.getMessage());
    }

    @Test
    @DisplayName("Test Risorse Massime Raggiunte ")
    void RisorseMaxTest() {
        citta.granaioAumRisorse(500);
        int NRisorse = citta.granaioProduciRisorse();
        Exception e = assertThrows(MassimoRisorseException.class,() -> Main.checkRisorseMax(citta,NRisorse));
        assertEquals("le risorse ricevute sono state scartate, il granaio è già pieno di risorse!",e.getMessage());
    }

    @Test
    @DisplayName("Test Risorse insufficienti x inviare")
    void RisorseInvioTest()  {
        citta.granaioAumRisorse(0);
        int inviate = citta.portoInviaRisorse();
        Exception e = assertThrows(ScarsitaRisorseException.class,() -> Main.checkRisorseInvio(citta, inviate));
        assertEquals("L'invio di risorse è fallito, risorse insufficienti!",e.getMessage());
    }





}
