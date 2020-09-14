package Controller;
import Model.*;
import java.util.TreeSet;

public class ControllerAutor {

    private TreeSet<Autor> listaAutores;
    private ControllerLibro controllerLibro;

    // Métodos
    //Constructores
    public ControllerAutor()
    {
        this.listaAutores = new TreeSet<Autor>();
    }
    // accesors de lista autores
    public TreeSet<Autor> getListaAutores() {
        return this.listaAutores;
    }

    public void setListaAutores(TreeSet<Autor> listaAutores_) {
        this.listaAutores = listaAutores_;
    }

    // Agregar Autor
    public void agregarAutor(Autor aut) {
        if (this.buscarAutor(aut.getCedula()) == null) {
            this.listaAutores.add(aut);
        } else {
            System.out.println("No se agrego el Autor :" + aut.getNombre() + " CC: " + aut.getCedula()
                    + " ya se encuentra esa cedula en nuestro sistema");

        }
    }
	//Agregar varios libros a autor
	public void agregarVariosLibrosAUnAutor(Autor aut, Libro... libros) {
        for (Libro lib : libros) {
            this.agregarLibroAAutor(lib, aut);
        }
        return;
    }
    // Agregar libro a autor
    public boolean agregarLibroAAutor(Libro lib, Autor aut) {
        Autor autor;
        TreeSet<Libro> librosEscritos;
        autor = this.buscarAutor(aut.getCedula());
        if (autor != null && autor.getEstado().equals("ACTIVO")) {
            librosEscritos = autor.getLibrosEscritos();
            try {
                if (this.controllerLibro.buscarLibro(lib.getIsbn()) == null) {
                    return false;
                } else {
                    if (!librosEscritos.contains(lib)) {
                        librosEscritos.add(lib);
                        autor.setLibrosEscritos(librosEscritos);
                        return true;
                    } else {
                        return false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Null pointer");
            }
        }
        return false;
    }

    /**
     * calcularCostoTotalLibros(int p_cedula) Calcular el costo total de los libros
     * del autor cuya cédula llega como parámetro.
     */
    public int calcularCostoTotalLibros(int p_cedula) {
        int total = 0;
        for (Autor autor : this.listaAutores) {
            if (autor.getCedula() == p_cedula) {
                for (Libro libro : autor.getLibrosEscritos()) {
                    total += libro.getCosto();
                }
                return total;
            }
        }
        return total;
    }

    // Multi-libros a autor
    /*
     * public static void agregarAutores(Autor aut, Libro... libros) { for (Libro
     * libro : libros) { ControllerAutor.agregarLibroAAutor(libro, aut);
     * aut.agregarLibroEscrito(libro); } }
     */
    // buscarAutor(int p_cedula) Buscar y retornar el autor cuya cédula llega como
    // parámetro
    public Autor buscarAutor(int p_cedula) {
        for (Autor autor : this.listaAutores) {
            if (autor.getCedula() == p_cedula) {
                return autor;
            }
        }
        return null;
    }

    public void setControllerLibro(ControllerLibro controllerLibro2) {
        this.controllerLibro = controllerLibro2;
    }

}
