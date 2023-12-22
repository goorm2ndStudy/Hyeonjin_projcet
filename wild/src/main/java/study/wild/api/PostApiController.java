package study.wild.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.wild.domain.Comment;
import study.wild.domain.Post;
import study.wild.dto.PostDto;
import study.wild.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    /**
     * 등록
     */
    @PostMapping("/api/posts")
    public PostResponse createPost(@RequestBody PostRequest request) {

        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());

        Long id = postService.create(post);

        return new PostResponse(id, String.format("id = %d 인 post 가 저장되었습니다.", id));
    }

    /**
     * 조회 (전체)
     */
    @GetMapping("/api/posts")
    public Result getPosts() {
        List<Post> posts = postService.readAll();

        List<PostDto> collect = posts.stream()
                .map(p -> new PostDto(p.getTitle(), p.getContent()))
                .collect(Collectors.toList());

        return new Result(collect);
    }

    /**
     * 수정
     */
    @PutMapping("/api/posts/{id}")
    public PostResponse updatePost(@PathVariable(name = "id") Long id, @RequestBody PostDto updatePost) {
        postService.update(id, updatePost);
        return new PostResponse(id, String.format("id = %d 인 post 가 수정되었습니다.", id));
    }


    /**
     * 삭제
     */
    @DeleteMapping("/api/posts/{id}")
    public PostResponse deletePost(@PathVariable(name = "id") Long id) {
        Post post = postService.read(id);
        postService.delete(post);
        return new PostResponse(id, String.format("id = %d 인 post 가 삭제되었습니다.", id));
    }


    @Data
    static class PostRequest {
        private String title;
        private String content;
    }

    @Data
    static class PostResponse {
        private Long id;
        private String msg;

        public PostResponse(Long id, String msg) {
            this.id = id;
            this.msg = msg;
        }
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T posts;
    }



}
