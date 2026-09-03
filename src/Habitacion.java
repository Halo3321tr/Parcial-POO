import java.util.Objects;

public abstract class Habitacion {

    private String codigohabitacion;
    private String nombre;
    private double tarifa;
    protected int cantidadDisponible;

    private static int cantidadHabitaciones = 0;

    public Habitacion(String codigo, String nombre, double precio, int cantidadDisponible)
            throw TartifaNegativaException {

        if (tarifa < 0) {
            throw new TarifaNegativaException("La tarifa no puede ser negativa");
        }

        this.codigohabitacion = codigohabitacion;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.cantidadDisponible = cantidadDisponible;

            }

    // Constructor sobrecargado
    public Habitacion(String codigo, String nombre, double tarifa)
            throws TarifaNegativaException {

        this(codigo, nombre, tarifa, 0);
    }

    // Método concreto
    public void mostrarInformacion() {
        System.out.println("Código: " + codigohabitacion);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + tarifa);
        System.out.println("Cantidad: " + cantidadDisponible);
    }

    // Método abstracto
    public abstract void revisarEstado();

    protected void descontarStock(int cantidad)
            throws NochesNegativasException, CantidadInvalidaException {

        if (cantidad <= 0) {
            throw new CantidadInvalidaException(
                    "La cantidad a vender debe ser mayor que cero"
            );
        }

        if (cantidad > cantidadDisponible) {
            throw new NochesNegativasException(
                    "No hay suficiente inventario de " + nombre
            );
        }

        cantidadDisponible -= cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return tarifa;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public static int getCantidadProductos() {
        return cantidadProductos;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre +
                " - $" + tarifa +
                " - Stock: " + cantidadDisponible;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Habitacion)) {
            return false;
        }

        Habitacion otro = (Habitacion) obj;

        return codigo.equals(otro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}