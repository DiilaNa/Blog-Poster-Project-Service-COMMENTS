package com.miniblog.commentservice.dto;

public class CommentRequestDTO {
    private Long postId;
    private Long userId;
    private String userName;
    private String content;

    // Constructors
    public CommentRequestDTO() {}

    public CommentRequestDTO(Long postId, Long userId, String userName, String content) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.content = content;
    }

    // Getters and Setters
    public Long getPostId() { return postId; }
    public void setPostId(Long postId) { this.postId = postId;   }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
