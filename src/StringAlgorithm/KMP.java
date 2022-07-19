package StringAlgorithm;

public class KMP {
    public static void main(String[] args) {
        String str = "ababacabacaabacaaba";
        String pattern = "abacaaba";

        kmp(str, pattern);
    }

    static int[] makeTable(String pattern) {
        // 접두사 접미사 일치 테이블 만들기
        char[] pattc = pattern.toCharArray();
        int[] table = new int[pattc.length];
        int j = 0;

        for (int i = 1; i < pattc.length; i++) {
            while (j > 0 && pattc[i] != pattc[j]) {
                // 불일치가 나오면 전까지 일치했던 접두사만큼 점프.
                j = table[j - 1];
            }

            if (pattc[i] == pattc[j]) {
                table[i] = ++j;
            }
        }
        return table;
    }

    static void kmp(String str, String pattern) {
        int[] table = makeTable(pattern);
        char[] strc = str.toCharArray();
        char[] pattc = pattern.toCharArray();
        int j = 0;

        for (int i = 0; i < strc.length; i++) {
            while (j > 0 && strc[i] != pattc[j]) {
                j = table[j-1];
            }

            if (strc[i] == pattc[j]) {
                if (j == pattc.length-1) {
                    System.out.printf("%d번째에서 찾았습니다!\n", i - pattc.length + 2);
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
    }
}
