package entidades;


import lombok.*;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@ToString (exclude = "articulos")
@Setter
@Getter
@Builder

public class UnidadMedida {

    private Long id;
    private String denominacion;

    private Set<Articulo> articulos = new HashSet<>();

}
