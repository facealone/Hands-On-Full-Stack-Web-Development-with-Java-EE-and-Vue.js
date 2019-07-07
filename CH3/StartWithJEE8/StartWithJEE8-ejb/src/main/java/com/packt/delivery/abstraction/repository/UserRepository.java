package com.packt.delivery.abstraction.repository;

import com.packt.delivery.abstraction.entity.User;
import java.util.List;

public interface UserRepository {
    List<User> getAll();
    User save(User user);
    User update(User user);
}
