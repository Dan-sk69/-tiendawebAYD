package com.sistemaventasropa.productos.service;

import com.sistemaventasropa.exception.ResourceNotFoundException;
import com.sistemaventasropa.productos.dto.ProductoRequest;
import com.sistemaventasropa.productos.dto.ProductoResponse;
import com.sistemaventasropa.productos.entity.Producto;
import com.sistemaventasropa.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoResponse> listar() {
        return productoRepository.findAll().stream().map(this::toResponse).toList();
    }

    public ProductoResponse obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
    }

    public ProductoResponse crear(ProductoRequest request) {
        Producto producto = Producto.builder()
                .nombre(request.nombre())
                .descripcion(request.descripcion())
                .categoria(request.categoria())
                .talla(request.talla())
                .color(request.color())
                .precio(request.precio())
                .stock(request.stock())
                .activo(true)
                .build();
        return toResponse(productoRepository.save(producto));
    }

    public ProductoResponse actualizar(Long id, ProductoRequest request) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        producto.setNombre(request.nombre());
        producto.setDescripcion(request.descripcion());
        producto.setCategoria(request.categoria());
        producto.setTalla(request.talla());
        producto.setColor(request.color());
        producto.setPrecio(request.precio());
        producto.setStock(request.stock());

        return toResponse(productoRepository.save(producto));
    }

    public void eliminar(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto no encontrado");
        }
        productoRepository.deleteById(id);
    }

    private ProductoResponse toResponse(Producto producto) {
        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getCategoria(),
                producto.getTalla(),
                producto.getColor(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getActivo()
        );
    }
}
