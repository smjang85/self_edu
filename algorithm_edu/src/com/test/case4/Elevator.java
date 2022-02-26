package com.test.case4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
People are waiting for an elevator in a hotel. the elevator has limited capacity and you would like to
analyse its movement.

The hotel has floors numbered from 0 to M. the elevator has Maximum capacity of X people and
a weight limit of Y. There are N people gathered at the ground floor, standing in a queue for the elevator.

you are given every person's weight A[K] and target floor B[K]. 

people continue to enter the elevator, in the order of their position in the queue( and push the
buttons for their target floors), for as long as there is room for them.(The queue order cannot be changed
even if there is room in the elevator for a particular person from the middle of the queue.)

the elecator goes up and stops at every selected floor, and finally returns to the ground floor. 
this process is preated until there ar no more people in the queue. the goal is to count the total
neumber of times that the elevator stops.


for example, consider a hotel with floors numbered from 0 to M = 5
with an elevator with a maximum capacity of X = 2 peole and a weight limit of Y =200.

A[0] = 60    B[0] = 2
A[1] = 80    B[1] = 3
A[2] = 40    B[2] = 5

the elevator will take the first two passengers together, stop at the 2nd and 3rd floors. then return
to the ground floor. Then it will take the last passenger, stop at the 5th floor and return to the ground
floor. in total, the elevator will stop five times.


A[0] =  40    B[0] = 3
A[1] =  40    B[1] = 3
A[2] = 100    B[2] = 2
A[3] =  80    B[3] = 2
A[4] =  20    B[4] = 3

M=3
180

the function should return 6, as the elevator will move in two stages : with the first three people and
then with two remaining people.
 */
class PeoPle {
	int weight;
	int floor;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
}

public class Elevator {

	public static int solution(int[] A, int[] B, int M, int X, int Y) {
		ArrayList<PeoPle> list = new ArrayList<PeoPle>();
		for (int i = 0; i < A.length; i++) {
			PeoPle people = new PeoPle();
			people.setWeight(A[i]);
			people.setFloor(B[i]);

			list.add(people);
		}

		int totalWeight = 0;	// 한번에 탑승한 인원 몸무게
		int cnt = 0;			// 한번에 탑승한 사람 수
		int move = 0;			// 움직임

		int beforeFloor = 0;
		for (int i = 0; i < list.size(); i++) {
			PeoPle people = (PeoPle) list.get(i);
			int floor = people.getFloor();
			
			totalWeight = totalWeight + people.getWeight();

			if (Y > totalWeight) {	// 몸무게 제한이 넘지 않는다면
				if (cnt < X) {		// 인원수 제한이 넘지 않는다면
					cnt++;
					
					if(floor != beforeFloor) {	//같은 층 사람들의 움직임은 1번
						move++;
						beforeFloor = floor;
					}
				} else { // 인원수 제한이 넘는다면 1층으로
					cnt = 0;
					totalWeight = 0;
					beforeFloor = 0;
					
					move++;
					i--;
					continue;
				}
			} else { // 몸무게 재한이 넘는다면 1층으로
				cnt = 0;
				totalWeight = 0;
				beforeFloor = 0;
				
				move++;
				i--;
				continue;
			}
			
			//마지막 1층 이동 count
			if(i == list.size() -1 ) {
				move = move +1;
			}
		}

		return move;
	}

	public static void main(String[] args) {
		
		  int[] A = {40,40,100,80,20}; 
		  int[] B = {3,3,2,2,3}; 
		  int M = 3; //max floor
		  int X = 5; //max people/one more 
		  int Y = 200; //weight
		
/*
		int[] A = { 60, 80, 40 };
		int[] B = { 2, 3, 5 };
		int M = 5; // max floor
		int X = 2; // max people/one more
		int Y = 200; // weight
*/
		System.out.println(solution(A, B, M, X, Y));
	}

}
