import java.util.ArrayList;

public class DynamicArraysDemo {

    public static void main (String[] args) {

        // here is a custom class structuring Dynamic Arrays
        class DynamicArray {
            // similar to simulation of dynamic scaling in intermediate stack example
            int size;
            int capacity = 10; // default value
            Object[] array;
            
            // default constructor
            public DynamicArray() {
                this.array = new Object[capacity];
            }

            // constructor for specified capacity
            public DynamicArray(int capacity) {
                this.capacity = capacity;
                this.array = new Object[capacity];
            }

            public void add(Object data) {
                if (size >= capacity) {
                    grow();
                }
                array[size] = data;
                size++;
            }

            public void insert(int index, Object data) {
                if (size >= capacity) {
                    grow();
                }
                for(int i = size; i > index; i--) {
                    array[i] = array[i - 1];
                }
                array[index] = data;
                size++;
            }

            public void delete(Object data) {
                for(int i = 0; i < size; i++) {
                    if(array[i] == data) {
                        for(int j = 0; j < (size - i - 1); j++) {
                            array[i + j] = array[i + j + 1];
                        }
                        array[size - 1] = null;
                        size--;
                        if (size <=(int) (capacity/3) ) {
                            shrink();
                        }
                        break;
                    }
                }
            }

            public int search(Object data) {
                for(int i = 0; i < size; i++) {
                    if(array[i] == data) {
                        return i;
                    }
                }
                return -1;
            }

            private void grow() {
                int newCapacity = (int)(capacity * 2);
                Object[] newArray = new Object[newCapacity];

                for(int i = 0; i < size; i++) {
                    newArray[i] = array[i];
                }
                capacity = newCapacity;
                array = newArray;
            }

            private void shrink() {
                int newCapacity = (int)(capacity / 2);
                Object[] newArray = new Object[newCapacity];

                for(int i = 0; i < size; i++) {
                    newArray[i] = array[i];
                }
                capacity = newCapacity;
                array = newArray;
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public String toString() {
                String string = "";
                for(int i = 0; i < size; i++) {
                    string += array[i] + ", ";
                }
                if (string != "") {
                    string = "[" + string.substring(0, string.length() - 2) + "]";
                }
                else {
                    string = "[]";
                }
                return string;
            }

        }

        // dynamic arrays are arrays with resizable capacity
        // in Java, they're known as ArrayLists
        ArrayList<String> arrayList = new ArrayList<String>();

        // using our custom class
        DynamicArray dynamicArray = new DynamicArray(); // no parameters = default constructor, parameters = specifiec constructor
        
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");

        dynamicArray.insert(0, "X");
        dynamicArray.delete("A");
        

        System.out.println(dynamicArray);
        System.out.println("size: " + dynamicArray.size);
        System.out.println("capacity: " + dynamicArray.capacity);
        System.out.println("empty: " + dynamicArray.isEmpty());
        System.out.println(dynamicArray.search("C"));

    }
}