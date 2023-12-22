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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private Category category;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();
    private String title;
    private String content;
    private Long view;
    private LocalDateTime createdDate;
    private LocalDateTime deletedDate;
    private LocalDateTime lastModifiedDate;

    public Post() {
    }
}
