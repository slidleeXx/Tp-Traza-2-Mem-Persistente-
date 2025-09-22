package entidades;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString ( exclude = "articuloManufacturado")
@Builder

public class ArticuloManufacturadoDetalle {
    private Long id;
    private Integer cantidad;

    private ArticuloManufacturado articuloManufacturado;

    private ArticuloInsumo articuloInsumo;

}
