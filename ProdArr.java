import java.util.Arrays;

public class ProdArr {
    public static void main(String[] args) {
        System.out.println("First approach: ");
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println("NEW approach: ");
        System.out.println(Arrays.toString(prodExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println("Second approach: ");
        System.out.println(Arrays.toString(productExceptSelfPS(new int[]{1, 2, 3, 4})));
    }

    static int[] prodExceptSelf(int nums[]) {

        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix products
        // result[i] will contain the product of all elements to the left of i
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products on the fly
        // Multiply the prefix product by the product of all elements to the right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    private static int[] productExceptSelfPS(int[] nums) {
        //prefix and suffix way - works fine and optimal way
        int n = nums.length;
        int[] output = new int[n];

        // prefix product
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        // suffix product
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffix;
            suffix *= nums[i];
        }
        return output;
    }

    public static int[] productExceptSelf(int[] nums) {
        // this fails in array having 0s
        int totalprod = 1;
        for (int i = 0; i < nums.length; i++) {
            totalprod = totalprod * nums[i];
        }
        System.out.println(totalprod);
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res[i] = totalprod / nums[i];
            }
        }
        return res;
    }
}
