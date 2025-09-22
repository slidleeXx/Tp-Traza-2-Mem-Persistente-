
package entidades;


import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Setter
@Getter
@SuperBuilder


public class ArticuloManufacturado  extends Articulo{
//    private Long id;
//    private String denominacion;
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;


    private Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new HashSet<>();


}
