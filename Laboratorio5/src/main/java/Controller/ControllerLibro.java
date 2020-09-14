package Controller;

import Model.*;
import java.util.TreeSet;

public class ControllerLibro {

    private static TreeSet<Libro> libros = new TreeSet<Libro>();

    // Métodos
    // Constructor
    // Accessors de libros
    public static TreeSet<Libro> getLibros() {
        return ControllerLibro.libros;
    }

    public static int getSize() {
        return ControllerLibro.libros.size();
    }

    public static void setLibros(TreeSet<Libro> libros_) {
        ControllerLibro.libros = libros_;
    }

    // Agregar Libro
    public static void agregarLibro(Libro lib) {
        if (ControllerLibro.buscarLibro(lib.getIsbn()) == null) {
            ControllerLibro.libros.add(lib);

        } else {
            System.out.println("No se agrego el libro *" + lib.getNombre() + "*,ya se encuentra en el sistema un libro con el mismo ISBN");

        }
    }

    public static boolean agregarLibro(Libro lib, Autor aut) {
        TreeSet<Autor> listaAutores;
        if (ControllerLibro.buscarLibro(lib.getIsbn()) == null) {
            listaAutores = ControllerAutor.getListaAutores();
            if (listaAutores.contains(aut)) {
                ControllerLibro.libros.add(lib);
                ControllerLibro.asignarAutorALibro(lib, aut);

            } else {
                return false;
            }
        }
        return false;
    }

    public static void asignarAutorALibro(Libro lib, Autor aut) {
        TreeSet<Autor> listaAutores;
        listaAutores = ControllerAutor.getListaAutores();
        Libro libro;
        if (listaAutores.contains(aut) && ControllerLibro.libros.contains(lib)) {
            try {
                if (aut.getEstado().equals("ACTIVO")) {
                    libro = ControllerLibro.buscarLibro(lib.getIsbn());
                    ControllerAutor.buscarAutor(aut.getCedula()).getLibrosEscritos().add(lib);
                    libro.getAutores().add(aut);
                } else {
                    System.out.println("El autor esta INACTIVO");
                }
            } catch (Exception e) {
                System.out.println("Null Pointer");
            }
        }
    }

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
    public static int calcularCostoTotalLibros() {
        int total = 0;
        for (Libro libro : ControllerLibro.libros) {
            total += libro.getCosto();
        }
        return total;
    }

    /**
     * asignarAutorALibro(Libro lib, Autor a): Asigna a un libro que debería
     * existir a un autor que debe existir El autor debe existir en la lista de
     * autores No se pueden asignar a los libros autores que tengan estado =
     * ‘INACTIVO’
     */
}
