package user;

import exceptions.NoSuchElementException;
import exceptions.ValidationException;
import java.util.Map;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository = UserRepository.getInstance();

    public void createNewUser(int id, String name, String email, int age) {
        try {
            if (id <= 0) {
                throw new ValidationException("Entered number should be positive");
            }
            if (name.isBlank()) {
                throw new ValidationException("You should enter your user name");
            }
            if (email.isBlank()) {
                throw new ValidationException("You should enter your user email");
            }
            if (age <= 0) {
                throw new ValidationException("Entered number should be positive");
            }
            User user = new User(id, name, email, age);
            userRepository.addUser(id, user);
        } catch (ValidationException e) {
            System.out.println("Invalid parameters were entered. Creation failed.");
        }
    }

    public Map<Integer, User> getUsers() {
        return userRepository.getUsers();
    }

    public Optional<User> retrieveUser(int userId) {
        return userRepository.getUserById(userId);
    }

    public void deleteUser(int userId) {
        try {
            if (retrieveUser(userId).isEmpty()) {
                throw new NoSuchElementException("Such user does not exist");
            }
            userRepository.deleteUserById(userId);
            System.out.println("User was deleted");
        } catch (NoSuchElementException e) {
            System.out.println("Such user does not exist");
        }
    }

    public void updateUserId(int userId, User user) {
        try {
            if (retrieveUser(userId).isEmpty()) {
                throw new NoSuchElementException("Such user does not exist");
            }
            userRepository.updateUserById(userId, user);
            System.out.println("User was updated");
        } catch (NoSuchElementException e) {
            System.out.println("Such user does not exist");
        }
    }
}
