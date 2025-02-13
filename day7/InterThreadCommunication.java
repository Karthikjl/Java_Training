package com.celcom.day7;

class Resource {
	private String data;

	String getData() {
		return data;
	}

	void setData(String data) {
		this.data = data;
	}
}

class Reader extends Thread {
	Resource resource;

	Reader(Resource resource) {
		this.resource = resource;
	}

	public void run() {
		synchronized (resource) {
			System.out.println("Waiting for writer.");
			try {
				resource.wait();
			}
			catch(InterruptedException e) {
				
			}
			System.out.println("The enterd data is "+ resource.getData());
		}
	}
}

class Writer extends Thread {
	Resource resource;

	Writer(Resource resource) {
		this.resource = resource;
	}

	public void run() {
		synchronized (resource) {
			resource.setData("Hello world");
			resource.notify();
		}
	}
}

public class InterThreadCommunication {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		Resource r1 = new Resource();
		Reader read = new Reader(r1);
		Writer write = new Writer(r1);
		
		read.start();
		Thread.sleep(2000);
		write.start();
	}

}
