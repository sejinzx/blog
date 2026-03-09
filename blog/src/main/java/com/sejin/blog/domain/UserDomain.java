package com.sejin.blog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.SoftDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@SoftDelete(columnName = "user_deleted")
@Table(name = "users")
public class UserDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq", nullable = false)
    private Long userSeq;

    @Column(name = "user_id", nullable = false)
    @Size(min = 6, max = 20)
    private String userId;

    @Column(name = "user_pw", nullable = false)
    private String userPw;

    @Column(name = "user_email", nullable = false)
    @Email
    private String userEmail;

    @Column(name = "user_nickname", nullable = false)
    private String userNickname;

    @Column(name = "user_created_date", nullable = false)
    @CreatedDate
    private LocalDateTime userCreatedDate;

    @Column(name = "user_update_date", nullable = false)
    @LastModifiedDate
    private LocalDateTime userUpdateDate;

    @Builder
    private UserDomain(String userId, String userPw, String userEmail, String userNickname){
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
        this.userNickname = userNickname;
    }

}
