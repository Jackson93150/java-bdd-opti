package com.exo1.exo1.controller;

import com.exo1.exo1.entity.ProjetTaskCount;
import com.exo1.exo1.service.ProjetTaskCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/count")
public class ProjetTaskCountController {
    @Autowired
    private ProjetTaskCountService projetTaskCountService;

    @GetMapping("/task")
    public Page<ProjetTaskCount> getAllProjetsWithTaskCount(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return projetTaskCountService.findAllWithTaskCount(pageable);
    }
}
