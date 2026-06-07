# Validador de Contraseñas - Métricas de Calidad de Software

## 1. Descripción del Proyecto

Este proyecto fue desarrollado como parte de la actividad **Configuración Colaborativa de Proyecto y Presentación de Métricas de Calidad** de la materia de Calidad de Software.

El sistema implementa un validador de contraseñas en Java. Su objetivo es verificar si una contraseña cumple con criterios básicos de seguridad, tales como longitud mínima, uso de números, mayúsculas, caracteres especiales y ausencia de espacios.

Además de la funcionalidad principal, el proyecto incorpora herramientas de calidad para automatizar la revisión del código mediante Maven y GitHub Actions.

---

## 2. Objetivo de la Actividad

El objetivo principal de esta actividad es configurar un proyecto Java desde cero, integrar herramientas de análisis de calidad y automatizar su ejecución mediante GitHub Actions.

Las herramientas utilizadas son:

* **JUnit 5:** ejecución de pruebas unitarias.
* **JaCoCo:** medición de cobertura de código.
* **Checkstyle:** validación del estilo del código.
* **PMD:** análisis estático del código.
* **GitHub Actions:** automatización del proceso de construcción, pruebas y generación de métricas.

---

## 3. Tecnologías Utilizadas

| Herramienta    | Uso en el proyecto                  |
| -------------- | ----------------------------------- |
| Java 17        | Lenguaje de programación            |
| Maven          | Gestión del proyecto y dependencias |
| JUnit 5        | Pruebas unitarias                   |
| JaCoCo         | Cobertura de código                 |
| Checkstyle     | Validación de estilo                |
| PMD            | Análisis estático                   |
| Git            | Control de versiones                |
| GitHub         | Repositorio remoto                  |
| GitHub Actions | Integración continua                |

---

## 4. Estructura del Proyecto

```text
validador-contrasena/
│
├── .github/
│   └── workflows/
│       └── ci.yml
│
├── config/
│   ├── checkstyle/
│   │   └── checkstyle.xml
│   └── pmd/
│       └── pmd.xml
│
├── docs/
│   └── evidencias/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── dayana/
│   │               └── calidad/
│   │                   └── ValidadorContrasena.java
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── dayana/
│                   └── calidad/
│                       └── ValidadorContrasenaTest.java
│
├── .gitignore
├── pom.xml
└── README.md
```

---

## 5. Funcionalidad Implementada

La clase principal del proyecto es:

```text
ValidadorContrasena.java
```

Esta clase valida una contraseña con las siguientes reglas:

1. Debe tener al menos 8 caracteres.
2. Debe contener al menos un número.
3. Debe contener al menos una letra mayúscula.
4. Debe contener al menos un carácter especial.
5. No debe contener espacios.

Métodos principales implementados:

```java
esLongitudValida(String contrasena)
contieneNumero(String contrasena)
contieneMayuscula(String contrasena)
contieneCaracterEspecial(String contrasena)
contieneEspacios(String contrasena)
tieneEspaciosDuplicados(String contrasena)
esValida(String contrasena)
```

---

## 6. Pruebas Unitarias

Las pruebas unitarias se encuentran en:

```text
src/test/java/com/dayana/calidad/ValidadorContrasenaTest.java
```

Se implementaron pruebas para validar diferentes escenarios:

| Caso de prueba                     | Resultado esperado |
| ---------------------------------- | ------------------ |
| Contraseña válida                  | Aceptada           |
| Contraseña nula                    | Rechazada          |
| Contraseña corta                   | Rechazada          |
| Contraseña sin número              | Rechazada          |
| Contraseña sin mayúscula           | Rechazada          |
| Contraseña sin carácter especial   | Rechazada          |
| Contraseña con espacio             | Rechazada          |
| Contraseña con espacios duplicados | Detectada          |
| Contraseña sin espacios duplicados | No detectada       |

Para ejecutar las pruebas:

```bash
mvn test
```

Resultado final obtenido:

```text
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
```

---

## 7. Configuración de Maven

El archivo `pom.xml` fue configurado con los siguientes plugins:

| Plugin                    | Propósito                        |
| ------------------------- | -------------------------------- |
| `maven-compiler-plugin`   | Compilar el proyecto con Java 17 |
| `maven-surefire-plugin`   | Ejecutar pruebas unitarias       |
| `jacoco-maven-plugin`     | Generar reporte de cobertura     |
| `maven-checkstyle-plugin` | Validar estilo del código        |
| `maven-pmd-plugin`        | Ejecutar análisis estático       |

Comando principal para validar todo el proyecto:

```bash
mvn clean verify
```

Este comando ejecuta:

1. Limpieza del proyecto.
2. Compilación.
3. Pruebas unitarias.
4. Generación del archivo `.jar`.
5. Reporte de cobertura con JaCoCo.
6. Validación de estilo con Checkstyle.
7. Análisis estático con PMD.

---

## 8. Métricas de Cobertura con JaCoCo

JaCoCo genera los reportes de cobertura en:

```text
target/site/jacoco/
```

Archivos principales generados:

```text
target/site/jacoco/index.html
target/site/jacoco/jacoco.xml
target/site/jacoco/jacoco.csv
```

### Resultado inicial

En la primera versión del proyecto existían pocas pruebas unitarias, por lo que la cobertura era menor.

| Métrica                    | Resultado inicial |
| -------------------------- | ----------------: |
| Cobertura de instrucciones |              88 % |
| Cobertura de ramas         |              63 % |
| Líneas no cubiertas        |                 6 |
| Métodos cubiertos          |                 6 |

### Resultado final

Después de agregar más pruebas unitarias, la cobertura mejoró.

| Métrica                    | Resultado final |
| -------------------------- | --------------: |
| Cobertura de instrucciones |            95 % |
| Cobertura de ramas         |            87 % |
| Instrucciones no cubiertas |        6 de 142 |
| Ramas no cubiertas         |         5 de 40 |
| Líneas no cubiertas        |         3 de 27 |
| Métodos no cubiertos       |               0 |
| Clases cubiertas           |          1 de 1 |

### Interpretación

El reporte final de JaCoCo muestra una cobertura de instrucciones del **95 %** y una cobertura de ramas del **87 %**. Esto evidencia una mejora respecto a la versión inicial, donde la cobertura de instrucciones era del **88 %** y la cobertura de ramas era del **63 %**.

La mejora se logró agregando pruebas unitarias para casos que inicialmente no estaban cubiertos, como contraseñas cortas, contraseñas sin número, sin mayúscula, sin carácter especial, con espacios y con espacios duplicados.

Aún quedan algunas ramas sin cubrir, por lo que una mejora futura sería agregar pruebas adicionales para casos límite específicos.

---

## 9. Validación de Estilo con Checkstyle

Checkstyle fue configurado mediante el archivo:

```text
config/checkstyle/checkstyle.xml
```

El reporte XML se genera en:

```text
target/checkstyle-result.xml
```

### Problemas detectados

Durante la iteración del proyecto, Checkstyle detectó problemas de estilo, entre ellos:

* Métodos que no seguían la convención `camelCase`.
* Archivos Java sin línea final.
* Validación de formato e indentación.
* Verificación de espacios alrededor de operadores.
* Validación de nombres de variables, parámetros y métodos.

Ejemplo de problema detectado:

```text
File does not end with a newline. [NewlineAtEndOfFile]
```

### Correcciones realizadas

Se realizaron las siguientes correcciones:

* Se agregó una línea final en los archivos `.java`.
* Se corrigió el nombre de métodos para cumplir con `camelCase`.
* Se ajustó el formato del código para cumplir las reglas establecidas.
* Se verificó nuevamente el proyecto con `mvn clean verify`.

### Resultado final

El resultado final de Checkstyle fue:

```text
You have 0 Checkstyle violations.
```

---

## 10. Análisis Estático con PMD

PMD fue configurado mediante el archivo:

```text
config/pmd/pmd.xml
```

PMD permite detectar problemas estáticos relacionados con malas prácticas, código innecesario o posibles errores.

El reporte XML se genera en:

```text
target/pmd.xml
```

O, según la ejecución:

```text
target/site/pmd.xml
```

### Problemas detectados

Durante la iteración del proyecto se introdujeron problemas deliberados para comprobar el funcionamiento de PMD, como:

* Bloques `if` vacíos.
* Código innecesario.
* Reglas obsoletas o mal configuradas.
* Posibles malas prácticas en el código.

También se identificó un problema de configuración con una regla antigua:

```text
Unable to find referenced rule EmptyIfStmt
```

Este error se corrigió actualizando la regla a:

```xml
<rule ref="category/java/codestyle.xml/EmptyControlStatement"/>
```

### Correcciones realizadas

Se corrigieron los problemas detectados por PMD mediante:

* Eliminación de bloques vacíos.
* Reemplazo de condiciones innecesarias por retornos directos.
* Actualización de reglas PMD compatibles con la versión utilizada.
* Verificación final con Maven.

### Resultado final

Después de las correcciones, PMD se ejecutó correctamente dentro del comando:

```bash
mvn clean verify
```

---

## 11. GitHub Actions

El proyecto incluye un pipeline de integración continua configurado en:

```text
.github/workflows/ci.yml
```

El pipeline se ejecuta automáticamente cuando se realiza un `push` o un `pull request` hacia la rama `main`.

### Etapas del pipeline

| Etapa                       | Comando o acción             |
| --------------------------- | ---------------------------- |
| Descargar código fuente     | `actions/checkout@v4`        |
| Configurar Java 17          | `actions/setup-java@v4`      |
| Construir proyecto          | `mvn clean install`          |
| Ejecutar pruebas unitarias  | `mvn test`                   |
| Generar métricas de calidad | `mvn verify`                 |
| Guardar reportes            | `actions/upload-artifact@v4` |

### Resultado del pipeline

El pipeline finalizó correctamente en GitHub Actions. Todas las etapas se ejecutaron con éxito:

```text
Descargar código fuente       OK
Configurar Java 17            OK
Construir proyecto            OK
Ejecutar pruebas unitarias    OK
Generar métricas de calidad   OK
Guardar reportes de calidad   OK
```

Además, se generó un artefacto descargable llamado:

```text
reportes-calidad
```

Este artefacto contiene reportes de:

* JaCoCo.
* Checkstyle.
* PMD.
* Surefire Reports.

---

## 12. Evidencias Generadas

Durante el desarrollo se almacenaron evidencias dentro de:

```text
docs/evidencias/
```

Ejemplos de evidencias generadas:

```text
checkstyle-error-newline.txt
checkstyle-error-newline.xml
checkstyle-final.xml
jacoco-final.xml
pmd-final.xml
validacion-final-corregida.txt
```

Estas evidencias permiten demostrar el proceso de detección, corrección y mejora de la calidad del proyecto.

---

## 13. Comparación Antes y Después

| Métrica                    |                          Estado inicial |          Estado final |
| -------------------------- | --------------------------------------: | --------------------: |
| Pruebas unitarias          |                               2 pruebas |             9 pruebas |
| Fallos en pruebas          |                                       0 |                     0 |
| Cobertura de instrucciones |                                    88 % |                  95 % |
| Cobertura de ramas         |                                    63 % |                  87 % |
| Líneas no cubiertas        |                                       6 |                     3 |
| Checkstyle                 |                         Con violaciones |         0 violaciones |
| PMD                        | Con errores de configuración y análisis |    Ejecución correcta |
| Pipeline GitHub Actions    |                          No configurado | Configurado y exitoso |

---

## 14. Comandos Principales

### Ejecutar pruebas unitarias

```bash
mvn test
```

### Ejecutar validación completa

```bash
mvn clean verify
```

### Abrir reporte JaCoCo localmente en Windows

```bash
start .\target\site\jacoco\index.html
```

### Guardar evidencia de ejecución

```bash
mvn clean verify *>&1 | Tee-Object -FilePath .\docs\evidencias\validacion-final-corregida.txt
```

---

## 15. Aprendizajes

Durante el desarrollo de esta actividad se aprendió a:

* Crear un proyecto Java con Maven desde cero.
* Configurar pruebas unitarias con JUnit 5.
* Medir cobertura de código con JaCoCo.
* Interpretar métricas de cobertura de instrucciones, ramas, líneas y métodos.
* Detectar problemas de estilo con Checkstyle.
* Detectar problemas estáticos con PMD.
* Corregir problemas detectados por herramientas automáticas.
* Configurar un pipeline de GitHub Actions.
* Generar reportes automáticos como artefactos descargables.
* Utilizar evidencia técnica para demostrar mejoras de calidad.

---

## 16. Conclusiones

El proyecto permitió aplicar un proceso básico de aseguramiento de calidad en software utilizando herramientas automatizadas.

La integración de JaCoCo, Checkstyle y PMD permitió identificar diferentes tipos de problemas: baja cobertura de pruebas, violaciones de estilo y errores de análisis estático. A partir de los reportes generados, se realizaron correcciones que mejoraron la calidad del código.

El uso de GitHub Actions permitió automatizar el proceso de validación, asegurando que cada cambio enviado al repositorio sea construido, probado y analizado automáticamente.

Como resultado final, el proyecto cuenta con pruebas unitarias exitosas, cobertura de código mejorada, cero violaciones de Checkstyle y ejecución correcta de PMD dentro del pipeline.

---

## 17. Recomendaciones

Como mejoras futuras se recomienda:

* Agregar más pruebas unitarias para cubrir el 100 % de ramas.
* Incorporar reglas adicionales de PMD.
* Agregar SpotBugs como herramienta complementaria.
* Configurar umbrales mínimos de cobertura para que el pipeline falle si la cobertura baja.
* Trabajar mediante ramas y pull requests para fortalecer la colaboración del equipo.
* Documentar cada iteración con capturas de los reportes generados.

---

## 18. Autor

Proyecto desarrollado por:

```text
Vanessa Torres y Dayana Vallejos
```

Materia:

```text
Calidad de Software
```
