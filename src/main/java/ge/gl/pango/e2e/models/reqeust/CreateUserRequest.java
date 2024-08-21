package ge.gl.pango.e2e.models.reqeust;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserRequest {
    private String name,
            job;

}
