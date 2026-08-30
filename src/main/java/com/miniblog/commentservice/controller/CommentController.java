package com.miniblog.commentservice.controller;

import com.miniblog.commentservice.dto.CommentRequestDTO;
import com.miniblog.commentservice.dto.CommentResponseDTO;
import com.miniblog.commentservice.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentResponseDTO> addComment(@RequestBody CommentRequestDTO requestDTO) {
        CommentResponseDTO created = commentService.addComment(requestDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentResponseDTO>> getCommentsByPostId(@PathVariable Long postId) {
        List<CommentResponseDTO> comments = commentService.getCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable String id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
