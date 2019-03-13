package domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Staff extends Thread {
	private int staffNumber;
	private boolean takingOrder;
	private Costumer currentCostumer;
	private Queue queueCostumers = new LinkedList<Costumer>();
	
	public Staff(int staffNumber, LinkedList<Costumer> listCostumers  ) {
		this.staffNumber = staffNumber;
		this.queueCostumers = listCostumers;
		
	}

public void run() {
	Iterator<Costumer> itr = queueCostumers.iterator();
	while (itr.hasNext()) {
		if(itr.next().getIsBeingServed() == false) {
			itr.next().setIsBeingServed(true);
			currentCostumer = itr.next();
			takingOrder = true;
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			takingOrder = false;
			itr.remove();
			break;
		}
	}
	if(!queueCostumers.isEmpty()) {
		this.start();
	}	
}


public boolean getTakingOrder() {
	return takingOrder;
}

}