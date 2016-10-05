package com.lagoon.backend.service;

import com.lagoon.backend.model.Photo;
import com.lagoon.backend.model.User;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 03-Oct-16.
 */
public interface PhotoService {

    Photo save(Photo photo);

    List<Photo> findByUser(User user);

    Photo findByPhotoId(Long photoId);

    List<Photo> findAll();
}
