package com.miniblog.commentservice.service;

import com.miniblog.commentservice.dto.CommentRequestDTO;
import com.miniblog.commentservice.dto.CommentResponseDTO;

import java.util.List;

public interface CommentService {
    CommentResponseDTO addComment(CommentRequestDTO requestDTO);
    List<CommentResponseDTO> getCommentsByPostId(Long postId);
    void deleteComment(String id);
}
