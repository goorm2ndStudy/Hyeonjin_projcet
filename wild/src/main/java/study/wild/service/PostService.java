package study.wild.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.wild.domain.Post;
import study.wild.dto.PostDto;
import study.wild.repository.PostRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long create(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    public Post read(Long postId) {
        return postRepository.find(postId);
    }

    public List<Post> readAll() {
        return postRepository.findAll();
    }

    @Transactional
    public PostDto update(Long id, PostDto post) {
        Post originPost = postRepository.find(id);
        originPost.setTitle(post.getTitle());
        originPost.setContent(post.getContent());
        return new PostDto(originPost.getTitle(), originPost.getContent());
    }

    @Transactional
    public Long delete(Post post) {
        return postRepository.delete(post);
    }


}
