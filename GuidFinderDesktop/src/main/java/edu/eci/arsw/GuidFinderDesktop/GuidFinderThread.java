package edu.eci.arsw.GuidFinderDesktop;

import java.util.UUID;

public class GuidFinderThread extends Thread{
	
	private boolean paused;
	
	private UUID[] guids;
	
	private UUID guidToFind;
	
	private int low;
	private int high;
	
	private int count;
	
	private final Object lock = new Object();

	public GuidFinderThread(int low,int high,UUID[] guids,UUID guidToFind) {
		this.guids=guids;
		this.guidToFind=guidToFind;
		this.low=low;
		this.high=high;
		count=0;
	}
	
	@Override
	public void run() {			
		
		
		for (int i=low;i<high;i++) {
			
			synchronized (lock) {
				if(paused) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(guids[i].equals(guidToFind))
					{
				count++;
					}
			
		}
		
	}
	
	public int getCount() {
		return count;
	}
	
	public void pauseThread() {
		paused=true;
	}
	
	public void resumeThread() {
		paused=false;
		synchronized (lock) {
			lock.notifyAll();
		}
	}

}