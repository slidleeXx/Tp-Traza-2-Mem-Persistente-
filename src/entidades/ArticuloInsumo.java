package entidades;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString (callSuper = true, exclude ="articuloDetalles" )
@SuperBuilder


public class ArticuloInsumo extends Articulo {

    private Boolean esParaElaborar;

    private Set<ArticuloManufacturadoDetalle> articuloDetalles = new HashSet<>();

}
