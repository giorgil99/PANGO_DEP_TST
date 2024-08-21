package ge.gl.pango.e2e.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ge.gl.pango.e2e.models.reqeust.UpdateUserRequest;
import ge.gl.pango.e2e.models.response.UpdateUserResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UpdateUserSteps {
    public static Response response;
    private List<String> validations;

    public UpdateUserSteps updateUser(UpdateUserRequest updateUserRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        validations = new ArrayList<>();
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        String createUserRequestLiteral;
        try {
            createUserRequestLiteral = objectMapper.writeValueAsString(updateUserRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        this.response = given().contentType("application/json")
                .body(createUserRequestLiteral)
                .put().then().extract().response();
        return this;
    }

    public UpdateUserSteps assertName(String name) {
        if (response.getStatusCode() == 200) {
            UpdateUserResponse userResponse = response.getBody().as(UpdateUserResponse.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(userResponse.getName(), name);
            validations.add("User name validation was correct, value : " + userResponse.getName());
            softAssert.assertAll();
        }
        return this;
    }

    public UpdateUserSteps assertJob(String job) {
        if (response.getStatusCode() == 200) {
            UpdateUserResponse userResponse = response.getBody().as(UpdateUserResponse.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(userResponse.getJob(), job);
            validations.add("User job validation was correct, value : " + userResponse.getJob());
            softAssert.assertAll();
        }
        return this;
    }

    public UpdateUserSteps assertCreatedAt() {
        if (response.getStatusCode() == 200) {
            UpdateUserResponse userResponse = response.getBody().as(UpdateUserResponse.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertNotNull(userResponse.getUpdatedAt());
            validations.add("User createdAt validation was correct, value : " + userResponse.getUpdatedAt());
            softAssert.assertAll();
        }
        return this;
    }

    public UpdateUserSteps displayReport() {
        if (response.getStatusCode() == 200) {
            validations.forEach(System.out::println);
        }
        return this;
    }

}
