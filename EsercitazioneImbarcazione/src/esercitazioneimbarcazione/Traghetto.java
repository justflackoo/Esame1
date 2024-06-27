package esercitazioneimbarcazione;

public class Traghetto extends Imbarcazione{
    private int numAutomobili;
    
    public Traghetto(int numPasseggeri, int stazza, String nome, int numAuto){
        super(numPasseggeri,stazza,nome);
        this.numAutomobili=numAuto;
    }
    
    public int getNumAutomobili(){return this.numAutomobili;}
    
    @Override
    public int notificaPasseggeri(){
        return this.getNumPasseggeri()+this.numAutomobili;}
    
    @Override
    public String toString(){
        return super.toString()+"\tNumAutomobili: "+this.numAutomobili;}
    
    
    
}
