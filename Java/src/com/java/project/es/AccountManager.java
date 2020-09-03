package com.java.project.es;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class AccountManager {
    public static void main(String[] args) throws ParseException {
        ArrayList<Account> acclist = new ArrayList<Account>();
        Scanner sc = new Scanner(System.in);

        int select = 0;

        while (true) {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("1. 계좌개설 2. 입금 3. 출금 4. 이체 5. 전체리스트 6. 계좌잔고조회 7. 종료 8. 정렬");
                System.out.println("-----------------------------------------------------------------");

                System.out.print("메뉴: ");
                select = sc.nextInt();

                switch(select) {
                    case 1:
                        System.out.println("------ 계좌생성");
                        System.out.println("1. 적금계좌 2. 대출계좌");

                        int accSelect = sc.nextInt();

                        if (accSelect == 1) {
                            System.out.println("계좌번호 잔액 이름 이자율 입력");

                            if (sc.hasNext()) {
                                String id = sc.next();
                                int balance = Integer.parseInt(sc.next());
                                String name = sc.next();
                                double rate = Double.parseDouble(sc.next());

                                SavingAccount acc = new SavingAccount();
                                acc.setId(id);
                                acc.setBalance(balance);
                                acc.setName(name);
                                acc.setRate(rate);

                                acclist.add(acc);
                            }
                        } else if (accSelect == 2) {
                            System.out.println("계좌번호 잔액 이름 이자 만기일 입력");

                            if (sc.hasNext()) {
                                String id = sc.next();
                                int balance = Integer.parseInt(sc.next());
                                String name = sc.next();
                                double loanRate = Double.parseDouble(sc.next());
                                Date reDate = new SimpleDateFormat("yyyy-MM-dd").parse(sc.next());

                                LoadAccount acc = new LoadAccount();
                                acc.setId(id);
                                acc.setBalance(balance);
                                acc.setName(name);
                                acc.setLoanRate(loanRate);
                                acc.setReDate(reDate);

                                acclist.add(acc);
                            }
                        }
                        break;

                    case 2:
                        System.out.println("------ 입금");
                        System.out.println("계좌번호 금액 입력");

                        if (sc.hasNext()) {
                            String id = sc.next();
                            int balance = Integer.parseInt(sc.next());

                            for (int i = 0; i < acclist.size(); i++) {
                                if (acclist.get(i).getId().equals(id)) {
                                    if (acclist.get(i) instanceof SavingAccount) {
                                        acclist.get(i).desposit(balance);
                                    } else {
                                        System.out.println("대출 계좌는 입금처리를 할 수 없습니다.");
                                    }
                                }
                            }
                        }
                        break;

                    case 3:
                        System.out.println("------ 출금");
                        System.out.println("계좌번호 금액 입력");

                        if (sc.hasNext()) {
                            String id = sc.next();
                            int balance = Integer.parseInt(sc.next());

                            for (int i = 0; i < acclist.size(); i++) {
                                if (acclist.get(i).getId().equals(id)) {
                                    if (acclist.get(i) instanceof SavingAccount) {
                                        acclist.get(i).withdrawal(balance);
                                    } else {
                                        System.out.println("대출 계좌는 출금처리를 할 수 없습니다.");
                                    }
                                }
                            }
                        }
                        break;

                    case 4:
                        System.out.println("------ 이체");
                        System.out.println("본인 계좌번호 입력");

                        if (sc.hasNext()) {
                            String id = sc.next();

                            System.out.println("이체할 계좌번호 금액 입력");

                            if (sc.hasNext()) {
                                String id2 = sc.next();
                                int balance = Integer.parseInt(sc.next());

                                for (int i = 0; i < acclist.size(); i++) {
                                    for (int j = 0; i < acclist.size(); i++) {
                                        if (acclist.get(i).getId().equals(id) && acclist.get(j).getId().equals(id2)) {
                                            if (acclist.get(i) instanceof SavingAccount && acclist.get(j) instanceof SavingAccount) {
                                                acclist.get(i).withdrawal(balance);
                                                acclist.get(j).desposit(balance);
                                            } else {
                                                System.out.println("대출 계좌는 이체처리를 할 수 없습니다.");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;

                    case 5:
                        System.out.println("------ 전체 리스트");
                        System.out.println("---------------------------------");
                        System.out.println("계좌번호　　　　　잔액　　　　　계좌주명");
                        System.out.println("---------------------------------");

                        for (int i = 0; i < acclist.size(); i++) {
                           System.out.println(acclist.get(i).getId() + "　　　　　　　" +
                                   acclist.get(i).getBalance() + "　　　　　" +
                                   acclist.get(i).getName());
                        }

                        System.out.println("---------------------------------");
                        break;

                    case 6:
                        System.out.println("------ 계좌 잔고 조회");
                        System.out.println("계좌번호 입력");

                        if (sc.hasNext()) {
                            String id = sc.next();

                            for (int i = 0; i < acclist.size(); i++) {
                                if (acclist.get(i).getId().equals(id)) {
                                    System.out.println(acclist.get(i).getBalance() + "원");
                                }
                            }
                        }
                        break;

                    case 7:
                        System.out.println("------ 종료");
                        return;

                    case 8:
                        System.out.println("------ 정렬");
                        Collections.sort(acclist);

                        //정렬 결과 확인용 소스코드
                        /*
                        System.out.println("------ 전체 리스트");
                        System.out.println("---------------------------------");
                        System.out.println("계좌번호　　　　　잔액　　　　　계좌주명");
                        System.out.println("---------------------------------");

                        for (int i = 0; i < acclist.size(); i++) {
                            System.out.println(acclist.get(i).getId() + "　　　　　　　" +
                                    acclist.get(i).getBalance() + "　　　　　" +
                                    acclist.get(i).getName());
                        }

                        System.out.println("---------------------------------");
                        break;
                        */
                }
        }
    }
}
