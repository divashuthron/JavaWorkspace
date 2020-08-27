package com.java.project;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManagement {
    public static void main(String[] args) {
        ArrayList<Account> ac = new ArrayList<Account>();
        AccountService as = new AccountService();
        Scanner sc = new Scanner(System.in);

        int sysStatus = 0;
        int maxAccount = 0;

        while(true) {
            System.out.println("--------------------");
            System.out.println("1. 계좌개설 2. 입금 3. 출금 4. 이체 5. 계좌리스트 6. 계좌잔고조회 7.종료");
            System.out.println("--------------------");
            System.out.print("메뉴 >> ");
            sysStatus = sc.nextInt();

            try {
                switch (sysStatus) {
                    case 1:
                        //계좌 개설
                        if (maxAccount <= 10) {
                            ac.add(as.newAccount(ac, maxAccount));
                            maxAccount++;
                            System.out.println("잔여 계좌 개설 개수: " + (10 - maxAccount));
                        }
                        break;
                    case 2:
                        //입금 처리
                        ac = as.desposit(ac);
                        break;
                    case 3:
                        //출금 처리
                        ac = as.withdrawal(ac);
                        break;
                    case 4:
                        //이체 처리
                        ac = as.transfer(ac);
                        break;
                    case 5:
                        //계좌 리스트 조회
                        as.getAccountList(ac);
                        break;
                    case 6:
                        //계좌 잔고 조회
                        as.getBalance(ac);
                        break;
                    case 7:
                        as.exit();
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
