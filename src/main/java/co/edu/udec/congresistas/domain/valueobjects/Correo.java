package co.edu.udec.congresistas.domain.valueobjects;

import java.util.regex.Pattern;

public class Correo {

    private final String direccion;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public Correo(String direccion) {
        if (direccion == null || !EMAIL_PATTERN.matcher(direccion).matches()) {
            throw new IllegalArgumentException("El correo no es válido.");
        }
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }
}
