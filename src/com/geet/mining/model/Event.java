package com.geet.mining.model;

import java.util.HashSet;
import java.util.Set;

public class Event implements Comparable<Event>,Cloneable{

	private String eventString;
	private int value;
	

	public Event(String eventString) {
		setEventString(eventString);
	}
	
	public String getEventString() {
		return eventString;
	}

	private void setEventString(String eventString) {
		this.eventString = eventString;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	 @Override
	    public int hashCode(){
	        int hashcode = 0;
	        hashcode += eventString.hashCode();
	        return hashcode;
	    }
	@Override
	public boolean equals(Object o) {
		if (o instanceof Event) {
			Event e = (Event) o;
			return e.eventString.equals(this.eventString);
		}else{
			return false;			
		}
	}
	
	@Override
	public String toString() {
		return eventString;
	}
	
	public static void main(String[] args) {
		Set<Event> events = new HashSet<Event>();
		Event e1 = new Event("a");
		System.out.println(e1+","+e1.hashCode());
		Event e2 = new Event("a");
		System.out.println(e2+","+e2.hashCode());
		Event e4 = new Event("a");
		System.out.println(events.add(e1));
		System.out.println(events.add(e2));
		System.out.println(events.add(e4));
		System.out.println(events.toString());
		
		System.out.println("a".compareTo("b"));
		
		
	}

	@Override
	public int compareTo(Event o) {
		return (o.value-value);
	}
	
	public Event clone(){
		Event event = new Event(eventString);
		event.setValue(value);
		return event;
	}
	
	public static Set<Event> getClonedEvents(Set<Event> events){
		Set<Event> clonedEvents = new HashSet<Event>();
		for (Event event : events) {
			clonedEvents.add(event.clone());
		}
		return clonedEvents;
	}
	
}
