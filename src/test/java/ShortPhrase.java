import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortPhrase {

    @Test
    public void testShortPhraseNegative() {
        String shortWord = "qwerty";

        assertFalse(shortWord.length() > 15, "Текст должен быть длиннее 15 символов");
    }

    @Test
    public void testShortPhrasePostitive() {
        String longWord = "1234567891013141234243534253246";

        assertTrue(longWord.length() > 15, "Текст должен быть длиннее 15 символов");
    }
}
