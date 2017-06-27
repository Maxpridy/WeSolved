import java.util.Scanner;


@FunctionalInterface
interface Func{
    public boolean method(int x);
}

class Main {

    static int m, n;
    static boolean areFriends[][] = new boolean[10][10];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        Func func = (a) -> (a>0 ? true : false);
        while(func.method(cases)) {
            cases--;

            n = sc.nextInt();
            m = sc.nextInt();

            assert(n<=10);
            for(int i=0; i<(m); i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                assert(0<=a && a<n && 0<=b && b<n);
                assert(!areFriends[a][b]);
                areFriends[a][b] = areFriends[b][a] = true;
            }

            boolean taken[] = new boolean[10];
            System.out.println(countPairings(taken));
        }

    }

    static int countPairings(boolean[] taken){
        int firstFree = -1;

        for(int i=0; i<(n); i++){
            if(!taken[i]){
                firstFree = i;
                break;
            }
        }

        if(firstFree == -1)
            return 1;
        int ret = 0;
        for(int pairWith = (firstFree+1); pairWith<(n); pairWith++){
            if(!taken[pairWith] && areFriends[firstFree][pairWith]){
                taken[firstFree] = taken[pairWith] = true;
                ret += countPairings(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return ret;
    }

}