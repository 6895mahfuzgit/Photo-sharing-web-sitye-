package com.lagoon.backend.dao;

import com.lagoon.backend.model.Photo;
import com.lagoon.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 03-Oct-16.
 */
@Repository
public interface PhotoDao extends CrudRepository<Photo, Long> {

    Photo save(Photo photo);

    List<Photo> findByUser(User user);
    Photo findByPhotoId(Long photoId);

    List<Photo> findAll();

}
