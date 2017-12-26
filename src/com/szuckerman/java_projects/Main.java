package com.szuckerman.java_projects;

public class Main {

    public static void main(String[] args) {
        int[] num_array = {5,4,3,5,46,3,6,7457,456,3,2,2,3,1,987,5,4,3};
//        int[] num_array = {1,1,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3};

        My_Array my_array = new My_Array(num_array);

        System.out.println(my_array.print_array());
        System.out.println(my_array.insertion_sort());
    }
}
