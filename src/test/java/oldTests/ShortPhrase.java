package oldTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortPhrase {

    @ParameterizedTest
    @ValueSource(strings = {"qwerty", "1234567891013141234243534253246"})
    public void testShortPhrase(String word) {

        if (word.length() > 15) {
            assertTrue(word.length() > 15, "Текст должен быть длиннее 15 символов");
        } else {
            assertFalse(word.length() > 15, "Текст должен быть длиннее 15 символов");
        }
    }
}
