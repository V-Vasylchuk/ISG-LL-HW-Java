package lessons.fourth.annotation;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        UserData firstUser = new UserData();
        UserData secondUser = new UserData();

        // set valid data
        firstUser.setUsername("user_name").setAge(18).validateData();
        secondUser.setUsername("second_user_name").setAge(18).validateData();

        // set invalid data, must throw exception with custom message
        try{
            firstUser.setUsername("Jo").validateData();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try{
            secondUser.setAge(10).validateData();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
