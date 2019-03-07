/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.GuidFinder.services;

import edu.eci.arsw.GuidFinder.persistence.GuidFinderPersistence;
import edu.eci.arsw.GuidFinder.persistence.guidSearch;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2116387
 */
@Service
public class GuidFinderServices {
    
    @Autowired
    GuidFinderPersistence gfp = null;
    
    public void saveSearch(String guid,int count){
        gfp.saveGuidSearch(guid, count);
    }
    
    public Set<guidSearch> getGuidSearches() throws Exception{
        return gfp.getGuidSearches();
    }
    
    public guidSearch getGuidSearch(String guid){
        return gfp.getGuidSearch(guid);
    }
}
