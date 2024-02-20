package lessons.fourth.exception.service;

import java.util.ArrayList;
import java.util.List;
import lessons.fourth.exception.customException.DuplicateUserException;
import lessons.fourth.exception.customException.UserBlockedException;
import lessons.fourth.exception.customException.UserNotFoundException;
import lessons.fourth.exception.model.User;

public class UserManagerImpl implements UserManager {
    private final List<User> users;

    public UserManagerImpl() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                throw new DuplicateUserException("User with username '"
                        + user.getUsername() + "' already exists.");
            }
        }
        users.add(user);
    }

    @Override
    public void removeUser(String username) {
        boolean removed = false;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
                removed = true;
                break;
            }
        }
        if (!removed) {
            throw new UserNotFoundException("User with username '" + username + "' not found.");
        }
    }

    @Override
    public void editUser(String username, String newPassword) {
        boolean edited = false;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.setPassword(newPassword);
                edited = true;
                break;
            }
        }
        if (!edited) {
            throw new UserNotFoundException("User with username '" + username + "' not found.");
        }
    }

    @Override
    public void blockUser(String username) {
        boolean blocked = false;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (!user.isBlocked()) {
                    user.setBlocked(true);
                    blocked = true;
                } else {
                    throw new UserBlockedException("User with username '"
                            + username + "' is already blocked.");
                }
                break;
            }
        }
        if (!blocked) {
            throw new UserNotFoundException("User with username '" + username + "' not found.");
        }
    }

    @Override
    public void unblockUser(String username) {
        boolean unblocked = false;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.isBlocked()) {
                    user.setBlocked(false);
                    unblocked = true;
                } else {
                    throw new UserBlockedException("User with username '"
                            + username + "' is not blocked.");
                }
                break;
            }
        }
        if (!unblocked) {
            throw new UserNotFoundException("User with username '" + username + "' not found.");
        }
    }
}
