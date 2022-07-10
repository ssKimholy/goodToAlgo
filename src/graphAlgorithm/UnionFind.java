package graphAlgorithm;

class UnionFind {
    static int[] arr = new int[9];
    public static void main(String[] args) {
        for (int i = 1; i < 9; i++) {
            arr[i] = i;
        }

        union(1, 2);
        union(2, 3);
        union(3, 4);
        union(5, 6);
        union(6, 7);
        union(7, 8);
        System.out.println("isSame 1, 5? : " + find(1, 5));

        union(1, 6);

        System.out.println("isSame 1, 5? : " + find(1, 5));
    }

    static int getParent(int i) {
        // 부모를 찾고 갱신하는 함수
        if (i == arr[i]) {
            return i;
        }
        return arr[i] = getParent(arr[i]);
    }

    static void union(int x, int y) {
        // 두 노드의 부모를 합치는 함수

        x = getParent(x);
        y = getParent(y);

        if (x < y) {
            arr[y] = x;
        } else {
            arr[x] = y;
        }
    }

    static boolean find(int x, int y) {

        // 두 노드의 부모가 같은지 보는 함수.

        x = getParent(x);
        y = getParent(y);

        if (x == y) {
            return true;
        } else {

            return false;

        }

    }



}
