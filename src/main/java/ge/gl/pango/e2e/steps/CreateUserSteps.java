package ge.gl.pango.e2e.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ge.gl.pango.e2e.models.reqeust.CreateUserRequest;
import ge.gl.pango.e2e.models.response.CreateUserResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateUserSteps {
    public static Response response;
    private List<String> validations;


    public CreateUserSteps createUser(CreateUserRequest createUserRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        this.validations = new ArrayList<>();
        RestAssured.baseURI = "https://reqres.in/api/users";
        String createUserRequestLiteral;
        try {
            createUserRequestLiteral = objectMapper.writeValueAsString(createUserRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        this.response = given().contentType("application/json")
                .body(createUserRequestLiteral)
                .post().then().extract().response();
        return this;
    }

    public CreateUserSteps assertName(String name) {
        if (response.getStatusCode() == 201) {
            CreateUserResponse userResponse = response.getBody().as(CreateUserResponse.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(userResponse.getName(), name);
            validations.add("User name validation was correct, value : " + userResponse.getName());
            softAssert.assertAll();
        }
        return this;
    }

    public CreateUserSteps assertJob(String job) {
        if (response.getStatusCode() == 201) {
            CreateUserResponse userResponse = response.getBody().as(CreateUserResponse.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(userResponse.getJob(), job);
            validations.add("User job validation was correct, value : " + userResponse.getJob());
            softAssert.assertAll();
        }
        return this;
    }

    public CreateUserSteps assertID() {
        if (response.getStatusCode() == 201) {
            CreateUserResponse userResponse = response.getBody().as(CreateUserResponse.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertNotNull(userResponse.getId());
            validations.add("User id validation was correct, value : " + userResponse.getId());
            softAssert.assertAll();
        }
        return this;
    }

    public CreateUserSteps assertCreatedAt() {
        if (response.getStatusCode() == 201) {
            CreateUserResponse userResponse = response.getBody().as(CreateUserResponse.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertNotNull(userResponse.getCreatedAt());
            validations.add("User createdAt validation was correct, value : " + userResponse.getCreatedAt());
            softAssert.assertAll();
        }
        return this;
    }

    public CreateUserSteps displayReport() {
        if (response.getStatusCode() == 201) {
            validations.forEach(System.out::println);
        }
        return this;
    }

}
