package entidades;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString (exclude ="articuloDetalles" )
@SuperBuilder


public class ArticuloInsumo extends Articulo {
//    private Long id;
//    private String denominacion;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMinimo;
    private Integer stockMaximo;
    private Boolean esParaElaborar;

    private Set<ArticuloManufacturadoDetalle> articuloDetalles = new HashSet<>();

}
