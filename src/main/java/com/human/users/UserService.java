package com.human.users;
import com.human.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager em;

    public Iterable<User> getAll(){
        
        return userRepository.findAll();
    }

    public User save(User user) { return userRepository.save(user); }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User user, Long id) { user.setId(id); return userRepository.save(user);  }

}

