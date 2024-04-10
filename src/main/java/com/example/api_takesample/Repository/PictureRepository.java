package com.example.api_takesample.Repository;

import com.example.api_takesample.Model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    Optional<Picture> findPictureByIdPicture(Long idPicture);

}
