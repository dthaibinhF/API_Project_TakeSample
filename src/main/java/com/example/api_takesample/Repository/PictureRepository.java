package com.example.api_takesample.Repository;

import com.example.api_takesample.Model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    Optional<Picture> findPictureByIdPicture(Long pictureId);
    List<Picture> findByIdPicture(Long pictureId);
    List<Picture> findBySampleIdSample(Long sampleId);

}
