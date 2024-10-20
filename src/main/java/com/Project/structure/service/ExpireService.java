package com.Project.structure.service;

import com.Project.structure.model.Expire;
import com.Project.structure.repository.ExpireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExpireService {

    @Autowired
    private ExpireRepository expireRepository;

    public List<Expire> getAllExpires() {
        return expireRepository.findAll();
    }

    public Optional<Expire> getExpireById(UUID expireId) {
        return expireRepository.findById(expireId);
    }

    public Expire createExpire(Expire expire) {
        return expireRepository.save(expire);
    }

    public Expire updateExpire(UUID expireId, Expire expire) {
        expire.setExpireId(expireId);
        return expireRepository.save(expire);
    }

    public void deleteExpire(UUID expireId) {
        expireRepository.deleteById(expireId);
    }
}
