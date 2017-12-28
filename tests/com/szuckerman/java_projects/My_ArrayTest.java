package com.szuckerman.java_projects;

import org.junit.Test;

import static org.junit.Assert.*;

public class My_ArrayTest {

    @Test
    public void test_insertion_sort_base_case() {
        int[] nonsorted_array_dat = {2,1,5,9,0,3};
        SortArray my_array = new SortArray(nonsorted_array_dat);
        assertEquals("[0, 1, 2, 3, 5, 9]", my_array.insertion_sort());
    }

    @Test
    public void test_insertion_sort_already_sorted() {
        int[] already_sorted_array_dat = {0, 1, 2, 3, 5, 9};
        SortArray my_array = new SortArray(already_sorted_array_dat);
        assertEquals("[0, 1, 2, 3, 5, 9]", my_array.insertion_sort());
    }

    @Test
    public void test_insertion_sort_length1_array() {
        int[] already_sorted_array_dat = {1};
        SortArray my_array = new SortArray(already_sorted_array_dat);
        assertEquals("[1]", my_array.insertion_sort());
    }

    @Test
    public void test_insertion_sort_array_with_multiple_vals() {
        int[] multiple_vals_array_dat = {5,4,3,2,2,3,4};
        SortArray my_array = new SortArray(multiple_vals_array_dat);
        assertEquals("[2, 2, 3, 3, 4, 4, 5]", my_array.insertion_sort());
    }

    @Test
    public void test_insertion_sort_sorted_array_with_multiple_vals() {
        int[] already_sorted_array_dat = {2,2,3,3,4,4,5};
        SortArray my_array = new SortArray(already_sorted_array_dat);
        assertEquals("[2, 2, 3, 3, 4, 4, 5]", my_array.insertion_sort());
    }

    @Test
    public void test_insertion_sort_all_decreasing() {
        int[] already_sorted_array_dat = {5,4,3,2,1};
        SortArray my_array = new SortArray(already_sorted_array_dat);
        assertEquals("[1, 2, 3, 4, 5]", my_array.insertion_sort());
    }

    @Test
    public void test_insertion_sort_multiple_all_decreasing() {
        int[] already_sorted_array_dat = {5,5,4,4,3,3,2,2,1,1};
        SortArray my_array = new SortArray(already_sorted_array_dat);
        assertEquals("[1, 1, 2, 2, 3, 3, 4, 4, 5, 5]", my_array.insertion_sort());
    }
}