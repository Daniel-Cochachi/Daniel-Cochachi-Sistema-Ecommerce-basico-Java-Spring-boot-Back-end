package com.example.sistema_ventas_basico.mapper;

import com.example.sistema_ventas_basico.dto.DetalleVentaResponseDTO;
import com.example.sistema_ventas_basico.dto.VentaDTO;
import com.example.sistema_ventas_basico.dto.VentaResponseDTO;
import com.example.sistema_ventas_basico.model.Venta;

import java.util.List;

public class VentaMapper {

    public static VentaDTO toDTO(Venta venta){

        VentaDTO dto = new VentaDTO();
        dto.setClienteId(venta.getCliente().getId());

        return dto;
    }

    public static VentaResponseDTO toResponseDTO(Venta venta) {

        VentaResponseDTO dto = new VentaResponseDTO();
        dto.setId(venta.getId());
        dto.setCliente(
                venta.getCliente().getNombre() + " " + venta.getCliente().getApellido()
        );
        dto.setFecha(venta.getFecha());
        dto.setTotal(venta.getTotal());

        List<DetalleVentaResponseDTO> detalles = venta.getDetalles()
                .stream()
                .map(d -> {
                    DetalleVentaResponseDTO det = new DetalleVentaResponseDTO();
                    det.setProducto(d.getProducto().getNombre());
                    det.setCantidad(d.getCantidad());
                    det.setPrecioUnitario(d.getPrecioUnitario());
                    det.setSubtotal(d.getSubtotal());
                    return det;
                })
                .toList();

        dto.setDetalles(detalles);

        return dto;
    }
}
