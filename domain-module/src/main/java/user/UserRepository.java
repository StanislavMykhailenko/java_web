package user;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class UserRepository {
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if(Objects.isNull(instance)) {
            instance = new UserRepository();
        }
        return instance;
    }

    private final Map<Integer, User> users = usersStorage();

    private Map<Integer, User> usersStorage() {
        Map<Integer, User> users = new HashMap<>();
        users.put(1, new User(1, "Stas", "s.mykhailenko@spd-ukraine.com", 27));
        return users;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(users.get(id));
    }

    public void addUser(Integer userId, User user) {
        users.put(userId, user);
    }

    public void deleteUserById(int userId) {
        users.remove(userId);
    }

    public Map updateUserById(Integer id, User user) {
        users.put(id, user);
        return users;
    }
}
