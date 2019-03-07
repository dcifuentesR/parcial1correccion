/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.GuidFinder.persistence;

import java.util.UUID;

/**
 *
 * @author 2116387
 */
public class guidSearch {

    private String date;
    private UUID guid;
    private int count;
    
    public guidSearch(String date,String guid, int count){
        this.date=date;
        this.guid=UUID.fromString(guid);
        this.count=count;
    }
    public String getDate() {
        return date;
    }

    public UUID getGuid() {
        return guid;
    }

    public int getCount() {
        return count;
    }
    
    
    
}
