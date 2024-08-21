package ge.gl.pango.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddUser {
    private String name, job;
}
