package com.lagoon.backend.service.impl;

import com.lagoon.backend.dao.CommentDao;
import com.lagoon.backend.model.Comment;
import com.lagoon.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 04-Oct-16.
 */
@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public Comment findOne(Long commentId) {
        return commentDao.findOne(commentId);
    }

    @Override
    public List<Comment> findByPhotoId(Long photo) {
        return commentDao.findByPhotoId(photo);
    }
}
