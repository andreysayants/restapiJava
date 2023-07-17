package oldTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class Tokens {

    @Test
    public void testTokens() throws InterruptedException {
        String result = null;

        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String token = response.get("token");
        int seconds = response.get("seconds");
        System.out.println("Токен " + token);
        System.out.println("Количество секунд, через сколько задача будет выполнена " + seconds);

        while (result == null) {
            JsonPath response2 = RestAssured
                    .given()
                    .queryParam("token", token)
                    .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                    .jsonPath();
            String status = response2.get("status");
            if (status.equals("Job is NOT ready")) {
                System.out.println("Job is NOT ready");
                Thread.sleep(seconds * 1000);
            } else if (status.equals("Job is ready")) {
                System.out.println("Job is ready");
                result = response2.get("result");
                System.out.println("Результат " + result);
            }

        }
    }
}

