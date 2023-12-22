package study.wild.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    private String title;

    @Column(name = "post_content")
    private String content;

    private Long view;

    @Column(name = "post_created_date")
    private LocalDateTime createdDate;

    @Column(name = "post_deleted_date")
    private LocalDateTime deletedDate;

    @Column(name = "post_last_modified_date")
    private LocalDateTime lastModifiedDate;

    public Post() {
    }
}
