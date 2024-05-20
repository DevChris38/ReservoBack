package com.reservo.reservoback;

import com.reservo.reservoback.controller.ImageController;
import com.reservo.reservoback.controller.ProfessionalController;
import com.reservo.reservoback.model.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ReservoBackApplication.class)
@Transactional
public class ImageTest {

    @Autowired
    private ImageController imageController;

    @Autowired
    private ProfessionalController professionalController;

    private Integer idImage;

    @BeforeEach
    public void setUp() throws Exception {
        Image image = new Image("www.image.fr", professionalController.getProfessional(1).orElseThrow(() -> new RuntimeException("Professional not found")));
        //save user, verify has ID value after save
        assertNull(image.getId());//null before save
        this.imageController.saveImage(image);
        idImage = image.getId();
        assertNotNull(idImage);
    }

    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        Optional<Image> imageOptional = imageController.getImage(idImage);
        assertNotNull(imageOptional);
        Image image = imageOptional.get();
        assertEquals("www.image.fr", image.getLink());
    }

}
