import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.min;

class Solution {
    final int INF = 9999, SWITCHES = 10, CLOCKS = 16;
    final String[] linked = {
            "xxx.............",
            "...x...x.x.x....",
            "....x.....x...xx",
            "x...xxxx........",
            "......xxx.x.x...",
            "x.x...........xx",
            "...x..........xx",
            "....xx.x......xx",
            ".xxxxx..........",
            "...xxx...x...x.."};

    boolean areAligned(ArrayList<Integer> clocks){
        for(int i=0; i<CLOCKS; i++){
            if(clocks.get(i)%4 != 0){
                return false;
            }
        }
        return true;
    }

    void push(ArrayList<Integer> clocks, int swtch){
        for(int clock=0; clock<CLOCKS; clock++){
            if(linked[swtch].charAt(clock) == 'x'){
                clocks.set(clock, clocks.get(clock) + 3);
            }
        }
    }

    int solve(ArrayList<Integer> clocks, int swtch){
        if(swtch == SWITCHES)
            return areAligned(clocks) ? 0 : INF;
        int ret = INF;
        for(int cnt=0; cnt<4; cnt++){
            ret = min(ret, cnt+solve(clocks, swtch+1));
            push(clocks, swtch);
        }
        return ret;
    }
}

class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int cc=0; cc<cases; cc++){
            ArrayList<Integer> clocks = new ArrayList<>();
            clocks = init(clocks, 16);
            for(int i=0; i<16; i++){
                clocks.set(i, sc.nextInt());
            }
            Solution sol = new Solution();
            int ret = sol.solve(clocks, 0);
            System.out.println(ret>=sol.INF ? -1 : ret);
        }
    }

    static ArrayList<Integer> init(ArrayList<Integer> al, int index){
        for(int i=0; i<index; i++){
            al.add(0);
        }
        return al;
    }
}