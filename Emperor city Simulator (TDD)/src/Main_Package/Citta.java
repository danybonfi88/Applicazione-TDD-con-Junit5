package Main_Package;

public class Citta {

    Granaio granaio;
    PortoCommerciale porto;
    Caserma caserma;

    public Citta(){
        granaio = new Granaio();
        porto = new PortoCommerciale();
        caserma = new Caserma();
    }

    public int granaioProduciRisorse(){return granaio.produciRisorse();}
    public int granaioGetRisorse(){return granaio.getRisorse();}
    public void granaioAumRisorse(int n){granaio.aumRisorse(n);}
    public void granaioDimRisorse(int n){granaio.dimRisorse(n);}
    public void granaioZeroRisorse(){granaio.zeroRisorse();}

    public int portoInviaRisorse(){return porto.inviaRisorse();}
    public int portoRiceviRisorse(){return porto.riceviRisorse();}

    public int casermaAddestraSoldati(){return caserma.addestraSoldati();}
    public void casermaAumSoldati(int n){caserma.aumSoldati(n);}
    public void casermaDimSoldati(int n){caserma.dimSoldati(n);}
    public int casermaGetSoldati(){return caserma.getSoldati();}

}
