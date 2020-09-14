package View;

import Controller.*;
import Model.*;

public class PantallaLibreria {
    private ControllerAutor controllerAutor;
    private ControllerLibro controllerLibro;

    public static void main(String args[]) {
        PantallaLibreria libreria = new PantallaLibreria();
        libreria.controllerLibro.setControllerAutor(libreria.controllerAutor);
        libreria.controllerAutor.setControllerLibro(libreria.controllerLibro);
        Autor aut = new Autor("Sebastian", 1000471976);
        Autor aut1 = new Autor("Rafael", 1000471976);
        Autor aut2 = new Autor("Lina", 1000500310);
        Autor aut3 = new Autor("Salome", 1000500311);
        Autor aut4 = new Autor("Thiago", 1000500312);
		Autor aut5 = new Autor("Kamila", 1001826288);
        libreria.controllerAutor.agregarAutor(aut);
        libreria.controllerAutor.agregarAutor(aut1);
        libreria.controllerAutor.agregarAutor(aut2);
        libreria.controllerAutor.agregarAutor(aut3);
        libreria.controllerAutor.agregarAutor(aut4);
		libreria.controllerAutor.agregarAutor(aut5);
        // Estado inactivo
        aut4.setEstado("INACTIVO");

        Libro libro1 = new Libro("Geek", "4ABC", 500);
        Libro libro2 = new Libro("Laia", "5FGH", 700);
        Libro libro3 = new Libro("Andrea", "2ACD", 200);
        Libro libro4 = new Libro("Lumia", "2XCC", 200);
        Libro libro5 = new Libro("Repetido", "2XCC", 200);
        Libro libro6 = new Libro("Nuevo", "DDEF", 200);
        Libro libro7 = new Libro("Libro no agregado", "IDDF", 200);
        Libro libro8 = new Libro("Multiples", "ABCD", 500);
		Libro libro9 = new Libro("MultipleLibro", "LAJS", 100);
        // Libro 7 no se agrega a la lista
        libreria.controllerLibro.asignarAutorALibro(libro7, aut);
        System.out.print("Agregando libro(NO ESTA EN LA LISTA) a autor desde el CONTROLLERAUTOR:"
                + libreria.controllerAutor.agregarLibroAAutor(libro7, aut));
        libreria.controllerLibro.agregarLibro(libro8);
		libreria.controllerLibro.agregarLibro(libro9);
        libreria.controllerLibro.agregarVariosAutoresAUnLibro(libro8, aut1, aut, aut3, aut4, aut2);
		libreria.controllerAutor.agregarVariosLibrosAUnAutor(aut5, libro9, libro8, libro7, libro6);
        libreria.controllerLibro.agregarLibro(libro1);
        libreria.controllerLibro.agregarLibro(libro2);
        libreria.controllerLibro.agregarLibro(libro3);
        libreria.controllerLibro.agregarLibro(libro4);
        // Autor único
        libreria.controllerAutor.agregarLibroAAutor(libro4, aut);
        libreria.controllerAutor.agregarLibroAAutor(libro2, aut4);
        // Multiples autores
        libreria.controllerAutor.agregarLibroAAutor(libro4, aut3);
        libreria.controllerAutor.agregarLibroAAutor(libro1, aut);
        libreria.controllerAutor.agregarLibroAAutor(libro1, aut2);
        System.out
                .println("\nLibro repetido a un autor : " + libreria.controllerAutor.agregarLibroAAutor(libro1, aut2));
        // Agregar libro repetido a una lista
        libreria.controllerLibro.agregarLibro(libro5);
        // Agregar libro con autor
        System.out.println("\nAgregar libro a un autor que no se encuentra en la lista :"
                + libreria.controllerLibro.agregarLibro(libro6, aut2));
        System.out.println("\nLista de autores\n");
        for (Autor autor : libreria.controllerAutor.getListaAutores()) {
            System.out.println(autor);
            System.out.println("Total " + libreria.controllerAutor.calcularCostoTotalLibros(autor.getCedula()) + "\n");
        }
        System.out.println("\nLista de libros, TAM: " + libreria.controllerLibro.getLibros().size() + "\n");
        for (Libro lib : libreria.controllerLibro.getLibros()) {
            System.out.println("\t" + lib);
        }
        System.out.println("\nTotal valor: " + libreria.controllerLibro.calcularCostoTotalLibros());
    }

    public PantallaLibreria() {
        this.controllerAutor = new ControllerAutor();
        this.controllerLibro = new ControllerLibro();
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
