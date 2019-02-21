package edu.eci.arsw.GuidFinderDesktop;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

public class GuidFinder extends KeyAdapter{
	
	private int startTime;
	
	public final static int NUM_THREADS=4;
	public final static int TIME_MILLIS=10000;
	
	private static UUID[] guids; 
	
	private GuidFinderThread[] workers;
	
	public GuidFinder() throws Exception {

		getGuids();
	}
	
	public static UUID[] getGuids() throws Exception 
	{
	
		if(guids==null){
			System.out.println("es nulo");
		FileInputStream fi;
		
			fi = new FileInputStream(new File("guids.eci"));
		
		ObjectInputStream oi = new ObjectInputStream(fi);

		
		guids= (UUID[]) oi.readObject();
	
		oi.close();
		fi.close();
		}
		return guids;
		
	}
	
	public int countGuids(UUID guidToFind) 
	{
		int count=0;

		workers= new GuidFinderThread[NUM_THREADS];
		for(int i=0;i<NUM_THREADS;i++) {
			workers[i]=new GuidFinderThread(i*guids.length/NUM_THREADS,
											(i+1)*guids.length/NUM_THREADS,
											guids,
											guidToFind);
			workers[i].start();
			
		}
		
		if((System.currentTimeMillis()-startTime)>=TIME_MILLIS) {
			for(GuidFinderThread t:workers) {
				t.pauseThread();
				
			}
		}
		
		for(GuidFinderThread t:workers) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count+=t.getCount();
		}
		
		
		return count;
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
	startTime=(int) System.currentTimeMillis();
	for(GuidFinderThread t:workers)
		t.resumeThread();
}
	
	


}
