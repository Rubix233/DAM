@echo off
SETLOCAL ENABLEDELAYEDEXPANSION

REM Contar cuántos parámetros se han pasado
SET contador=0
FOR %%A IN (%*) DO SET /A contador+=1

REM Verificar que solo hay un parámetro
IF %contador% NEQ 1 (
    ECHO Error: Debes proporcionar exactamente un parametro.
    EXIT /B
)

REM Verificar que el parámetro es una sola letra
ECHO %1| FINDSTR /R "^[a-zA-Z]$" >NUL
IF ERRORLEVEL 1 (
    ECHO Error: El parametro debe ser una sola letra.
    EXIT /B
)

REM Convertir la letra a minúscula para la comparacion
REM Usamos comillas para declarar variables que pueden contener espacios o caracteres raros para evitar errores de sintaxis
SET "letra=%1"
FOR %%A IN (a b c d e f g h i j k l m n o p q r s t u v w x y z) DO (
    IF /I "%letra%"=="%%A" SET letra=%%A
)

REM Lista de meses
SET "meses=enero febrero marzo abril mayo junio julio agosto septiembre octubre noviembre diciembre"

REM Variable para indicar si se encontró al menos un mes. Usamos valor numerico por falta de booleanos.
SET encontrado=0

ECHO ...........................................
ECHO Buscando meses que terminan en "%letra%"...
ECHO ...........................................

FOR %%M IN (%meses%) DO (
    SET "ultimo=%%M"
    SET "ultimo=!ultimo:~-1!"
	REM Aqui hace uso del delayed expansion para extraer el caracter del ultimo puesto de %ultimo%
    IF "!ultimo!"=="%letra%" (
        ECHO %%M
        SET encontrado=1
    )
)

REM Si no se encontró ningún mes, mostrar mensaje
IF %encontrado%==0 (
    ECHO Ningun mes termina en la letra "%letra%".
)

ENDLOCAL
EXIT /B