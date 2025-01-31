package com.journal.journalapplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journal.journalapplication.Entity.JournalEntity;
import com.journal.journalapplication.Repository.JournalRepo;

@Service
public class JournalServices {

    @Autowired
    private JournalRepo repo;

    //save a entry
    public void saveEntry(JournalEntity entity){
        this.repo.save(entity);
    }
    //Get all entries
    public List<JournalEntity> getAll(){
        return this.repo.findAll();
    }
    //Get entry by id
    public Optional<JournalEntity> getByID(String id){
        return this.repo.findById(id);
    }
    //Update a entry
    // public JournalEntity updateById(JournalEntity entity,String id){
    //     List<JournalEntity> list=this.repo.findAll();
    //     list=list.stream().filter(e->e.getId()==id).collect(Collector.)
    // }
    //Delete by id
    public void deleteEntry(String id){
        this.repo.deleteById(id);
    }
}
