package com.test.case1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
2.
- Problem statement
	Implement a FIFO queue with limited size.

- It should support the following commands:
	SIZE
	OFFER x
	TAKE
	x can be any string.

- Input
N C
command 1
command 2...
Where N is the number of commands (1 <= N <= 10000) and C the capacity of the queue (0 <= C <= 10000).

- Output
For SIZE command, the number of items currently in the queue followed by a newline.
For TAKE command, the item taken followed by a newline if the queue was not empty. Nothing otherwise.
For OFFER command, "true" if the item was accepted by the queue, or "false" otherwise, followed by a newline.

-ex1                                      -ex2
Input example                             Input example
5 2                                       6 2
OFFER hello                               OFFER 1
OFFER world                               OFFER Hello
OFFER !                                   OFFER 3
TAKE                                      SIZE
SIZE                                      TAKE
                                          TAKE
Output example
For the above input,                      Output example
true                                      true
true                                      true
false                                     false
hello
1
*/

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

	
public class MakeQueue
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
