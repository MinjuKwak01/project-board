package com.fastcampus.projectboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),

})
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 autoincrement
    private Long id; //pk

    //사용자가 직접 세팅 (임의로 바꿀 수 있음)
    @Setter @Column(nullable=false) private String title; //제목
    @Setter @Column(nullable=false, length=10000) private String content; //본문

     @Setter private String hashtag; //해시태그

    //자동으로 세팅 :jpa auditing -jpa config
    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt; //생성일시
    @CreatedBy @Column(nullable = false, length=100) private String createdBy; //생성자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; //수정일시
    @LastModifiedBy @Column(nullable = false, length=100) private String motifiedBy; //수정자


}
