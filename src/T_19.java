import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-6 下午9:26
 * 顺时针打印矩阵：我的解法，写的比较复杂
 * 思路：设置row和col的增量，碰到4个顶点转个弯
 */
public class T_19 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> res=new ArrayList<>();
        int length_i=matrix.length,
                length_j=matrix[0].length;
        int direct_i=0,direct_j=1;//row和col的增量
        int a=0;//已经遍历了外边几圈
        int count=1;//已经访问的数据的个数
        int index_x=0,index_y=0;//row和col的索引
        res.add(matrix[index_x][index_y]);
        while (count<length_i*length_j){
            if ((index_y+a==length_j-1)&&(index_x-a==0)&&!(index_x+a==length_i-1)){//如果到达了右上角，往下转
                direct_i=1;
                direct_j=0;
            }else if ((index_y+a==length_j-1)&&(index_x+a==length_i-1)&&!(index_x-a==0)){//如果到达了右下角，往左转
                direct_i=0;
                direct_j=-1;
            }else if ((index_y-a==0)&&(index_x+a==length_i-1)&&!(index_x-a==0)){//如果到达了左下角
                direct_i=-1;
                direct_j=0;
            }else if ((index_y-a==0)&&(index_x-a==1)&&!(index_x+a==length_i-1)&&!(index_y+a==length_j-1)){//如果到了左上角
                direct_i=0;
                direct_j=1;
                a+=1;//一圈结束
            }
            index_x+=direct_i;
            index_y+=direct_j;
            res.add(matrix[index_x][index_y]);
            count++;
        }
        return res;
    }

    public static void main(String[] args){
        T_19 t=new T_19();
        int[][] a=new int[][]{{1},{2},{3},{4},{5}};
        ArrayList res=t.printMatrix(a);
        for (int i=0;i<res.size();i++)
            System.out.print(res.get(i));
    }
}
