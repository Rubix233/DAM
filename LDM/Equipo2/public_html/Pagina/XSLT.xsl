<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Listado de Familias Profesionales</title>
                <link rel="stylesheet" type="text/css" href="HojaEstilos.css"/> 
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
                <div class="PostHeader1">
                    <p class="TextoBanner">OFERTA ACADEMICA</p>
                </div>
                <div class="PostHeader2">
                    <p class="TextoBanner">Centro FP Superior -- Ciclos Grado Superior</p>
                </div>
                
                <div class="Cuerpo">
                    <div class = "Familias">
                        <div>
                        <div class = "FamiliasContainer" id="Fam1">
                            <h2>
                                <xsl:value-of select ="(//Familia_Profesional/@nombre)[1]"/>
                            </h2>
                            <p>
                                <xsl:value-of select ="(//Familia_Profesional/@descripcion)[1]"/>
                            </p>
                        </div>
                        <div class="FamiliasTitulos">  
                            <ul class="ListaAzul">
                                <xsl:for-each select = "//Familia_Profesional[1]/Titulo">   
                                    <li>
                                        <a>
                                            <xsl:attribute name="href">
                                                <xsl:text>ciclo0.html?titulo=</xsl:text>
                                                
                                            </xsl:attribute>
                                            <xsl:value-of select ="@nombre"/>
                                        </a>
                                        
                                    </li>
                                </xsl:for-each>
                            </ul>
                        </div>
                        </div>                        
                    </div>
                    <div class = "Familias">
                        <div>
                        <div class = "FamiliasContainer" id="Fam2">
                            
                            <h2>
                                <xsl:value-of select ="(//Familia_Profesional/@nombre)[2]"/>
                            </h2>
                            <p>
                                <xsl:value-of select ="(//Familia_Profesional/@descripcion)[2]"/>
                            </p>
                        </div>
                        <div class="FamiliasTitulos">
                            <ul class="ListaAzul">
                                <xsl:for-each select = "//Familia_Profesional[2]/Titulo">  
                                    <xsl:variable name="tituloPos" select="position()" /> 
                                    <li>
                                        <a>
                                            <xsl:attribute name="href">
                                                <xsl:text>ciclo</xsl:text>
                                                <xsl:value-of select="position()"/>
                                                <xsl:text>.html</xsl:text>
                                            </xsl:attribute>
                                            <xsl:value-of select ="@nombre"/>
                                        </a>
                                    </li>
                                </xsl:for-each>
                            </ul>
                        </div>
                        </div>
                    </div>
                </div>
                <div class = "Footer">
                    <div class = "FooterSec">
                        <div class = "FooterLogo">
                            <img src="../Imagenes/logoCampusCamara.png" alt = "" />
                        </div>
                        <div class = "FooterRedes">
                            <img src="../Imagenes/medios-de-comunicacion-social.png" alt = "" />
                            <img src="../Imagenes/icons8-instagram-50.png" alt = "" />
                            <img src="../Imagenes/logo-de-facebook.png" alt = "" />
                            <img src="../Imagenes/icons8-youtube-50.png" alt = "" />
                        </div>
                    </div>
                    <div class = "FooterSec">
                        
                    </div>
                    <div class = "FooterSec">
                        <div class = "Correo">
                            <img src="../Imagenes/correo-electronico.png" alt = "" />
                            <p>info@fpcampuscamara.es</p>
                        </div>
                        <div class = "Telefono">
                            <img src="../Imagenes/llamada.png" alt = "" />
                            <p>954238797</p>
                        </div>
                    </div>
                    
                </div>
                

            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>