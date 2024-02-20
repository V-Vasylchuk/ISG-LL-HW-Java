package lessons.fourth;

import lessons.fourth.annotation.UserData;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        UserData firstUser = new UserData();
        UserData secondUser = new UserData();

        // set valid data
        firstUser.setUsername("user_name").setAge(18).validateData();
        secondUser.setUsername("second_user_name").setAge(18).validateData();

        // set invalid data, must throw exception with custom message
        firstUser.setUsername("Jo").validateData();
        secondUser.setAge(10).validateData();
    }
}
