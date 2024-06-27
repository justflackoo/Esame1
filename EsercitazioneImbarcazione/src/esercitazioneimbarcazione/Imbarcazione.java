package esercitazioneimbarcazione;

public abstract class Imbarcazione implements Comparable <Imbarcazione>{
    private int numPasseggeri;
    private int stazza;
    private String nome;
    
    public Imbarcazione(int num, int stazza, String nome){
        this.numPasseggeri=num;
        this.stazza=stazza;
        this.nome = new String(nome);
    }
 
    public int getNumPasseggeri(){return this.numPasseggeri;}    
    public String getNome(){return this.nome;}
    public int getStazza(){return this.stazza;}
    
    @Override
    public int compareTo(Imbarcazione i){
        return this.stazza-i.stazza;}
    
    
    @Override
    public boolean equals(Object obj){
        if(this==obj){return true;}
        if(obj==null){return false;}
        if(!(obj instanceof Imbarcazione)){return false;}
        
        Imbarcazione imb = (Imbarcazione) obj;
        return this.nome.equals(imb.nome);
    }
    
    public abstract int notificaPasseggeri();
    
    @Override
    public String toString(){
        return "Nome: "+this.nome+"\tStazza: "+this.stazza+"\tNumPasseggeri: "+this.numPasseggeri;
    }
    

    
}
