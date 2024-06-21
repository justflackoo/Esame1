package imbarcazione;

/**
 *
 * @author giuse
 */
public abstract class Imbarcazione implements Comparable{
    private int numPasseggeri;
    private int stazza;
    private String nome;
    
    public Imbarcazione(int num, int stazza, String nome){
        this.numPasseggeri=num;
        this.stazza=stazza;
        this.nome = new String(nome);
    }

    public int getNumPasseggeri() {return numPasseggeri;}
    public void setNumPasseggeri(int numPasseggeri) {this.numPasseggeri = numPasseggeri;}
    
    public int getStazza() {return stazza;}
    public void setStazza(int stazza) {this.stazza = stazza;}
    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    
    @Override
    public int compareTo(Imbarcazione i){
        return this.stazza-i.stazza;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this==obj){return true;}
        if(obj==null){return false;}
        if(!(obj instanceof Imbarcazione)){return false;}
        
        //Verifiche preliminari superate,  confronto per nome
       Imbarcazione imb = (Imbarcazione) obj;
       return this.nome.equals(imb.nome);
    }
    
    @Override
    public String toString(){
        return "Nome: "+this.nome+"\tStazza: "+this.stazza+"\t NumPasseggeri: "+this.numPasseggeri;
    }
    
    public abstract int notificaPasseggeri();
    

}
