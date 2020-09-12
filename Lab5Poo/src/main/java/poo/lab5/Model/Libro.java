package poo.lab5.Model;
public class Libro implements Comparable <Libro>
{
    private Autor autor;
    private String nombre;
    private String isbn;
    private int costo;
    @Override
    public int compareTo(Libro otro)
    {
        /*
            Devuelve 0 en caso de que ambos objetos tengan el mismo orden (no haya uno mayor que otro)
            Un número entero negativo si el objeto actual es menor al objeto pasado como parámetro
            Un número positivo si el objeto actual es mayor al objeto pasado como parámetro
        */ 
        return 0;
    }
}