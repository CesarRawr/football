public class Torneo {

    private String idTorneo;
    private String tipoTorneo;
    private String nmTorneo;

    public Torneo(String idTorneo, String tipoTorneo, String nmTorneo) {
        this.setID(idTorneo);
        this.setTipoTorneo(tipoTorneo);
        this.setNmTorneo(nmTorneo);
    }

    public Torneo() { }

    public String getID() {
        return this.idTorneo;
    }

    public void setID(String idTorneo){
        this.idTorneo = idTorneo;
    }

    public String getTipoTorneo() {
        return this.tipoTorneo;
    }

    public void setTipoTorneo(String tipoTorneo){
        this.tipoTorneo = tipoTorneo;
    }

    public String getNmTorneo(){
        return this.nmTorneo;
    }

    public void setNmTorneo(String nmTorneo){
        this.nmTorneo = nmTorneo;
    }
}
