package poo.lab5.Controller;

import poo.lab5.Model.Libro;
import poo.lab5.Model.Autor;

import java.util.TreeSet;

public class ControllerAutor {
    private static TreeSet<Autor> listaAutores;

    // Métodos
    // accesors de lista autores
    public static TreeSet<Autor> getListaAutores() {
        return ControllerAutor.listaAutores;
    }

    public static void setListaAutores(TreeSet<Autor> listaAutores_) {
        ControllerAutor.listaAutores = listaAutores_;
    }

    // Agregar Autor
    public void agregarAutor(Autor aut) {
        for (Autor autor_ : ControllerAutor.getListaAutores()) {
            if (autor_.getCedula() == aut.getCedula()) {
                return;
            }
        }
        aut.setLibrosEscritos(new TreeSet<Libro>());
        ControllerAutor.getListaAutores().add(aut);
    }

    // Agregar libro a autor
    public void agregarLibroAAutor(Libro lib, Autor aut) {
        for (Autor autor_ : ControllerAutor.getListaAutores()) {
            if (autor_ == aut) {
                for (Libro libro_ : autor_.getLibrosEscritos()) {

                    if (libro_.getIsbn().equals(lib.getIsbn())) {
                        return;
                    }
                    if (ControllerLibro.getLibros().contains(lib)) {
                        if (lib.getAutor() != aut) {
                            lib.setAutor(aut);
                        }
                        aut.agregarLibroEscrito(lib);
                        return;
                    }
                }
            }
        }
    }

    /**
     * calcularCostoTotalLibros(int p_cedula) Calcular el costo total de los libros
     * del autor cuya cédula llega como parámetro.
     */
    public int calcularCostoTotalLibros(int p_cedula) {
        int total = 0;
        for (Autor autor : ControllerAutor.listaAutores) {
            if (autor.getCedula() == p_cedula) {
                for (Libro libro : autor.getLibrosEscritos()) {
                    total += libro.getCosto();
                }
                return total;
            }
        }
        return total;
    }

    // buscarAutor(int p_cedula) Buscar y retornar el autor cuya cédula llega como
    // parámetro
    public static Autor buscarAutor(int p_cedula) {
        for (Autor autor : ControllerAutor.listaAutores) {
            if (autor.getCedula() == p_cedula) {
                return autor;
            }
        }
        return null;
    }

    // Constructor
    public ControllerAutor() {
        ControllerAutor.listaAutores = new TreeSet<Autor>();
    }
}
