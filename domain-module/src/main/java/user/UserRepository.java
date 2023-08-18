package user;

import java.util.ArrayList;
import java.util.List;
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

    private final List<User> users = usersStorage();

    private List<User> usersStorage() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Stas", "s.mykhailenko@spd-ukraine.com", 27));
        return users;
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return users.stream().filter(user -> user.getId() == (id)).findFirst();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUserById(int userId) {
        users.removeIf(user -> userId == user.getId());
    }

    public Optional updateUserById(int id, Integer newId) {
        return users.stream().filter(user -> user.getId() == (id)).findFirst().get().setId(newId);
    }
}
