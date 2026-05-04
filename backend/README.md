# Sistema de Ventas de Ropa

Backend modular con Spring Boot 3, Java 21, Maven, PostgreSQL y JWT.

## Estructura

Package base: `com.sistemaventasropa`

Modulos principales:

- `auth`
- `usuarios`
- `productos`
- `ventas`
- `clientes`
- `reportes`

Cada modulo queda preparado con paquetes:

- `controller`
- `service`
- `repository`
- `entity`
- `dto`
- `config`
- `security`
- `exception`

Capas transversales:

- `config`
- `security`
- `exception`

## Ejecutar con Docker

```bash
docker compose up --build
```

La API queda disponible en `http://localhost:8080`.

## Ejecutar localmente

Levanta PostgreSQL:

```bash
docker compose up postgres
```

Luego ejecuta la aplicacion:

```bash
mvn spring-boot:run
```

## Configuracion principal

Variables soportadas:

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `JWT_SECRET`
- `JWT_EXPIRATION_MS`

Endpoints iniciales:

- `POST /api/auth/register`
- `POST /api/auth/login`
- `GET /api/usuarios`
- `GET /api/productos`
- `POST /api/productos`
- `GET /api/clientes`
- `POST /api/clientes`
- `GET /api/ventas`
- `POST /api/ventas`
- `GET /api/reportes/ventas`
