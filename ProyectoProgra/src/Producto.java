class Producto {

    //Atributos
    private static int nextID = 1;
    private final int id;
    private final String tipo;
    private double precio;
    private final String modelo;

    public Producto(String tipo, double precio, String modelo) {
        this.id = nextID++;
        this.tipo = tipo;
        this.precio = precio;
        this.modelo = modelo;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    //Setter
    public void cambiarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    @Override
    public String toString() {
        return "TIPO: " + tipo + "\nID: " + id + "\nMODELO: " + modelo + "\nPRECIO: " + precio;
    }
}