package com.fastcampus.crash.model.entity;

import com.fastcampus.crash.model.user.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "\"user\"",
indexes = {
        @Index(name = "user_usename_index", columnList = "username",unique = true)
}
) // user라는 테이블이 이미 존재하기 때문에 쌍따옴표를 추가하여 생성할 수 있도록 함
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserEntity implements UserDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private ZonedDateTime createdDateTime;



    @Override
    public boolean isAccountNonExpired() { // 정상인지 그런거 확인
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public static UserEntity of(String username, String password, String email, String name){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        userEntity.setName(name);
        userEntity.setRole(Role.USER);
        return userEntity;
    }

    @PrePersist// DB에 insert 하기 전에 실행
    public void onPersist(){
        this.createdDateTime = ZonedDateTime.now(); // 데이터베이스가 저장되기 직전에 현재 시간을 넣어줌
    }


}
