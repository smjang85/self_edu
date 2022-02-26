package com.test.case5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Queue {
    
    private int front = 0;
    private int back = -1;
    private int size = 0;
    private Object[] queue;
    
    public Queue(int size){
        this.size = size;
        this.queue = new Object[size];
    }
    
    public int getSize() {
    	if(full()) {
    		return size;
    	}else if(empty()) {
    		return 0;
    	}else {
    		return back + 1;
    	}
    }
    
    public boolean empty(){
        return (front == back+1);
    }
    
    public boolean full(){
        return (back == size-1);
    }
    
    public boolean insert(Object item){
        if(full()) {
        	return false;
        }else {
        	queue[++back] = item;
        	return true;
        }
    }
    
    public Object peek(){
        if(empty()) {
        	return "";
        }else {
        	return queue[front];	
        }
    }
    
    public Object remove(){
        Object item = peek();
        front++;
        return item;
    }
}

	
public class Test3
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] order = input.split(" ");
        int orderCnt = Integer.parseInt(order[0]);
        int queueSize = Integer.parseInt(order[1]);
        
        Queue queue = new Queue(queueSize);
        for(int i = 0; i <orderCnt ; i++) {
        	input = br.readLine();
        	order = input.split(" ");
        	if("SIZE".equals(order[0])) {
        		System.out.println(queue.getSize());
        	}else if("TAKE".equals(order[0])) {
        		System.out.println(queue.remove());
        	}else if("OFFER".equals(order[0])) {
        		System.out.println(queue.insert(order[1]));
        	}
        		
        }
    }
}
