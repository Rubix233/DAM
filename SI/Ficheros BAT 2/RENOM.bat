@echo off
SETLOCAL ENABLEDELAYEDEXPANSION

REM Contador de parámetros
SET contador=0
FOR %%A IN (%*) DO SET /A contador+=1

REM Verificar que hay exactamente dos parámetros
IF %contador% NEQ 2 (
    ECHO NUMERO ERRONEO DE PARAMETROS
    EXIT /B
)
REM ~ limpiar el parametro de comillas
SET "fichero_actual=%~1"
SET "nuevo_nombre=%~2"

REM Verificar que el primer parámetro es un archivo existente
IF NOT EXIST "%fichero_actual%" (
    ECHO EL FICHERO A RENOMBRAR NO EXISTE
    EXIT /B
)

REM Verificar que el segundo parámetro no existe ya como archivo
IF EXIST "%nuevo_nombre%" (
    ECHO YA EXISTE UN FICHERO CON ESE NOMBRE
    EXIT /B
)

REM Renombrar el archivo
REN "%fichero_actual%" "%nuevo_nombre%"
ECHO FICHERO RENOMBRADO CON EXITO

ENDLOCAL
EXIT /B