package logica;

public class Proceso {
	public int rafaga;
    public int tllegada;
    public int tcomienzo;
    public int tfinal;
    public int tretorno;
    public int prioridad;
    public int tespera;
    public String id;
    public Proceso padre;
    public Proceso sig;
    public boolean ejecutado;
    public int tbloqueo;
    public int tesperaRetorno;
    public int IdCola;
    public String NombreCola;
    
    public Proceso(){
    	sig = null;
    	padre = null;
    	ejecutado = false;
    }
}
