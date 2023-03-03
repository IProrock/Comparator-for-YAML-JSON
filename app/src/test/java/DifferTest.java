import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public final class DifferTest {

    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;

    @BeforeAll
    public static void beforeAll() throws Exception {
        expectedStylish = readFixture("expectedStylishOrDefault.txt");
        expectedPlain = readFixture("expectedPlain.txt");
        expectedJson = readFixture("expectedJson.txt");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml", "yaml"})
    public void generateTest(String format) throws Exception {

        String file1Str = getFixturePath("./src/test/resources/file1." + format).toString();
        String file2Str = getFixturePath("./src/test/resources/file2." + format).toString();
        assertThat(Differ.generate(file1Str, file2Str, "stylish")).isEqualTo(expectedStylish);
        assertThat(Differ.generate(file1Str, file2Str)).isEqualTo(expectedStylish);
        assertThat(Differ.generate(file1Str, file2Str, "plain")).isEqualTo(expectedPlain);
        assertThat(Differ.generate(file1Str, file2Str, "json")).isEqualTo(expectedJson);
    }

    private static String readFixture(String fixture) throws Exception {
        Path fixturePath = Paths.get("./src/test/resources/" + fixture).toAbsolutePath().normalize();

        return Files.readString(fixturePath);
    }

    private static Path getFixturePath(String fixture) {
        Path fixturePath = Paths.get(fixture).toAbsolutePath().normalize();

        return fixturePath;
    }
}
