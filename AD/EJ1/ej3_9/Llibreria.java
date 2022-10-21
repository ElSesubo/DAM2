package es.florida.ej3_9;

import java.sql.Date;
import java.util.ArrayList;

public class Llibreria {
	private static int identificador = 0;
	private String titol;
	private String autor;
	private String anyPublicacio;
	private String editorial;
	private int numPagines;
	private ArrayList<Llibreria> llibres = new ArrayList<Llibreria>();

	public Llibreria() {
		
	}
	
	public Llibreria(String titol, String autor, String anyPublicacio, String editorial, int numPagines) {
		identificador++;
		this.titol = titol;
		this.autor = autor;
		this.anyPublicacio = anyPublicacio;
		this.editorial = editorial;
		this.numPagines = numPagines;
	}
	
	public ArrayList<Llibreria> getLista(){
		return this.llibres;
	}
	
	public void setLista(ArrayList<Llibreria> llibres) {
		this.llibres = llibres;
	}
	
	public static int getIdentificador() {
		return identificador;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAnyPublicacio() {
		return anyPublicacio;
	}

	public void setAnyPublicacio(String anyPublicacio) {
		this.anyPublicacio = anyPublicacio;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNumPagines() {
		return numPagines;
	}

	public void setNumPagines(int numPagines) {
		this.numPagines = numPagines;
	}

	public ArrayList<Llibreria> getLlibres() {
		return llibres;
	}

	public void setLlibres(ArrayList<Llibreria> llibres) {
		this.llibres = llibres;
	}
	
	public int crearLlibre(String tit, String aut, String any, String edit, int num) {
		Llibreria libro = new Llibreria(tit, aut, any, edit, num);
		llibres.add(libro);
		return identificador;
	}
	
	public void mostrarLlibre(int id) {
		System.out.println(llibres.get(id).getTitol() + "\n" + llibres.get(id).getAutor() + "\n" + llibres.get(id).getAnyPublicacio() 
				+ "\n" + llibres.get(id).getEditorial() + "\n" + llibres.get(id).getNumPagines());	
	}
	

	public void borrarRegistre(int id) {
		llibres.remove(id);
		System.out.println("Llibre eliminat");
	}
	
	public void actualitzarRegistre(int id,String tit, String aut, String any, String edit, int num) {
		Llibreria libroAct = new Llibreria(tit, aut, any, edit, num);
		llibres.set(id, libroAct);
		System.out.println("Llibre actualitzat");
	}
	
	public void recuperarTots() {
		for(int i = 0; i < llibres.size(); i++) {
			llibres.get(i);
			System.out.println(llibres.get(i).getTitol());
		}
	}
}
