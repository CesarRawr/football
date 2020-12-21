public class Partido {

    private String idPartido;
    private String equipoL;
    private String equipoV;
    private String fechaP;
    private String horaP;

    public Partido(String idPartido, String equipoL, String equipoV, String fechaP, String horaP) {
        this.setID(idPartido);
        this.setEquipoL(equipoL);
        this.setEquipoV(equipoV);
        this.setFechaP(fechaP);
        this.setHoraP(horaP);
    }

    public Partido() { }

    public String getID() {
        return this.idPartido;
    }

    public void setID(String idPartido){
        this.idPartido = idPartido;
    }

    public String getEquipoL() {
        return this.equipoL;
    }

    public void setEquipoL(String equipoL){
        this.equipoL = equipoL;
    }

    public String getEquipoV(){
        return this.equipoV;
    }

    public void setEquipoV(String equipoV){
        this.equipoV = equipoV;
    }

    public String getFechaP(){
        return this.fechaP;
    }

    public void setFechaP(String fechaP){
        this.fechaP = fechaP;
    }

    public String getHoraP(){
        return this.horaP;
    }

    public void setHoraP(String horaP){
        this.horaP = horaP;
    }
}
