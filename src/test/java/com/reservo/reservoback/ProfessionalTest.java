package com.reservo.reservoback;

import com.reservo.reservoback.controller.ProfessionalController;
import com.reservo.reservoback.model.Professional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ReservoBackApplication.class)
@Transactional
public class ProfessionalTest {
    @Autowired
    private ProfessionalController professionalController;

    private Integer idProfessional;

    @BeforeEach
    public void setUp() throws Exception {
        Professional professional = new Professional("toto l'abricot", "Abricotier", "C'est juste un abricot", "www.abricot.tree.fr", "0605030809", "10 rue des vergers");
        //save user, verify has ID value after save
        assertNull(professional.getId());//null before save
        this.professionalController.saveProfessional(professional);
        idProfessional = professional.getId();
        assertNotNull(idProfessional);
    }

    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        Optional<Professional> professionalOptional = professionalController.getProfessional(idProfessional);
        assertNotNull(professionalOptional);
        Professional professional = professionalOptional.get();
        assertEquals("toto l'abricot", professional.getName());
    }
}
