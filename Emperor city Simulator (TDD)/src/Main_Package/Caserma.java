package Main_Package;

public class Caserma {
    private int soldati;

    public Caserma(){
        soldati=0;
    }
    public int addestraSoldati(){return (int)(Math.random()*(3-1))+1;}
    public void aumSoldati(int n){soldati=soldati+n;}
    public void dimSoldati(int n){if(n==0){soldati=0;} else{soldati=soldati/2;}}
    public int getSoldati(){return soldati;}
}
