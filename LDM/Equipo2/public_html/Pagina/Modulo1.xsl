<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Modulo1.xsl
    Created on : May 14, 2025, 9:38 PM
    Author     : Rubix
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Modulo 1</title>
                <link rel="stylesheet" type="text/css" href="../HojaEstilos.css"/>
                <link rel="stylesheet" type="text/css" href="ModulosStyle.css"/> 
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" />
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
            </head>
            <body>
                <xsl:variable name="codigo" select="0647" />
                <div class="Header">
                    <div class="Titulos">
                        
                        <img src="../../Imagenes/logo-cfp.png" alt=""/>
                    </div>
                    
                    <xsl:for-each select = "//Familia_Profesional">
                        
                        <div class="FamiliasBanner">
                            <p>
                                <xsl:value-of select ="@nombre"/>
                            </p>
                            
                        </div>
                    </xsl:for-each>
                    
                    
                </div>
                <div class="PostHeader1">
                    <p class="TextoBanner">Oferta academica</p>
                </div>
                <div class="PostHeader2">
                    <p class="TextoBanner">Centro FP Superior -- Ciclos Grado Superior</p>
                </div>
                <div class="PostHeader3">
                    <p class="TextoBanner">
                        <xsl:value-of select="//Familia_Profesional[1]/Titulo/Modulos/Modulo[@cod = $codigo]/@nombre"/>
                    </p>
                </div>
                
                
                <div class="page-wrapper">
                    <!-- Lado izquierdo vacío -->
                    <div class="left-panel">
                        <!-- vacío a propósito para mantener alineación -->
                    </div>

                    <!-- Lado derecho con acordeón "Objetivos" -->
                    <div class="right-panel">
                        <div class="accordion-wrapper">
                            <div class="accordion" id="objetivosAcordeon">
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="objetivosHeader">
                                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#objetivosCollapse" aria-expanded="false" aria-controls="objetivosCollapse">
                                            Contenidos Basicos
                                        </button>
                                    </h2>
                                    <div id="objetivosCollapse" class="accordion-collapse collapse" data-bs-parent="#objetivosAcordeon">
                                        <div class="accordion-body">
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed feugiat quam et nisi blandit, non consequat turpis tempus.
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="page-wrapper">
                    <!-- Lado izquierdo vacío -->
                    <div class="left-panel">
                        <!-- vacío a propósito para mantener alineación -->
                    </div>

                    <!-- Lado derecho con acordeón "Objetivos generales" -->
                    <div class="right-panel">
                        <div class="accordion-wrapper">
                            <div class="accordion" id="objetivosAcordeon2">
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="objetivosHeader2">
                                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#objetivosCollapse2" aria-expanded="false" aria-controls="objetivosCollapse2">
                                            Objetivos generales
                                        </button>
                                    </h2>
                                    <div id="objetivosCollapse2" class="accordion-collapse collapse" data-bs-parent="#objetivosAcordeon2">
                                        <div class="accordion-body">
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed feugiat quam et nisi blandit, non consequat turpis tempus.
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                
                
                
                <div class="page-wrapper">
                    <!-- Panel izquierdo -->
                    <div class="left-panel">
                        <div class="titulo-ra">Resultados de aprendizaje</div>
                    </div>

                    <!-- Panel derecho -->
                    <div class="right-panel">
                        <div class="accordion-wrapper">
                            
                            <xsl:for-each select="//Familia_Profesional[1]/Titulo/Modulos/Modulo[@cod = $codigo]/Resultados_de_Aprendizaje/Resultado_de_Aprendizaje">
                                <xsl:variable name="idNum" select="position()" />
                                <div class="accordion" id="ra1{$idNum}">
                                    <div class="accordion-item">
                                        <h2 class="accordion-header" id="RA{$idNum}">
                                            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse{$idNum}" aria-expanded="false" aria-controls="collapse{$idNum}">
                                                <xsl:value-of select="@nombre"/>
                                            </button>
                                        </h2>
                                        <div id="collapse{$idNum}" class="accordion-collapse collapse" data-bs-parent="#ra1{$idNum}">
                                            <div class="accordion-body">
                                                <ul>
                                                    <xsl:for-each select="Criterios_de_Evaluacion/Criterio_de_Evaluacion">
                                                        <li>
                                                            <xsl:value-of select="@nombre"/>
                                                        </li>
                                                    </xsl:for-each>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </xsl:for-each>
                        </div>
                    </div>
                </div>
                
                
                
                
                
                
                
                <div class = "Footer">
                    <div class = "FooterSec">
                        <div class = "FooterLogo">
                            <img src="../../Imagenes/logoCampusCamara.png" alt = "" />
                        </div>
                        <div class = "FooterRedes">
                            <img src="../../Imagenes/medios-de-comunicacion-social.png" alt = "" />
                            <img src="../../Imagenes/icons8-instagram-50.png" alt = "" />
                            <img src="../../Imagenes/logo-de-facebook.png" alt = "" />
                            <img src="../../Imagenes/icons8-youtube-50.png" alt = "" />
                        </div>
                    </div>
                    <div class = "FooterSec">
                        
                    </div>
                    <div class = "FooterSec">
                        <div class = "Correo">
                            <img src="../../Imagenes/correo-electronico.png" alt = "" />
                            <p>info@fpcampuscamara.es</p>
                        </div>
                        <div class = "Telefono">
                            <img src="../../Imagenes/llamada.png" alt = "" />
                            <p>954238797</p>
                        </div>
                    </div>
                    
                </div>   
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
