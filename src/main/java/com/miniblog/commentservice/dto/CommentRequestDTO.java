package com.miniblog.commentservice.dto;

public class CommentRequestDTO {
    private String postId;
    private Long userId;
    private String userName;
    private String content;

    // Constructors
    public CommentRequestDTO() {}

    public CommentRequestDTO(String postId, Long userId, String userName, String content) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.content = content;
    }

    // Getters and Setters
    public String getPostId() { return postId; }
    public void setPostId(String postId) { this.postId = postId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
