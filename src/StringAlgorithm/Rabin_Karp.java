package StringAlgorithm;

class Rabin_Karp {
    public static void main(String[] args) {
        String str = "ababacabacaabacaaba";
        String pattern = "abacaaba";

        findString(str, pattern);
    }

    static void findString(String str, String pattern) {
        char[] strc = str.toCharArray();
        char[] pattc = pattern.toCharArray();
        int strHash = 0; int patternHash = 0; int power = 1;

        for (int i = 0; i <= strc.length - pattc.length; i++) {
            // 처음부터 끝까지 반복 n번
            if (i == 0) {
                // 초기화
                for (int j = 0; j < pattc.length; j++) {
                    strHash += strc[pattc.length - 1 - j] * power;
                    patternHash += pattc[pattc.length - 1 - j] * power;

                    if (j < pattc.length - 1) power *= 2; // 자리수마다 2의 제곱수를 더해간다. 
                }
            } else {
                strHash = 2 * (strHash - strc[i-1]*power) + strc[pattc.length - 1 + i];
                // 해쉬값 갱신
            }

            if (strHash == patternHash) {
                boolean finded = true;
                // 단순 해쉬충돌이 아닌지 판별
                for (int j = 0; j < pattc.length; j++) {
                    if (strc[i + j] != pattc[j]) {
                        finded = false;
                        break;
                    }
                }
                // 단순 충돌이 아니라면 추가.
                if (finded) {
                    System.out.printf("%d번째에서 찾았습니다!\n", i+1);
                }
            }
        }
    }
}