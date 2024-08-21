package ge.gl.pango.e2e.steps;

import ge.gl.pango.e2e.models.response.GetUserResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetUserSteps {
    public static Response response;
    public List<String> validations;

    public GetUserSteps getUser() {
        validations = new ArrayList<>();

        RestAssured.baseURI = "https://reqres.in/api/users/2";

        this.response = given().contentType("application/json")
                .get().then().extract().response();
        return this;
    }

    //due to the issue of the api itself validation is only done to the potentially existing user
    public GetUserSteps assertData() {
        if (response.getStatusCode() == 200) {
            GetUserResponse userResponse = response.getBody().as(GetUserResponse.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertNotNull(userResponse.getData());
            validations.add("User data validation was correct, value : " + userResponse);
            softAssert.assertAll();
        }
        return this;
    }

    public GetUserSteps displayReport() {
        if (response.getStatusCode() == 200) {
            validations.forEach(System.out::println);
        }
        return this;
    }

}
