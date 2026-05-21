public class RT_Call {
    public static void main(String[] args) {
        NewRateLimiter rateLimiter = new NewRateLimiter();
        System.out.println(
                rateLimiter.allowReq("A", 1)
        ); // true

        System.out.println(
                rateLimiter.allowReq("A", 2)
        ); // true

        System.out.println(
                rateLimiter.allowReq("A", 3)
        ); // true

        System.out.println(
                rateLimiter.allowReq("A", 5)
        ); // false

        System.out.println(
                rateLimiter.allowReq("A", 12)
        ); // true


    }
}
