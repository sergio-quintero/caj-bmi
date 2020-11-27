package com.mauricio.bmi.controller;

import com.mauricio.bmi.resource.Bmi;
import com.mauricio.bmi.service.BmiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bmis")
public class BmiController {

    private final BmiService bmiService;

    @GetMapping("/{bmi_uuid}")
    public Bmi getBmi(@PathVariable String bmi_uuid) throws ChangeSetPersister.NotFoundException {
        return bmiService.getBmiById(bmi_uuid);
    }

    @GetMapping("/users/{username}")
    public List<Bmi> getBmisByUsername(@PathVariable String username) {
        return bmiService.getBmisByUsername(username);
    }

    @PostMapping("/users/{username}")
    public Bmi addBmi(@PathVariable String username, @RequestBody Bmi bmi) {
        return bmiService.addBmi(username, bmi);
    }
}
