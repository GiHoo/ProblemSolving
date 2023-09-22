package boj;

import java.io.*;

public class J3085 {
    private static char[][] arr;    // 맵 크기
    private static int N;            // 맵 크기
    private static int max = 0;        //최대 사탕 수


    /* 가로로, 세로로 비교하면서 먹을 수 있는 사탕의 최대 갯수 찾기 */
    public static void arrCheck() {

        // 가로 체크
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) count++;
                else count = 1;
                max = Math.max(max, count);
            }
        }

        // 세로 체크
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) count++;
                else count = 1;
                max = Math.max(max, count);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        /* 가로로 인접한 두 사탕 교환하고 최대 사탕 개수 찾고 원위치 */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                char temp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = temp;

                arrCheck();

                temp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = temp;
            }
        }

        /* 세로로 인접한 두 사탕 교환하고 최대 사탕 개수 찾고 원위치 */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {

                char temp = arr[j][i];
                arr[j][i] = arr[j + 1][i];
                arr[j + 1][i] = temp;

                arrCheck();

                temp = arr[j][i];
                arr[j][i] = arr[j + 1][i];
                arr[j + 1][i] = temp;
            }
        }
        System.out.println(max);
    }
}

    /*
    C : 빨
    P : 파
    Z : 초
    Y : 노
     */