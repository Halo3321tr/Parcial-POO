public class Suite extends Habitacion implements Cuartos{

    public Suite(
            String codigohabitacion,,
            double tarifa,
            int diasReserva,
            int porcRecargo

    ) throws TarifaNegativaException {

        super(codigohabitacion, porcRecargo, tarifa, diasReserva);

        if (diasReserva <= 0) {
            throw new IllegalArgumentException(
                    "La Cantidad minima para reservar una Habitacion es de 1 dia"
            );
        }

        this.diasReserva = diasReserva;
    }

    public int getdiasReserva() {
        return diasReserva;
    }


    @Override
    public void revisarEstado() {

        int diasReserva = (-2);

        if (diasReserva = -2) {

            System.out.println(
                    " No se puede registrar con una cantidad de noches negativas"
            );

        } else() {

            System.out.println(
                    "AVISO: puede continuar con el registro"
            );

            if  (tarifa <= 0)

                System.out.println(
                        "De donde sacaste tarifas negativas?, NO SE PUEDE GENERAR EL CARGO"
                );

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

                if (diasReserva < 0) {

                    throw new NochesNegativasException(
                            "No se puede vender pues está ingresando un numero invalidode dias para reservar "
                }


            }

        }