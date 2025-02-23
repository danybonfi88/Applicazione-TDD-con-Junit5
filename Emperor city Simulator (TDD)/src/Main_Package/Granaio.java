package Main_Package;

public class Granaio {
    private int risorse;

    public Granaio(){
        risorse=0;
    }

    public int produciRisorse(){return (int)(Math.random()*(20-1))+1;}
    public int getRisorse(){return risorse;}
    public void aumRisorse(int n){risorse=risorse+n;}
    public void dimRisorse(int n){risorse=risorse-n;}
    public void zeroRisorse(){risorse=0;}
}
