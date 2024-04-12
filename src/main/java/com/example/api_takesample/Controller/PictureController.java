package com.example.api_takesample.Controller;

import com.example.api_takesample.Model.Picture;
import com.example.api_takesample.Service.PicturService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/picture")
public class PictureController {

    PicturService picturService;

    @Autowired
    public PictureController(PicturService picturService) {
        this.picturService = picturService;
    }

    @GetMapping
    public List<Picture> getPicture() {
        return picturService.getPicture();
    }

    @GetMapping("{pictureId}")
    public List<Picture> getPictureById(@PathVariable Long pictureId) {
        return picturService.getPictureById(pictureId);
    }

    @GetMapping("/sample/{sampleId}")
    public List<Picture> getPictureBySampleId(@PathVariable Long sampleId) {
        return picturService.getPictureBySampleId(sampleId);
    }

    @PostMapping("/{sampleId}")
    public void registerPictureInSample(
            @PathVariable Long sampleId,
            @RequestBody Picture picture) {
        picturService.addNewPictureInSample(sampleId, picture);
    }

    @DeleteMapping(path = "{pictureId}")
    public void deletePicture(@PathVariable("pictureId") Long pictureId) {
        picturService.deletePicture(pictureId);
    }

    @PutMapping(path = "{pictureId}")
    public void updatePicture(
            @PathVariable("pictureId") Long pictureId,
            @RequestParam(required = false) String namePicture,
            @RequestParam(required = false) String describe,
            @RequestParam(required = false) String url
    ){
        picturService.updateProject(pictureId, namePicture, describe, url);
    }
}
