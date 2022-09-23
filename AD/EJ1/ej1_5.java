package es.florida.ejT1;

import java.io.File;

public class ej1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strdirectorio2 = args[0];
		String extension = args[1];
		File directorio = new File(strdirectorio2);
		FiltroExtension filtro = new FiltroExtension(extension);
		String[] listaArchivos = directorio.list(filtro);
		
		for (int i = 0; i < listaArchivos.length; i++) {
				System.out.println(listaArchivos[i]);
		}
	}
}
