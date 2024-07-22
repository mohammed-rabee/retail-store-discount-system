package org.blackstone.retail.service.impl;

import lombok.RequiredArgsConstructor;
import org.blackstone.retail.domain.entity.User;
import org.blackstone.retail.repository.UserRepository;
import org.blackstone.retail.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }
}
