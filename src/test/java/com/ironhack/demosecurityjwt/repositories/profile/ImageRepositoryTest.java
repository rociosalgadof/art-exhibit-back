package com.ironhack.demosecurityjwt.repositories.profile;

import com.ironhack.demosecurityjwt.models.profile.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ImageRepositoryTest {
    @Autowired
    private ImageRepository imageRepository;

    @Test
    public void testSaveImage() {
        Image image = new Image();
        image.setImage("image.jpg");
        Image savedImage = imageRepository.save(image);
        Assertions.assertNotNull(savedImage.getId());
        Assertions.assertEquals(image.getImage(), savedImage.getImage());
    }

    @Test
    public void testFindAllImages() {
        // Arrange
        Image image1 = new Image();
        image1.setImage("image1.jpg");
        imageRepository.save(image1);
        Image image2 = new Image();
        image2.setImage("image2.jpg");
        imageRepository.save(image2);
        List<Image> images = imageRepository.findAll();
        Assertions.assertEquals(23, images.size());
        Assertions.assertTrue(images.contains(image1));
        Assertions.assertTrue(images.contains(image2));
    }
}