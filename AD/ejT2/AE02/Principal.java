package ejT2.AE02;

public class Principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vista vista = new Vista();
		Model model = new Model();
		Controlador controlador = new Controlador(vista, model);
	}
}	
