import org.apache.pig.pigunit.PigTest;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;

import java.io.IOException;

public class ScriptPigOrderAlphabetTest {

    private String scriptPath = "./src/main/script_order_alphabet.pig";

    @Test
    public void data_ordered_shouldOrderElementsBy_Alphabet() throws IOException, ParseException {
        // Given
        PigTest test = new PigTest(scriptPath);

        String[] input = {
                "yahoo",
                "twitter",
                "facebook",
                "linkedin",
        };

        String[] expected = {
                "(facebook)",
                "(linkedin)",
                "(twitter)",
                "(yahoo)",
        };

        // When
        test.runScript();

        // Then
        test.assertOutput("data", input, "data_ordered", expected);
    }
}

