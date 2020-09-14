package View;

import Controller.*;
import Model.*;

public class PantallaGaleria {

    public static void main(String args[]) {
        Autor aut = new Autor("Sebastian", 1000471976);
        Autor aut1 = new Autor("Rafael", 1000471976);
        Autor aut2 = new Autor("Lina", 1000500310);
        Autor aut3 = new Autor("Salome", 1000500311);
        Autor aut4 = new Autor("Thiago", 1000500312);

        ControllerAutor.agregarAutor(aut);
        ControllerAutor.agregarAutor(aut1);
        ControllerAutor.agregarAutor(aut2);
        ControllerAutor.agregarAutor(aut3);
        ControllerAutor.agregarAutor(aut4);

        Libro libro1 = new Libro("Geek", "4ABC", 500);
        Libro libro2 = new Libro("Laia", "5FGH", 700);
        Libro libro3 = new Libro("Andrea", "2ACD", 200);
        Libro libro4 = new Libro("Lumia", "2XCC", 200);
        Libro libro5 = new Libro("Repetido", "2XCC", 200);
        Libro libro6 = new Libro("Nuevo", "DDEF", 200);
        Libro libro7 = new Libro("Libro no agregado", "IDDF", 200);
        //Libro 7 no se agrega a la lista
       ControllerLibro.asignarAutorALibro(libro7, aut);
       System.out.print("Agregando libro(NO ESTA EN LA LISTA) a autor desde el CONTROLLERAUTOR:"+ControllerAutor.agregarLibroAAutor(libro7, aut));
        ControllerLibro.agregarLibro(libro1);
        ControllerLibro.agregarLibro(libro2);
        ControllerLibro.agregarLibro(libro3);
        ControllerLibro.agregarLibro(libro4);
        //Autor único
        ControllerAutor.agregarLibroAAutor(libro4, aut);

        //Estado inactivo
        aut4.setEstado("INACTIVO");
        ControllerAutor.agregarLibroAAutor(libro2, aut4);
        //Multiples autores
        ControllerAutor.agregarLibroAAutor(libro4, aut3);
        ControllerAutor.agregarLibroAAutor(libro1, aut);
        ControllerAutor.agregarLibroAAutor(libro1, aut2);
        System.out.println("\nLibro repetido a un autor : " + ControllerAutor.agregarLibroAAutor(libro1, aut2));
        //Agregar libro repetido a una lista
        ControllerLibro.agregarLibro(libro5);
        //Agregar libro con autor
        System.out.println("\nAgregar libro a un autor que no se encuentra en la lista :" + ControllerLibro.agregarLibro(libro6, aut2));
        System.out.println("\nLista de autores\n");
        for (Autor autor : ControllerAutor.getListaAutores()) {
            System.out.println(autor);
            System.out.println("Total " + Controller.ControllerAutor.calcularCostoTotalLibros(autor.getCedula()) + "\n");
        }
        System.out.println("\nLista de libros, TAM: " + ControllerLibro.getLibros().size() + "\n");
        for (Libro lib : ControllerLibro.getLibros()) {
            System.out.println("\t" + lib);
        }
        System.out.println("\nTotal valor: " + ControllerLibro.calcularCostoTotalLibros());
    }
}
/**
 * Tasks
 *
 * CONTROLADOR LIBRO AgregarLibro(Libro lib) -> CHECK AgregarLibro(Libro lib,
 * Autor aut): -> CHECK AsignarAutorALibro(Libro lib, Autor a)-> CHECK
 * BuscarLibro(String _isbn) -> CHECK CalcularCostoTotalLibros(): -> CHECK
 *
 *
 * CONTROLADOR AUTOR agregarAutor(Autor aut) -> Check agregarLibroAAutor(Libro
 * lib, Autor aut) -> Check calcularCostoTotalLibros(int p_cedula) -> Check
 * buscarAutor(int p_cedula): Buscar y retornar el autor cuya cédula llega como
 * parámetro -> Check.
 */
