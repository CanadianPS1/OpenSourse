package csc180.roeback.lia;
public class App {
    public static void main(String [] args){
        box<Integer> intBox = new box<>(Integer.class, 5);
        //their are six sides on a box so ig it can be 6
        intBox.set(0, 6);
        System.out.println("Box element at 0: " + intBox.get(0));
    }
}
