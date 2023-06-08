package com.ironhack.demosecurityjwt.repositories.profile;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ironhack.demosecurityjwt.models.profile.Paragraph;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParagraphRepositoryTest {
    @Autowired
    private ParagraphRepository paragraphRepository;

    @Test
    public void testSaveAndFindById() {
        Paragraph paragraph = new Paragraph();
        Paragraph savedParagraph = paragraphRepository.save(paragraph);
        Paragraph foundParagraph = paragraphRepository.findById(savedParagraph.getId()).orElse(null);
        Assertions.assertNotNull(foundParagraph);
    }

}