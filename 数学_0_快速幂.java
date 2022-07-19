public class qPow {
    public static void main(String[] args) {
        int base = 9, power = 5;
        int res = 1;
        while (power!=0){
            if ((power & 1) == 1)
                res  *= base;
            power>>=1;
            base = base * base;
        }
        System.out.println(res);
        System.out.println(Math.pow(9,5));

    }
}
