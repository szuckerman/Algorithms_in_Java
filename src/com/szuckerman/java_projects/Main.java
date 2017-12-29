package com.szuckerman.java_projects;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] num_array = {5,5,4,3,3,5,46,3,6,7457,456,3,2,2,3,1,987,5,4,5};

        System.out.println(Arrays.toString(num_array));
        System.out.println(SortArray.insertion_sort(num_array));

    }
}
