public class compress {

    public static void main() {
        int[] a = {5,5,5,-1,-1,-1};
        printarray(compress(a));

    }
    public static void printarray(int[] a) {
        for (int i = 0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static int[] compress(int[] a) {
        int l = 2;
        int test = a[0];
        for (int i = 0; i<a.length; i++) {
            if (a[i] != test) {
                l+= 2;
                test = a[i]; 
            }

        }
        int[] comp = new int[l];

        int track = 0;
        int counter = 0;
        for (int j = 0; j< a.length; j = j+ counter) {
            counter = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == a[j]) {
                    counter++;
                }
            }

            comp[track] = counter;
            comp[track+1] = a[j];
            track+=2;
        }

        return comp;
    }
}

