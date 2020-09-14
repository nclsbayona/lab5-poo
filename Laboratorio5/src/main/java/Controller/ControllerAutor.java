package Controller;

import Model.*;
import java.util.TreeSet;

public class ControllerAutor {

    private static TreeSet<Autor> listaAutores = new TreeSet<Autor>();

    // Métodos
    // accesors de lista autores
    public static TreeSet<Autor> getListaAutores() {
        return ControllerAutor.listaAutores;
    }

    public static void setListaAutores(TreeSet<Autor> listaAutores_) {
        ControllerAutor.listaAutores = listaAutores_;
    }

    // Agregar Autor
    public static void agregarAutor(Autor aut) {
        if (ControllerAutor.buscarAutor(aut.getCedula()) == null) {
            ControllerAutor.listaAutores.add(aut);
        } else {
            System.out.println("No se agrego el Autor :" + aut.getNombre() + " CC: " + aut.getCedula() + " ya se encuentra esa cedula en nuestro sistema");
        }

    }

    // Agregar libro a autor
    public static boolean agregarLibroAAutor(Libro lib, Autor aut) {
        Autor autor;
        TreeSet<Libro> librosEscritos;
        autor = ControllerAutor.buscarAutor(aut.getCedula());
        if (autor != null && autor.getEstado().equals("ACTIVO")) {
            librosEscritos = autor.getLibrosEscritos();
            try {
                if (librosEscritos.contains(lib)) {
                    return false;
                } else {
                    if (ControllerLibro.getLibros().contains(lib)) {
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
     * calcularCostoTotalLibros(int p_cedula) Calcular el costo total de los
     * libros del autor cuya cédula llega como parámetro.
     */
    public static int calcularCostoTotalLibros(int p_cedula) {
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

    // Multi-libros a autor
    /*  public static void agregarAutores(Autor aut, Libro... libros) {
        for (Libro libro : libros) {
            ControllerAutor.agregarLibroAAutor(libro, aut);
            aut.agregarLibroEscrito(libro);
        }
    }
     */
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

}
