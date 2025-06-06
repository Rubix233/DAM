<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>
    <xsl:param name="tutu"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>ciclo.xsl</title>
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
                    <p class="TextoBanner">GRADO SUPERIOR de <xsl:value-of select="//Familia_Profesional[1]/Titulo[1]/@nombre"/></p>
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
                                                Competencia general del ciclo
                                            </button>
                                        </h2>
                                        <div id="collapseComp" class="accordion-collapse collapse" data-bs-parent="#accordionCompetencias">
                                            <div class="accordion-body">
                                                La competencia general de este título consiste en organizar y ejecutar las operaciones de gestión y administración en los procesos comerciales, laborales, contables, fiscales y financieros de una empresa pública o privada, aplicando la normativa vigente y los protocolos de gestión de calidad, gestionando la información, asegurando la satisfacción del cliente y/o usuario, y actuando según las normas de prevención de riesgos laborales y protección medioambiental.
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
                                                Objetivos generales del ciclo
                                            </button>
                                        </h2>
                                        <div id="collapseObj" class="accordion-collapse collapse" data-bs-parent="#accordionObjetivos">
                                            <div class="accordion-body">
                                                <ol>
                                                    <li>Analizar y confeccionar los documentos o comunicaciones que se utilizan en la empresa, identificando su tipología y finalidad, para gestionarlos eficazmente.</li>
                                                    <li>Elaborar documentos y comunicaciones a partir de órdenes recibidas, información obtenida y/o necesidades detectadas, utilizando las herramientas informáticas adecuadas.</li>
                                                    <li>Clasificar, registrar y archivar comunicaciones y documentos según las técnicas apropiadas, garantizando su integridad y confidencialidad.</li>
                                                    <li>Gestionar los procesos de tramitación administrativa empresarial en relación a las áreas comercial, financiera, contable y fiscal, con una visión integradora de las mismas.</li>
                                                    <li>Realizar la gestión administrativa de los procesos comerciales, llevando a cabo las tareas de aprovisionamiento, almacenaje, distribución y financiación.</li>
                                                    <li>Realizar la gestión administrativa de las operaciones de compraventa y tesorería, aplicando la normativa mercantil y fiscal vigente.</li>
                                                    <li>Supervisar la gestión de tesorería, la captación de recursos financieros y el estudio de viabilidad de proyectos de inversión, siguiendo las normas y protocolos establecidos.</li>
                                                    <li>Aplicar procedimientos de gestión de calidad, prevención de riesgos laborales y protección ambiental en los procesos administrativos.</li>
                                                    <li>Utilizar y mantener aplicaciones informáticas de propósito general y específico para apoyar el desarrollo de las tareas administrativas y la toma de decisiones.</li>
                                                    <li>Atender a los clientes y usuarios, aplicando procedimientos establecidos y normas de calidad en la prestación del servicio.</li>
                                                    <li>Adaptarse a las nuevas situaciones laborales generadas como consecuencia de los cambios tecnológicos y organizativos en los procesos productivos.</li>
                                                    <li>Resolver problemas y tomar decisiones individuales siguiendo las normas y procedimientos establecidos, definidos dentro del ámbito de su competencia.</li>
                                                    <li>Aplicar técnicas de trabajo en equipo, liderando, coordinando y supervisando tareas, fomentando la colaboración y el respeto entre los miembros del grupo.</li>
                                                    <li>Gestionar su carrera profesional, analizando oportunidades de empleo, autoempleo y aprendizaje.</li>
                                                    <li>Crear y gestionar una pequeña empresa, realizando estudios de viabilidad, planificación y comercialización.</li>
                                                    <li>Participar de forma activa en la vida económica, social y cultural, con una actitud crítica y responsable.</li>
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
                            <div class="titulo-bloque">Modulos 1º</div>
                        </div>
                        <div class="right-panel">
                            <div class="accordion-wrapper">
                                <xsl:for-each select="//Familia_Profesional[1]/Titulo[1]/Modulos/Modulo[@curso = '1º']">
                                    <xsl:variable name="idNum" select="position()" />
    
                                    <div class="accordion" id="accordion1{$idNum}">
                                        <div class="accordion-item">
                                            <h2 class="accordion-header" id="heading1{$idNum}">
                                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse1{$idNum}" aria-expanded="false" aria-controls="collapse1{$idNum}">
                                                    <xsl:value-of select="@nombre"/>
                                                </button>
                                            </h2>
                                            <div id="collapse1{$idNum}" class="accordion-collapse collapse" data-bs-parent="#accordion1{$idNum}">
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
                    
                    
                    <div class="page-wrapper">
                        <div class="left-panel">
                            <div class="titulo-bloque">Modulos 2º</div>
                        </div>
                        <div class="right-panel">
                            <div class="accordion-wrapper">
                                <xsl:for-each select="//Familia_Profesional[1]/Titulo[1]/Modulos/Modulo[@curso = '2º']">
                                    <xsl:variable name="idNum" select="position()" />
    
                                    <div class="accordion" id="accordion2{$idNum}">
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
                                                    <div>
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
