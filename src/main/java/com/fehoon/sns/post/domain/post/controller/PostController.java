package com.fehoon.sns.post.domain.post.controller;

import com.fehoon.sns.post.common.api.ApiResponse;
import com.fehoon.sns.post.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("Post")
public class PostController {

    private final PostService postService;

//    @GetMapping("{id}")
//    public ApiResponse<PostResponse>
}
