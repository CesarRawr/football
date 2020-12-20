public class Equipo {

    private String idEquipo;
    private String nmEquipo;
    private String slogan;
    private String dt;
    private String torneo;

	public Equipo(String idEquipo, String nmEquipo, String slogan, String dt, String torneo) {
		this.setID(idEquipo);
        this.setNmEquipo(nmEquipo);
		this.setSlogan(slogan);
        this.setDT(dt);
        this.setTorneo(torneo);
	}

	public Equipo() { }

    public String getID() {
        return this.idEquipo;
    }

    public void setID(String idEquipo){
        this.idEquipo = idEquipo;
    }

    public String getNmEquipo() {
        return this.nmEquipo;
    }

    public void setNmEquipo(String nmEquipo){
        this.nmEquipo = nmEquipo;
    }

    public String getSlogan(){
        return this.slogan;
    }

    public void setSlogan(String slogan){
        this.slogan = slogan;
    }

    public String getDT(){
        return this.dt;
    }

    public void setDT(String dt){
        this.dt = dt;
    }

    public String getTorneo(){
        return this.torneo;
    }

    public void setTorneo(String torneo){
        this.torneo = torneo;
    }
}
