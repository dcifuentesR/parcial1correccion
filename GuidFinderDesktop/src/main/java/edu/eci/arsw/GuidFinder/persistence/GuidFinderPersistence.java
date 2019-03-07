/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.GuidFinder.persistence;

import java.util.Set;

/**
 *
 * @author 2116387
 */
public interface GuidFinderPersistence {
    
    public Set<guidSearch> getGuidSearches()throws Exception;
    
    public void saveGuidSearch(String guid, int count);
    
    public guidSearch getGuidSearch(String guid);
    
}
