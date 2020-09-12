package poo.lab5.Controller;

import poo.lab5.Model.Libro;
import poo.lab5.Model.Autor;
import java.util.TreeSet;

public class ControllerLibro {
    private static TreeSet<Libro> libros=new TreeSet<Libro>();

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
        for (Libro libro_ : ControllerLibro.getLibros()) {
            if (lib.getIsbn() == libro_.getIsbn()) {
                return;
            }
            libros.add(lib);
        }
    }

    /*
     * agregarLibro(Libro lib, Autor aut): Agrega un libro nuevo con un autor aut No
     * pueden existir dos libros con el mismo isbn El autor debe existir en la lista
     * de autores
     */
    public boolean agregarLibro(Libro lib, Autor aut) {
        if ((ControllerLibro.buscarLibro(lib.getIsbn()) != null)
                && (ControllerAutor.buscarAutor(aut.getCedula()) != null)) {
            ControllerLibro.getLibros().add(lib);
            ControllerAutor.getListaAutores().add(aut);
            return true;
        }
        return false;
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
}
