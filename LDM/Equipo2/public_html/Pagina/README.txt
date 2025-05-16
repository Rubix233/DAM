README del Proyecto
Descripción
Este proyecto consiste en la creación de una página web utilizando XSLT para transformar un documento XML. El XML contiene información sobre módulos formativos, incluyendo sus objetivos y contenidos. La transformación se realiza mediante consultas XPath y generación de contenido HTML.



Tecnologías utilizadas
XML: Contiene los datos estructurados de los módulos.

XSLT + XPath: Se utiliza para transformar el XML en HTML y generar dinámicamente páginas individuales para cada módulo.

HTML + CSS: Para la estructura y el diseño visual.

Bootstrap: Se emplea para crear acordeones interactivos, posteriormente personalizados con CSS.



Estructura del proyecto
XML FINAL.xml: Archivo XML con toda lo necesario para generar el contenido por consultas. Ajustado para albergar contenido y objetivo de módulos. Ajustado el XSD para la validación del XML

XSLT.xsl: Hoja de transformación XSLT de pagina inicio.

Ciclo.xsl: Hojas de transformación XSLT de cada ciclo

Modulo1.xsl: Hoja de transformación XSLT que he reutilizado para generar cada pagina de modulo modificando la variable que contiene el código.

HojaEstilos.css: Estilos generales de la web.

ModulosStyle.css: Estilos específicos aplicados a los módulos.

index.html: Página principal generada.

cicloX.html: Páginas individuales de cada ciclo generadas con XSLT y uso de variable para el índice del ciclo.

ModuloX.html: Páginas individuales de cada módulo generadas con XSLT y uso de variable para el codigo del modulo.



Funcionalidades implementadas
Inclusión de los objetivos y contenidos de cada módulo en el XML.

Generación automática de páginas (ciclo0.html, ciclo1.html, etc.) mediante el uso de una variable XSLT que recoge la posición del módulo.

Uso de Bootstrap para implementar acordeones, los cuales han sido personalizados con CSS a medida.

División de estilos entre dos archivos CSS para una mejor organización.

Eliminación del cuadro de asignaturas necesarias, ya que no se ajustaba a los resultados de las consultas y no aplicaba en el caso de los másteres.

Lecciones aprendidas
Uso práctico de XSLT con XPath para transformar datos estructurados en contenido web.

Integración de tecnologías externas (Bootstrap) con estilos personalizados.

Adaptación del diseño a las limitaciones y estructura del XML original.

El valor de defender tu diseño cuando sabes que va a ser mejor a la larga.