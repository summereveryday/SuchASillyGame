@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  SummersSillyGame startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and SUMMERS_SILLY_GAME_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\SummersSillyGame-1.0-SNAPSHOT.jar;%APP_HOME%\lib\fxgl-0.5.4.jar;%APP_HOME%\lib\fxgl-base-0.5.4.jar;%APP_HOME%\lib\kotlinx-coroutines-core-0.23.4.jar;%APP_HOME%\lib\jackson-module-kotlin-2.9.0.jar;%APP_HOME%\lib\kotlin-reflect-1.1.3.jar;%APP_HOME%\lib\kotlin-stdlib-1.2.51.jar;%APP_HOME%\lib\jackson-databind-2.9.0.jar;%APP_HOME%\lib\httpclient-4.5.3.jar;%APP_HOME%\lib\charm-down-plugin-storage-desktop-3.7.0.jar;%APP_HOME%\lib\fxgl-plugin-audio-desktop-0.0.2.jar;%APP_HOME%\lib\fxgl-plugin-audio-0.0.2.jar;%APP_HOME%\lib\charm-down-plugin-storage-3.7.0.jar;%APP_HOME%\lib\charm-down-plugin-lifecycle-3.7.0.jar;%APP_HOME%\lib\kotlinx-coroutines-core-common-0.23.4.jar;%APP_HOME%\lib\atomicfu-common-0.10.3.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.2.51.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\jackson-annotations-2.9.0.jar;%APP_HOME%\lib\jackson-core-2.9.0.jar;%APP_HOME%\lib\httpcore-4.4.6.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-codec-1.9.jar;%APP_HOME%\lib\charm-down-core-3.7.0.jar

@rem Execute SummersSillyGame
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %SUMMERS_SILLY_GAME_OPTS%  -classpath "%CLASSPATH%" com.Summer.SillyGame.BasicGameApp %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable SUMMERS_SILLY_GAME_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%SUMMERS_SILLY_GAME_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega