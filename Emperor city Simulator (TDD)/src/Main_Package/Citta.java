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
}
