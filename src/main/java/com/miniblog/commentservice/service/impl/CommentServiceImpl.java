package com.miniblog.commentservice.service.impl;

import com.miniblog.commentservice.dto.CommentRequestDTO;
import com.miniblog.commentservice.dto.CommentResponseDTO;
import com.miniblog.commentservice.exception.CommentNotFoundException;
import com.miniblog.commentservice.mapper.CommentMapper;
import com.miniblog.commentservice.model.Comment;
import com.miniblog.commentservice.repository.CommentRepository;
import com.miniblog.commentservice.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public CommentResponseDTO addComment(CommentRequestDTO requestDTO) {
        Comment comment = commentMapper.toEntity(requestDTO);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toResponseDTO(savedComment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommentResponseDTO> getCommentsByPostId(String postId) {
        return commentRepository.findByPostIdOrderByCreatedAtDesc(postId).stream()
                .map(commentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new CommentNotFoundException("Comment not found with ID: " + id);
        }
        commentRepository.deleteById(id);
    }
}
