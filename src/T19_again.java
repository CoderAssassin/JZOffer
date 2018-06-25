import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午5:31 18-6-25
 * 顺时针打印矩阵：二刷
 * 思路：总的圈数为(min(行数，列数)+1)/2，然后分别打印两行两列
 **/
public class T19_again {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res=new ArrayList<>();
        if (matrix.length==0)
            return res;

        int rows=matrix.length,cols=matrix[0].length;
        int circle=rows<cols?(rows+1)/2:(cols+1)/2;//总的圈数
        int count=0;
        int alls=rows*cols;

        for (int i=1;i<=circle;i++){//从外到里遍历圈
            for (int j=i-1;j<=cols-i&&count<alls;j++){//第一行
                res.add(matrix[i-1][j]);
                count++;
            }
            for (int j=i;j<=rows-i-1&&count<alls;j++){//最右边的列
                res.add(matrix[j][cols-i]);
                count++;
            }
            for (int j=cols-i;j>=i-1&&count<alls;j--){//最后一行
                res.add(matrix[rows-i][j]);
                count++;
            }
            for (int j=rows-i-1;j>=i&&count<alls;j--){//第一列
                res.add(matrix[j][i-1]);
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        T19_again t=new T19_again();
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> res=t.printMatrix(matrix);
        for (Integer a:res)
            System.out.print(a+",");
    }
}
