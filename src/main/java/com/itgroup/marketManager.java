package com.itgroup;

import com.itgroup.bean.client;
import com.itgroup.bean.market;
import com.itgroup.bean.marketer;
import com.itgroup.dao.clientDao;
import com.itgroup.dao.marketDao;
import com.itgroup.dao.marketerDao;

import java.util.List;
import java.util.Scanner ;


public class marketManager {
    private Scanner scan = null;
    private marketDao markDao = null;
    private marketerDao mrkerDao = null;
    private clientDao cliedao = null;
    private String marketerId = null;
    private String userId = null;

    public marketManager() {
        this.markDao = new marketDao();
        this.mrkerDao = new marketerDao();
        this.cliedao = new clientDao();
        this.scan=new Scanner(System.in);
    }




    public int marketerLoginData() {
        System.out.println("아이디 입력 : ");
        String findId = scan.next();
        this.marketerId = findId;
        System.out.println("비밀번호 입력 : ");
        String findpw = scan.next();
        int someone = mrkerDao.checkLogin(findId,findpw);
        int let = 0 ;

        if (someone == 1) {
            System.out.println("로그인 되었습니다.");
            let = 1;

        }else  {
            System.out.println("아이디 또는 비밀번호가 잘못 되었습니다.");
            let = 0;

        }
        return let;
    }




    public int clientLoginData() {
        System.out.println("아이디 입력 : ");
        String findId = scan.next();
        this.userId = findId;
        System.out.println("비밀번호 입력 : ");
        String findpw = scan.next();
        int someone = cliedao.checkLogin(findId,findpw);
        int let = 0 ;

        if (someone == 1) {
            System.out.println("로그인 되었습니다.");
            let = 1;

        }else  {
            System.out.println("아이디 또는 비밀번호가 잘못 되었습니다.");
            let = 0;

        }
        return let;

    }


    public void lookpost() {
        List<market> markets = markDao.lookpost();
        System.out.println("게시물을 보여드리겠습니다.");
        System.out.println("번호\t제목\t가격\t악기종류\t판매자\t갯수");
        for (market bean : markets){
            int no = bean.getNom();
            String name = bean.getPost();
            int price = bean.getPrice();
            String kind = bean.getKind();
            String seller = bean.getSeller();
            int onoff = bean.getOnoff();
            String message = no+"\t"+name+"\t"+price+"\t"+kind+"\t"+seller+"\t"+onoff;
            System.out.println(message);
        }
    }

    public void getclieone() {
        String findId= userId ;
        client someone = cliedao.getMemberone(findId);

        if (someone == null){
            System.out.println("회원님의 정보가 확인되지 않습니다.");
        }else {
            System.out.println("아이디\t이름\t비밀번호\t구매한 악기\t결제한 금액\t멤버십 등급\t장바구니");
            String Id =someone.getCid();
            String name = someone.getCname();
            String pass = someone.getCpassword();
            String by = someone.getCby();
            int total = someone.getTotal();
            String member = someone.getMembership();
            String basket = someone.getBasket();
            String message = Id+"\t"+name+"\t"+pass+"\t"+by+"\t"+total+"\t"+member+"\t"+basket;
            System.out.println(message);
        }

    }

    public void getslietotal() {
        String findId = userId;
        client findTotal = cliedao.getTotal(findId);
        int total = findTotal.getTotal();
        if (total == 0){
            System.out.println("결제가 된 기록이 없습니다.");
        }else {
            System.out.println("회원님의 지금까지 총 결제 내역은 : ");

            System.out.println(total + "만원 입니다");
        }
    }

    public void setpushbasket() {
        int cnt= -1;
        String Id=this.userId;
        List<market> markets = markDao.lookpost();
        System.out.println("게시물을 보여드리겠습니다.");
        System.out.println("번호\t제목\t가격\t악기종류\t판매자\t갯수");

        for (market bean : markets){
            int no = bean.getNom();
            String name = bean.getPost();
            int price = bean.getPrice();
            String kind = bean.getKind();
            String seller = bean.getSeller();
            int onoff = bean.getOnoff();
            String message = no+"\t"+name+"\t"+price+"\t"+kind+"\t"+seller+"\t"+onoff;
            System.out.println(message);
        }
        System.out.println("장바구니에 넣고싶은 악기 종류를 입력해 주세요 : ");
        String post = scan.next();
        cnt = cliedao.pushbasket(post,Id);

        if (cnt == -1){
            System.out.println("장바구니 담기 실패");
        } else if (cnt == 1) {
            System.out.println("장바구니 담기 성공");
        }
    }

    public void lookbasket() {
        String Id=this.userId;
        client basket = cliedao.getbasket(Id);
        System.out.println("회원님의 장바구니 입니다");
        if (basket == null){
            System.out.println("회원님의 장바구니가 비워져 있습니다");
        }else {
            String bas = basket.getBasket();
            System.out.println(bas+"이(가) 들어가 있습니다.");
        }
    }
}
