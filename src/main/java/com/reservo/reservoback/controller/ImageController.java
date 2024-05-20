package com.reservo.reservoback.controller;

import com.reservo.reservoback.model.Image;
import com.reservo.reservoback.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    public Optional<Image> getImage(final Integer id) {
        return imageService.getImage(id);
    }

    public void deleteImage(final Integer id) {
        imageService.deleteImage(id);
    }

    public Image saveImage(Image image) {
        return imageService.saveImage(image);
    }
}
