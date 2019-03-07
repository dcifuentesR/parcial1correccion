/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controllers;

import edu.eci.arsw.GuidFinder.persistence.guidSearch;
import edu.eci.arsw.GuidFinder.services.GuidFinderServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2116387
 */
@RestController
public class GuidFinderAPIController {
    
    @Autowired
    GuidFinderServices gfs=null;
    
    @RequestMapping(value="/uuid",method = RequestMethod.GET)
    public ResponseEntity manejadorGetGuidSearches(){
        try {
            gfs.getGuidSearches();
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(GuidFinderAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value="/uuid/{search}",method = RequestMethod.GET)
    public ResponseEntity manejadorGetGuidSearch(@PathVariable("search") String guid){
        try {
            gfs.getGuidSearch(guid);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(GuidFinderAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @RequestMapping(value="/uuid/{search}",method = RequestMethod.POST)
    public ResponseEntity manejadorPostGuidSearch(@RequestBody guidSearch search){
        try {
            //gfs.saveSearch(guid, 0);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(GuidFinderAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
}
