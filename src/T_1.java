/**
 * Created by AliYang on 2018/4/16.
 * 二维数组的查找:左下角的点比该列上边的数大，比右边的数小，因此从左下角开始遍历，
 * 若比target小，那么右移，若比target大，那么左移
 */
public class T_1 {

    public boolean Find(int target, int [][] array) {

        int rowNum=array.length,colNum=array[0].length;//行数和列数
        int leftBottom_row=rowNum-1,leftBottom_col=0;//左下角的点行列值

        while (leftBottom_row>=0&&leftBottom_col<colNum){
            int leftBottom=array[leftBottom_row][leftBottom_col];//左下角点的坐标
            if (target==leftBottom)
                return true;
            else if (target<leftBottom){
                leftBottom_row--;
            }else if (target>leftBottom){
                leftBottom_col++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        T_1 t=new T_1();
        int[][] num=new int[5][5];
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++)
                num[i][j]=i+j;
        }
        System.out.println(t.Find(0,num));
    }
}
