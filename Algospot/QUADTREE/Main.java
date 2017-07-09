import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Solution{
    final int MAX_SIZE = 1024;
    char[][] decompressed = new char[MAX_SIZE][MAX_SIZE];
    ArrayList<String> quadtree_al = new ArrayList<>();

    void decompress(Iterator<String> it, int y, int x, int size){

        String head = it.next();

        if(head=="b" || head=="w") {
            for(int dy=0; dy<size; dy++)
                for(int dx=0; dx<size; dx++)
                    decompressed[y+dy][x+dx] = head.charAt(0);
        }
        else {
            int half = size/2;
            decompress(it, y, x, half);
            decompress(it, y, x+half, half);
            decompress(it, y+half, x, half);
            decompress(it, y+half, x+half, half);
        }
    }

    String reverse(Iterator<String> it){
        if(!it.hasNext())
            return "";
        String head = it.next();

        if(head.charAt(0)=='b')
            return "b";
        else if(head.charAt(0)=='w')
            return "w";

        String ul = reverse(it);
        String ur = reverse(it);
        String ll = reverse(it);
        String lr = reverse(it);
        return "x" + ll + lr + ul + ur;
    }

    void solve(){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();
        for(int cc=0; cc<cases; cc++){
            quadtree_al.clear();
            String quadtree = sc.nextLine();

            for(int i=0; i<quadtree.length(); i++){
                quadtree_al.add("" + quadtree.charAt(i));
            }

            assert(quadtree.length() <= 1000);
            assert(quadtree.length() == 1 + 4 * count(0, quadtree.length()-1, 'x'));
            Iterator<String> it = quadtree_al.iterator();
            String reversed =  reverse(it);
            System.out.println(reversed);
        }
    }

    int count(int begin, int end, char ch){
        int ret=0;

        for(int i=0; i<=end; i++){
            if(quadtree_al.get(i).charAt(0) == 'x'){
                ret++;
            }
        }

        return ret;
    }

    ArrayList<String> repr(Iterator<String> it){

        String head = it.next();

        if(head=="b"){
            ArrayList<String> temp = new ArrayList<>();
            temp.add("#");
            return temp;
        }
        if(head=="w"){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(".");
            return temp;
        }

        ArrayList<String> ul = repr(it);
        ArrayList<String> ur = repr(it);
        ArrayList<String> ll = repr(it);
        ArrayList<String> lr = repr(it);

        int sz = max(max(ul.size(), ur.size()), max(ll.size(), lr.size()));
        return merge(resize(ul, sz), resize(ur, sz), resize(ll, sz), resize(lr, sz));
    }

    int max(int a, int b){
        return a>b ? a : b;
    }

    ArrayList<String> merge(ArrayList<String> ul, ArrayList<String> ur, ArrayList<String> ll, ArrayList<String> lr){
        ArrayList<String> ret = new ArrayList<>();
        for(int i=0; i<ul.size(); i++){
            ret.add(ul.get(i) + ur.get(i));
        }
        for(int i=0; i<ll.size(); i++){
            ret.add(ll.get(i) + lr.get(i));
        }
        return ret;
    }

    ArrayList<String> resize(ArrayList<String> original, int sz){
        if (sz==original.size())
            return original;
        ArrayList<String> ret = new ArrayList<>();
        init_al(ret, sz);
        int factor = sz/original.size();
        for(int i=0; i<sz; i++)
            for(int j=0; j<sz; j++)
                ret = modifyChar(ret, i, j, factor);

        return ret;

    }

    ArrayList<String> modifyChar(ArrayList<String> board, int ny, int nx, int factor){
        String temp = board.get(ny/factor);
        String temp2 = temp.substring(0, nx-1) + temp.charAt(nx/factor) + temp.substring(nx);
        board.set(ny, temp2);
        return board;
    }

    ArrayList<String> init_al(ArrayList<String> al, int sz){
        for(int i=0; i<sz; i++){
            al.add("0");
        }
        return al;
    }
}

class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}