package co.edu.udec.congresistas.infrastructure.rest;

import co.edu.udec.congresistas.domain.model.Congresista;
import co.edu.udec.congresistas.domain.ports.inbound.CongresistaServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/congresistas")
public class CongresistaController {

    private final CongresistaServicePort service;

    public CongresistaController(CongresistaServicePort service) {
        this.service = service;
    }

    @PostMapping
    public Congresista crear(@RequestBody CongresistaDTO dto) {
        return service.crearCongresista(dto.nombre(), dto.correo());
    }

    @GetMapping
    public List<Congresista> listar() {
        return service.listarCongresistas();
    }

    @PutMapping("/{id}")
    public Congresista actualizar(@PathVariable Long id, @RequestBody CongresistaDTO dto) {
        return service.actualizarCongresista(id, dto.nombre(), dto.correo());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarCongresista(id);
    }
}
