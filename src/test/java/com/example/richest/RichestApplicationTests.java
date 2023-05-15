package com.example.richest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RichestApplicationTests {
    static final  int MAX_NUM=8;
    int chessBoard[][]=new int[MAX_NUM][MAX_NUM];


    @Test
    void contextLoads() {
      settleQueen(0);
       //打印内容这里是
        printChessBoard();

    }

    //输出内容
    void printChessBoard(){
        for(int a=0;a<MAX_NUM;a++){
            for(int b=0;b<MAX_NUM;b++){
                System.out.println(chessBoard[a][b]);
            }
            System.out.println();
        }
    }

    Boolean settleQueen(int y ){
        if(y==MAX_NUM){
            return true;
        }
        for(int i=0;i<MAX_NUM;i++){
            for(int x=0;x<MAX_NUM;x++){
                chessBoard[x][y]=0;

            }
            if(check(i,y)){
                chessBoard[i][y]=1;
                if(settleQueen(y+1)){
                        return  true;
                }
            }
        }

        return  false;
    }



    //检查内容
    public boolean check(int x  , int y){
        for(int i=0;i<y;i++){
            if(chessBoard[x][i]==1){
                return  false;
            }
            //检查左倾斜
            if(x-1-i>=0 && chessBoard[x-1-i][y-1-i]==1){
                return  false;
            }
            //检查右倾斜
            if(x+1-i<MAX_NUM && chessBoard[x+1+i][y-1-i]==1){
                return  false;
            }

        }
            return true;

    }

    



    public static void countSort(int[] arr){
        if (arr == null ||arr.length<2){
            return;
        }
        //找到数组中最大的数
        int max = Integer.MIN_VALUE;
        for (int i =0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        //实例化一组桶
        int[] bucket =  new int[max+1];
        //把数组中的数放到自己的桶中
        for (int i=0;i<arr.length;i++){
            bucket[arr[i]]++;
        }
        //按照桶的顺序把数倒出来
        int i=0;
        for (int j=0;j<bucket.length;j++){
            while (bucket[j]-->0){
                arr[i++]=j;
            }
        }



    }

}
