public class Noticia {

    private String idNoticia;
    private String tituloN;
    private String infoN;

    public Noticia(String idNoticia, String tituloN, String infoN) {
        this.setID(idNoticia);
        this.setTituloN(tituloN);
        this.setInfoN(infoN);
    }

    public Noticia() { }

    public String getID() {
        return this.idNoticia;
    }

    public void setID(String idNoticia){
        this.idNoticia = idNoticia;
    }

    public String getTituloN() {
        return this.tituloN;
    }

    public void setTituloN(String tituloN){
        this.tituloN = tituloN;
    }

    public String getInfoN(){
        return this.infoN;
    }

    public void setInfoN(String infoN){
        this.infoN = infoN;
    }
}
