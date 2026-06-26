Sistema de Gestión de Juegos Olímpicos

El presente sistema consiste en el desarrollo de un Sistema de Gestión de Juegos Olímpicos utilizando el lenguaje Java y aplicando los principios fundamentales de la Programación Orientada a Objetos. El objetivo principal del sistema es permitir la administración de todos los elementos involucrados en la organización y desarrollo de una edición de los Juegos Olímpicos, incluyendo países participantes, delegaciones, atletas, entrenadores, deportes, disciplinas, competencias, inscripciones, resultados, medallas y récords.
La aplicación fue desarrollada con una interfaz de usuario por consola, organizada mediante un menú principal y distintos submenús especializados. Esta estructura permite separar las responsabilidades del sistema y facilita la navegación del usuario. Desde el menú principal es posible acceder a los módulos de Gestión Organizativa, Gestión Deportiva, Gestión de Participación, Gestión de Resultados y Consultas del Sistema.
La clase central del sistema es JuegoOlimpico, encargada de representar una edición específica de los Juegos Olímpicos. Esta clase administra la información relacionada con las delegaciones participantes, los deportes, las competencias y las instalaciones utilizadas durante el evento. A partir de ella se organiza toda la información necesaria para el funcionamiento general del sistema.
Dentro del módulo organizativo se gestionan:
-Países
-Delegaciones
Cada delegación representa a una nación participante y contiene los atletas y entrenadores asociados. Para ello se implementaron las clases Pais, Delegacion, Atleta y Entrenador.
El módulo deportivo permite registrar:
-Deportes
-Disciplinas
-Competencias
-Instalaciones
La clase Deporte representa una categoría deportiva general, mientras que la clase Disciplina permite especificar modalidades particulares dentro de un deporte. Las competencias representan las pruebas concretas en las que participan los atletas y se desarrollan dentro de una determinada disciplina.
Las instalaciones representan los espacios físicos donde se realizan las distintas competencias.
El módulo de participación permite generar:
-Inscripción de atletas a competencias
-Verificación de la inscripción
Las competencias son las diferentes instancias que posee cada deporte, como por ejemplo: final, clasificacion, entre otros y la inscipción se encarga de ser el nexo entre competencia y atletas para que los mismos puedan participar deportivamente.
Módulo de gestión de resultados nos permite: 
-Registrar resultados y marcas de los atletas
-Determinar rankings
-Otorgar medallas 
-Actualizar y asignar récords
Las clases involucradas son: Resultado, que engloba la información de las marcas individuales de cada atleta, Ranking, que nos permite ordenar los resultados de mayor a menor para informar cuál fue el mejor participante, Medalla nos permite reconocer a los atletas que poseen los mejores desempeños y, por último Record que, en el caso que sea necesario anota un nuevo récord.
Módulo consultas del sistema engloba:
-Medallero
-Competencias
-Resultados
-Records
Donde el medallero hace referencia al medallero por país por ende tiene la participación de las clases Pais y Medalla, con respecto a la competencia la clase permite ubicar las competencias por deporte. Disciplina es similar a competencia pero en este caso nos permite identificar las competencias vinculadas a disciplinas y record registra los casos que logran superar records.
Además se suma una opción extra denominada "Gestión Antidopong" que, con la participación de las clases Antidoping y Laboratorio nos permite verificar que atletas dan positivo en antidoping y cuáles no, de ser positivo el dopaje se le requitarán las medallas obtenidas.

Se agrega que se implementa polimorfismo al generar una clase Marca con clases subhijas que implementan de diversa manera el método definido y se implementan recorridos de listas con Iterator, uso de excepciones y de enum cuando se condero necesario.
En este proyecto se trabajo inicialmente con un menú por consulta para pasar luego a una interfaz gráfica de usuario (GUI) usando Java Swing. Se crearon clases para cada opción presente en el anterior menú. Cada una se denominó Ventana + nombre. 

Se hacen algunas correcciones con respecto a lo presentado en el diagrama UML, estas se detallan a continuación:
-Se quitan las clases Clasificacion y Final que eran clases hijas de Competencia porque se considero que no es necesario establecerlas, ya que al utilizar Java Swing se puede ingresar el tipo de competencia requerida.
- Se agregan y eliminan métodos en la clase juegos olimpicos, como por ejemplo eliminarPais() ya que al utilizar Java Swing se considera más intuitivo para el usuario agregar botones.
- Se agregan las opciones para archivo y ayuda con el objetivo de hacer el sistema lo más real posible.

El sistema desarrollado permite gestionar de manera integral los principales procesos involucrados en la organización y desarrollo de unos Juegos Olímpicos. La solución implementada aprovecha los principios de la Programación Orientada a Objetos para lograr un diseño modular, extensible y alineado con los requisitos planteados en la consigna.
