import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {

    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;

    @BeforeAll
    public static void beforeAll() throws Exception {
        expectedStylish = readFixture("expectedStylishOrDefault.txt");
        expectedPlain = readFixture("expectedPlain.txt");
        expectedJson = readFixture("expectedJson.txt");
    }

    @Test
    public void testJsonValidCase() throws Exception {

        Path file1 = Paths.get("./src/test/resources/file1.json").toAbsolutePath().normalize();
        Path file2 = Paths.get("./src/test/resources/file2.json").toAbsolutePath().normalize();
        assertThat(Differ.generate(file1.toString(), file2.toString(), "stylish")).isEqualTo(expectedStylish);
        assertThat(Differ.generate(file1.toString(), file2.toString())).isEqualTo(expectedStylish);
        assertThat(Differ.generate(file1.toString(), file2.toString(), "plain")).isEqualTo(expectedPlain);
        assertThat(Differ.generate(file1.toString(), file2.toString(), "json")).isEqualTo(expectedJson);
    }

    @Test
    public void testYmlValidCase() throws Exception {
        Path file1 = Paths.get("./src/test/resources/file1.yml").toAbsolutePath().normalize();
        Path file2 = Paths.get("./src/test/resources/file2.yml").toAbsolutePath().normalize();
        Path file2Yaml = Paths.get("./src/test/resources/file2.yaml").toAbsolutePath().normalize();
        assertThat(Differ.generate(file1.toString(), file2.toString(), "stylish")).isEqualTo(expectedStylish);
        assertThat(Differ.generate(file1.toString(), file2.toString(), "plain")).isEqualTo(expectedPlain);
        assertThat(Differ.generate(file1.toString(), file2.toString(), "json")).isEqualTo(expectedJson);
        assertThat(Differ.generate(file1.toString(), file2Yaml.toString())).isEqualTo(expectedStylish);
    }

    public static String readFixture(String fixture) throws Exception {
        Path fixturePath = Paths.get("./src/test/resources/" + fixture).toAbsolutePath().normalize();

        return Files.readString(fixturePath);
    }
}
