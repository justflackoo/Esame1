package esame2;

/**
 *
 * @author giuse
 */
public class Video extends Multimedia {
    private int numFrames;
    
    public Video(String fileName, char resolution, boolean raw, int numFrames){
        super(fileName,resolution,raw);
        this.numFrames=numFrames;
    }
    public void setNumFrames(int n){this.numFrames=n;}
    public int getNumFrames(){return this.numFrames;}
    
    
    /*Il metodo resize permette di ridimensionare un file multimediale in base ad una 
    percentuale passata come parametro. Se la percentuale è esterna all’intervallo ]0 100[ 
    allora il metodo solleva una eccezione del tipo IllegalArgumentException con 
    opportuno messaggio.
    Un video è ridotto modificando in percentuale il valore numero di frame.*/
    
    @Override
    public void resize(int percentage) throws IllegalArgumentException{
        if(percentage<=0 ||percentage >=100){
            throw new IllegalArgumentException("Valore non consentito");
        }
        this.numFrames = numFrames - (percentage*numFrames)/100;}
    
    @Override
    public String toString(){
        return super.toString()+"\tnumFrames: "+this.numFrames;
    }
}
