package study.wild.dto;

import lombok.Data;


@Data
public class PostRequestDto {

    private Long id;
    private String title;
    private String content;

    public PostRequestDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public PostRequestDto() {
    }
}
