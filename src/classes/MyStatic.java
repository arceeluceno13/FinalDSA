package classes;

public class MyStatic extends MySet {
    public MyStatic(int[] Set) {
        super(Set);
    }
    public static int[] union(MySet set1, MySet set2) {
            int[] elements1 = set1.Set();
            int[] elements2 = set2.Set();
            int[] unionSet = new int[elements1.length + elements2.length];
            int index = 0;

            for (int i = 0; i < elements1.length; i++) {
                unionSet[index++] = elements1[i];
            }

            for (int i = 0; i < elements2.length; i++) {
                boolean found = false;
                for (int j = 0; j < elements1.length; j++) {
                    if (elements2[i] == elements1[j]) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    unionSet[index++] = elements2[i];
                }
            }

            int[] result = new int[index];
            for (int i = 0; i < index; i++) {
                result[i] = unionSet[i];
            }

            return result;
        }

    public static boolean isSubset(MySet set1, MySet set2) {
        int[] elements1 = set1.Set();
        int[] elements2 = set2.Set();

        for (int element2 : elements2) {
            boolean found = false;
            for (int element1 : elements1) {
                if (element2 == element1) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static int[] mode(MySet set) {
        int[] elements = set.Set();
        int maxCount = 0;
        int[] modes = new int[elements.length];
        int modesCount = 0;

        // iphon ang frequency sa kada element
        for (int i = 0; i < elements.length; ++i) {
            int count = 0;
            for (int j = 0; j < elements.length; ++j) {
                if (elements[j] == elements[i]) ++count;
            }
            // current count kay dako sa maxCount, e clear ang modes array ug e update ang maxCount.
            if (count > maxCount) {
                maxCount = count;
                modes = new int[elements.length];
                modes[0] = elements[i];
                modesCount = 1;
            }
            // og ang current count kay equal sa maxCount, then e add the element to the modes array
            else if (count == maxCount) {
                boolean alreadyInModes = false;
                for (int k = 0; k < modesCount; ++k) {
                    if (modes[k] == elements[i]) {
                        alreadyInModes = true;
                        break;
                    }
                }
                if (!alreadyInModes) {
                    modes[modesCount] = elements[i];
                    ++modesCount;
                }
            }
        }

        // e cut ang size sa modes array
        int[] modesArray = new int[modesCount];
        for (int i = 0; i < modesCount; i++) {
            modesArray[i] = modes[i];
        }

        return modesArray;
    }

    public static double median(MySet set) {
        int[] sortedElements = sort(set.Set());
        int totalElements = sortedElements.length;

        if (totalElements % 2 == 0)
            return ((double)sortedElements[totalElements/2] + (double)sortedElements[totalElements/2 - 1])/2;
        else
            return (double) sortedElements[totalElements/2];
    }

    public static double mean(MySet set) {
        int[] elements = set.Set();
        double sum = 0.0;
        for(int i: elements) {
            sum += i;
        }
        return sum/elements.length;
    }

    public static int[] sort(int[] elements) {
        int n = elements.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (elements[j] > elements[j+1]) {
                    int temp = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                }
        return elements;
    }

    }

