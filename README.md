# Automatización web 

El siguiente respositorio fue creado para automatizar la pagina web (http://automationpractice.com/index.php), creando una serie de criterios y casos de pruebas expuestos en un documento en word. 

Cabe destacar que para este repositorio se usa de base el proyecto [the Serenity BDD/Cucumber 4 Starter Project](https://github.com/serenity-bdd/serenity-cucumber4-starter). Este repositorio es quien nos brinda un entorno de pruebas listo para que solamente tengamos que desarrollar las automatizaciones de test.

# Ejecución
Para ejecutar las pruebas basta con ejecutar el siguiente comando dependiendo del sistema operativo

Windows:
```
./gradlew test --tests "starter.CucumberTestSuite"
```
MAC y Linux
```
./gradle test --tests "starter.CucumberTestSuite"
```
# Creditos
Felosque - Creación de la automatización de los casos de prueba
wakaleo y mtdidexx - Creación base del proyecto para facil ejecución
