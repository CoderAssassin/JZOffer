import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-7 下午1:44
 * 顺时针打印矩阵：别人解法
 * 思路：利用到了矩形左上角点和右下角点，打印完一个圈后，行和列坐标进行加一减一进入内部的圈
 */
public class T_19_1 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {

        int row=matrix.length,
                col=matrix[0].length;

        ArrayList<Integer> res=new ArrayList<>();

        if (row==0||col==0) return null;

        int left=0,top=0,right=col-1,bottom=row-1;//定义左上和右下的打印范围

        while (left<=right&&top<=bottom){

//            上边的行，从左到右
            for (int i=left;i<=right;i++)
                res.add(matrix[top][i]);
//            右边的列，从上到下
            for (int i=top+1;i<=bottom;i++)
                res.add(matrix[i][right]);
//            下边的行，从右到左
            if (top!=bottom)//排除只有一行的情况
                for (int i=right-1;i>=left;i--)
                    res.add(matrix[bottom][i]);
//            左边的列，从下到上
            if (left!=right)//排除只有一列的情况
                for (int i=bottom-1;i>top;i--)
                    res.add(matrix[i][left]);
//            更新左上和右下角点
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }
}
