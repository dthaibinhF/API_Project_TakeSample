package com.example.api_takesample.Service;

import com.example.api_takesample.Model.Picture;
import com.example.api_takesample.Repository.PictureRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PicturService {

    PictureRepository pictureRepository;

    @Autowired
    public PicturService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public List<Picture> getPicture() {
        return pictureRepository.findAll();
    }

    public void addNewPicture(Picture picture) {
        Optional<Picture> optionalPicture = pictureRepository.findPictureByIdPicture(picture.getIdPicture());

        if (optionalPicture.isPresent()) throw new IllegalStateException(
                "Picture id have taken"
        );

        pictureRepository.save(picture);
    }

    public void deletePicture(Long pictureId) {
        boolean exist = pictureRepository.existsById(pictureId);

        if (!exist) throw new IllegalStateException(
                "Picture with id " + pictureId + " does not exist"
        );

        pictureRepository.deleteById(pictureId);
    }

    @Transactional
    public void updateProject(Long pictureId, String namePicture, String describe, String url) {
        Picture picture = pictureRepository.findPictureByIdPicture(pictureId)
                .orElseThrow(
                        () -> new IllegalStateException(
                                "Picture with id " + pictureId + " does not exist"
                        )
                );

        if (namePicture != null &&
                !namePicture.isEmpty() &&
                !Objects.equals(namePicture, picture.getNamePicture())) {
            picture.setNamePicture(namePicture);
        }

        if (describe != null &&
                !describe.isEmpty() &&
                !Objects.equals(describe, picture.getDescribe())) {
            picture.setDescribe(describe);
        }

        if (url != null &&
                !url.isEmpty() &&
                !Objects.equals(url, picture.getUrl())) {
            picture.setUrl(url);
        }
    }
}
