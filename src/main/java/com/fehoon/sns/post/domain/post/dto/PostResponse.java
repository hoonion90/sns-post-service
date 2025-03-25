package com.fehoon.sns.post.domain.post.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class PostResponse {
    Long id;
    Long userId;
    List<PostImageResponse> images;
    LocalDateTime createdAt;
}
