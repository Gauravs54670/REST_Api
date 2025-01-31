package com.journal.journalapplication.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journal.journalapplication.Entity.JournalEntity;
import com.journal.journalapplication.Service.JournalServices;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalServices service;
    //Post a entry
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody JournalEntity entity){
        entity.setDate(LocalDateTime.now());
        this.service.saveEntry(entity);
        return ResponseEntity.ok("Entry Saved");
    }
    //Get All Entries
    @GetMapping
    public List<JournalEntity> getAllEntries(){
        return this.service.getAll();
    }
    //Get by id
    @GetMapping("/{id}")
    public Optional<JournalEntity> findById(@PathVariable ("id") String id){
        return this.service.getByID(id);
    }
    //Delete a entry
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable String id){
        this.service.deleteEntry(id);
        return true;
    }
    //Update a entry
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable String id, @RequestBody JournalEntity entry){
        JournalEntity old=service.getByID(id).orElse(null);
        if(old!=null){
            if(entry.getTitle()==null || entry.getTitle().isEmpty())
                entry.setTitle(old.getTitle());
            if(entry.getContent()==null || entry.getContent().isEmpty())
                entry.setContent(old.getContent());
            entry.setDate(LocalDateTime.now());
            this.service.saveEntry(entry);
            return ResponseEntity.ok("Entry Updated");
        }
        else    
            return ResponseEntity.ok("Entry did not found");
    }
}
