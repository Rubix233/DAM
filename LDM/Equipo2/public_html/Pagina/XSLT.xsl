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
                    <p class="TextoBanner">Oferta academica</p>
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
                                        <xsl:value-of select ="@nombre"/>
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
                                    <li>
                                        <xsl:value-of select ="@nombre"/>
                                    </li>
                                </xsl:for-each>
                            </ul>
                        </div>
                        </div>
                    </div>
                </div>
                

            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>