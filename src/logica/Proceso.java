package logica;
import java.util.Comparator;

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
    
    public int getRafaga() {
		return rafaga;
	}

	public static Comparator<Proceso> ProcesoRafaga = new Comparator<Proceso>() {

    	public int compare(Proceso p1, Proceso p2) {

    	   int rafaga1 = p1.getRafaga();
    	   int rafaga2 = p2.getRafaga();

    	   /*For ascending order*/
    	   return rafaga1-rafaga2;

    	   /*For descending order*/
    	   //rollno2-rollno1;
    }};
    
    //aux.padre.id + " | " + aux.sig.id + " | " + aux.id + " | " + aux.tllegada + " | "
	//+ aux.rafaga + " | " + aux.tcomienzo + " | " + aux.tfinal + " | " + aux.tretorno + " | "
	//+ aux.tespera + " | " + aux.ejecutado
    @Override
    public String toString() {
        return "[ Padre: "+this.padre.id+", Sig: "+this.sig.id+", id: " + this.id +", tllegada: "+ this.tllegada+ ", rafaga: " + this.rafaga +
        		", tComienzo: "+this.tcomienzo +", tFinal: "+this.tfinal+", tRetorno: "+this.tretorno+", tEspera: "+this.tespera +"]";
    }
}
