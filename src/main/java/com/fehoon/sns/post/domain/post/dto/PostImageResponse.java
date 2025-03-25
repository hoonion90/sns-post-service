package com.fehoon.sns.post.domain.post.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class PostImageResponse {
    int sequence;
    String imageUrl;
}
