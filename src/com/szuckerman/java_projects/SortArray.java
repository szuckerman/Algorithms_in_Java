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

    private static ArrayNode make_array_tree(int[] my_array) {
        ArrayNode head_array_node = new ArrayNode(my_array);
        Stack<ArrayNode> array_stack = new Stack<>();

        ArrayNode my_array_left = new ArrayNode(Arrays.copyOfRange(head_array_node.getNodeValue(),
                                            0, head_array_node.getNodeMidpoint()));
        ArrayNode my_array_right = new ArrayNode(Arrays.copyOfRange(head_array_node.getNodeValue(),
                                                head_array_node.getNodeMidpoint(), head_array_node.getNodeLength()));

        head_array_node.setChildNodes(my_array_left, my_array_right);

        my_array_left.setParentNode(head_array_node);
        my_array_right.setParentNode(head_array_node);

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

                new_array_node.setChildNodes(my_array_left, my_array_right);

                my_array_left.setParentNode(new_array_node);
                my_array_right.setParentNode(new_array_node);

                array_stack.push(my_array_left);
                array_stack.push(my_array_right);
            }
        }

        return head_array_node;

    }


    public static int[] merge_arrays(int[] left_array, int[] right_array){

        int n_L = left_array.length;
        int n_R = right_array.length;

        int num_elements = n_L + n_R;
        int[] new_array = new int[num_elements];

        System.out.format("There are %d elements in the first array\n", n_L);
        System.out.format("There are %d elements in the second array\n", n_R);

        //left_array.length <= right_array.length. Equal if main array is even, right_array
        //is larger if main array is odd.

        if (n_L == 1 && n_R == 1){
            new_array[0] = Math.min(left_array[0], right_array[0]);
            new_array[1] = Math.max(left_array[0], right_array[0]);
            return new_array;
        }

        int l_i = 0;
        int r_i = 0;
        int k = 0;

        while (l_i < n_L && r_i < n_R) {

            if (left_array[ l_i ] <= right_array[ r_i ]) {
                new_array[ k ] = left_array[ l_i ];
                l_i++;

            }

            else if (right_array[ r_i ] < left_array[ l_i ]){
                new_array[ k ] = right_array[ r_i ];
                r_i++;
            }

            k++;
        }

        // if we finish an array too early, just fill new_array with the rest of the other one

        if (l_i < n_L) {
            for (int i = l_i; i < n_L; i++) {
                new_array[ k ] = left_array[ i ];
                k++;
            }
        }

        if (r_i < n_R) {
            for (int i = r_i; i < n_R; i++) {
                new_array[ k ] = right_array[ i ];
                k++;
            }
        }

        return new_array;
    }

    public static int[] merge_sort(int[] node){

        ArrayNode my_node = make_array_tree(node);

        Stack<ArrayNode> array_stack = new Stack<>();

        array_stack.push(my_node);
        System.out.format("%s added to stack\n", Arrays.toString(node));

        while (!array_stack.isEmpty()) {
            ArrayNode current_node = array_stack.pop();
            System.out.format("Current array is: %s\n", Arrays.toString(current_node.getNodeValue()));

            if (current_node.isTailNode()){
                continue;
            }

            else if (current_node.getLeftNode().isTailNode() && current_node.getRightNode().isTailNode()){

                current_node.getLeftNode().setParentNode(current_node);
                current_node.getRightNode().setParentNode(current_node);

                int[] merged_node = merge_arrays(current_node.getLeftNode().getNodeValue(), current_node.getRightNode().getNodeValue());

                System.out.format("Array merged as %s\n", Arrays.toString(merged_node));
                current_node.setNode(merged_node);
                System.out.format("Current node has now been changed to: %s\n\n", Arrays.toString(current_node.getNodeValue()));

                if (current_node.getParentNode() != null) {
                    array_stack.push(current_node.getParentNode());
                }
            }

            else {
                array_stack.push(current_node.getLeftNode());
                System.out.format("%s added to stack\n", Arrays.toString(current_node.getLeftNode().getNodeValue()));
                array_stack.push(current_node.getRightNode());
                System.out.format("%s added to stack\n", Arrays.toString(current_node.getRightNode().getNodeValue()));
            }
        }

        return my_node.getNodeValue();
    }
}