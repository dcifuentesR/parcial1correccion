/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.GuidFinder.persistence.impl;

import edu.eci.arsw.GuidFinder.persistence.GuidFinderPersistence;
import edu.eci.arsw.GuidFinder.persistence.guidSearch;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 *
 * @author 2116387
 */
@Component("gfp")
public class VolatilePersistence implements GuidFinderPersistence{
    private final Map<String,guidSearch> searches=new HashMap<>();
    
    public VolatilePersistence(){
        
    }

    @Override
    public Set<guidSearch> getGuidSearches() throws Exception {
        return new HashSet(searches.values());
    }

    @Override
    public void saveGuidSearch(String guid, int count) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        searches.put(guid,new guidSearch(dateFormat.format(new Date()), guid, count));
    }

    @Override
    public guidSearch getGuidSearch(String guid) {
        return searches.get(guid);
    }
    
}
