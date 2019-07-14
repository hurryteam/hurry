package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Selection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectionRepositoryTest {

    @Autowired
    private SelectionRepository repository;
    @Test
    public void add(){
        Selection selection = new Selection();
        selection.setUserId(2);
        selection.setCourseId(3);
        repository.save(selection);
    }

    @Test
    public void findAllByUserId() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<Selection> selectionPage = repository.findAllByUserId(1, pageable);
        selectionPage.getContent().forEach(System.out::println);
    }
}