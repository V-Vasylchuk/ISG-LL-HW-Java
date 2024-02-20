package lessons.fourth.annotation;

import java.lang.reflect.Field;

public class UserData {
    @DataValidation(type = "STRING_LENGTH", minLength = 3, maxLength = 20)
    private String username;
    @DataValidation(type = "RANGE", minValue = 14, maxValue = 120)
    private int age;

    public UserData setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserData setAge(int age) {
        this.age = age;
        return this;
    }

    public void validateData() throws IllegalAccessException {
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(DataValidation.class)) {
                field.setAccessible(true);
                Object value = field.get(this);
                DataValidation dataValidation = field.getAnnotation(DataValidation.class);
                String type = dataValidation.type();
                switch (type) {
                    case "STRING_LENGTH":
                        validateStringLength(value,
                                dataValidation.minLength(),
                                dataValidation.maxLength());
                        break;
                    case "RANGE":
                        validateRange(value,
                                dataValidation.minValue(),
                                dataValidation.maxValue());
                        break;
                }
            }
        }
    }

    private static void validateStringLength(Object value, int minLength, int maxLength) {
        if (!(value instanceof String)) {
            return;
        }
        String stringValue = (String) value;
        int length = stringValue.length();
        if (length < minLength || length > maxLength) {
            throw new IllegalArgumentException("Invalid string length for field: " + stringValue
                    + " valid length is " + minLength + "-" + maxLength);
        }
    }

    private static void validateRange(Object value, int minValue, int maxValue) {
        if (!(value instanceof Integer)) {
            return;
        }
        int intValue = (Integer) value;
        if (intValue < minValue || intValue > maxValue) {
            throw new IllegalArgumentException("Value out of range("
                    + minValue + "-" + maxValue + ") for field: " + intValue);
        }
    }
}
