import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class LongRedirect {

    @Test
    public void testLongRedirect() {
        int statusCode = 0;
        String location = "https://playground.learnqa.ru/api/long_redirect";
        int count = -1;

        while (statusCode != 200) {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .get(location)
                .andReturn();

        count ++;
        statusCode = response.statusCode();
        System.out.println(statusCode);

        location = response.getHeader("Location");
        if (location != null) {
            System.out.println(location);
        } else {
            System.out.println("Количество редиректов " + count);
        }
    }
    }
}
