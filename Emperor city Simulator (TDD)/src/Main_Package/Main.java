package Main_Package;

public class Main {
    public static void main(String[] args) {

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