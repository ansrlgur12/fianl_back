package com.example.demo.controller;

import com.example.demo.dto.CommentDto;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * 특정 회원 댓글 작성
     */

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto request) {
        CommentDto createdComment = commentService.createComment(request.getReviewId(), request.getMemberId(), request.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    /**
     * 특정 회원 댓글 수정
     */
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long commentId, @RequestBody CommentDto request) {
        CommentDto updatedComment = commentService.updateComment(commentId, request.getContent());
        return ResponseEntity.ok(updatedComment);
    }

    /**
     * 특정 회원 댓글 삭제
     */
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    /**
     * 특정 회원 댓글 조회
     */
    @GetMapping("/review/{reviewId}")
    public ResponseEntity<List<CommentDto>> getCommentsByReview(@PathVariable Long reviewId) {
        List<CommentDto> comments = commentService.getCommentsByReview(reviewId);
        return ResponseEntity.ok(comments);
    }
}
