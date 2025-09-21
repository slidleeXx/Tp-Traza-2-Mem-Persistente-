package entidades;



import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString (exclude = "categoria")
@Setter
@SuperBuilder


public  class Articulo  {
    private Long id;
    private String denominacion;
    protected Double precioVenta;


    private UnidadMedida unidadMedida;
    private Categoria categoria;
    private Set<Imagen> imagenes = new HashSet<>();





}

