package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelRepositoryTest {
    @Autowired
    private ModelRepository repository;

    @Test
    public void findByUserId(){
        Model model = repository.findByUserId(1);
        System.out.println(model);
        assertNotNull(model);
    }
}