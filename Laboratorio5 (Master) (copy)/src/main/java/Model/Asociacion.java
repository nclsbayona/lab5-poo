package Model;
public class Asociacion {
    private Autor autor;
    private Libro libro;
    //Métodos
    //Accessors de autor
	public Autor getAutor() {
		return this.autor;
    }
    
	public void setAutor(Autor autor) {
		this.autor = autor;
    }
    //Accessors de libro
	public Libro getLibro() {
		return this.libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

}
