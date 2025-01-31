package com.journal.journalapplication.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.journal.journalapplication.Entity.JournalEntity;

@Repository
public interface JournalRepo extends MongoRepository<JournalEntity,String> {


}
