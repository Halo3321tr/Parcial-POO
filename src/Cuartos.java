public interface Cuartos {

    void vender(int cantidad)
            throws NochesNegativasException,
            TarifaNegativaException,
            CantidadInvalidaException;
}