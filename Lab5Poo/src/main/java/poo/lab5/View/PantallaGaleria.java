package poo.lab5.View;

import poo.lab5.Controller.*;
import poo.lab5.Model.*;

public class PantallaGaleria {
    private ControllerLibro controlLibro;
    private ControllerAutor controlAutor;

    public PantallaGaleria() {
        this.controlAutor = new ControllerAutor();
        this.controlLibro = new ControllerLibro();
    }

    public static void main(String args[]) {
        // PantallaGaleria galeria = new PantallaGaleria();
        Autor autores[] = new Autor[3];
        autores[0] = new Autor("Nicolas Bayona", 1000000);
        autores[1] = new Autor("Sebastian Herrera", 2000000);
        Libro libro1[] = new Libro[4];
        libro1[0] = new Libro("Doña barbara", "4EFG", 25000);
        libro1[1] = new Libro("Siempre a tu lado", "4RSG", 50000);
        libro1[2] = new Libro("Laia", "544F", 75000);
        libro1[3] = new Libro("Inferno", "7JIO", 25000);
        //autores[0].setEstado("ACTIVO");
        ControllerAutor.agregarAutor(autores[0]);
        autores[0].setEstado("ACTIVO");
        autores[1].setEstado("ACTIVO");
        ControllerAutor.agregarAutor(autores[1]);
        ControllerLibro.agregarLibro(libro1[0]);
        ControllerAutor.agregarLibroAAutor(libro1[0], autores[0]);
        ControllerLibro.agregarLibro(libro1[1]);
        ControllerAutor.agregarLibroAAutor(libro1[1], autores[0]);
        ControllerLibro.asignarAutorALibro(libro1[2], autores[1]);
        System.out.print("Buscando \"4RSG\"" + '\n' + "Este se llama: ");
        Libro aux = ControllerLibro.buscarLibro(libro1[1].getIsbn());
        System.out.println(aux.getNombre());
        //ControllerLibro.agregarLibro(libro1[2]);
        ControllerLibro.agregarLibro(libro1[3], autores[1]);
        for (Autor autor : ControllerAutor.getListaAutores()) {
            System.out.println("Autor: "+autor+"Total de costo de sus libros: "+ControllerAutor.calcularCostoTotalLibros(autor.getCedula())); System.out.println(); 
            for (Libro lib :autor.getLibrosEscritos()) {
                System.out.println("Libro: "+lib.getNombre()+':'+lib.getAutor().getNombre());
            } 
            System.out.println();
        }
    }
}
/**
 * Task Controlador Libro AgregarLibro(Libro lib) -> CHECK 
 * AgregarLibro(Libro lib, Autor aut): -> CHECK
 * AsignarAutorALibro(Libro lib, Autor a)-> No
 * BuscarLibro(String  _isbn) -> CHECK
 * CalcularCostoTotalLibros(): -> Check
 */
