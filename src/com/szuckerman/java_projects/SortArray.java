package com.szuckerman.java_projects;
import java.util.Arrays;

public class SortArray {

    private int[] default_array = {2,1,3};
//    private int[] default_array = {1, 3, 45, 2, 63, 10, 10, 22, 5, 222, 10, 20, 31, 100, 7, 4};
    private int[] my_array;
    
    public SortArray(int[] my_array){
        this.my_array = my_array;
    }

    public SortArray(){
        this.my_array = default_array;
    }

    public String print_array(){
        return Arrays.toString(my_array);
    }

    public String insertion_sort() {
        //k is the index of the value we're looking at right now
        //i is the index of the last value of the previous subarray to which we're comparing the value of my_array[k]

        int i = 0;
        int k = i + 1;

        while (k < my_array.length) {
            if (my_array[k] >= my_array[i]) {
                //if my_array[k] is bigger than the previous element (i.e. the biggest element in the previous subarray)
                //just move the i and k cursors to the right.

                k += 1;
                i += 1;

            } else if (my_array[k] < my_array[i]) {

                int val_to_move = my_array[k];

                // we want to keep track of k, but also have a new k 'move' to sort the subarray
                int new_k = k;

                while (i>=0 && val_to_move < my_array[i]){
                    //at i=0, we've looked at the whole subarray. We should quit at that point.
                    my_array[new_k] = my_array[i];
                    my_array[i] = val_to_move;
                    //move everything one to the right and the 'bigger value' to the current location
                    //move two cursors to the left and repeat
                    i -= 1;
                    new_k -= 1;
                }

                // once the subarray is sorted, move the main cursor one to the right and set the last element in the
                // subarray to one element prior
                k += 1;
                i = k - 1;

            }
        }
    return Arrays.toString(my_array);
    }
}