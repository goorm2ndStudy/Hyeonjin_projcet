package study.wild.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import study.wild.domain.Comment;
import study.wild.domain.Post;
import study.wild.repository.PostRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
// @Transactional
public class PostServiceTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Test
    public void create() throws Exception {

        // Given
        Post post = new Post();
        post.setTitle("Title");
        post.setContent("Content");

        Comment comment = new Comment();
        comment.setContent("comment..");

        // When
        Long createdId = postService.create(post);
        commentService.create(post.getId(), comment);

        // Then
        assertEquals(post.getId(), postRepository.find(createdId).getId());

    }



}