package ge.gl.pango.e2e.models.response;

import lombok.Data;

@Data
public class UpdateUserResponse {
    private String name,
            job,
            updatedAt;

}
