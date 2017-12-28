package com.szuckerman.java_projects;

public class Main {

    public static void main(String[] args) {
        int[] num_array = {5,5,4,3,3,5,46,3,6,7457,456,3,2,2,3,1,987,5,4,5};

        SortArray my_array = new SortArray(num_array);

        System.out.println(my_array.print_array());
        System.out.println(my_array.insertion_sort());

    }
}
