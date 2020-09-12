package poo.lab5.Controller;

import poo.lab5.Model.Libro;
import poo.lab5.Model.Autor;
import java.util.TreeSet;

public class ControllerAutor {
    private static TreeSet<Autor> listaAutores;

    // Métodos
    // Agregar Autor
    public void agregarAutor(Autor aut) {
        for (Autor autor_ : ControllerAutor.listaAutores) {
            if (autor_.getCedula() == aut.getCedula()) {
                return;
            }
            aut.setLibrosEscritos(new TreeSet<>() );
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
}
