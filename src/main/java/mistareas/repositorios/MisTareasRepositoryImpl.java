package mistareas.repositorios;

import mistareas.entidades.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MisTareasRepositoryImpl implements MisTareasRepository {

    private final JdbcTemplate jdbcTemplate;

    public MisTareasRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Task> getMisTareas() {
        return jdbcTemplate.query(
                "SELECT * FROM task",
                (rs, rowNum) -> new Task(
                        rs.getLong("id"),
                        rs.getString("description"),
                        rs.getString("status")
                )
        );
    }

    @Override
    public Task getMiTarea(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM task WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Task(
                        rs.getLong("id"),
                        rs.getString("description"),
                        rs.getString("status")
                )
        );
    }

    @Override
    public void crearTarea(Task task) {
        jdbcTemplate.update(
                "INSERT INTO task (description, status) VALUES (?, ?)",
                task.getDescription(),
                task.getStatus()
        );
    }

    @Override

    public void actualizarTarea(Task task) {
        String sql = "UPDATE task SET description = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(
                sql,
                task.getDescription(),
                task.getStatus(),
                task.getId()
        );
    }

    @Override
    public void eliminarTarea(Long id) {
        jdbcTemplate.update("DELETE FROM task WHERE id = ?", id);

    }


}
