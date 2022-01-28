package recap.v3.extra;

public class StringProduct {

    public static void main(String[] args) {
        StringProduct stringProduct = new StringProduct();
        System.out.println(stringProduct.multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int n = num1.length();
        int m = num2.length();
        int k = n + m;
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);

        sb1.reverse();
        sb2.reverse();

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < k; i++)
            res.append('0');

        int c = 0;
        for (int i = 0; i < n; i++) {
            int d1 = sb1.charAt(i) - '0';
            for (int j = 0; j < m; j++) {
                int d2 = sb2.charAt(j) - '0';
                int d = res.charAt(i + j) - '0';

                int r = d1 * d2 + c + d;
                res.setCharAt(i + j, (char)(r % 10 + '0'));
                c = r / 10;
            }
            if (c != 0) {
                res.setCharAt(i + m, (char)(c + '0'));
                c = 0;
            }
        }

        res.reverse();
        if (res.charAt(0) == '0')
            return res.substring(1);
        return res.toString();
    }
}
