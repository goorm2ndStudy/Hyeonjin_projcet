package study.wild.service;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.wild.domain.Comment;
import study.wild.domain.Post;
import study.wild.repository.CommentRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final EntityManager em;

    @Transactional
    public Long create(Long postId, Comment comment) {

        Post post = em.find(Post.class, postId);

        post.getComments().add(comment);
        comment.setPost(post);

        commentRepository.save(comment);
        return comment.getId();
    }

}
