package poo.lab5.Controller;

import poo.lab5.Model.Libro;
import poo.lab5.Model.Autor;
import java.util.TreeSet;

public class ControllerLibro {
    private static TreeSet<Libro> libros;

    // Métodos
    // Add Libro
    public void addLibro(Libro lib) {
        for (Libro libro_ : ControllerLibro.libros) {
            if (lib.getIsbn() == libro_.getIsbn()) {
                return;
            }
            libros.add(lib);
        }
    }

    public boolean addLibro(Libro lib, Autor aut) {}
     /* public void asignarAutorAlLibro(Libro lib, Autor aut) {}
     */
    public Libro buscarLibro(String isbn) {
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
