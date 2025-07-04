package chapter3AutomatedFunctionalTesting;

import chapter3AutomatedFunctionalTesting.models.LoginDetails;
import chapter3AutomatedFunctionalTesting.utilities.TestData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

// API Testing Exercise ( REST Assured )
public class ItemsTests {

    // GET data
    @Test
    public void verifyGetProductsListEndPointReturnsSuccessStatusCode(){
        given().
                when().
                get("https://automationexercise.com/api/productsList").
                then()
                .assertThat()
                .statusCode(200);
    }

    // POST data
    @Test
    public void verifyLoginEndPointReturnsSuccessStatusCode(){
        LoginDetails loginTest = new LoginDetails(TestData.EMAIL_TEST, TestData.PASSWORD_TEST);
        given().
                contentType(ContentType.JSON).
                body(loginTest).
                log().body().
                when().
                get("https://automationexercise.com/api/verifyLogin").
                then()
                .assertThat()
                .statusCode(200);
    }
}
