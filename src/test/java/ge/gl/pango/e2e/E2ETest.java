package ge.gl.pango.e2e;

import ge.gl.pango.e2e.models.reqeust.CreateUserRequest;
import ge.gl.pango.e2e.models.reqeust.UpdateUserRequest;
import ge.gl.pango.e2e.steps.CreateUserSteps;
import ge.gl.pango.e2e.steps.GetUserSteps;
import ge.gl.pango.e2e.steps.UpdateUserSteps;
import org.testng.annotations.Test;

public class E2ETest {


    @Test
    public void createUserTest() {
        var createUserRequest = new CreateUserRequest("gl", "physician");
        CreateUserSteps createUser = new CreateUserSteps();
        createUser.createUser(createUserRequest)
                .assertName(createUserRequest.getName())
                .assertJob(createUserRequest.getJob())
                .assertID()
                .assertCreatedAt()
                .displayReport();
    }

    @Test
    public void updateUserTest() {
        var updateUserRequest = new UpdateUserRequest("gl", "qa automation testing engineer");
        UpdateUserSteps updateUser = new UpdateUserSteps();
        updateUser.updateUser(updateUserRequest)
                .assertName(updateUserRequest.getName())
                .assertJob(updateUserRequest.getJob())
                .assertCreatedAt()
                .displayReport();
    }

    @Test(dependsOnMethods = "createUserTest")
    public void getUserTest() {
        GetUserSteps updateUser = new GetUserSteps();
        updateUser.getUser()
                .assertData()
                .displayReport();

    }
}
