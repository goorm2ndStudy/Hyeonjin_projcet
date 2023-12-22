package study.wild.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Comment {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post")
    private Post post;

    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime deletedDate;
    private LocalDateTime lastModifiedDate;


}
