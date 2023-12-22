package study.wild.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponseDto {

    private String message;
    private Long postId;
    private LocalDateTime dateTime;

    public PostResponseDto(String message, Long postId, LocalDateTime dateTime) {
        this.message = message;
        this.postId = postId;
        this.dateTime = dateTime;
    }

    public PostResponseDto() {
    }

}
