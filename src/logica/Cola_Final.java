package logica;

public class Cola_Final extends Cola {
	public void Ordenamiento() {

		this.calcularTiemposProcesos();
	}

	public void CambiarRafaga(int rafagaEjecutada) {
		Proceso proceso = raiz.padre;
		if (proceso == this.raiz) {
			System.out.println("Cola Vacia");
			return;
		}
		this.raiz.padre.rafaga = rafagaEjecutada;
		//this.calcularTiemposProcesos();
	}
	public void recalcularBloqueado(int rafagaEjecutada) {
		Proceso proceso = raiz.padre;
		if (proceso == this.raiz) {
			System.out.println("Cola Vacia");
			return;
		}
		int aux = this.raiz.padre.tfinal - this.raiz.padre.tcomienzo - rafagaEjecutada; 
		this.raiz.padre.rafaga = rafagaEjecutada;
		this.raiz.padre.tfinal = this.raiz.padre.tfinal-aux;
		this.raiz.padre.tretorno = this.raiz.padre.tretorno-aux;
	}
}
