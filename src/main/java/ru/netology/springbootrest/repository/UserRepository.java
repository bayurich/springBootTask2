package ru.netology.springbootrest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootrest.exception.InvalidCredentials;
import ru.netology.springbootrest.model.Authorities;
import ru.netology.springbootrest.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    ConcurrentMap<String, User> users = new ConcurrentHashMap<>();


    public UserRepository() {
        //terporary for test
        users.put("user1", new User("user1", "pass1", Set.of(Authorities.WRITE)));
        users.put("user2", new User("user2", "pass2", Set.of(Authorities.READ, Authorities.DELETE)));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        User userObject = getUser(user);
        if (userObject == null) {
            return null;
        }
        if (!password.equals(userObject.getPassword())) {
            throw new InvalidCredentials("Password is incorrect");
        }

        return new ArrayList<>(userObject.getAuthorities());
    }

    private User getUser(String user) {
        return users.get(user);
    }

}
