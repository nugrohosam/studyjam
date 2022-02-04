package com.nugrohosamiyono.studyjam.presist.usecases;

import java.util.List;

import com.nugrohosamiyono.studyjam.application.request.v1.UserCreate;
import com.nugrohosamiyono.studyjam.application.request.v1.UserUpdate;
import com.nugrohosamiyono.studyjam.presist.models.User;
import com.nugrohosamiyono.studyjam.presist.repos.UserRepo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserUseCase {

    private UserRepo repo;

    @Cacheable("users")
    public List<User> getAll() {
        return repo.findAll();
    }

    @CacheEvict(value="users", allEntries=true)
    public void createUser(UserCreate userCreate) {
        var newUser = new User();
        newUser.setName(userCreate.getName());
        newUser.setAge(userCreate.getAge().intValue());

        saveUser(newUser);
    }

    @CacheEvict(value="users", allEntries=true)
    public void updateUser(Long id, UserUpdate userUpdate) throws Exception {
        var oldUser = repo.findById(id).orElseThrow(() -> new Exception("user tidak ditemukan"));
        oldUser.setAge(userUpdate.getAge());

        saveUser(oldUser);
    }

    @CacheEvict(value="users", allEntries=true)
    public void deleteUser(Long id) throws Exception {
        repo.deleteById(id);
    }

    private void saveUser(User user){
        repo.save(user);
    }
}
