
# Sistema de Ventas de Ropa

Monorepo para el sistema de ventas de ropa.

## Estructura

```text
sistema-de-ventas-ropa
├── backend
│   └── Proyecto Spring Boot
├── frontend
│   └── Estructura base React
├── docker-compose.yml
└── README.md
```

## Backend

El backend esta en `backend` y usa:

- Java 21
- Spring Boot 3
- Maven
- PostgreSQL 17
- Spring Security con JWT
- Hibernate con `spring.jpa.hibernate.ddl-auto=update`

Ejecutar localmente:

```bash
cd backend
mvn spring-boot:run
```

Endpoint publico de prueba:

```text
GET http://localhost:8080/api/test
```

Respuesta esperada:

```text
Backend funcionando correctamente
```

## Frontend

El frontend esta preparado con una base React + Vite.

```bash
cd frontend
npm install
npm run dev
```

La URL de la API se configura con `VITE_API_URL`. Por defecto apunta a:

```text
http://localhost:8080/api
```

## Docker

Desde la raiz del repositorio:

```bash
docker compose up --build
```

Esto levanta PostgreSQL 17 y construye el backend desde `./backend`.
=======
# -tiendawebAYD
>>>>>>> ae024f2f66ec9b7bd4f77b342afe8007e8d60a0d
