# Conversor de Monedas

Este es un simple conversor de monedas que utiliza la API de tasas de cambio para convertir cantidades de una moneda a otra.

## Uso

### Obtener una clave de API

1. **Regístrate en ExchangeRate-API**: Ve a [ExchangeRate-API](https://app.exchangerate-api.com/signup) y regístrate para obtener una clave de API gratuita.

2. **Obtener la clave de API**: Después de registrarte, recibirás un correo electrónico con un enlace para activar tu cuenta y obtener tu clave de API. Sigue las instrucciones en el correo electrónico para obtener tu clave de API.

### Configuración de la aplicación

1. **Clonar el repositorio**: Clona este repositorio en tu máquina local utilizando el siguiente comando:

   ```bash
   git clone https://github.com/LuiFernandoSh/ConversorDeMonedas.git
   ```


3. **Configurar la clave de API**: Abre el archivo `Main.java` en el directorio `src/main/java/conversordemonedas` y reemplaza `"YOUR_API_KEY"` en la línea 10 con tu clave de API obtenida anteriormente.

4. **Compilar la aplicación**: Ve al directorio del proyecto y compila la aplicación usando Maven:
  ```bash
  cd ConversorDeMonedas
  mvn package
```

Esto generará un archivo JAR ejecutable en el directorio `target`.
```bash
  cd target
```

### Ejecutar la aplicación

1. **Ejecutar la aplicación**: Ejecuta el archivo JAR generado desde la raíz del proyecto utilizando el siguiente comando:
   ```bash
   java -jar target/ConversorDeMonedas-1.0-SNAPSHOT.jar
   ```


2. **Utilizar el conversor de monedas**: Una vez que la aplicación esté en funcionamiento, sigue las instrucciones en la consola para seleccionar la moneda de destino e ingresar la cantidad que deseas convertir.

## Requisitos

- Java Development Kit (JDK) 17
- Maven

## Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras algún error o tienes ideas para mejorar este proyecto, no dudes en abrir un issue o enviar un pull request.

## Autor

Este proyecto fue creado por [Luis Fernando Saldalña Hernandez](https://github.com/LuiFernandoSh).


