package es.florida.AE03;

public class Libros {
    private static int id_auto=0;
    private int id;
    private String titulo;

    public Libros(String titulo) {
        this.id=id_auto++;
        this.titulo = titulo;
        id_auto++;
    }

    public Libros(int id,String titulo) {
        this.id=id;
        this.titulo = titulo;
        if(id>id_auto) {
            id_auto=id;
        }
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
