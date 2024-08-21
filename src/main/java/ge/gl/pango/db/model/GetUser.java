package ge.gl.pango.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUser {
    private int id;
    private String name, job;
}
