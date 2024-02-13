package com.exercisegenerator.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercisegenerator.backend.models.Contact;
import com.exercisegenerator.backend.services.ContactService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/contact")
public class ContactController {
   
    private ContactService contactService;

    /*
     * Saves contact info from contact us page to database
     */
    @PostMapping()
    public ResponseEntity<?> saveContact(@RequestBody Contact contact){
        try {
            return ResponseEntity.ok(contactService.saveInfo(contact));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
