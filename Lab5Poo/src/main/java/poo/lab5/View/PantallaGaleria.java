package poo.lab5.View;

import poo.lab5.Model.*;
import poo.lab5.Controller.*;

public class PantallaGaleria {
    private ControllerLibro controlLibro;
    private ControllerAutor controlAutor;

    public PantallaGaleria() {
        this.controlAutor = new ControllerAutor();
        this.controlLibro = new ControllerLibro();
    }

    public static void main(String args[]) {
        Autor autores[] = new Autor[3];
        autores[0] = new Autor("Nicolas Bayona", 1000000);
        autores[1] = new Autor("Sebastian Herrera", 2000000);
        Libro libro1[] = new Libro[3];
        libro1[0] = new Libro("Doña barbara", "4EFG", 25000);
        libro1[1] = new Libro("Siempre a tu lado", "4RSG", 50000);
        autores[0].setEstado("ACTIVO");
        ControllerAutor.agregarAutor(autores[0]);
        ControllerAutor.agregarAutor(autores[1]);
        ControllerLibro.agregarLibro(libro1[0]);
        ControllerAutor.agregarLibroAAutor(libro1[0], autores[0]);
        ControllerLibro.agregarLibro(libro1[1]);
        System.out.println(ControllerLibro.getLibros());
        /*ControllerAutor.agregarLibroAAutor(libro1[1], autores[0]);
        System.out.print("Buscando \"4RSG\"" + '\n' + "Este se llama: ");
        Libro aux;
        aux = ControllerLibro.buscarLibro(libro1[1].getIsbn());
        System.out.println(aux.getNombre());
         * for (Autor autor : ControllerAutor.getListaAutores()) {
         * 
         * System.out.println("Autor: "+autor+
         * "Total de costo de sus libros: "+ControllerAutor.calcularCostoTotalLibros(
         * autor.getCedula())); System.out.println(); for (Libro lib :
         * autor.getLibrosEscritos()) {
         * System.out.println("Libro: "+lib.getNombre()+'-'+lib.getAutor().getNombre());
         * 
         * } System.out.println();
         * 
         * }
         */
    }
}
