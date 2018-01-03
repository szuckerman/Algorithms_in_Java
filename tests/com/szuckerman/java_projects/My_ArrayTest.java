package com.szuckerman.java_projects;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class My_ArrayTest {

    @Test
    public void test_insertion_sort_base_case() {
        int[] nonsorted_array_dat = {2,1,5,9,0,3};
        assertEquals("[0, 1, 2, 3, 5, 9]", SortArray.insertion_sort(nonsorted_array_dat));
    }

    @Test
    public void test_insertion_sort_already_sorted() {
        int[] already_sorted_array_dat = {0, 1, 2, 3, 5, 9};
        assertEquals("[0, 1, 2, 3, 5, 9]", SortArray.insertion_sort(already_sorted_array_dat));
    }

    @Test
    public void test_insertion_sort_length1_array() {
        int[] already_sorted_array_dat = {1};
        assertEquals("[1]", SortArray.insertion_sort(already_sorted_array_dat));
    }

    @Test
    public void test_insertion_sort_array_with_multiple_vals() {
        int[] multiple_vals_array_dat = {5,4,3,2,2,3,4};
        assertEquals("[2, 2, 3, 3, 4, 4, 5]", SortArray.insertion_sort(multiple_vals_array_dat));
    }

    @Test
    public void test_insertion_sort_sorted_array_with_multiple_vals() {
        int[] already_sorted_array_dat = {2,2,3,3,4,4,5};
        assertEquals("[2, 2, 3, 3, 4, 4, 5]", SortArray.insertion_sort(already_sorted_array_dat));
    }

    @Test
    public void test_insertion_sort_all_decreasing() {
        int[] already_sorted_array_dat = {5,4,3,2,1};
        assertEquals("[1, 2, 3, 4, 5]", SortArray.insertion_sort(already_sorted_array_dat));
    }

    @Test
    public void test_insertion_sort_multiple_all_decreasing() {
        int[] already_sorted_array_dat = {5,5,4,4,3,3,2,2,1,1};
        assertEquals("[1, 1, 2, 2, 3, 3, 4, 4, 5, 5]", SortArray.insertion_sort(already_sorted_array_dat));
    }

    @Test
    public void test_merge_two_arrays(){
        int[] array1 = {1,3,4,6};
        int[] array2 = {2,5,7,8};
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]", Arrays.toString(SortArray.merge_arrays(array1, array2)));
    }

    @Test
    public void test_merge_two_small_arrays(){
        int[] array1 = {2};
        int[] array2 = {1};
        assertEquals("[1, 2]", Arrays.toString(SortArray.merge_arrays(array1, array2)));
    }

    @Test
    public void test_merge_uneven_small_arrays(){
        int[] array1 = {3};
        int[] array2 = {1,2};
        assertEquals("[1, 2, 3]", Arrays.toString(SortArray.merge_arrays(array1, array2)));
    }

}