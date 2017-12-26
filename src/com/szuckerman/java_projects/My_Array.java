package com.szuckerman.java_projects;
import java.util.Arrays;

public class My_Array {

    private int[] default_array = {2,1,3};
//    private int[] default_array = {1, 3, 45, 2, 63, 10, 10, 22, 5, 222, 10, 20, 31, 100, 7, 4};
    private int[] my_array;
    
    public My_Array(int[] my_array){
        this.my_array = my_array;
    }

    public My_Array(){
        this.my_array = default_array;
    }

    public String print_array(){
        return Arrays.toString(my_array);
    }

    public String insertion_sort() {
        //i is location to refer to
        //k is the referrer
        int i = 0;
        int k = i + 1;
        int temp;
        while (k < my_array.length) {
            System.out.format("i: %d, k = %d\n", i, k);
            if (my_array[k] >= my_array[i]) {
                k += 1;
                i += 1;
                System.out.println(Arrays.toString(my_array));
                System.out.format("i: key = %d, val = %d\n", i, my_array[i]);
                System.out.format("k: key = %d, val = %d\n", k, my_array[k]);
            } else if (my_array[k] < my_array[i]) {

                int val_to_move = my_array[k];

                System.out.format("We will be moving %d", val_to_move);
                System.out.println("");
                System.out.println("");

                int new_k = k;

                while (i>=0 && val_to_move < my_array[i]){
                    my_array[new_k] = my_array[i];
                    System.out.format("new_i: key = %d, val = %d\n", i, my_array[i]);
                    System.out.format("new_k: key = %d, val = %d\n", new_k, my_array[new_k]);
                    my_array[i] = val_to_move;
                    i -= 1;
                    new_k -= 1;
                }

                k += 1;
                i = k - 1;

            }
        }
    return Arrays.toString(my_array);
    }
}