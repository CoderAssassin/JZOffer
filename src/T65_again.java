/**
 * @Author:Aliyang
 * @Data: Created in 下午5:01 18-7-4
 * 矩阵中的路径：二刷
 **/
public class T65_again {

    int index=1;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (rows==0||cols==0||matrix.length==0)
            return false;

        boolean[] visit=new boolean[matrix.length];
        for (int i=0;i<matrix.length;i++){
            index=1;
            if (matrix[i]==str[0]&&dfs(matrix,rows,cols,i/cols,i%cols,str,visit))
                return true;
        }
        return false;
    }

    private boolean dfs(char[] matrix,int rows,int cols,int rowNow,int colNow,char[] str,boolean[] visit){

        if (index==str.length)
            return true;

        visit[rowNow*cols+colNow]=true;

        if (rowNow-1>=0&&visit[(rowNow-1)*cols+colNow]==false&&matrix[(rowNow-1)*cols+colNow]==str[index]){//上
            index++;
            if (dfs(matrix,rows,cols,rowNow-1,colNow,str,visit))
                return true;
        }
        if (rowNow+1<rows&&visit[(rowNow+1)*cols+colNow]==false&&matrix[(rowNow+1)*cols+colNow]==str[index]){//下
            index++;
            if (dfs(matrix,rows,cols,rowNow+1,colNow,str,visit))
                return true;
        }
        if (colNow-1>=0&&visit[rowNow*cols+colNow-1]==false&&matrix[rowNow*cols+colNow-1]==str[index]){//左
            index++;
            if (dfs(matrix,rows,cols,rowNow,colNow-1,str,visit))
                return true;
        }
        if (colNow+1<cols&&visit[rowNow*cols+colNow+1]==false&&matrix[rowNow*cols+colNow+1]==str[index]){//右
            index++;
            if (dfs(matrix,rows,cols,rowNow,colNow+1,str,visit))
                return true;
        }
        index--;
        visit[rowNow*cols+colNow]=false;
        return false;
    }

    public static void main(String[] args){
        T65_again t=new T65_again();
        char[] matrix="ABCESFCSADEE".toCharArray();
        char[] str="SEE".toCharArray();
        System.out.println(t.hasPath(matrix,3,4,str));
    }
}
