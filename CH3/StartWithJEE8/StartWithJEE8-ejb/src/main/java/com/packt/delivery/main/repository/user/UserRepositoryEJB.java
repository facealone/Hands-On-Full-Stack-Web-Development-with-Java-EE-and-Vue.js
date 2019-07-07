package com.packt.delivery.main.repository.user;

import com.packt.delivery.abstraction.entity.User;
import com.packt.delivery.abstraction.repository.UserRepository;
import com.packt.delivery.main.repository.Infrastructure;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local
@Infrastructure
public class UserRepositoryEJB implements UserRepository{
    @Inject
    private UserRepositoryJPA userRepositoryJPA;

    @Override
    public List<User> getAll() {
        return userRepositoryJPA.getAll();
    }

    @Override
    public User save(User user) {
        return userRepositoryJPA.save(user);
    }

    @Override
    public User update(User user) {
        return userRepositoryJPA.update(user);
    }
}
