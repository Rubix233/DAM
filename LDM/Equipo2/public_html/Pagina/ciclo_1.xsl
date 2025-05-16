<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>
    <xsl:param name="tutu"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>ciclo_1.xsl</title>
                <link rel="stylesheet" type="text/css" href="HojaEstilos.css"/> 
                <link rel="stylesheet" type="text/css" href="./Modulos/ModulosStyle.css"/> 
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" />
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
            </head>
            <body>
                <div class="Header">
                    <div class="Titulos">
                        
                        <img src="../Imagenes/logo-cfp.png" alt=""/>
                    </div>
                    
                    <xsl:for-each select = "//Familia_Profesional">
                        
                        <div class="FamiliasBanner">
                            <p>
                                <xsl:value-of select ="@nombre"/>
                            </p>
                            
                        </div>
                    </xsl:for-each>
                    
                    
                </div>
                <div class="PostHeader2">
                    <p class="TextoBanner">CENTRO FP SUPERIOR DE LA CAMARA DE COMERCIO DE SEVILLA</p>
                </div>
                <div class="PostHeader1">
                    <p class="TextoBanner">MASTER en <xsl:value-of select="//Familia_Profesional[2]/Titulo[1]/@nombre"/></p>
                    <p class ="TextoBanner">-FP SUPERIOR CON TITULACION OFICIAL JUNTA DE ANDALUCIA-</p>
                </div>
                
                
                <div class = "CuerpoTitulo">
                    <div class="page-wrapper">
                        <div class="left-panel">
                            <div class="titulo-bloque">Competencias</div>
                        </div>
                        <div class="right-panel">
                            <div class="accordion-wrapper">
                                <div class="accordion" id="accordionCompetencias">
                                    <div class="accordion-item">
                                        <h2 class="accordion-header">
                                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseComp" aria-expanded="false" aria-controls="collapseComp">
                                                Competencia general del master
                                            </button>
                                        </h2>
                                        <div id="collapseComp" class="accordion-collapse collapse" data-bs-parent="#accordionCompetencias">
                                            <div class="accordion-body">
                                               La competencia general de este curso de especialización consiste en diseñar, desarrollar e implementar soluciones basadas en inteligencia artificial y análisis de grandes volúmenes de datos (Big Data), utilizando técnicas avanzadas de aprendizaje automático, procesamiento de datos y algoritmos inteligentes, para resolver problemas complejos en entornos empresariales y tecnológicos, garantizando la ética, la seguridad y la optimización de recursos.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Objetivos -->
                    <div class="page-wrapper">
                        <div class="left-panel">
                            <div class="titulo-bloque">Objetivos</div>
                        </div>
                        <div class="right-panel">
                            <div class="accordion-wrapper">
                                <div class="accordion" id="accordionObjetivos">
                                    <div class="accordion-item">
                                        <h2 class="accordion-header">
                                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseObj" aria-expanded="false" aria-controls="collapseObj">
                                                Objetivos generales del master
                                            </button>
                                        </h2>
                                        <div id="collapseObj" class="accordion-collapse collapse" data-bs-parent="#accordionObjetivos">
                                            <div class="accordion-body">
                                                <ol>
  <li>Comprender los fundamentos teóricos y prácticos de la inteligencia artificial y el Big Data.</li>
  <li>Aplicar técnicas avanzadas de aprendizaje automático para el análisis y modelado de datos.</li>
  <li>Desarrollar y programar sistemas inteligentes que automatizan procesos complejos.</li>
  <li>Gestionar grandes volúmenes de datos utilizando herramientas y ecosistemas Big Data.</li>
  <li>Interpretar y visualizar resultados para facilitar la toma de decisiones basadas en datos.</li>
  <li>Implementar soluciones escalables y eficientes en entornos distribuidos.</li>
  <li>Garantizar la seguridad, privacidad y ética en el tratamiento de datos y algoritmos de IA.</li>
  <li>Adaptarse a nuevas tecnologías y tendencias emergentes en inteligencia artificial y Big Data.</li>
</ol>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="page-wrapper">
                        <div class="left-panel">
                            <div class="titulo-bloque">Modulos</div>
                        </div>
                        <div class="right-panel">
                            <div class="accordion-wrapper">
                                <xsl:for-each select="//Familia_Profesional[2]/Titulo[1]/Modulos/Modulo">
                                    <xsl:variable name="idNum" select="position()" />
    
                                    <div class="accordion" id="accordion1{$idNum}">
                                        <div class="accordion-item">
                                            <h2 class="accordion-header" id="heading{$idNum}">
                                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse{$idNum}" aria-expanded="false" aria-controls="collapse{$idNum}">
                                                    <xsl:value-of select="@nombre"/>
                                                </button>
                                            </h2>
                                            <div id="collapse{$idNum}" class="accordion-collapse collapse" data-bs-parent="#accordion{$idNum}">
                                                <div class="accordion-body">
                                                    <div>
                                                        Horas anuales: <xsl:value-of select="@horas_anuales"/>
                                                    </div>
                                                    <div class="Info">
                                                        <a href="./Modulos/Modulo{@cod}.html">Más información</a>
                                                    </div>
                                                
                                                </div>
                                            
                                            </div>
                                        </div>
                                    </div>
                                </xsl:for-each>
                            </div>
                        </div>
                    </div>
                    
                    
                    

                    
                </div>
                
                
                
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
