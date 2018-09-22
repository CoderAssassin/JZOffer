import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午7:56 18-8-5
 **/
public class Main1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int judge=sc.nextInt();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i=0;i<N;i++){
            String str=sc.nextLine();
            String[] strs=str.split(" ");
            List<Integer> list=new ArrayList<>(strs.length);
            for (String s:strs){
                if (!s.equals(""))
                    list.add(Integer.parseInt(s));
            }
            Collections.sort(list);
            map.put(i,list);
        }

        int res=-1;
        int max=0;
        List<Integer> list1=map.get(judge);
        for (int j=0;j<N;j++){
            if (j==judge)
                continue;
            List<Integer> list2=map.get(j);
            int count=0;
            int m=0,n=0;
            while (m<list1.size()&&n<list2.size()){
                while (list1.get(m)<list2.get(n)){
                    m++;
                }
                if (list1.get(m)==list2.get(n))
                    count++;
                m++;
                n++;
            }
            if (count>max){
                max=count;
                res=j;
            }
        }
        System.out.println(res);
    }
}
