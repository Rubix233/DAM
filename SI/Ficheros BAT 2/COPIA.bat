@echo off

ECHO Verificando si existe el directorio ACTIND8
ECHO ...........................................

IF EXIST C:\ACTIND8 (
    ECHO El directorio ACTIND8 existe. Eliminándolo...
    RMDIR /S /Q C:\ACTIND8
    ECHO Directorio eliminado correctamente.
) ELSE (
    ECHO El directorio ACTIND8 no existe, no es necesario eliminarlo.
)

ECHO ..........................................
ECHO Creando la estructura de directorios
ECHO ..........................................

MKDIR C:\ACTIND8
MKDIR C:\ACTIND8\EJER1
MKDIR C:\ACTIND8\EJER2
MKDIR C:\ACTIND8\EJER3

ECHO Directorios creados correctamente.

ECHO ...............................................
ECHO Copiando archivos a sus respectivos directorios
ECHO ...............................................


COPY C:\ACTIVIDAD8\CUANTOS.BAT C:\ACTIND8\EJER1\EJ1.BAT
ECHO CUANTOS.BAT copiado y renombrado a EJ1.BAT en EJER1.


COPY C:\ACTIVIDAD8\CAMBIO.BAT C:\ACTIND8\EJER2\EJ2.BAT
ECHO CAMBIO.BAT copiado y renombrado a EJ2.BAT en EJER2.


COPY C:\ACTIVIDAD8\IGUALES.BAT C:\ACTIND8\EJER3\EJ3.BAT
ECHO IGUALES.BAT copiado y renombrado a EJ3.BAT en EJER3.


ECHO ...................
ECHO Proceso finalizado.
ECHO ...................

EXIT /B