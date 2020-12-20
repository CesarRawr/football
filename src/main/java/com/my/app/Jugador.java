public class Jugador {

    private String id;
    private String nombre;
    private String fecha;
    private String numero;
    private String equipo;
    private String torneo;

	public Jugador(String id, String nombre, String fecha, String numero, String equipo, String torneo) {
		this.setID(id);
        this.setNombre(nombre);
		this.setFecha(fecha);
        this.setNumero(numero);
        this.setEquipo(equipo);
        this.setTorneo(torneo);
	}

	public Jugador() { }

    public String getID() {
        return this.id;
    }

    public void setID(String id){
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getFecha(){
        return this.fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public String getNumero(){
        return this.numero;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }

    public String getTorneo(){
        return this.torneo;
    }

    public void setTorneo(String torneo){
        this.torneo = torneo;
    }

    public String getEquipo(){
        return this.equipo;
    }

    public void setEquipo(String equipo){
        this.equipo = equipo;
    }
}
