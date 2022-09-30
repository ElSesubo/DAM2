package es.florida.ejT1.ej2_9;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vista vista = new Vista();
		Model model = new Model();
		Controlador controlador = new Controlador(vista, model);
	}

}
