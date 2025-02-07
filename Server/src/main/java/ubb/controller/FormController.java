package ubb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubb.model.Question;
import ubb.service.FormService;

import java.util.List;

@RestController
@RequestMapping("/api/form")
public class FormController {
    private final FormService formService;

    @Autowired
    public FormController(FormService formService){
        this.formService = formService;
    }

    @GetMapping
    public ResponseEntity<List<Question>> getForm(){
        formService.makeForm();
        return ResponseEntity.ok(formService.getFormular());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Integer> postForm(@PathVariable Long id, @RequestBody List<String> responses){
        return ResponseEntity.ok(formService.saveUserResponse(id, responses));
    }
}
