
import entidades.*;
import repositorios.Repositorio;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        //creacion de Categorias

     Categoria catPizzas = Categoria.builder().
                id(101L).
                denominacion("Pizzas").
                build();

        Categoria catSandwich = Categoria.builder().
                id(102L).
                denominacion("Sandwich").
                build();

        Categoria catLomos = Categoria.builder().
                id(103L).
                denominacion("Lomos")
                .build();

        Categoria catInsumos =Categoria.builder().
                id(104L).
                denominacion("Insumos").
                build();

        // Creacion de unidades de medidas
        UnidadMedida kg = UnidadMedida.builder().id(1L).denominacion("Kilogramos").build();
        UnidadMedida lt = UnidadMedida.builder().id(2L).denominacion("Litros").build();
        UnidadMedida gr = UnidadMedida.builder().id(3L).denominacion("Gramos").build();

        // Creacion de Artículos Insumos

        ArticuloInsumo sal = ArticuloInsumo.builder().id(3001L)
                        .stockActual(100).stockMaximo(300).stockMinimo(2).precioCompra(2.00).
                denominacion("Sal").unidadMedida(gr).
                precioCompra(1.00).precioVenta(3.00).
                esParaElaborar(true).
                build();

        ArticuloInsumo aceite = ArticuloInsumo.builder().id(3002L)
                        .stockActual(23).stockMaximo(300).stockMinimo(0).precioCompra(1.00).
                denominacion("Aceite").
                esParaElaborar(true).
                unidadMedida(lt).
                build();


        ArticuloInsumo carne = ArticuloInsumo.builder().id(3003L).
                denominacion("Carne").
                precioCompra(40.00).precioVenta(50.00).
                        stockActual(26).stockMaximo(150).stockMinimo(2).
                esParaElaborar(true).
                unidadMedida(kg).
                build();

        ArticuloInsumo harina = ArticuloInsumo.builder().id(3004L).
                denominacion("Harina")
                        .stockActual(20).stockMaximo(100).stockMinimo(2).
                precioCompra(15.00).precioVenta(30.00).
                esParaElaborar(true).
                unidadMedida(kg).
                build();

        // creacion de Imagenes
        Imagen img1 = Imagen.builder().id(40001L).url("imagen1_Hawaiana1.png").build();
        Imagen img2 = Imagen.builder().id(40002L).url("imagen2_Hawaiana2.png").build();
        Imagen img3 = Imagen.builder().id(40003L).url("imagen3_Hawaiana3.png").build();
        Imagen img4 = Imagen.builder().id(40004L).url("imagen4_Lomo1.png").build();
        Imagen img5 = Imagen.builder().id(40005L).url("imagen5_Lomo2.png").build();
        Imagen img6 = Imagen.builder().id(40006L).url("imagen6_Lomo3.png").build();

        //  creamos Detalles
        ArticuloManufacturadoDetalle detallePizza1 = ArticuloManufacturadoDetalle.builder()
                .id(1L).
                cantidad(1).
                articuloInsumo(sal).
                build();

        ArticuloManufacturadoDetalle detallePizza2 = ArticuloManufacturadoDetalle.builder()
                .id(2L).
                cantidad(2).
                articuloInsumo(harina).
                build();

        ArticuloManufacturadoDetalle detallePizza3 = ArticuloManufacturadoDetalle.builder()
                .id(3L).
                cantidad(1).
                articuloInsumo(aceite).
                build();

        ArticuloManufacturadoDetalle detalleLomo1 = ArticuloManufacturadoDetalle.builder()
                .id(4L).
                cantidad(1).
                articuloInsumo(sal).
                build();

        ArticuloManufacturadoDetalle detalleLomo2 = ArticuloManufacturadoDetalle.builder()
                .id(5L).
                cantidad(1).
                articuloInsumo(aceite).
                build();

        ArticuloManufacturadoDetalle detalleLomo3 = ArticuloManufacturadoDetalle.builder()
                .id(6L).
                cantidad(2).
                articuloInsumo(carne).
                build();


        // Creacion de articulos Manufacturados -> Pizza Hawaian y lomoCompleto y seteamos imagenes -detalles
        ArticuloManufacturado pizzaHawaiana = ArticuloManufacturado.builder()
                .id(10L).denominacion("Pizza hawaiana")
                .categoria(catPizzas).unidadMedida(kg).
                descripcion("1 porcion sin Piña").precioVenta(70.00).preparacion("Al horno").tiempoEstimadoMinutos(15)
                .imagenes(new HashSet<>(Set.of(img1, img2, img3)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detallePizza1, detallePizza2, detallePizza3)))
                .build();

        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                .id(11L).denominacion("Lomo completo").
                descripcion("Incluye adereso completo").precioVenta(90.00).preparacion("a la Plancha").tiempoEstimadoMinutos(20)
                .categoria(catLomos).unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img4, img5, img6)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalleLomo1, detalleLomo2, detalleLomo3)))
                .build();

        // Operaciones Con el Repositorio

        // creamos repositorios para persistir

        Repositorio<Categoria> repoCategorias = new Repositorio<>();
        Repositorio<ArticuloInsumo> repoInsumos = new Repositorio<>();
        Repositorio<ArticuloManufacturado> repoManufacturados = new Repositorio<>();

        // persistimos

        // Guardar datos (no cascada) Usamos Save Normal
        repoCategorias.save(catPizzas);
        repoCategorias.save(catLomos);
        repoCategorias.save(catInsumos);

        repoInsumos.save(sal);
        repoInsumos.save(aceite);
        repoInsumos.save(carne);
        repoInsumos.save(harina);

        repoManufacturados.save(pizzaHawaiana);
        repoManufacturados.save(lomoCompleto);

        // Mostrar repositorios ->

        System.out.println("Mostrando Categorías guardadas : " + repoCategorias.findAll()+"\n");
        System.out.println("Mostrando Insumos guardadas : " + repoInsumos.findAll()+ "\n");
        System.out.println("Mostrando Manufacturados guardadas: " + repoManufacturados.findAll()+"\n");


        // relazar busqueda por id
        System.out.println("Buscar y mostrar manufacturado con  id=10: " + repoManufacturados.findById(10L));//imprime
        System.out.println("Buscar y mostrar insumos con  id=3004: " + repoManufacturados.findById(3004L)); //imprime


        // Actualizar
        lomoCompleto.setDenominacion("Lomo Completo precio actualizado");
        lomoCompleto.setPrecioVenta(lomoCompleto.getPrecioVenta()*0.05+lomoCompleto.getPrecioVenta());
        repoManufacturados.genericUpdate(lomoCompleto.getId(), lomoCompleto);

        pizzaHawaiana.setDenominacion("Pi<za hawaina precio actualizado");
        pizzaHawaiana.setPrecioVenta(pizzaHawaiana.getPrecioVenta()*0.05+pizzaHawaiana.getPrecioVenta());
        repoManufacturados.genericUpdate(lomoCompleto.getId(), lomoCompleto);

        System.out.println(" manufacturado Después de actualizar: " + repoManufacturados.findAll());

        // eliminar Pizza Hawaina
        System.out.println("Retiramos pizza Hawaina -> quien come pizza con piña");
        repoManufacturados.genericDelete(pizzaHawaiana.getId());
        System.out.println("mostrar Después de eliminar: " + repoManufacturados.findAll());

    }
}