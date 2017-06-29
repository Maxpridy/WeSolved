import java.util.ArrayList;
import static java.lang.Math.abs;


class Boggle{
    ArrayList<String> board = new ArrayList<>();

    boolean hasWord(int y, int x, String word){
        if(y<0 || x<0 || y>=5 || x>=5) {
            return false;
        }
        if(board.get(y).charAt(x) != word.charAt(0)) {
            return false;
        }
        if(word.length() == 1){
            return true;
        }

        for(int dx=-1; dx<=1; ++dx){
            for(int dy=-1; dy<=1; ++dy) {
                if (hasWord(y + dy, x + dx, word.substring(1)) & (isTrue(abs(dx)) | isTrue(abs(dy)))) {
                    return true;
                }
            }
        }
        return false;
    }

    int isOne(boolean b){
        if(b)
            return 1;
        else
            return 0;
    }

    boolean isTrue(int value){
        if(value==0) {
            return false;
        }
        else
            return true;
    }

    void run(){
        board.add("URLPM");
        board.add("XPRET");
        board.add("GIAET");
        board.add("XTNZY");
        board.add("HOQRS");
        assert(hasWord(1, 1, "PRETTY"));
        assert(hasWord(2, 0, "GIRL"));
        assert(hasWord(4, 0, "HONEY"));
        assert(!hasWord(1, 1, "PRETTMY"));
        assert(!hasWord(2, 0, "GIRAL"));
    }
}



class Main{
    public static void main(String[] args){
        Boggle boggle = new Boggle();
        boggle.run();
        System.out.println("all test passed");
    }
}