import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Menú
            System.out.println("*******************************************");
            System.out.println("*******************************************");
            System.out.println("Seleccione una opcion ingresando el numero:");
            System.out.println("1- Agregar producto al inventario");
            System.out.println("2- Buscar producto");
            System.out.println("3- Vender producto");
            System.out.println("4- Modificar precio de un producto");
            System.out.println("5- Mostrar facturacion total");
            System.out.println("6- Mostrar facturacion por tipo de producto");
            System.out.println("7- Salir");
            System.out.println("*******************************************");
            System.out.println("*******************************************");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Agregar producto al inventario
                    System.out.println("Ingrese el tipo de producto (RAM, Tarjeta Grafica, Placa Base, Fuente Alimentacion, SSD):");
                    String tipoProducto = "";
                    while (!tipoProducto.matches("RAM|Tarjeta Grafica|Placa Base|Fuente Alimentacion|SSD")) {
                        tipoProducto = scanner.nextLine();
                        if (!tipoProducto.matches("RAM|Tarjeta Grafica|Placa Base|Fuente Alimentacion|SSD")) {
                            System.out.println("Ingrese un tipo de producto valido.");
                        }
                    }

                    System.out.println("Ingrese el precio del producto:");
                    double precioProducto = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese el modelo del producto:");
                    String modeloProducto = scanner.nextLine();

                    Producto nuevoProducto = new Producto(tipoProducto, precioProducto, modeloProducto);
                    almacen.agregarProducto(nuevoProducto);
                    System.out.println("Producto agregado correctamente.");
                    break;

                case 2:
                    // Buscar producto
                    System.out.println("Ingrese el ID del producto a buscar:");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine();

                    Producto productoEncontrado = almacen.buscarProducto(idBuscar);
                    if (productoEncontrado != null) {
                        System.out.println("*******************************************");
                        System.out.println("************PRODUCTO ENCONTRADO:************\n" + productoEncontrado);

                    } else {
                        System.out.println("*******************************************");
                        System.out.println("*********PRODUCTO NO ENCONTRADO**********+*");

                    }
                    break;

                case 3:
                    // Venta de producto
                    System.out.println("Ingrese el tipo del producto a vender : ");
                    String tipoVenta = scanner.nextLine();
                    almacen.venderProducto(tipoVenta);
                    break;

                case 4:
                    // Cambiar precio de producto
                    System.out.println("Ingrese el ID del producto cuyo precio desea cambiar:");
                    int idCambiarPrecio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el nuevo precio:");
                    double nuevoPrecio = scanner.nextDouble();
                    scanner.nextLine();

                    almacen.cambiarPrecioProducto(idCambiarPrecio, nuevoPrecio);
                    break;

                case 5:
                    // Mostrar facturación general
                    System.out.println("FACTURACION GENERAL:");

                    System.out.println("Tipo: RAM , Facturacion: €" + almacen.facturRam);
                    System.out.println("Tipo: Tarjeta Gráfica , Facturacion: €" + almacen.facturTarjeta);
                    System.out.println("Tipo: Placa base , Facturacion: €" + almacen.facturPlaca);
                    System.out.println("Tipo: Fuente alimentación , Facturacion: €" + almacen.facturFuente);
                    System.out.println("Tipo: SSD , Facturacion: €" + almacen.facturSsd);

                    break;

                case 6:
                    // Mostrar facturación de producto
                    System.out.println("Ingrese el tipo de producto (RAM, Tarjeta Gráfica, Placa Base, Fuente Alimentación, SSD):");
                    String tipoFacturacion = scanner.nextLine();

                    if (tipoFacturacion.equalsIgnoreCase("RAM")){
                        System.out.println("VENTAS DE " + tipoFacturacion.toUpperCase() + ":\nFacturacion de producto €" + almacen.facturRam);
                    }
                    if (tipoFacturacion.equalsIgnoreCase("Tarjeta Grafica")){
                        System.out.println("VENTAS DE " + tipoFacturacion.toUpperCase() + ":\nFacturacion de producto €" + almacen.facturTarjeta);
                    }
                    if (tipoFacturacion.equalsIgnoreCase("Placa Base")){
                        System.out.println("VENTAS DE " + tipoFacturacion.toUpperCase() + ":\nFacturacion de producto €" + almacen.facturPlaca);
                    }
                    if (tipoFacturacion.equalsIgnoreCase("Fuente Alimentacion")){
                        System.out.println("VENTAS DE " + tipoFacturacion.toUpperCase() + ":\nFacturacion de producto €" + almacen.facturFuente);
                    }
                    if (tipoFacturacion.equalsIgnoreCase("SSD")){
                        System.out.println("VENTAS DE " + tipoFacturacion.toUpperCase() + ":\nFacturacion de producto €" + almacen.facturSsd);
                    }


                    break;

                case 7:
                    // Salir
                    System.out.println("Saliendo del programa");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion no valida. Ingrese un numero del 1 al 7.");
                    break;
            }
        }
    }
}