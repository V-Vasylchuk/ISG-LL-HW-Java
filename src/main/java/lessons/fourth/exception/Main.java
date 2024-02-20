package lessons.fourth.exception;

import lessons.fourth.exception.customException.DuplicateUserException;
import lessons.fourth.exception.customException.UserBlockedException;
import lessons.fourth.exception.customException.UserNotFoundException;
import lessons.fourth.exception.model.User;
import lessons.fourth.exception.service.UserManagerImpl;

public class Main {
    public static void main(String[] args) {
        UserManagerImpl userManager = new UserManagerImpl();

        // add users
        try {
            userManager.addUser(new User("user1", "password1"));
            userManager.addUser(new User("user2", "password2"));
            userManager.addUser(new User("user3", "password3"));
            // add duplicate
            userManager.addUser(new User("user3", "password3"));
        } catch (DuplicateUserException e) {
            System.out.println(e.getMessage());
        }

        // check correct adding users
        System.out.println("Users:");
        for (User user : userManager.getUsers()) {
            System.out.print(user.getUsername());
        }

        // edit password by username
        try {
            userManager.editUser("user1", "newpassword1");
            // invalid user name
            userManager.editUser("user", "newpassword1");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // block user
        try {
            userManager.blockUser("user2");
            // try block when user is blocked
            userManager.blockUser("user2");
        } catch (UserNotFoundException | UserBlockedException e) {
            System.out.println(e.getMessage());
        }

        // unlock user
        try {
            userManager.unblockUser("user2");
            // try to unblock when user is blocked
            userManager.unblockUser("user2");
        } catch (UserNotFoundException | UserBlockedException e) {
            System.out.println(e.getMessage());
        }

        // remove user
        try {
            userManager.removeUser("user3");
            // try to delete user which does not exist
            userManager.removeUser("user3");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
