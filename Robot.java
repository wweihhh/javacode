package Day10;

/*
* 机器人走方格*/
public class Robot {
    public static void main(String[] args) {
        Robot robot = new Robot();
        int n = robot.countWays(3,3);
        System.out.println(n);
    }
    public static int countWays(int x, int y) {
        // write code here
        if (x == 1 || y == 1){//矩阵从1开始 当行和列任意一个为1时，都只有一种走法
            return 1;
        }
        //递归思想：相当于每次有两个选择，向下走或向右走
        //向下走相当于（x-1，y）   向右走（想，y-1） 不断递归
        // 每次讲将下一行（列）看作起始点 直到走到最后的行和列
        return countWays(x-1,y)+countWays(x,y-1);
    }
}
