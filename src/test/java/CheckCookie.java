import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckCookie {

    @Test
    public void testCheckCookie() {
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        Map<String, String> cookies = response.getCookies();
//        cookies.forEach((key, value) -> {
//            System.out.println(key + " - " + value);
//        });
        assertEquals(200, response.getStatusCode(), "Unexpected status code");
        assertTrue(cookies.containsKey("HomeWork"), "Response doesn't have 'HomeWork' cookie key");
        assertTrue(cookies.containsValue("hw_value"), "Response doesn't have 'hw_value' cookie value");
    }
}
