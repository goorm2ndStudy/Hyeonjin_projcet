package study.wild.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import study.wild.domain.Comment;

import java.util.List;

@Repository
public class CommentRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Comment comment) {
        em.persist(comment);
    }

    public Comment find(Long id) {
        return em.find(Comment.class, id);
    }

    public List<Comment> findAll() {
        return em.createQuery("select c from Comment c", Comment.class)
                .getResultList();
    }



}
