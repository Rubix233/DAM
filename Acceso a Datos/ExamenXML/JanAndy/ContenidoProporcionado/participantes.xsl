<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
	<xsl:apply-templates />
</html>
</xsl:template>

<xsl:template match="participantes">
	<head>
		<title>HOJA DE EVALUACIÓN</title>
	</head>
	<body>
		<h1>LISTA DE PARTICIPANTES</h1>
		<table border="1">
			<tr align="center">
				<th>Nombre</th>
				<th>Total Pruebas</th>
				<th>Puntuación Media</th>
			</tr>
			<xsl:apply-templates select='participante'/>
		</table>
	</body>
</xsl:template>
<xsl:template match="participante">
	<tr align="center"><xsl:apply-templates /></tr>
</xsl:template>	
<xsl:template match="nombre|totalPruebas|puntuacionMedia">
	<td><xsl:apply-templates /></td>
</xsl:template>
</xsl:stylesheet>	