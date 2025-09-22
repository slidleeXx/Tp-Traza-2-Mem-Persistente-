
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

        ArticuloInsumo sal = ArticuloInsumo.builder().id(3001L).
                denominacion("Sal").unidadMedida(gr)
                .precioVenta(4.00).
                esParaElaborar(true).
                build();

        ArticuloInsumo aceite = ArticuloInsumo.builder().id(3002L).
                denominacion("Aceite").
                precioVenta(3.00).
                esParaElaborar(true).
                unidadMedida(lt).
                build();


        ArticuloInsumo carne = ArticuloInsumo.builder().id(3003L).
                denominacion("Carne").precioVenta(10.00).
                esParaElaborar(true).
                unidadMedida(kg).
                build();

        ArticuloInsumo harina = ArticuloInsumo.builder().id(3004L).
                denominacion("Harina")
                .precioVenta(8.00).
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



        //Creacion de Empresas -----------------------------------

        // cr un Pais
        Pais pais1 = Pais.builder().
                id(01L).
                nombre("Argentina").
                build();

        // cr Provincia y relacionamos con su pais

        Provincia provincia2 = Provincia.builder().
                id(202L).
                nombre("Cordoba").
                pais(pais1).
                build();

        // cr Localidades y relacionamos con su Provincia

        Localidad localidad3= Localidad.builder().
                id(3000003L).
                nombre("Cordoba Capital").
                provincia(provincia2).
                build();

        Localidad localidad4= Localidad.builder().
                id(3000004L).
                nombre("Villa Carlos Paz").
                provincia(provincia2).
                build();


        // cr Domicilio y relacionamos con su Localidad

        Domicilio domicilio3 = Domicilio.builder().id(43L).
                calle("Av. Libertador Salvador Jr").
                num(224).piso(0).numDpto(4).
                codPost(5200).localidad(localidad3).
                build();

        Domicilio domicilio4 = Domicilio.builder().id(44L).
                calle("Juana Zurduy").
                num(524).piso(0).numDpto(0).
                codPost(5204).localidad(localidad4).
                build();


        // Creacion de Sucursales
        // en Cordoba Cap
        Sucursal sucursal3= Sucursal.builder().
                id(5003L).
                nombre("Mostaza Sucursal Oeste Crba Cap").
                esCasaMatriz(true).
                horarioApertura(LocalTime.of(14,00)).
                horarioCierre(LocalTime.of(23,30)).
                domicilio(domicilio3).
                build();

        // en Villa Carloz P
        Sucursal sucursal4= Sucursal.builder().
                id(5004L).
                nombre("Mostaza Sucursal Centro Villa Carl P.").
                esCasaMatriz(true).
                horarioApertura(LocalTime.of(14,00)).
                horarioCierre(LocalTime.of(23,30)).
                domicilio(domicilio3).
                build();

        // Creacion de Empresa

        Empresa empresa2 = Empresa.builder().
                id(60002L).
                nombre("Mostaza").
                razonSocial("Mostaza y Pan S.A").
                cuit(123333).
                sucursales(new HashSet<>(Set.of(sucursal3,sucursal4))).
                build();

        // Setear Bidireccionalidad

        // asignar a sucursales su empresa

        sucursal3.setEmpresa(empresa2);
        sucursal4.setEmpresa(empresa2);

        // Domicilios a Localidades

        localidad3.setDomicilios(new HashSet<>(Set.of(domicilio3)));
        localidad4.setDomicilios(new HashSet<>(Set.of(domicilio4)));
      // Localidades a Provincias
           provincia2.setLocalidades(new HashSet<>(Set.of(localidad3,localidad4)));

        // Provincias a Paises
        pais1.setProvincias(new HashSet<>(Set.of(provincia2)));



        // Conexion con sistema de comidas RAPIDAS-> CLASE ASOCIATIVA Inventario

        try {

            // inventarios para cada articulo de Insumos
            InventarioSucursal inventarioMostazaSuc1_aceite = InventarioSucursal.builder().fechaIngreso(LocalDate.of(25,3,01)).stock(300).precioCompra(3.00).articulo(aceite).sucursal(sucursal3).build();
            InventarioSucursal inventarioMostazaSuc1_carne = InventarioSucursal.builder().fechaIngreso(LocalDate.of(25,8,01)).stock(100).precioCompra(2.00).articulo(aceite).sucursal(sucursal3).build();
            InventarioSucursal inventarioMostazaSuc1_sal = InventarioSucursal.builder().fechaIngreso(LocalDate.of(25,9,01)).stock(300).precioCompra(1.00).articulo(aceite).sucursal(sucursal3).build();
            InventarioSucursal inventarioMostazaSuc1_harina = InventarioSucursal.builder().fechaIngreso(LocalDate.of(25,10,01)).stock(100).precioCompra(3.00).articulo(aceite).sucursal(sucursal3).build();


            // inventarios para cada articulo Manufacturado
            InventarioSucursal inventarioMostazaSuc1_piz = InventarioSucursal.builder().fechaIngreso(LocalDate.of(25,10,01)).stock(100).precioCompra(3.00).articulo(lomoCompleto).sucursal(sucursal3).build();
            InventarioSucursal inventarioMostazaSuc1_lom = InventarioSucursal.builder().fechaIngreso(LocalDate.of(25,10,01)).stock(100).precioCompra(3.00).articulo(pizzaHawaiana).sucursal(sucursal3).build();


            // seteamos inventarios a sucursales

            sucursal3.setInventarios(new HashSet<>(Set.of(inventarioMostazaSuc1_aceite,inventarioMostazaSuc1_harina,inventarioMostazaSuc1_sal,inventarioMostazaSuc1_carne,inventarioMostazaSuc1_piz,inventarioMostazaSuc1_lom)));

            // seteamos inventarios a articulos
            aceite.setInventarios(new HashSet<>(Set.of(inventarioMostazaSuc1_aceite)));
            harina.setInventarios(new HashSet<>(Set.of(inventarioMostazaSuc1_harina)));
            carne.setInventarios(new HashSet<>(Set.of(inventarioMostazaSuc1_carne)));
            sal.setInventarios(new HashSet<>(Set.of(inventarioMostazaSuc1_sal)));

            lomoCompleto.setInventarios(new HashSet<>(Set.of(inventarioMostazaSuc1_lom)));
            pizzaHawaiana.setInventarios(new HashSet<>(Set.of(inventarioMostazaSuc1_piz)));


        } catch (RuntimeException e) {
            throw new RuntimeException("Clase asociativa. No existe si no tiene los miembros para su existencia ",e);
        }




        // Operaciones Con el Repositorio

        // creamos repositorios para persistir

        Repositorio<Categoria> repoCategorias = new Repositorio<>();
        Repositorio<ArticuloInsumo> repoInsumos = new Repositorio<>();
        Repositorio<ArticuloManufacturado> repoManufacturados = new Repositorio<>();

        // persistimos empreasas

        Repositorio<Empresa> repositorioEmp = new Repositorio<>();
        repositorioEmp.save(empresa2);


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
        System.out.println("Buscar y mostrar insumos con  id=3004: " + repoManufacturados.findById(3004L)); //imprime false optional


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

        // Mostramos El contenifo de la empresa persistida incluida su sucursal con sus articulos
        System.out.println("Todas las empresas guardadas");
        System.out.println(repositorioEmp.findAll());


    }
}
