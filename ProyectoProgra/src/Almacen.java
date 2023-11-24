import java.util.ArrayList;

class Almacen {

    //Atributos
    private final ArrayList<Producto> inventario;
    public double facturRam = 0;
    public double facturTarjeta = 0;
    public double facturPlaca = 0;
    public double facturFuente = 0;
    public double facturSsd = 0;

    public Almacen() {
        this.inventario = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        inventario.add(producto);
    }

    public Producto buscarProducto(int id) {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    //Venta de producto
    public void venderProducto(String tipo) {
        Producto productoVendido = null;
        for (Producto producto : inventario) {
            if (producto.getTipo().equalsIgnoreCase(tipo)) {

                // Facturación por tipo de producto
                switch (tipo.toUpperCase()) {
                    case "RAM":
                        facturRam += producto.getPrecio();
                        break;
                    case "TARJETA GRAFICA":
                        facturTarjeta += producto.getPrecio();
                        break;
                    case "PLACA BASE":
                        facturPlaca += producto.getPrecio();
                        break;
                    case "FUENTE ALIMENTACION":
                        facturFuente += producto.getPrecio();
                        break;
                    case "SSD":
                        facturSsd += producto.getPrecio();
                        break;
                }

                // Registro del producto vendido
                if (productoVendido == null || producto.getId() < productoVendido.getId()) {
                    productoVendido = producto;
                }
            }
        }

        // Proceso de venta y actualización del inventario
        if (productoVendido != null) {
            inventario.remove(productoVendido);
            System.out.println("Producto vendido:\n" + productoVendido);
        } else {
            System.out.println("No hay producto del tipo " + tipo + " en el inventario.");
        }
    }


    //Cambio de precio a producto por id
    public void cambiarPrecioProducto(int id, double nuevoPrecio) {
        Producto producto = buscarProducto(id);
        if (producto != null) {
            producto.cambiarPrecio(nuevoPrecio);
            System.out.println("Precio cambiado correctamente");
        } else {
            System.out.println("Producto no encontrado");
        }
    }
}