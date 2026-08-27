package com.miniblog.commentservice.mapper;

import com.miniblog.commentservice.dto.CommentRequestDTO;
import com.miniblog.commentservice.dto.CommentResponseDTO;
import com.miniblog.commentservice.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public Comment toEntity(CommentRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.setPostId(requestDTO.getPostId());
        comment.setUserId(requestDTO.getUserId());
        comment.setUserName(requestDTO.getUserName());
        comment.setContent(requestDTO.getContent());
        return comment;
    }

    public CommentResponseDTO toResponseDTO(Comment comment) {
        if (comment == null) {
            return null;
        }
        CommentResponseDTO responseDTO = new CommentResponseDTO();
        responseDTO.setId(comment.getId());
        responseDTO.setPostId(comment.getPostId());
        responseDTO.setUserId(comment.getUserId());
        responseDTO.setUserName(comment.getUserName());
        responseDTO.setContent(comment.getContent());
        responseDTO.setCreatedAt(comment.getCreatedAt());
        return responseDTO;
    }
}
