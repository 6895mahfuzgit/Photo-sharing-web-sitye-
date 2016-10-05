package com.lagoon.backend.controller;

import com.lagoon.backend.model.Comment;
import com.lagoon.backend.model.Photo;
import com.lagoon.backend.service.CommentService;
import com.lagoon.backend.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 04-Oct-16.
 */

@RestController
@RequestMapping("/rest")
public class CommentResourcesController {


    @Autowired
    private PhotoService photoService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public void addComment(@RequestBody Comment comment) {


        Photo photo = photoService.findByPhotoId(comment.getPhotoId());

      //  List<Comment> commentList = photo.getCommentList();

        comment.setPhoto(photo);

        commentService.save(comment);

    }


}
