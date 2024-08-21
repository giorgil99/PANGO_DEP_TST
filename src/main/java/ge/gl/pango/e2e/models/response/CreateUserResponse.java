package ge.gl.pango.e2e.models.response;

import lombok.Data;

@Data
public class CreateUserResponse {
    private String name,
            job,
            id,
            createdAt;

}
