package com.ssnail.myspringboot.freemarker;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @author pengdengwang
 * @since 2021/5/28
 */
public class SuanFa {

    static int[] result = new int[8];//全局或成员变量,下标表示行,值表示queen存储在哪一列
    static int numQueens = 0; // 一共多少种组合

    @Test
    public void testCal8queens() {
        cal8queens(0);
        System.out.println("testCal8queens一共多少种组合" + numQueens);
    }

    /**
     * 八皇后
     *
     * @param row 行
     */
    public static void cal8queens(int row) { // 调用方式：cal8queens(0);
        if (row == 8) { // 8个棋子都放置好了，打印结果
            printQueens(result);
            ++numQueens;
            return; // 8行棋子都放好了，已经没法再往下递归了，所以就return
        }
        for (int column = 0; column < 8; ++column) { // 每一行都有8中放法
            if (isOk(row, column)) { // 有些放法不满足要求
                result[row] = column; // 第row行的棋子放到了column列
                cal8queens(row + 1); // 考察下一行
            }
        }
    }

    private static boolean isOk(int row, int column) {//判断row行column列放置是否合适
        int leftup = column - 1, rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) { // 逐行往上考察每一行
            if (result[i] == column) return false; // 第i行的column列有棋子吗？
            if (leftup >= 0) { // 考察左上对角线：第i行leftup列有棋子吗？
                if (result[i] == leftup) return false;
            }
            if (rightup < 8) { // 考察右上对角线：第i行rightup列有棋子吗？
                if (result[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    private static void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 使用回溯算法计算0-1背包问题
     */
    @Test
    public void test_f_0_1() {
        int[] items = {2, 2, 4, 6, 3};
        f_0_1(0, 0, items, 5, 9);
        System.out.println("背包最大可装入：" + maxW);
        System.out.println("f_0_1循环次数：" + numCirclef_0_1);
    }

    // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
    // w背包重量；items表示每个物品的重量；n表示物品个数
    // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
    public int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值
    public int numCirclef_0_1 = 0; // 循环次数
    public boolean[][] memory = new boolean[5][10]; // 备忘录用于记录计算记录

    public void f_0_1(int i, int cw, int[] items, int n, int w) {
        ++numCirclef_0_1;
        if (cw == w || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        if (memory[i][cw]) {
            return;
        }
        memory[i][cw] = true;
        f_0_1(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            f_0_1(i + 1, cw + items[i], items, n, w);
        }
    }

    public int min_dis = Integer.MAX_VALUE;

    @Test
    public void testMinDistBackTracing() {
        int[][] w = {
                {1, 3, 5, 9},
                {2, 1, 3, 4},
                {5, 2, 6, 7},
                {6, 8, 4, 3}};
        minDistBackTracing(0, 0, 0, w, 4);
        System.out.println("回溯法求矩阵最短路径:" + min_dis);
    }

    /**
     * 回溯法求矩阵最短路径
     * 只能向右或向下
     * <pre>
     *     ->   [2, 2, 3, 6]
     *          [2, 2, 3, 6]
     *          [2, 2, 3, 6]
     *          [2, 2, 3, 6]   ->
     * </pre>
     *
     * @param i   行
     * @param j   列
     * @param dis 到当前位置的距离
     * @param w   距离矩阵
     * @param n   矩阵长度
     * @return
     */
    public void minDistBackTracing(int i, int j, int dis, int[][] w, int n) {
        if (i == n - 1 && j == n - 1) {
            dis += w[i][j];
            if (dis < min_dis) {
                min_dis = dis;
            }
            return;
        }
        // 往下走
        if (i < n - 1) {
            minDistBackTracing(i + 1, j, dis + w[i][j], w, n);
        }
        // 往右走
        if (j < n - 1) {
            minDistBackTracing(i, j + 1, dis + w[i][j], w, n);
        }
    }

    @Test
    public void testMinDist() {
        int[][] matrix = {
                {1, 3, 5, 9},
                {2, 1, 3, 4},
                {5, 2, 6, 7},
                {6, 8, 4, 3}};
        int[][] mem = new int[4][4];
        int minDist = minDist(3, 3, matrix, mem);
        System.out.println("状态转移方程法求矩阵最短路径:" + minDist);
    }

    public int minDist(int i, int j, int[][] matrix, int[][] mem) { // 调用minDist(n-1, n-1);
        if (i == 0 && j == 0) return matrix[0][0];
        if (mem[i][j] > 0) return mem[i][j];
        int minLeft = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            minLeft = minDist(i, j - 1, matrix, mem);
        }
        int minUp = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            minUp = minDist(i - 1, j, matrix, mem);
        }

        int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }

    @Test
    public void testKnapsack2() {
        int[] items = {2, 2, 4, 6, 3};
        int maxWeight = knapsack2(items, 5, 9);
        System.out.println("背包最大可装入：" + maxWeight);
    }

    /**
     * 动态规划 求解0-1背包问题
     *
     * @param items 可选物品数组
     * @param n     物品个数
     * @param w     背包可装最大重量
     * @return 背包实际装入最大重量
     */
    public int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1]; // 默认值false
        states[0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        states[items[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w - items[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j]) states[j + items[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i]) return i;
        }
        return 0;
    }

    @Test
    public void testMaxSubSequence() {
//        int[] sequence = {1, 2, 3, 4, 1, 2, 3, 4, 5};
//        int maxSubSequence = maxSubSequence(sequence, sequence.length);
//        System.out.println("最长子序列：" + maxSubSequence);

        List<Object> objects = Arrays.asList(null);
        System.out.println(objects);
    }

    /**
     * 动态规划求最长子序列长度
     *
     * @param sequence 数字序列
     * @param n        序列长度
     * @return 最长序列
     */
    public int maxSubSequence(int[] sequence, int n) {
        int[] maxSubNum = new int[n];
        Arrays.fill(maxSubNum, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (sequence[i] > sequence[j]) {
                    if (maxSubNum[i] <= maxSubNum[j]) {
                        maxSubNum[i] = maxSubNum[j] + 1;
                    }
                }
            }
        }

        int maxSubNumber = 0;
        for (int subNum : maxSubNum) {
            if (maxSubNumber < subNum) {
                maxSubNumber = subNum;
            }
        }
        return maxSubNumber;
    }

}
