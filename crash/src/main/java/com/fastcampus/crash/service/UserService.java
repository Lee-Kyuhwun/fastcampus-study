package com.fastcampus.crash.service;


import com.fastcampus.crash.error.user.UserNotFoundException;
import com.fastcampus.crash.model.entity.UserEntity;
import com.fastcampus.crash.model.user.User;
import com.fastcampus.crash.model.user.UserAuthenticationResponse;
import com.fastcampus.crash.model.user.UserLoginRequestBody;
import com.fastcampus.crash.model.user.UserSignUpRequestBody;
import com.fastcampus.crash.repository.UserEntityRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  implements UserDetailsService {

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JwtService jwtService;

    // username으로 사용자를 찾는 메소드
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserEntityRepositoryByUsername(username);
    }


    public User signUp(UserSignUpRequestBody user) {

        getUserEntityRepositoryByUsername(user.username());



        // UserEntity를 저장
        UserEntity save = userEntityRepository.save(
                UserEntity.of(
                        user.username(),
                        bCryptPasswordEncoder.encode(user.password()), // 비밀번호는 암호화하여 저장
                        user.name(),
                        user.email()
                )

        );

        // 저장된 UserEntity를 User로 변환하�� 반환
        return User.from(save);
    }

    public UserAuthenticationResponse authenticate(@Valid UserLoginRequestBody userLoginRequestBody) {

        var userEntity = getUserEntityRepositoryByUsername(userLoginRequestBody.username());

        // 비밀번호가 일치하는지 확인
        if (!bCryptPasswordEncoder.matches(userLoginRequestBody.password(), userEntity.getPassword())) {
            throw new UserNotFoundException("Invalid password for user: " + userLoginRequestBody.username());
        }

        String accessToken = jwtService.generateAccessToken(userEntity);
        // 인증 성공 시 UserAuthenticationResponse 생성
        return new UserAuthenticationResponse(accessToken);
    }

    private UserEntity getUserEntityRepositoryByUsername(String userLoginRequestBody) {
        return userEntityRepository.findByUsername(userLoginRequestBody).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + userLoginRequestBody));
    }
}
