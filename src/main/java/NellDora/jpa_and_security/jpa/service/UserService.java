package NellDora.jpa_and_security.jpa.service;

import NellDora.jpa_and_security.jpa.dao.userRepository.UserRepository;
import NellDora.jpa_and_security.jpa.dto.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public int LevelUp(User user){

        return 1;
    }
}
