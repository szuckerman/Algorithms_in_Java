package com.szuckerman.java_projects;
import java.util.*;

public class SortArray {

    public static String insertion_sort(int[] my_array) {
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

    public static ArrayNode make_array_tree(int[] my_array) {
        ArrayNode head_array_node = new ArrayNode(my_array);
        Stack<ArrayNode> array_stack = new Stack<>();

        ArrayNode my_array_left = new ArrayNode(Arrays.copyOfRange(head_array_node.getNodeValue(),
                                            0, head_array_node.getNodeMidpoint()));
        ArrayNode my_array_right = new ArrayNode(Arrays.copyOfRange(head_array_node.getNodeValue(),
                                                head_array_node.getNodeMidpoint(), head_array_node.getNodeLength()));

        head_array_node.setNodes(my_array_left, my_array_right);

        array_stack.push(my_array_left);
        array_stack.push(my_array_right);

        ArrayNode new_array_node;

        while (!array_stack.isEmpty()) {
            new_array_node = array_stack.pop();

            if (new_array_node.getNodeLength() > 1) {
                my_array_left = new ArrayNode(Arrays.copyOfRange(new_array_node.getNodeValue(),
                                            0, new_array_node.getNodeMidpoint()));
                my_array_right = new ArrayNode(Arrays.copyOfRange(new_array_node.getNodeValue(),
                                                new_array_node.getNodeMidpoint(), new_array_node.getNodeLength()));

                new_array_node.setNodes(my_array_left, my_array_right);
                array_stack.push(my_array_left);
                array_stack.push(my_array_right);
            }
        }

        return head_array_node;

    }


    private static int[] merge_arrays(int[] left_array, int[] right_array){

        int num_elements = left_array.length + right_array.length;
        int[] new_array = new int[num_elements];

        //left_array.length <= right_array.length. Equal if main array is even, right_array
        //is larger if main array is odd.

        for (int i=0; i<left_array.length; i++){
            new_array[2*i] = Math.max(left_array[i], right_array[i]);
            new_array[2*i + 1] = Math.min(left_array[i], right_array[i]);
        }

        if (right_array.length > left_array.length){
            new_array[num_elements-1] = right_array[right_array.length-1];
        }

        return new_array;
    }


}