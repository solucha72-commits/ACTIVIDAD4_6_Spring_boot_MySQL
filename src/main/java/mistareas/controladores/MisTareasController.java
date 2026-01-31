package mistareas.controladores;

import mistareas.entidades.Task;
import mistareas.servicios.MisTareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class MisTareasController {
    private final MisTareasService misTareasService;

    @Autowired
    public MisTareasController(MisTareasService misTareasService){
        this.misTareasService = misTareasService;
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody Task task) {
        misTareasService.crearTarea(task);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Task> obtenerTodos() {
        return misTareasService.getMisTareas();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Task> obtenerPorId(@PathVariable Long id) {
        Task tarea = misTareasService.getMiTarea(id);

        if (tarea != null) {
            return new ResponseEntity<>(tarea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public void actualizarTarea(
            @PathVariable Long id,
            @RequestBody Task task) {

        task.setId(id);
        misTareasService.actualizarTarea(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        misTareasService.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }
}
