import java.time.LocalDate;

public class HabitacionBasica extends Habitacion implements Cuartos {

    public HabitacionBasica(
            String codigo,
            String nombre,
            double tarifa,
            int diasReserva
    ) throws TarifaNegativaException {

        super(codigo, nombre, tarifa, diasReserva);

        if (diasReserva <= 0) {
            throw new IllegalArgumentException(
                    "La Cantidad minima para reservar una Habitacion es de 1 dia"
            );
        }

        this.diasReserva = diasReserva;
    }

    public LocalDate getdiasReserva() {
        return diasReserva;
    }

    private boolean estaVencido() {
        return !fechaVencimiento.isAfter(LocalDate.now());
    }

    @Override
    public void revisarEstado() {

        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(3);

        if (estaVencido()) {

            System.out.println(
                    getNombre() + " está VENCIDO"
            );

        } else if (!fechaVencimiento.isAfter(limite)) {

            System.out.println(
                    "AVISO: " + getNombre() +
                            " está próximo a vencerse"
            );

        } else {

            System.out.println(
                    getNombre() + " está en buen estado"
            );
        }
    }

    @Override
    public void vender(int cantidad)
            throws StockInsuficienteException,
            ProductoVencidoException,
            CantidadInvalidaException {

        if (cantidad <= 0) {
            throw new CantidadInvalidaException(
                    "La cantidad a vender debe ser mayor que cero"
            );
        }

        if (estaVencido()) {

            throw new ProductoVencidoException(
                    "No se puede vender " +
                            getNombre() +
                            " porque está vencido"
            );
        }

        descontarStock(cantidad);
    }

    @Override
    public String toString() {
        return super.toString()
                + " - Vence: "
                + fechaVencimiento;
    }
