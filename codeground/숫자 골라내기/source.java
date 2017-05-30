import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception	{
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int TC;
        int test_case;

        TC = sc.nextInt();
        for(test_case = 1; test_case <= TC; test_case++) {
            // 이 부분에서 알고리즘 프로그램을 작성하십시오.
            int countOfNumber =sc.nextInt();
            int result=0;

            for(int i=0; i<countOfNumber; i++){
                result = result ^ sc.nextInt();
            }//for

            System.out.println("Case #" + test_case);
            System.out.println(result);
        }
    }
}