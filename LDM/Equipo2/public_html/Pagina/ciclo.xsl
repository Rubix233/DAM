<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>
    <xsl:param name="tutu"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>ciclo.xsl</title>
                <link rel="stylesheet" type="text/css" href="HojaEstilos.css"/> 
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
                    <div class = "Competencias">
                        <div>
                            <p>competencias</p>
                        </div>
                        <div>
                            <div class="accordion" id="accordionCompetencias">
                                <div class="accordion-item">
                                    <h2 class="accordion-header">
                                        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                            Accordion Item #1
                                        </button>
                                    </h2>
                                    <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <strong>This is the first item’s accordion body.</strong> It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It’s also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class = "Competencias">
                        <div>
                            <p>Objetivos</p>
                        </div>
                        <div>
                            <div class="accordion" id="accordionObjetivos">
                                <div class="accordion-item">
                                    <h2 class="accordion-header">
                                        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                                            Accordion Item #1
                                        </button>
                                    </h2>
                                    <div id="collapseTwo" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <strong>This is the first item’s accordion body.</strong> It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It’s also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class = "Competencias">
                        <div>
                            <p>Modulos 1º</p>
                        </div>
                        <div>
                            
                            <xsl:for-each select="//Familia_Profesional[1]/Titulo[1]/Modulos/Modulo[@curso = '1º']">
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
                                                <div>
                                                    <a href="Modulo{$idNum}.html">Más información</a>
                                                </div>
                                                
                                            </div>
                                            
                                        </div>
                                    </div>
                                </div>
                            </xsl:for-each>
                            
                        </div>
                    </div>
                    <div class = "Competencias">
                        <div>
                            <p>Modulos 2º</p>
                        </div>
                        <div>
                            
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
                                                    Mas informacion
                                                </div>
                                                
                                            </div>
                                            
                                        </div>
                                    </div>
                                </div>
                            </xsl:for-each>
                            
                        </div>
                    </div>
                </div>
                
                
                
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
