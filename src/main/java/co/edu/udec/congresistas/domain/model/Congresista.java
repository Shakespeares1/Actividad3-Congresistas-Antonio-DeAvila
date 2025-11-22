package co.edu.udec.congresistas.domain.model;

import co.edu.udec.congresistas.domain.valueobjects.Correo;
import co.edu.udec.congresistas.domain.valueobjects.Nombre;

public class Congresista {

    private final Long id;
    private final Nombre nombre;
    private final Correo correo;

    public Congresista(Long id, Nombre nombre, Correo correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Correo getCorreo() {
        return correo;
    }
}
