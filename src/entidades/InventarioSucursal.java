package entidades;

import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"sucursal"})
@Builder

public class InventarioSucursal {

    private Integer stock ;
    private LocalDate fechaIngreso;
    private Double precioCompra;
    @NonNull // clase asociativa, no existe si no existe articulo y sucursal
    private Articulo  articulo;
    @NonNull
    private Sucursal  sucursal ;
}
