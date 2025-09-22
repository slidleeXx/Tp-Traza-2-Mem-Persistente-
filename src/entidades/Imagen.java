package entidades;


import lombok.*;



    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    @ToString (exclude = "articulo")
    @Builder

    public class Imagen {
        private Long id;
        private String url;
        private Articulo articulo ;

    }
