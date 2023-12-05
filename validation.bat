@echo off

set JAR_PATH=target/sudoku-validator-0.0.1-SNAPSHOT.jar
set CSV_FILE=src\main\resources\%1

echo JAR_PATH: %JAR_PATH%
echo CSV_FILE: %CSV_FILE%

if "%1"=="" (
    echo Error: You need to pass the CSV file name.
    exit /b 2
)

java -jar "%JAR_PATH%" "%CSV_FILE%"

set JAVA_EXIT_CODE=%errorlevel%

if %JAVA_EXIT_CODE% equ 0 (
    echo true
) else (
    echo false
)

exit /b %JAVA_EXIT_CODE%
