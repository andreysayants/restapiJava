import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckHeader {

    @Test
    public void testCheckHeader() {
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        Headers headers = response.getHeaders();
        System.out.println(headers);

        String headerValue = headers.getValue("x-secret-homework-header");

        assertEquals(200, response.getStatusCode(), "Unexpected status code");
        assertTrue(headers.hasHeaderWithName("x-secret-homework-header"), "Response doesn't have 'x-secret-homework-header' header");
        assertEquals("Some secret value", headerValue, "Header 'x-secret-homework-header' doesn't have value 'Some secret value'" );
    }
}
