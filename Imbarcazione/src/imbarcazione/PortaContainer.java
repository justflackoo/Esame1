package imbarcazione;

/**
 *
 * @author giuse
 */
public class PortaContainer extends Imbarcazione{
    private int numContainer;
    
    public PortaContainer(int numPasseggeri, int stazza, String nome, int numContainer){
        super(numPasseggeri,stazza,nome);
        this.numContainer=numContainer;
    }
    
    @Override
    public int notificaPasseggeri(){return this.getNumPasseggeri()+(this.numContainer*2);}
    
    public int getNumContainer(){return this.numContainer;}
    
    public String toString(){
        return super.toString()+"\tNumContainer"+this.numContainer;
    }
    
}
