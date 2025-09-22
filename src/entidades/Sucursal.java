package entidades;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "empresa")
@Builder

public class Sucursal {
        private Long id;
        private String nombre;
        private LocalTime horarioApertura;
        private LocalTime horarioCierre;
        private Boolean esCasaMatriz;

        private Domicilio domicilio;
        private Empresa empresa;
        private Set<InventarioSucursal> inventarios = new HashSet<>();

    }

