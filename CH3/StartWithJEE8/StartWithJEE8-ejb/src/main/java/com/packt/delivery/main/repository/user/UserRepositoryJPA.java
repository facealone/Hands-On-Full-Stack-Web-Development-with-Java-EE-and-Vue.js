package com.packt.delivery.main.repository.user;

import com.packt.delivery.abstraction.entity.User;
import com.packt.delivery.abstraction.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

public class UserRepositoryJPA implements UserRepository {

    private final EntityManager entityManager;

    public UserRepositoryJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public User save(User user) {
        UserData userData = new UserData();
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());

        entityManager.persist(userData);

        return user;
    }

    @Override
    public User update(User user) {
        UserData userData = new UserData();
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());

        entityManager.merge(userData);

        return user;
    }

    @Override
    public List<User> getAll() {
        return entityManager.createNamedQuery("UserData.findAll", UserData.class)
                .getResultList()
                .stream()
                .map(user -> new User(user.getEmail(), user.getPassword(), null))
                .collect(Collectors.toList());
    }

}
