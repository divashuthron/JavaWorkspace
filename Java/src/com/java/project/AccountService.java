package com.java.project;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountService {
    Scanner sc = new Scanner(System.in);

    public Account newAccount(ArrayList<Account> alac, int mxc) {
        Account ac = new Account();
        try {
            System.out.println("------ 계좌 생성");
            System.out.print("계좌번호 입력 >> ");
            String orgNum = sc.next();
            System.out.print("잔고 입력 >> ");
            int balance = sc.nextInt();
            System.out.print("이름 입력 >> ");
            String name = sc.next();

            for (int i = 0; i < alac.size(); i++) {
                if (alac.get(i).getOriginNumber().equals(orgNum)) {
                    System.out.println("실패: 동일한 계좌번호가 존재합니다.");
                    throw new Exception();
                }
            }

            ac.setOriginNumber(orgNum);
            ac.setBalance(balance);
            ac.setName(name);
            System.out.println("성공: 계좌 개설");

        } catch (Exception e) {
            System.out.println("실패: 계좌 개설");
            e.printStackTrace();
            System.exit(1);
        }
        return ac;
    }

    public ArrayList<Account> desposit(ArrayList<Account> alac) {
        try {
            System.out.println("------ 입금 처리");
            System.out.print("계좌번호 입력 >> ");
            String orgNum = sc.next();

            for (int i = 0; i < alac.size(); i++) {
                if (alac.get(i).getOriginNumber().equals(orgNum)) {
                    System.out.print("입금액 입력 >> ");
                    int balance = sc.nextInt();

                    alac.get(i).setBalance(alac.get(i).getBalance() + balance);
                    System.out.println("성공: 입금 처리");
                    System.out.println("계좌 잔액: " + alac.get(i).getBalance());
                } else {
                    System.out.println("실패: 해당하는 계좌번호가 존재하지 않습니다.");
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("실패: 입금 처리");
            e.printStackTrace();
            System.exit(1);
        }
        return alac;
    }

    public ArrayList<Account> withdrawal(ArrayList<Account> alac) {
        try {
            System.out.println("------ 출금 처리");
            System.out.print("계좌번호 입력 >> ");
            String orgNum = sc.next();

            for (int i = 0; i < alac.size(); i++) {
                if (alac.get(i).getOriginNumber().equals(orgNum)) {
                    System.out.print("출금액 입력 >> ");
                    int balance = sc.nextInt();

                    if (balance > alac.get(i).getBalance()) {
                        System.out.println("실패: 출금하고자 하는 액수가 잔고량보다 많습니다.");
                        throw new Exception();
                    } else {
                        alac.get(i).setBalance(alac.get(i).getBalance() - balance);
                        System.out.println("성공: 출금 처리");
                        System.out.println("계좌 잔액: " + alac.get(i).getBalance());
                    }
                } else {
                    System.out.println("실패: 해당하는 계좌번호가 존재하지 않습니다.");
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("실패: 출금 처리");
            e.printStackTrace();
            System.exit(1);
        }
        return alac;
    }

    public ArrayList<Account> transfer(ArrayList<Account> alac) {
        try {
            System.out.println("------ 이체 처리");
            System.out.print("본인 계좌번호 입력 >> ");
            String orgNum1 = sc.next();
            System.out.print("이체 계좌번호 입력 >> ");
            String orgNum2 = sc.next();

            for (int i = 0; i < alac.size(); i++) {
                if (alac.get(i).getOriginNumber().equals(orgNum1)) {
                    for (int j = 0; j < alac.size(); j++) {
                        if (alac.get(i).getOriginNumber().equals(orgNum2)) {
                            System.out.print("이체하고자 하는 액수 입력 >> ");
                            int balance = sc.nextInt();

                            if (alac.get(i).getBalance() > balance) {
                                alac.get(i).setBalance(alac.get(i).getBalance() - balance);
                                alac.get(j).setBalance(alac.get(j).getBalance() + balance);
                                System.out.println("성공: 이체 처리");
                                System.out.println("계좌 잔액: " + alac.get(i).getBalance());
                            } else {
                                System.out.println("실패: 이체하고자 하는 액수가 잔액보다 큽니다.");
                                throw new Exception();
                            }
                        } else {
                            System.out.println("실패: 이체하고자 하는 계좌가 없습니다.");
                            throw new Exception();
                        }
                    }
                } else {
                    System.out.println("실패: 본인 계좌가 없습니다.");
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("실패: 이체 처리");
            e.printStackTrace();
            System.exit(1);
        }
        return alac;
    }

    public void getAccountList(ArrayList<Account> alac) {
        System.out.println("------ 계좌 리스트 조회 처리");
        if (alac.size() == 0) {
            System.out.println("실패: 개설 된 계좌가 없습니다.");
            return;
        }

        System.out.println("성공: 계좌 리스트 조회 처리");
        for (int i = 0; i < alac.size(); i++) {
            System.out.println("제 " + i + " 계좌 >> ");
            System.out.println("　　계좌번호: " + alac.get(i).getOriginNumber());
            System.out.println("　　계좌잔액: " + alac.get(i).getBalance());
            System.out.println("　　계좌주명: " + alac.get(i).getName());
        }
    }

    public void getBalance(ArrayList<Account> alac) {
        try {
            System.out.println("------ 계좌 잔고 조회 처리");
            System.out.print("조회 계좌번호 입력 >> ");
            String orgNum = sc.next();

            for (int i = 0; i < alac.size(); i++) {
                if (alac.get(i).getOriginNumber().equals(orgNum)) {
                    System.out.println("성공: 계좌 잔고 조회 처리");
                    System.out.println(alac.get(i).getName() + "님의 계좌 잔고: " + alac.get(i).getBalance() + "원");
                    return;
                }
            }
            System.out.println("실패: 조회하고자 하는 계좌가 존재하지 않습니다.");
            throw new Exception();
        } catch(Exception e) {
            System.out.println("실패: 계좌 잔고 조회 처리");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void exit() {
        System.out.println("시스템을 종료합니다.");
        System.exit(0);
    }
}
