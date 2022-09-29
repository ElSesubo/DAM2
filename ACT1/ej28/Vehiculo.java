package es.florida.ej;

public class Vehiculo {
	
	private String tipo;
	private String modelo;
	private String marca;
	
	public Vehiculo(String attr1, String attr2, String attr3)
    {
        tipo = attr1;
        modelo = attr2;
        marca = attr3;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
