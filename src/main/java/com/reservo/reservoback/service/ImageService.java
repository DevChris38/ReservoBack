package com.reservo.reservoback.service;

import com.reservo.reservoback.model.Image;
import com.reservo.reservoback.repository.ImageRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Optional<Image> getImage(final Integer id) {
        return imageRepository.findById(id);
    }

    public void deleteImage(final Integer id) {
        imageRepository.deleteById(id);
    }

    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }
}
