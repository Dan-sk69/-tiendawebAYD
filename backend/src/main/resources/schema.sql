-- Schema SQL para PostgreSQL 17
-- Proyecto: Sistema de Ventas de Ropa
-- Basado en las entidades JPA actuales del backend Spring Boot.

CREATE TABLE IF NOT EXISTS usuarios (
    id BIGSERIAL,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(255) NOT NULL,
    activo BOOLEAN NOT NULL,
    creado_en TIMESTAMP(6) NOT NULL,

    CONSTRAINT pk_usuarios PRIMARY KEY (id),
    CONSTRAINT uk_usuarios_email UNIQUE (email),
    CONSTRAINT chk_usuarios_rol CHECK (rol IN ('ADMIN', 'VENDEDOR'))
);

CREATE TABLE IF NOT EXISTS productos (
    id BIGSERIAL,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255),
    categoria VARCHAR(255) NOT NULL,
    talla VARCHAR(255) NOT NULL,
    color VARCHAR(255) NOT NULL,
    precio NUMERIC(10, 2) NOT NULL,
    stock INTEGER NOT NULL,
    activo BOOLEAN NOT NULL,
    creado_en TIMESTAMP(6) NOT NULL,

    CONSTRAINT pk_productos PRIMARY KEY (id),
    CONSTRAINT chk_productos_precio_no_negativo CHECK (precio >= 0),
    CONSTRAINT chk_productos_stock_no_negativo CHECK (stock >= 0)
);

CREATE TABLE IF NOT EXISTS clientes (
    id BIGSERIAL,
    nombre VARCHAR(255) NOT NULL,
    documento VARCHAR(255),
    telefono VARCHAR(255),
    email VARCHAR(255),
    direccion VARCHAR(255),
    creado_en TIMESTAMP(6) NOT NULL,

    CONSTRAINT pk_clientes PRIMARY KEY (id),
    CONSTRAINT uk_clientes_documento UNIQUE (documento)
);

CREATE TABLE IF NOT EXISTS ventas (
    id BIGSERIAL,
    cliente_id BIGINT,
    usuario_id BIGINT NOT NULL,
    total NUMERIC(10, 2) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    creado_en TIMESTAMP(6) NOT NULL,

    CONSTRAINT pk_ventas PRIMARY KEY (id),
    CONSTRAINT fk_ventas_clientes FOREIGN KEY (cliente_id) REFERENCES clientes (id),
    CONSTRAINT fk_ventas_usuarios FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    CONSTRAINT chk_ventas_estado CHECK (estado IN ('REGISTRADA', 'PAGADA', 'ANULADA')),
    CONSTRAINT chk_ventas_total_no_negativo CHECK (total >= 0)
);

CREATE INDEX IF NOT EXISTS idx_ventas_cliente_id ON ventas (cliente_id);
CREATE INDEX IF NOT EXISTS idx_ventas_usuario_id ON ventas (usuario_id);
CREATE INDEX IF NOT EXISTS idx_ventas_estado ON ventas (estado);
