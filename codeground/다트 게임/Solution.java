import java.util.Scanner;

class Solution {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();  // 테스트 케이스 횟수 입력
        for(int test_case = 0; test_case < T; test_case++) {

            int[] score = {6,13,4,18,1,20,5,12,9,14,11,8,16,7,19,3,17,2,15,10};
            //다트판 초기화
            int A = sc.nextInt();   // Bull의 반지름 입력
            int B = sc.nextInt();   // Triple시작구간의 반지름 입력
            int C = sc.nextInt();   // Triple종료구간의 반지름 입력
            int D = sc.nextInt();   // Double시작구간의 반지름 입력
            int E = sc.nextInt();   // Double종료구간의 반지름 입력

            int n = sc.nextInt();   // 정우가 쏜 다트의 개수 입력

            int Answer = 0;         // 다트게임의 총 점수
            for(int i=0; i<n; i++){ // 정우가 쏜 다트의 개수만큼 반복
                int x = sc.nextInt(); // x좌표 입력
                int y = sc.nextInt(); // y좌표 입력

                double r = Math.sqrt(x*x+y*y); // 다트의 (x,y)좌표를 이용하여 반지름 설정
                if(r<A){                       // 다트가 Bull안에 들어가면
                    Answer+=50;                // 50점 추가
                    continue;                  // 다음다트 던지러
                }
                if(r>E){                       // 다트가 다트판 밖을 맞추면
                    continue;                  // 점수 추가 없이 다음다트 던지러
                }
                int m = 1;                     // 획득점수에 곱할 변수
                if(r>B && r<C)                 // 다트가 Triple안에 들어가면
                    m=3;                       // 3배
                if(r>D && r<E)                 // 다트가 Double안에 들어가면
                    m=2;                       // 2배


                double theta = Math.atan(y/(double)x);
                theta *= (180/Math.PI);
                if(x<0)
                    theta+=180;
                theta +=9;
                theta = (theta + 360) % 360;
                int t = (int)(theta/18);
                int add = m*score[t];          // 다트판에 해당하는 점수
                Answer+=(add);                 // 총 점수에 추가
            }

            System.out.println("Case #" + (test_case+1));
            System.out.println(Answer);
        }
    }
}