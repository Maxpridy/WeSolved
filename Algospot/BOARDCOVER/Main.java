import java.util.ArrayList;
import java.util.Scanner;


class Solution{
    final int coverType[][][] = {
            {{0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {0, 1}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {1, -1}}};


    boolean set(ArrayList<ArrayList<Integer>> board, int y, int x, int type, int delta){
        boolean ok = true;

        for(int i=0; i<3; i++){
            int ny = y + coverType[type][i][0];
            int nx = x + coverType[type][i][1];
            if(ny<0 || ny>=board.size() || nx<0 || nx>=board.get(0).size())
                ok = false;
            else if((modifyValue(board, ny, nx, delta).get(ny).get(nx)) > 1)
                ok = false;
        }
        return ok;
    }

    ArrayList<ArrayList<Integer>> modifyValue(ArrayList<ArrayList<Integer>> board, int ny, int nx, int delta){
        ArrayList<Integer> temp = board.get(ny);
        temp.set(nx, temp.get(nx)+delta);
        board.set(ny, temp);
        return board;
    }

    int cover(ArrayList<ArrayList<Integer>> board){
        int y=-1, x=-1;
        for(int i=0; i<board.size(); i++){
            for(int j=0; j<board.get(i).size(); j++){
                if(board.get(i).get(j) == 0){
                    y = i;
                    x = j;
                    break;
                }
            }
            if(y != -1)
                break;
        }

        if(y==-1)
            return 1;

        int ret=0;
        for(int type=0; type<4; type++){
            if(set(board, y, x, type, 1))
                ret += cover(board);
            set(board, y, x, type, -1);
        }
        return ret;
    }

    void solve() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int cc=0; cc<cases; cc++){
            int height = sc.nextInt();
            int width = sc.nextInt();
            sc.nextLine();
            assert(1<=height && height<=20);
            assert(1<=width && width<=20);
            ArrayList<ArrayList<Integer>> board = new ArrayList<>();
            board = init(board, height, width);
            int whites = 0;
            for(int i=0; i<height; i++){
                String s = sc.nextLine();
                for(int j=0; j<width; j++){
                    if(s.charAt(j) == '#'){
                        ArrayList<Integer> temp = board.get(i);
                        temp.set(j, 1);
                        board.set(i, temp);
                    }
                }
                whites += count(board.get(i), 0);
            }
            assert(whites<=50);
            int ways = cover(board);
            System.out.println(ways);
        }
    }

    ArrayList<ArrayList<Integer>> init (ArrayList<ArrayList<Integer>> board, int height, int width){

        ArrayList<Integer> temp;
        for(int i=0; i<height; i++){
            temp = new ArrayList<>();
            for(int j=0; j<width; j++){
                temp.add(0);
            }
            board.add(temp);
        }

        return board;
    }

    int count(ArrayList<Integer> al, int target){
        int ret=0;

        for(int num : al) {
            if(num == target){
                ret++;
            }
        }
        return ret;
    }
}


class Main{
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solve();
    }
}