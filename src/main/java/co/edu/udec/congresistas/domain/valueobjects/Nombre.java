package co.edu.udec.congresistas.domain.valueobjects;

public class Nombre {

    private final String valor;

    public Nombre(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
