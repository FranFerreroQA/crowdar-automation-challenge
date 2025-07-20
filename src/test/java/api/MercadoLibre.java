package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MercadoLibre {

    public static Response getDepartments() {
        return RestAssured
                .given()
                .header("User-Agent", "Mozilla/5.0")
                .baseUri("https://www.mercadolibre.com.ar")
                .basePath("/menu/departments")
                .get();
    }
}

