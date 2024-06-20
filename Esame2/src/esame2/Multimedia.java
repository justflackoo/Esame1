package esame2;

/**
 *
 * @author giuse
 */
public abstract class Multimedia implements Resizable {
    private String fileName;
    private char resolution;
    private boolean raw;
    
    public Multimedia(String filename, char resolution, boolean raw){
        this.fileName = new String(filename);
        this.resolution = resolution;
        this.raw=raw;
    }
    
    public String getFileName(){return this.fileName;}
    public char getResolution(){return this.resolution;}
    public boolean getRaw(){return this.raw;}
    
    @Override
    public  boolean equals(Object obj){
        if(this==obj){return true;}
        if(obj==null){return false;}
        if(!(obj instanceof Multimedia)){return false;}
        
        //Verifiche preliminari superate
        Multimedia m = (Multimedia) obj;
        return fileName.equals(m.getFileName());
    }
    /*Il metodo checkQuality verifica se l’elemento multimediale è di alta qualità o meno, 
      ovvero quando la risoluzione è almeno High ed è salvato in formato raw.*/
    @Override
    public boolean checkQuality(){
        return ((this.resolution=='H' || this.resolution=='E') && this.raw==true);
    }
    //Ho necessità di implementarlo nelle sottoclassi, non nella superclasse.
    //Per questo motivo lo rendo abstract
    @Override
    public abstract void resize(int percentage)throws IllegalArgumentException;
    
    @Override
    public String toString(){
        return "FileName: "+this.fileName+"\tResolution: "+this.resolution+"\tRaw: "+this.raw;
    }
        
    
}
