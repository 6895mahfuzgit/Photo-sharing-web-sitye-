package com.lagoon.backend.service.impl;

import com.lagoon.backend.dao.PhotoDao;
import com.lagoon.backend.model.Photo;
import com.lagoon.backend.model.User;
import com.lagoon.backend.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 03-Oct-16.
 */
@Service
public class PhotoServiceImpl implements PhotoService {


    @Autowired
    private PhotoDao photoDao;


    @Override
    public Photo save(Photo photo) {
        return photoDao.save(photo);
    }

    @Override
    public List<Photo> findByUser(User user) {
        return photoDao.findByUser(user);
    }

    @Override
    public Photo findByPhotoId(Long photoId) {
        return photoDao.findByPhotoId(photoId);
    }

    @Override
    public List<Photo> findAll() {
        return photoDao.findAll();
    }
}
