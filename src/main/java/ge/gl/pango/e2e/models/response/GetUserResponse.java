package ge.gl.pango.e2e.models.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GetUserResponse {
    private UserData data;
    private Support support;
}
