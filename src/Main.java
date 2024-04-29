import classes.*;

public class Main {
    public static void main(String[] args) {
        MySet setA = new MySet(new int[]{1, 2, 3, 5,5,7,7});
        MySet setB = new MySet(new int[]{1, 2, 3, 5,6,6,8,8,8});

        int[] union = MyStatic.union(setA, setB);
        System.out.print("Union: ");
        MyStatic.sort(union);

        for (int i = 0; i < union.length; i++) {
            System.out.print(union[i] + " ");
        }

        System.out.println();

        MySet unionSet = new MySet(union);

        System.out.println("Is B a subset of A? " + MyStatic.isSubset(setA, setB));
        System.out.println("Is A a subset of B? " + MyStatic.isSubset(setB, setA));

        int[] modeUnion = MyStatic.mode(unionSet);
        System.out.print("Mode of Union: ");
        for (int i = 0; i < modeUnion.length; i++) {
            System.out.print(modeUnion[i] + " ");
        }
        System.out.println();

        double medianUnion = MyStatic.median(unionSet);
        System.out.println("Median of Union: " + medianUnion);

        double meanUnion = MyStatic.mean(unionSet);
        System.out.println("Mean of Union: " + meanUnion);
    }
}