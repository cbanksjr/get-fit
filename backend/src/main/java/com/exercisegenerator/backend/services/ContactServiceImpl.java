package com.exercisegenerator.backend.services;

import org.springframework.stereotype.Service;

import com.exercisegenerator.backend.models.Contact;
import com.exercisegenerator.backend.repositories.ContactRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {
    
    private ContactRepo contactRepo;

    /**
     * saves contact us info. Checks repo and then saves info
     */
    @Override
    public Contact saveInfo(Contact contact) {
        if(contact != null){
            return contactRepo.save(contact);
        }
        return contact;
        
    }


    
}
