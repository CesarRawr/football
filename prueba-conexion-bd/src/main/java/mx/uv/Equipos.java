package mx.uv;

//DTO
public class Equipos {
    private String id;
    private String nombreEq;
    private String slogan;
    private String directorT;
    private int torneo;

    public Equipos(String nombreEq, String slogan, String directorT, int torneo, String id){
        this.id = id;
        this.nombreEq = nombreEq;
        this.slogan = slogan;
        this.directorT = directorT;
        this.torneo = torneo;
    }

    public void setId(String id){
        this.id = id;
    }
 
    public void setNombreEq(String nombreEq){
        this.nombreEq = nombreEq;
    }    
 
    public void setSlogan(String slogan){
        this.slogan = slogan;
    }  
 
    public void setDirectorT(String directorT){
        this.directorT = directorT;
    }  
    
    public void setTorneo(int torneo){
        this.torneo = torneo;
    }     

    public String getId(){
        return id;
    }

    public String getNombreEq(){
        return nombreEq;
    }

    public String getSlogan(){
        return slogan;
    }

    public String getDirectorT(){
        return directorT;
    }

    public int getTorneo(){
        return torneo;
    }
    
}

