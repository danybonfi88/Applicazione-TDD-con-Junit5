package Main_Package;

public class Main {
    public static void main(String[] args) {
        Citta citta1 = new Citta();

        boolean cond1 = true, cond2 = true, cond3 = true, cond4 = true, cond5 = true, cond6 = true;
        int x, y, z, w, probRivolta, probInvasione;


        // PRODUZIONE GRANAIO //
        x = citta1.granaioProduciRisorse();
        try{
            checkRisorseMax(citta1, x);
        } catch (MassimoRisorseException e) {
            System.out.println("Errore: la produzione è stata scartata" + e.getMessage());
            cond1=false;
        }
        if(cond1){citta1.granaioAumRisorse(x);}


        // INVIO PORTO //
        y = citta1.portoInviaRisorse();
        try{
            checkRisorseInvio(citta1, y);
        } catch (ScarsitaRisorseException e) {
            System.out.println("Errore: " + e.getMessage());
            cond2=false;
        }
        if(cond2){citta1.granaioDimRisorse(y);}


        // RICEVI PORTO //
        z = citta1.portoRiceviRisorse();
        try{
            checkRisorseMax(citta1, z);
        } catch (MassimoRisorseException e) {
            System.out.println("Errore: " + e.getMessage());
            cond3=false;
        }
        if(cond3){citta1.granaioAumRisorse(z);}


        // ADDESTRAMENTO CASERMA //
        w = citta1.casermaAddestraSoldati() * 5;
        try{
            checkAddestraSoldati(citta1, w);
        } catch(AddestramentoFallitoException e){
            System.out.println("Errore: " + e.getMessage());
            cond4=false;
        }
        if(cond4){citta1.casermaAumSoldati(w); citta1.granaioDimRisorse(w*5);}


        // RIVOLTA //
        probRivolta = (int)(Math.random()*(10-1))+1;
        if(probRivolta <= 4){
            try{
                checkSoldatiRivolta(citta1);
            } catch(RivoltaAvvenutaException e){
                System.out.println("Errore: " + e.getMessage());
                cond5=false;
            }
            if(!cond5){citta1.granaioZeroRisorse(); citta1.casermaDimSoldati(2);}
        }


        // INVASIONE //
        probInvasione = (int)(Math.random()*(10-1))+1;
        if(probInvasione <= 2){
            try{
                checkSoldatiInvasione(citta1);
            } catch(InvasioneAvvenutaException e){
                System.out.println("Errore: " + e.getMessage());
                cond6=false;
            }
            if(!cond6){citta1.granaioZeroRisorse(); citta1.casermaDimSoldati(0);}
        }
    }

    public static void checkRisorseMax(Citta citta, int n)throws MassimoRisorseException{
        if((citta.granaioGetRisorse()+n)>500){
            throw new MassimoRisorseException("le risorse ricevute sono state scartate, il granaio è già pieno di risorse!");
        }
    }

    public static void checkRisorseInvio(Citta citta, int n)throws ScarsitaRisorseException{
        if(n>citta.granaioGetRisorse()){
            throw new ScarsitaRisorseException("L'invio di risorse è fallito, risorse insufficienti!");
        }
    }

    public static void checkAddestraSoldati(Citta citta, int n)throws AddestramentoFallitoException{
        if(citta.granaioGetRisorse()-(n*5)<0){
            throw new AddestramentoFallitoException("Non è stato possibile addestrare alcuni soldati, risorse insufficienti!");
        }
    }

    public static void checkSoldatiRivolta(Citta citta)throws RivoltaAvvenutaException{
        if(citta.casermaGetSoldati()<20){
            throw new RivoltaAvvenutaException("Non è possibile difendersi dalla rivolta, soldati insufficienti!");
        }
    }

    public static void checkSoldatiInvasione(Citta citta)throws InvasioneAvvenutaException{
        if(citta.casermaGetSoldati()<40){
            throw new InvasioneAvvenutaException("Non è possibile difendersi dall'invasione barbarica, soldati insufficienti!");
        }
    }
}