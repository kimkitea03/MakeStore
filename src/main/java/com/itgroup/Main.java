package com.itgroup;

import java.util.Scanner ;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("로그인 선택");
            System.out.println("0: 종료, 1: 판매자 로그인, 2: 구매자 로그인");

            int menu = scan.nextInt();
            switch (menu) {
                case 0:
                    System.out.println("프로그렘을 종료 합니다.");
                    System.exit(0);//운영체제에게 종료됨을 알리고 빠져 나가기
                case 1:
                    //로그인 하는 프로그렘

                    //로그인 후
                    System.out.println("판매자님 반갑습니다. 메뉴를 선택해 주세요");
                    System.out.println("0: 로그아웃, 1: 회원 정보, 2: 회원 게시물, 3: 판매금액 확인, 4: 게시물 확인, 5: 게시물 추가, 6: 게시물 삭제, 7: 판메자 정보");
                    while (true){

                    }
                case 2:
                    while (true){
                        //로그인 하는 프로그렘

                        //로그인 후
                        System.out.println("회원님 반갑습니다. 메뉴를 선택해 주세요");
                        System.out.println("0: 로그아웃, 1: 회원 정보, 2: 게시물 보기, 3: 결제금액 확인, 4: 장바구니 넣기, 5: 장바구니 비우기, 6: 장바구니 전부 비우기, 7: 결제하기");

                    }
            }
        }


    }
}