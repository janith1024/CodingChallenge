package com.jsa.repository;

import com.jsa.entity.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Janith on 8/27/2017.
 * This is the supper class of the repository in this application
 */
public interface AbstractRepository<T extends Entity>   extends MongoRepository<T, String> {
}
