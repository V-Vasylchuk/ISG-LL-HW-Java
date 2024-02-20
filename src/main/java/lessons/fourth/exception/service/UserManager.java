package lessons.fourth.exception.service;

import lessons.fourth.exception.model.User;

public interface UserManager {
    void addUser(User user);

    void removeUser(String username);

    void editUser(String username, String newPassword);

    void blockUser(String username);

    void unblockUser(String username);
}
