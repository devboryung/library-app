package com.group.libraryapp.controller.study.controller;

import java.util.Scanner;

public class StudyD3 {

    public static void main(String[] args) {

        Dice dice = new Dice(6);
        int rollCount = dice.setRollCount();
        dice.countDice(rollCount);
        dice.printResult();
    }

    static class Dice {
        final int[] diceNumbers; //주사위 번호

        public Dice(int diceNumbers) {
            this.diceNumbers = new int[diceNumbers];
        }

        //주사위를 굴릴 횟수를 정한다
        public int setRollCount() {
            System.out.println("숫자를 입력하세요: ");
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        }

        //주사위를 굴려 각 숫자가 몇 번 나왔는지 카운트한다.
        public void countDice(int rollCount) {
            for (int i = 0; i < rollCount; i++) {
                int rollDice = (int)(Math.random() * 6) + 1;
                System.out.println("rollDice === " + rollDice);
                diceNumbers[rollDice-1]++;
            }
        }

        //결과를 출력한다.
        public void printResult() {
            for (int i = 0; i < diceNumbers.length; i++) {
               System.out.printf((i+1) + "은 %d번 나왔습니다.\n", diceNumbers[i]);
            }
        }
    }


}
