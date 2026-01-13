package com.example.sistema_ventas_basico.service;

import com.example.sistema_ventas_basico.dto.DetalleVentaDTO;
import com.example.sistema_ventas_basico.dto.VentaDTO;
import com.example.sistema_ventas_basico.dto.VentaResponseDTO;
import com.example.sistema_ventas_basico.exception.ResourceNotFoundException;
import com.example.sistema_ventas_basico.mapper.VentaMapper;
import com.example.sistema_ventas_basico.model.Cliente;
import com.example.sistema_ventas_basico.model.DetalleVenta;
import com.example.sistema_ventas_basico.model.Producto;
import com.example.sistema_ventas_basico.model.Venta;
import com.example.sistema_ventas_basico.repository.ClienteRepository;
import com.example.sistema_ventas_basico.repository.ProductoRepository;
import com.example.sistema_ventas_basico.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaService implements IVentaService{

    private final VentaRepository ventaRepository;

    private final ClienteRepository clienteRepository;

    private final ProductoRepository productoRepository;

    @Override
    @Transactional
    public VentaDTO registrarVenta(VentaDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no existe"));

        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setFecha(LocalDateTime.now());
        double total= 0;
        List<DetalleVenta> detalles = new ArrayList<>();

        for (DetalleVentaDTO d : dto.getDetalles()){
            Producto producto = productoRepository.findById(d.getProductoId())
                    .orElseThrow(()-> new ResourceNotFoundException("Producto no existe"));

            DetalleVenta detalle = new DetalleVenta();
            detalle.setProducto(producto);
            detalle.setCantidad(d.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());
            double subtotal= producto.getPrecio() * d.getCantidad();
            detalle.setSubtotal(subtotal);
            detalle.setVenta(venta);
            total+= subtotal;
            detalles.add(detalle);
        }

        venta.setTotal(total);
        venta.setDetalles(detalles);

        Venta guardada = ventaRepository.save(venta);

        return VentaMapper.toDTO(guardada);
    }

    @Override
    public List<VentaResponseDTO> listarVentas() {
        return ventaRepository.findAll().stream()
                .map(VentaMapper::toResponseDTO)
                .toList();
    }

    @Override
    public VentaResponseDTO buscarPorId(Long id) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venta no encontrada"));

        return VentaMapper.toResponseDTO(venta);
    }
}
