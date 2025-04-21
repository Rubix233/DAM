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
                        <!-->no se ve la imagen <-->
                            <img src="../Imagenes/logo-cfp.png" alt=""/>
                    </div>
                    
                    <xsl:for-each select = "//Familia_Profesional/Titulo">
                        <!-->no funciona css <-->
                        <div class="Titulos">
                            <xsl:value-of select ="@nombre"/>
                        </div>
                    </xsl:for-each>
                </div>

            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>