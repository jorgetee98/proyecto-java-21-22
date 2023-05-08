# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  21/22)
Autor/a: --------   uvus: ------

Descripción sobre el Proyecto de Java.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes:
  * **fp.police**: Paquete que contiene los tipos del proyecto. (USPolice, Contenedor_USPolice y Factoria_USPolice)
  * **fp.police.test**: Paquete que contiene las clases de test del proyecto. (test_USPolice, Factoria_Test y Contenedor_Test)
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto. (Genero)
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. (Checkers y Ficheros)
* **/data**: Contiene el dataset del proyecto.
    * **\<dataset1.csv\>**: Dataset que trata sobre personas asesinadas por policias en E.E.U.U.
    
## Estructura del *dataset*

URL del dataset original: 

El dataset está compuesto por 9 columnas, con la siguiente descripción:

* **NOMBRE**: de tipo String, representa el nombre de la persona asesinada por el policía.
* **FECHA**: de tipo LocalDate, representa la fecha del asesinato policial.
* **FORMA**: de tipo String, representa la forma en la que el policía mató al individuo.
* **ARMADO**: de tipo String, representa el arma que portaba el asesinado en el momento del crimen.
* **EDAD**: de tipo Integer, representa representa la edad de la persona asesinada.
* **ESTADO**: de tipo String, representa en el que ocurrio el incidente.
* **GENERO**: de tipo Enumerate, representa el género de la persona asesinada (MALE o FEMALE).
* **ENFERMEDAD MENTAL**: de tipo Boolean, representa con un "true" si tenía una enfermedad mental y con "false" si no tenía ninguna enfermedad mental.
* **RANGO DE POBREZA**: de tipo Double, representa el reango de pobreza de la persona asesianda por el policía.

## Tipos implementados
null.

### Tipo Base
El tipo base del proyecto, es el tipo USPolice. Este esta formado por las características que aparecen en el dataset. Estas características, mejor conocidades como propiedades del tipo, son las las siguientes:

**Propiedades**:

- NOMBRE, de tipo String, consultable y modificable.
- FECHA, de tipo LocalDate, consultable y modificable. 
- FORMA, de tipo String, consultable y modificable.
- ARMADO, de tipo String, consultable y modificable. 
- EDAD, de tipo Integer, consultable y modificable. 
- GENERO, de tipo Genero, consultable y modificable. 
- ESTADO, de tipo String, consultable y modificable. 
- ENFERMEDAD MENTAL, de tipo Boolean, consultable y modificable.
- RANGO DE POBREZA, de tipo Double, consultable y modificable.


**Constructores**: 
//ENTREGA 1
- C1: Constructor de un tipo base.
- C2: Constructor con solo algunas de las propiedades del tipo base.
//ENTREGA 2
- C3: Constructor de un tipo List, vacio.
- C4: Construcor de un tipo List.
//ENTREGA 3
Constructor indicado para trabajar correctamente con streams.

**Restricciones**:
 
- R1: La edad de el asesinado no puede ser menor o igual que 0.
- R2: El nombre de un asesinado no puede empexar por un número.
(En el caso de que no se cumplan los requisitos, lanza una excepcion)

**Criterio de igualdad**:
Criterio de igualdad generado automaticamente por el IDE.

**Criterio de ordenación**:
null.

**Otras operaciones**:
  //ENTREGA 2
-	leerUSPolices: Método encargado de leer el CSV (gracias al método paresearUspolices) y saltarse la primera linea (que es el encabezado)
- parsearUspolices: Método encargado de trocear cada línea del CSV y indentificar cada trozo como una propiedad del tipo USPolice.
- ExisteUSPolice: Método que devuelve true/false si el tipo USPolice dado como parametro existe en el CSV.
- MediaEdadesUspolice: Método encargado de calcular la media de edades de todas las personas asesinadas.
- ElementsFilter: Método encargado de devolver una lista solo con los elementos que contengan el estado dado como parametro.
- EdadesPorEstado: Método encargado de devolver un diccionario que tiene como clave, un estado, y como valor, un conjunto con todas las edades que coinciden con ese estado.
- AcumuladorPorEdades: Método encargado de devolver un diccionario que tiene como clave, la edad, y como valor, las veces que se repite en el CSV esa edad.

#### Tipos auxiliares
//ENTREGA 3
Funcion auxiliar para completar la funcion del método 14. Esta función crea una lista de n elementos segun edades, para mas tarde usarla y obtener las menores.

//ENTREGA 2
### Factoría
Clase encargada de leer el CSV y procesarlo para poder usarlo con facilidad en el proyecto.

-	leerUSPolices: Método encargado de leer el CSV (gracias al método paresearUspolices) y saltarse la primera linea (que es el encabezado)
- parsearUspolices: Método encargado de trocear cada línea del CSV y indentificar cada trozo como una propiedad del tipo USPolice.

### Tipo Contenedor

**Operaciones**:
 
- ExisteUSPolice: Método que devuelve true/false si el tipo USPolice dado como parametro existe en el CSV.
- MediaEdadesUspolice: Método encargado de calcular la media de edades de todas las personas asesinadas.
- ElementsFilter: Método encargado de devolver una lista solo con los elementos que contengan el estado dado como parametro.
- EdadesPorEstado: Método encargado de devolver un diccionario que tiene como clave, un estado, y como valor, un conjunto con todas las edades que coinciden con ese estado.
- AcumuladorPorEdades: Método encargado de devolver un diccionario que tiene como clave, la edad, y como valor, las veces que se repite en el CSV esa edad.

//ENTREGA 3 (funciones nuevas)
- ExisteStreamUSPolice: Comprueba si existe un tipo base , que contenga el estado dado por parametro.
- ContadorEdadesUSpolice: Actua a modo de contador, contando cuantas veces se repite las edades del csv.
- SeleccionConFiltradoUSpolice: Selecciona una conjunto filtrado con la edad dada por parametro.
- SeleccionMaximo: Selecciona el tipo base con la maxima edad de todo el csv.
- SeleccionConFiltradoUSpoliceOrd:  Selecciona una conjunto ordenado y filtrado con la edad dada por parametro.
- EdadesPorEstadoStream: Calcula las distintas edades de las personas que pertenecen a un estado.
- AcumuladorPorEdadesStreams: Acumula a modo de contador las veces que se repiten las edades en el csv.
- ObtenerMayorEdadPorEstado: Devuelve el tipo base que tenga mayor edad de cada estado.
- NAsesinatosSegunEstadosDeMenorEdad: Devuelve los n asesinates realizados a las personas de menor edad de cada estado.
- EdadMasRepetida: Devulve la clave con el valor mas mayor del map ( la edad mas repetida en este caso ).
