import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 阿里巴巴内推编程题
 */
public class Main {

    static final Point START = new Point(0,0);
    static int minpath = Integer.MAX_VALUE;

    private static class Point{
        int x;
        int y;
        boolean visited=false;

        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }

        public int getLength(Point p){
            return Math.abs(x-p.x)+Math.abs(y-p.y);
        }
    }

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int calculate(String[] locations) {
        Point[] points=new Point[locations.length];

        for(int i=0;i<locations.length;i++){
            String[] lines=locations[i].split(",");
            Point point=new Point(Integer.parseInt(lines[0]),Integer.parseInt(lines[1]));
            points[i]=point;
        }

        int sum=0,count=0;
        return calculate1(START,points,0,0);
    }

    static int calculate1(Point startPoint,Point[] points,int sum,int count){
        if(count == points.length){
            minpath = Math.min(minpath, sum +startPoint.getLength(START));
            return minpath;
        }
        for(int i = 0; i<points.length; i++){
            if(points[i].visited == false){
                sum += points[i].getLength(startPoint);
                if(sum < minpath){
                    points[i].visited = true;
                    calculate1(points[i], points, sum, count+1);
                }
                sum -= points[i].getLength(startPoint);
                points[i].visited = false;
            }
        }
        return minpath;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
        }

        System.out.println(calculate(locations));
    }
}