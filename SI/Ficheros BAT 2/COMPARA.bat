@echo off
SETLOCAL

SET NVARIABLES=0

FOR %%I IN (%*) DO (
	SET /A NVARIABLES+=1
)

IF %NVARIABLES% LSS 2 (
    ECHO Error: Debes proporcionar exactamente dos parámetros.
    EXIT /B
)
IF %NVARIABLES% GTR 2 (
    ECHO Error: Has proporcionado más de dos parámetros.
    EXIT /B
)

IF "%1"=="%2" (
    ECHO %1 es igual a %2
) ELSE IF %1 GTR %2 (
    ECHO %1 es mayor que %2
) ELSE (
    ECHO %1 es menor que %2
)

