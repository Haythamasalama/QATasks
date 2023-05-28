package task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    final private Person person = new Person();

    @ParameterizedTest
    @CsvSource({
            "18",
            "19",
            "30",
            "59",
            "60",
    })
    public void testCanCreatePersonAgeBetween18and60(int age) {
        assertDoesNotThrow(() -> person.setAge(age));
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "17",
            "61",
    })
    public void testCanNotCreatePersonAgeNotBetween18and60(int age) {
        assertThrows(AgeException.class, () -> person.setAge(age));
    }

    @ParameterizedTest
    @CsvSource({
            "Haytham",
            "Salama",
            "Hay",
            "Hayt",
            "HaythamASalama", // 14
            "HaythamASalamaH", // 15
    })
    public void testCanCreateValidNamePerson(String name) {
        assertDoesNotThrow(() -> person.setName(name));
    }

    @ParameterizedTest
    @CsvSource({
            "Ha",
            "Hay th",
            "Haytham#@$+",
            "_@#!#!",
            "تجريب",
            "HaythamASalamaHa", // 16
    })
    public void testCanNotCreateInvalidNamePerson(String name) {
        assertThrows(NameException.class, () -> person.setName(name));
    }

    @Test
    public void testCanNotCreateInvalidNamePersonWithSpace() {
        assertThrows(NameException.class, () -> person.setName(""));
        assertThrows(NameException.class, () -> person.setName(" "));
    }

    @ParameterizedTest
    @CsvSource({
            "male",
            "female",
    })
    public void testCanCreateValidGenderPerson(String gender) {
        assertDoesNotThrow(() -> person.setGender(gender));
    }

    @ParameterizedTest
    @CsvSource({
            "F",
            "M",
            "MALE",
            "FEMALE",
            "Male",
            "Female",
            "Haytham",
    })
    public void testCanNotCreateInvalidGenderPerson(String gender) {
        assertThrows(GenderException.class, () -> person.setGender(gender));
    }

    @ParameterizedTest
    @CsvSource({
            "599999999",
            "569999999",
    })
    public void testCanCreateValidMobilePerson(int mobile) {
        assertDoesNotThrow(() -> person.setMobile(mobile));
    }

    @ParameterizedTest
    @CsvSource({
            "519999999", // not 59 or 56
            "119999999", // not 59 or 56
            "51999999", // not 9
    })
    public void testCanNotCreateInvalidMobilePerson(int mobile) {
        assertThrows(MobileException.class, () -> person.setMobile(mobile));
    }
}
