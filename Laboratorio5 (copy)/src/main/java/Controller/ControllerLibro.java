package Controller;

import Model.*;
import java.util.TreeSet;

public class ControllerLibro {

    private TreeSet<Libro> libros = new TreeSet<Libro>();

    // Métodos
    // Constructor
    // Accessors de libros
    public TreeSet<Libro> getLibros() {
        return this.libros;
    }

    public int getSize() {
        return this.libros.size();
    }

    public void setLibros(TreeSet<Libro> libros_) {
        this.libros = libros_;
    }

    // Agregar Libro
    public void agregarLibro(Libro lib) {
        if (this.buscarLibro(lib.getIsbn()) == null) {
            this.libros.add(lib);

        } else {
            System.out.println("No se agrego el libro *" + lib.getNombre()
                    + "*,ya se encuentra en el sistema un libro con el mismo ISBN");

        }
    }

    public boolean agregarLibro(Libro lib, Autor aut, ControllerAutor controla) {
        TreeSet<Autor> listaAutores;
        if (this.buscarLibro(lib.getIsbn()) == null) {
            listaAutores = controla.getListaAutores();
            if (listaAutores.contains(aut)) {
                this.libros.add(lib);
                this.asignarAutorALibro(lib, aut, controla);

            } else {
                return false;
            }
        }
        return false;
    }

    public void asignarAutorALibro(Libro lib, Autor aut, ControllerAutor controlautor) {
        TreeSet<Autor> listaAutores;
        listaAutores = controlautor.getListaAutores();
        Libro libro;
        if (listaAutores.contains(aut) && this.libros.contains(lib)) {
            try {
                if (aut.getEstado().equals("ACTIVO")) {
                    libro = this.buscarLibro(lib.getIsbn());
                    controlautor.buscarAutor(aut.getCedula()).getLibrosEscritos().add(lib);
                    libro.getAutores().add(aut);
                } else {
                    System.out.println("El autor esta INACTIVO");
                }
            } catch (Exception e) {
                System.out.println("Null Pointer");
            }
        }
    }

    public Libro buscarLibro(String isbn) {
        for (Libro libro : this.libros) {
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
        for (Libro libro : this.libros) {
            total += libro.getCosto();
        }
        return total;
    }

    /**
     * asignarAutorALibro(Libro lib, Autor a): Asigna a un libro que debería existir
     * a un autor que debe existir El autor debe existir en la lista de autores No
     * se pueden asignar a los libros autores que tengan estado = ‘INACTIVO’
     */
}
