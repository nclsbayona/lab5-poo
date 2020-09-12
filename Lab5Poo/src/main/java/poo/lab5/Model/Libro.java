package poo.lab5.Model;
import java.util.TreeSet;
public class Libro implements Comparable<Libro> {
    private TreeSet<Autor> autores;
    private String nombre;
    private String isbn;
    private int costo;

    //
    // Métodos
    // Accessors de autor
    public TreeSet<Autor> getAutores() {
        return this.autores;
    }

    public void setAutores(TreeSet<Autor> _autor) {
        this.autores = _autor;
    }

    // Accessors de costo
    public int getCosto() {
        return this.costo;
    }

    public void setCosto(int _costo) {
        this.costo = _costo;
    }

    // Accessors de nombre
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre_) {
        this.nombre = nombre_;
    }

    // Accessors de isbn
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn_) {
        this.isbn = isbn_;
    }

    // Comparable method
    @Override
    public int compareTo(Libro otro) {
        /*
         * Devuelve 0 en caso de que ambos objetos tengan el mismo orden (no haya uno
         * mayor que otro) Un número entero negativo si el objeto actual es menor al
         * objeto pasado como parámetro Un número positivo si el objeto actual es mayor
         * al objeto pasado como parámetro
         */
        if (this.nombre.charAt(0) == otro.nombre.charAt(0)) {
            return 0;
        } else if (this.nombre.charAt(0) < otro.nombre.charAt(0)) {
            return -1;
        } else {
            return 1;
        }
    }

    // Constructor
    public Libro(Autor _autor, String _nombrelibro, String _isbn, int _costo) {
        this.autores=new TreeSet<Autor>();
        this.autores.add(_autor);
         
        if (!_autor.getLibrosEscritos().contains(this)) {
            _autor.agregarLibroEscrito(this);
        }
        this.nombre = _nombrelibro;
        this.isbn = _isbn;
        this.costo = _costo;
    }

    public Libro(String _nombrelibro, String _isbn, int _costo) {
        this.autores=new TreeSet<Autor>();
        this.nombre = _nombrelibro;
        this.isbn = _isbn;
        this.costo = _costo;
    }

    public String toString() {
        String retorno=this.nombre + '-' + this.isbn + '-' + this.costo;
        //System.out.println("Retorno "+ retorno);
        return retorno;
    }
}