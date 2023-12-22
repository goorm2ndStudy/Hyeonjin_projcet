package study.wild.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import study.wild.domain.Post;
import study.wild.dto.PostRequestDto;
import study.wild.dto.PostResponseDto;
import study.wild.dto.PostResultDto;
import study.wild.service.PostService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    /**
     * 등록
     */
    @PostMapping("/api/posts")
    public ResponseEntity<PostRequestDto> createPost(@RequestBody PostRequestDto request) {

        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        postService.create(post);

        PostResponseDto response = new PostResponseDto("게시글이 성공적으로 생성되었습니다.", post.getId(), LocalDateTime.now());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    /**
     * 조회 (전체)
     */
    @GetMapping("/api/posts")
    public PostResultDto getPosts() {
        List<Post> posts = postService.readAll();

        List<PostRequestDto> collect = posts.stream()
                .map(p -> new PostRequestDto(p.getId(), p.getTitle(), p.getContent()))
                .collect(Collectors.toList());

        return new PostResultDto(collect);
    }

    /**
     * 수정
     */
    @PutMapping("/api/posts/{id}")
    public ResponseEntity<PostRequestDto> updatePost(@PathVariable(name = "id") Long id, @RequestBody PostRequestDto updatePost) {
        postService.update(id, updatePost);

        PostResponseDto response = new PostResponseDto("게시글이 성공적으로 수정되었습니다.", id, LocalDateTime.now());
        return new ResponseEntity(response, HttpStatus.OK);
    }


    /**
     * 삭제
     */
    @DeleteMapping("/api/posts/{id}")
    public ResponseEntity<PostRequestDto> deletePost(@PathVariable(name = "id") Long id) {
        Post post = postService.read(id);
        postService.delete(post);

        PostResponseDto response = new PostResponseDto("게시글이 성공적으로 삭제되었습니다.", id, LocalDateTime.now());

        return new ResponseEntity(response, HttpStatus.OK);
    }


}
