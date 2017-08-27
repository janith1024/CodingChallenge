package com.jsa.controller;

import com.jsa.entity.Entity;
import com.jsa.repository.AbstractRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Janith on 8/27/2017.
 * This is the supper class of the controller and all the common logic implement here
 */
public abstract class AbstractController<T extends Entity> {

    /**
     * Return all the records of the table
     * @return
     */
    @RequestMapping("/all")
    public List<T> getAll(){
        return getRepository().findAll();
    }

    /**
     * Return the object relevant to the given id
     * @param id
     * @return
     */
    @RequestMapping("/one/{id}")
    public T get(@PathVariable("id")String id){
        return getRepository().findOne(id);
    }

    /**
     * update the relevant record
     * @param entity
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<String> update(@RequestBody T entity){
        if(isValid(entity)){
            getRepository().save(entity);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody T entity){
        if(isValid(entity)){
            getRepository().insert(entity);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    protected abstract AbstractRepository<T> getRepository();

    /**
     * This is the validation check method currently check only null.
     * If sub class need to check other validation they can simply override this method
     * @param entity
     * @return
     */
    protected boolean isValid(T entity){
        if(entity != null) {
            return true;
        }
        return false;
    }
}
