package ejT2;

import java.util.Date;

public class Libro {
	
	private String titol;
	private String autor;
	private Date anyNaixement;
	private Date anyPublicacio;
	private String editorial;
	private int numPagines;
	
	public Libro(String titol, String autor, Date anyNaixement, Date anyPublicacio, String editorial, int numPagines) {
		super();
		this.titol = titol;
		this.autor = autor;
		this.anyNaixement = anyNaixement;
		this.anyPublicacio = anyPublicacio;
		this.editorial = editorial;
		this.numPagines = numPagines;
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



	public Date getAnyNaixement() {
		return anyNaixement;
	}



	public void setAnyNaixement(Date anyNaixement) {
		this.anyNaixement = anyNaixement;
	}



	public Date getAnyPublicacio() {
		return anyPublicacio;
	}



	public void setAnyPublicacio(Date anyPublicacio) {
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
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
