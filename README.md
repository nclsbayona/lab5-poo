## LABORATORIO 5 POO
Pontificia Universidad Javeriana

La entrega del laboratorio consistirá de 1 archivos zip, con el proyecto de maven. No incluya la carpeta target. Este archivo contendrá el código fuente del proyecto Java realizado por el estudiante. 

## ENUNCIADO
Para el siguiente diagrama UML

![UML](https://i.ibb.co/V2X5H1T/Screenshot-2020-09-14-154943.png)

1. Cree tres paquetes: view (clase PantallaLibreria), controller (para las clases ControllerLibro y ControllerAutor) y model (para las clases Libro y Autor).
2. Cree las clases y métodos mostrados en el siguiente diagrama de clases (no se muestran constructores ni accessors pero deben ser creados).

### Reglas de Negocio:

● Los posibles valores del estado del autor son ‘ACTIVO’, ‘INACTIVO’ 

### Observaciones de métodos de ControllerAutor:

1. agregarAutor(Autor aut): Agrega un nuevo autor
   1.1 No pueden existir dos autores con el mismo número de cédula
   1.2 Cuando se cree el autor cree la lista de libros vacía

2. agregarLibroAAutor(Libro lib, Autor aut): Agrega un Libro que debe existir a un Autor que ya existe
   2.1 Se debe buscar el autor que llega como parámetro.
   2.2 No se pueden agregar a un autor dos libros con el mismo isbn.
   2.3 Al autor se le debe vincular el libro que llega como parámetro.
   
   En la lista de ‘librosEscritos’ sólo se pueden asignar libros de la lista de ‘libros’.

3. calcularCostoTotalLibros(int p_cedula)
   ○ Calcular el costo total de los libros del autor cuya cédula llega como parámetro.

4. buscarAutor(int p_cedula)
   ○ Buscar y retornar el autor cuya cédula llega como parámetro.

### Observaciones de métodos de ControllerLibro:

1. agregarLibro(Libro lib): Agrega un libro nuevo sin Autor.
   1.1 No pueden existir dos libros con el mismo isbn
   
2. agregarLibro(Libro lib, Autor aut): Agrega un libro nuevo con un autor aut
   2.1 No pueden existir dos libros con el mismo isbn
   2.2 El autor debe existir en la lista de autores

3. asignarAutorALibro(Libro lib, Autor a): Asigna a un libro que debería existir a un autor que debe existir
   3.1 El autor debe existir en la lista de autores
   3.2 No se pueden asignar a los libros autores que tengan estado = ‘INACTIVO’

4. buscarLibro(String isbn): buscar y retorna un libro dado su isbn.
5. calcularCostoTotalLibros(): calcular el costo total de todos los libros existentes en el sistema.

### Relación Muchos a muchos

Modifique su aplicación para que un libro tenga muchos autores. Tenga en cuenta que:

1. Se deben hacer cambios en los atributos y accessors de las clases Libro y Autor
2. Los controladores deben incluir los métodos que permitan vincular un libro a un conjunto de autores y viceversa

### Adicionalmente se pide:

1. En el método main( ) de la pantalla usted debe crear los objetos y las llamadas necesarias que permitan probar cada uno de los métodos de los dos controladores.
2. Se deben probar en cada método todos los caminos (if..)
3. Sobrecargue el método toString( ) de las clases Libro y Autor, para imprimir por pantalla de forma personalizada la información de los objetos instancias de estas clases.

### Bono Adicional (+0.5 pts.) 😃  !!!

1. Modifique su aplicación para que realice la relación muchos a muchos entre libro y autor a través de una clase intermedia, como se explicó en clase.
2. Adicionalmente, sobrecargue el método equals() de las clases Libro y Autor para que se usen los datos de ISBN y cédula respectivamente como atributos que identifican a cada objeto y no se deben repetir. Con este cambio, los métodos agregar* pueden usar el método contains(…) de la colección para evitar repetidos
