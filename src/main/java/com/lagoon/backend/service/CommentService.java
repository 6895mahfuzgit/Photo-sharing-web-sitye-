package com.lagoon.backend.service;

import com.lagoon.backend.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 04-Oct-16.
 */
public interface CommentService {


    Comment save(Comment comment);

    Comment findOne(Long commentId);

    List<Comment> findByPhotoId(Long photo);
}
