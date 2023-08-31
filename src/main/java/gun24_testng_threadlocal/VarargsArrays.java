package gun24_testng_threadlocal;

public class VarargsArrays {

    public static void main(String[] args) {

        System.out.println((char)67);
        System.out.println((int)'a');


        /*
        int[] arr = {1,2,3,4};
        System.out.println(sum1(arr));

        System.out.println("--------------");
        System.out.println(sum2(1,2,3));
        System.out.println(sum2());
        System.out.println(sum2(arr));

         */
    }


    public static int sum1(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int sum2(int...arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }



}
