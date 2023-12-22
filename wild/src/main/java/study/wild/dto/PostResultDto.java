package study.wild.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostResultDto<T> {

    private T posts;
}
