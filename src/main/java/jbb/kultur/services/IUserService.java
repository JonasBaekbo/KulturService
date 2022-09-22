package jbb.kultur.services;

import jbb.kultur.models.Band;
import jbb.kultur.models.User;

import java.util.List;

public interface IUserService extends ICrudService<User,Long> {
    List<User> findUserByName(String name);
}
