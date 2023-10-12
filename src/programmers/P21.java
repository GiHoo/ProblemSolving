package programmers;

import java.util.Stack;

public class P21 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int[] wall = new int[n];
        for(int i=0; i<section.length; i++) {
            int wall_point = section[i];
            wall[wall_point-1] = 1;
        }

        int index = 0;
        while(index<wall.length) {
            if(wall[index] == 0) {
                index++;
                continue;
            }
            else {
                for(int i = index; i<index+m; i++) {
                    if(i>=wall.length) break;
                    wall[i] = 1;
                }
                answer++;
                index += m;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new P21().solution(8, 4, new int[]{2, 3, 6}));
    }
}

/*

페인트 칠해진 길이가 n인 벽을 덧칠
벽을 1미터의 길이의 구역 n개로 나눔, 왼쪽부터 1~n번 번호

페인트를 칠하는 롤러의 길이 m
    롤러가 벽에서 벗어나면 안됨
    구역의 일부분만 칠하면 안됨


한 번 칠하면 그 끝까지는 해야 함

페인트가 칠해진 곳은 0, 칠하지 않은 곳은 1

0 1 1 0 0 1 0 0
0부터 시작해서
만일 칠하지 않은 곳(1)을 발견한다면
그 부분 ~ 그부분+m 까지 0으로 대입
그 후 i는 그부분+m으로 이동



*/

