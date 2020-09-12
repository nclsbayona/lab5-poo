package poo.lab5.View;
import poo.lab5.Model.*;
import poo.lab5.Controller.*;
public class PantallaGaleria 
{
    private ControllerLibro controlLibro=new ControllerLibro();
    private ControllerAutor controlAutor=new ControllerAutor();
    public static void main(String args[]) {
        PantallaGaleria Galeria = new PantallaGaleria();
        Autor autores[] = new Autor[3];
        autores[0]=new Autor("Nicolas Bayona", 1000000);
        autores[1]=new Autor("Sebastian Herrera", 1000000);
        Libro libro1 = new Libro("Doña barbara", "4EFG", 25000);
        autores[0].setEstado("ACTIVO");
        Galeria.controlAutor.agregarAutor(autores[0]);
        Galeria.controlAutor.agregarAutor(autores[1]);
        ControllerLibro.agregarLibro(libro1);
        Galeria.controlAutor.agregarLibroAAutor(libro1, autores[0]);
        for (Autor autor : ControllerAutor.getListaAutores())
        {
            System.out.println(autor);
        }
    }
}

