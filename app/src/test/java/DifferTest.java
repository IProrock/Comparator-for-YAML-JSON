import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {

    String expectedStylish = """
            {
                chars1: [a, b, c]
              - chars2: [d, e, f]
              + chars2: false
              - checked: false
              + checked: true
              - default: null
              + default: [value1, value2]
              - id: 45
              + id: null
              - key1: value1
              + key2: value2
                numbers1: [1, 2, 3, 4]
              - numbers2: [2, 3, 4, 5]
              + numbers2: [22, 33, 44, 55]
              - numbers3: [3, 4, 5]
              + numbers4: [4, 5, 6]
              + obj1: {nestedKey=value, isNested=true}
              - setting1: Some value
              + setting1: Another value
              - setting2: 200
              + setting2: 300
              - setting3: true
              + setting3: none
            }""";

    String expectedPlain = """
            Property 'chars2' was updated. From [complex value] to false
            Property 'checked' was updated. From false to true
            Property 'default' was updated. From null to [complex value]
            Property 'id' was updated. From 45 to null
            Property 'key1' was removed
            Property 'key2' was added with value: 'value2'
            Property 'numbers2' was updated. From [complex value] to [complex value]
            Property 'numbers3' was removed
            Property 'numbers4' was added with value: [complex value]
            Property 'obj1' was added with value: [complex value]
            Property 'setting1' was updated. From 'Some value' to 'Another value'
            Property 'setting2' was updated. From 200 to 300
            Property 'setting3' was updated. From true to 'none'""";

    String expectedJson = "{\"chars1\":{\"Status\":\"unchanged\",\"Old value\":[\"a\",\"b\",\"c\"],"
            + "\"New value\":[\"a\",\"b\",\"c\"]},\"chars2\":{\"Status\":\"changed\",\"Old value\":[\"d\",\"e\",\"f\"],"
            + "\"New value\":false},\"checked\":{\"Status\":\"changed\",\"Old value\":false,\"New value\":true},"
            + "\"default\":{\"Status\":\"changed\",\"Old value\":null,\"New value\":[\"value1\",\"value2\"]},"
            + "\"id\":{\"Status\":\"changed\",\"Old value\":45,\"New value\":null},\"key1\":{\"Status\":\"removed\","
            + "\"Old value\":\"value1\",\"New value\":null},\"key2\":{\"Status\":\"added\",\"Old value\":null,"
            + "\"New value\":\"value2\"},\"numbers1\":{\"Status\":\"unchanged\",\"Old value\":[1,2,3,4],"
            + "\"New value\":[1,2,3,4]},\"numbers2\":{\"Status\":\"changed\",\"Old value\":[2,3,4,5],"
            + "\"New value\":[22,33,44,55]},\"numbers3\":{\"Status\":\"removed\",\"Old value\":[3,4,5],"
            + "\"New value\":null},\"numbers4\":{\"Status\":\"added\",\"Old value\":null,\"New value\":[4,5,6]},"
            + "\"obj1\":{\"Status\":\"added\",\"Old value\":null,"
            + "\"New value\":{\"nestedKey\":\"value\",\"isNested\":true}},"
            + "\"setting1\":{\"Status\":\"changed\",\"Old value\":\"Some value\","
            + "\"New value\":\"Another value\"},\"setting2\":{\"Status\":\"changed\",\"Old value\":200,"
            + "\"New value\":300},\"setting3\":{\"Status\":\"changed\",\"Old value\":true,\"New value\":\"none\"}}";

    @Test
    public void testJsonValidCase() throws Exception {

        Path file1 = Paths.get("./src/test/resources/file1.json").toAbsolutePath().normalize();
        Path file2 = Paths.get("./src/test/resources/file2.json").toAbsolutePath().normalize();
        assertThat(Differ.generate(file1.toString(), file2.toString(), "stylish")).isEqualTo(expectedStylish);
        assertThat(Differ.generate(file1.toString(), file2.toString(), "plain")).isEqualTo(expectedPlain);
        assertThat(Differ.generate(file1.toString(), file2.toString(), "json")).isEqualTo(expectedJson);

    }

    @Test
    public void testYmlValidCase() throws Exception {
        Path file1 = Paths.get("./src/test/resources/file1.yml").toAbsolutePath().normalize();
        Path file2 = Paths.get("./src/test/resources/file2.yml").toAbsolutePath().normalize();
        assertThat(Differ.generate(file1.toString(), file2.toString(), "stylish")).isEqualTo(expectedStylish);
        assertThat(Differ.generate(file1.toString(), file2.toString(), "plain")).isEqualTo(expectedPlain);
        assertThat(Differ.generate(file1.toString(), file2.toString(), "json")).isEqualTo(expectedJson);
    }

}
