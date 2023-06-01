package task;

public class Person {
    private int age;
    private String name;
    private String gender;
    private int mobile;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if (isValidAge(age)) {
            this.age = age;
            return;
        }

        throw new AgeException(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NameException {
        if (isValidNameLength(name) && isValidNameValue(name)) {
            this.name = name;

            return;
        }

        throw new NameException(name);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) throws GenderException {
        if (isValidGenderValue(gender)) {
            this.gender = gender;

            return;
        }

        throw new GenderException(gender);
    }

    public int getMobile() {
        return mobile;
    }

    public void  setMobile(int mobile) throws MobileException {
        if (isValidMobileLength(mobile) && isValidMobileValue(mobile)) {
            this.mobile = mobile;

            return;
        }

        throw new MobileException("Invalid mobile number! Mobile number should start with either 59 or 56, followed by 7 digits.");
    }

    public boolean isValidNameValue(String name) {
        return name.matches("[A-Za-z]+");
    }

    public boolean isValidNameLength(String name) {
        int length = name.length();

        return length >= 3 && length <= 15;
    }

    public boolean isValidAge(int age) {
        return age >= 18 && age <= 60;
    }

    public boolean isValidMobileLength(int mobile) {
        return String.valueOf(mobile).length() == 9;
    }

    public boolean isValidGenderValue(String gender) {
        return gender.equals("male") || gender.equals("female");
    }

    public boolean isValidMobileValue(int mobile) {
        String mobileString = String.valueOf(mobile);

        return mobileString.startsWith("59") || mobileString.startsWith("56");
    }
}
