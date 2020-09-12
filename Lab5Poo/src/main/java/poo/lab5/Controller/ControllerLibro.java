package poo.lab5.Controller;

import poo.lab5.Model.Libro;
import poo.lab5.Model.Autor;
import java.util.TreeSet;

public class ControllerLibro {
    private static TreeSet<Libro> libros = new TreeSet<Libro>();

    // Métodos
    // Constructor
    // Accessors de libros
    public static TreeSet<Libro> getLibros() {
        return ControllerLibro.libros;
    }

    public static void setLibros(TreeSet<Libro> libros_) {
        ControllerLibro.libros = libros_;
    }

    // Agregar Libro
    public static void agregarLibro(Libro lib) {
        if (ControllerLibro.buscarLibro(lib.getIsbn()) == null) {
            ControllerLibro.libros.add(lib);
        }
    }
    public static void agregarAutoraListBook(Libro libro, Autor aut) {
        Libro lib = ControllerLibro.buscarLibro(libro.getIsbn());
        if (lib == null) {
            return;
        }
        lib.getAutores().add(aut);

    }
    // Multi-autores a libro
    public void agregarAutores(Libro lib, Autor... autores) {
        for (Autor autor : autores) {
            ControllerLibro.agregarAutoraListBook(lib, autor);
            autor.agregarLibroEscrito(lib);
        }
    }

    

    /*
     * agregarLibro(Libro lib, Autor aut): Agrega un libro nuevo con un autor aut No
     * pueden existir dos libros con el mismo isbn El autor debe existir en la lista
     * de autores
     */
    public static boolean agregarLibro(Libro lib, Autor aut) {
        boolean retorno = false;
        Libro _libro = ControllerLibro.buscarLibro(lib.getIsbn());
        if (_libro != null) {
            return retorno;
        }
        if ((ControllerAutor.buscarAutor(aut.getCedula()) != null)) {
            ControllerLibro.getLibros().add(lib);
            ControllerAutor.getListaAutores().add(aut);
            aut.agregarLibroEscrito(lib);
            retorno = true;

            return retorno;
        }
        return retorno;
    }

    /*
     * asignarAutorALibro(Libro lib, Autor a): Asigna a un libro que debería existir
     * a un autor que debe existir El autor debe existir en la lista de autores No
     * se pueden asignar a los libros autores que tengan estado = ‘INACTIVO’ public
     * void asignarAutorAlLibro(Libro lib, Autor aut) {}
     */
    public static Libro buscarLibro(String isbn) {
        for (Libro libro : ControllerLibro.libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    // calcularCostoTotalLibros(): calcular el costo total de todos los libros
    // existentes en el sistema
    public int calcularCostoTotalLibros() {
        int total = 0;
        for (Libro libro : ControllerLibro.libros) {
            total += libro.getCosto();
        }
        return total;
    }

    /**
     * asignarAutorALibro(Libro lib, Autor a): Asigna a un libro que debería existir
     * a un autor que debe existir El autor debe existir en la lista de autores No
     * se pueden asignar a los libros autores que tengan estado = ‘INACTIVO’
     */
    public static void asignarAutorALibro(Libro lib, Autor aut) {
        Autor aut2 = ControllerAutor.buscarAutor(aut.getCedula());
        if (aut2 != null) {
            aut2.agregarLibroEscrito(lib);
            ControllerLibro.agregarLibro(lib);
        }
    }
}
