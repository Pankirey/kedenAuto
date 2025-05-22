package Utils;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class AuthApi {

    public static String getToken(String username, String password) {
        RestAssured.baseURI = "https://test-keden.codecraft.kz";

        return given()
                .contentType("application/json")
                .body("{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}")
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .extract()
                .path("token"); // подстрой под свой ключ
    }
}
