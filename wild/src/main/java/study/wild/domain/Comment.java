package study.wild.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "comment_content")
    private String content;

    @Column(name = "comment_created_date")
    private LocalDateTime createdDate;

    @Column(name = "comment_deleted_date")
    private LocalDateTime deletedDate;

    @Column(name = "comment_last_modified_date")
    private LocalDateTime lastModifiedDate;

}
