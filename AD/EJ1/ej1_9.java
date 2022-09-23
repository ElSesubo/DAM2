package es.florida.ejT1;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ej1_9 {
	
	public static void getInformacio(String nom) {
		File dirfit = new File("C:/Users/gaarag/Desktop/" + nom);
		
		long time = dirfit.lastModified();
		DateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
		
		System.out.println("Nombre del archivo: " + dirfit.getName());
		if(dirfit.isFile()) {
			System.out.println("Tipus: Fitxer");
		}else if(dirfit.isDirectory()) {
			System.out.println("Tipus: Directori");
		}
		System.out.println("Última modificació: " + sdf.format(time));
		System.out.println("Ruta: " + dirfit.getPath());
		
		if(dirfit.isFile()) {
			System.out.println("Tamaño: " + dirfit.length() + " Bytes");
		}
		if(dirfit.isDirectory()) {
			System.out.println("Elements: " + dirfit.listFiles());
			System.out.println("Espai lliure: " + dirfit.getFreeSpace());
			System.out.println("Espai disponible: " + dirfit.getUsableSpace());
			System.out.println("Espai total: " + dirfit.getTotalSpace());
		}
	}
	
	public static void crearCarpeta(String nom) {
		File directorio = new File("C:/Users/gaarag/Desktop/" + nom);
		if (!directorio.exists()) {
			  if (directorio.mkdirs()) {
				  System.out.println("El directori s'ha creat correctament");
			  }
			  else {
				  System.out.println("Ha hagut un problema al crear el directori");  
			  }
			}else {
				System.out.println("El directorio ja existeix"); 
			}
	}
	
	public static void crearFitxer(String nom) {
		File fichero = new File ("C:/Users/gaarag/Desktop/" + nom);
		try {
			if (!fichero.exists()) {
			  if (fichero.createNewFile()) {
				  System.out.println("El fitxer s'ha creat correctament");
			  }
			  else {
				  System.out.println("Ha hagut un problema al crear el fitxer");  
			  }
			}else {
				System.out.println("El fitxer ja existeix"); 
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void eliminar(String nom) {
		File dirfit = new File("C:/Users/gaarag/Desktop/" + nom);
		if (!dirfit.exists()) {
			  if (dirfit.delete()) {
				  System.out.println("El directori o fitxer s'ha eliminat correctament");
			  }
			  else {
				  System.out.println("Ha hagut un problema al eliminar el directori o fitxer");  
			  }
			}else {
				System.out.println("El directorio o fitxer no existeix");
			}
	}
	
	public static void renomenar(String nom) {
		File dirfit = new File("C:/Users/gaarag/Desktop/" + nom);
		if (dirfit.exists()) {
			Scanner teclado = new Scanner(System.in);
			System.out.print("Quin nom li vols posar? ");
			String nombre = teclado.nextLine();
			File renom = new File("C:/Users/gaarag/Desktop/" + nombre);
			  if (dirfit.renameTo(renom)) {
				  System.out.println("S'ha cambiat el nom correctament");
			  }
			  else {
				  System.out.println("Ha hagut un problema al cambiar el nom del directori o fitxer");  
			  }
			}else {
				System.out.println("El directorio o fitxer no existeix");
			}
	}
	
	public static boolean continuar() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Vols continuar? (Y/N) ");
		String yn = teclado.nextLine();
		if(yn.equals("Y") || yn.equals("y")){
			return false;
		}else {
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado;
		boolean continuar = false;
		do {
			System.out.println("1. Mostrar informació");
			System.out.println("2. Crear carpeta");
			System.out.println("3. Crear fitxer");
			System.out.println("4. Eliminar fitxer/carpeta");
			System.out.println("5. Renomenar fitxer/carpeta");
			teclado = new Scanner(System.in);
			System.out.print("Triar opció: ");
			Integer opcio = Integer.parseInt(teclado.nextLine());
			switch (opcio) {
				case 1: {
					System.out.print("Nom del fitxer o directori: ");
					String dirfit = teclado.nextLine();
					
					getInformacio(dirfit);
					
					continuar = continuar();
				}
				break;
				case 2: {
					System.out.print("Nom de la carpeta: ");
					String dir = teclado.nextLine();
					
					crearCarpeta(dir);

					continuar = continuar();
				}
				break;
				case 3: {
					System.out.print("Nom del fitxer: ");
					String fit = teclado.nextLine();
					
					crearFitxer(fit);
					
					continuar = continuar();
				}
				break;
				case 4: {
					System.out.print("Quin directori o fitxer vols borrar? ");
					String dirfit = teclado.nextLine();
					
					eliminar(dirfit);
					
					continuar = continuar();
				}
				break;
				case 5: {
					System.out.print("Quin directori o fitxer vols renombrar? ");
					String dirfit = teclado.nextLine();
					
					renomenar(dirfit);
					
					continuar = continuar();
				}
				break;
			}
		}while(continuar == false);
		System.out.println("Proces finalitzat");
	}

}
