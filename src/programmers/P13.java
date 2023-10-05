package programmers;

public class P13 {
    public int solution(int a, int b, int n) {
    int returnCoke = 0;
    int emptySet = 0;
    while(n >= a) {
        returnCoke += (n/a)*b;
        emptySet = n%a;
        n = (n/a)*b + emptySet;
    }
    return returnCoke;
}
}
