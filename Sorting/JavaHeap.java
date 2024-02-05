package Sorting;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class JavaHeap {

    public static class Student implements Comparable{
        public int age;
        public String name;
        public Student(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Object o) {
            Student other = (Student)o;
            return Integer.compare(this.age,other.age);
        }
    }



    public static void main(String[] args) {
//        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
//        minHeap.add(10);
//        minHeap.add(100);
//        minHeap.add(20);
//        minHeap.add(2);
//        minHeap.add(2);


        Queue<Student> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap.add(new Student(10,"A"));
        minHeap.add(new Student(6,"B"));
        minHeap.add(new Student(8,"C"));
        while(!minHeap.isEmpty()){
           Student youngestStudet = minHeap.poll();
            System.out.println(youngestStudet.name + " - " + youngestStudet.age);
        }
    }
}
