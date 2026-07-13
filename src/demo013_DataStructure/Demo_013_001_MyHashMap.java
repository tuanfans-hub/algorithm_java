package demo013_DataStructure;

import java.io.*;
import java.util.HashMap;

/**
 * @author TuanFans
 * @date 2026/7/12
 * <p><a href="https://www.nowcoder.com/practice/7c4559f138e74ceb9ba57d76fd169967">牛客：设计有setAll功能的哈希表</a></p>
 *
 * <p>输入描述：</p>
 * <p>第一行一个整数N表示操作数。</p>
 * <p>接下来N行，每行第一个数字opt代表操作类型</p>
 * <p>若opt=1，接下来有两个整数x, y表示设置key=x对应的value=y</p>
 * <p>若opt=2，接下来一个整数x，表示查询key=x对应的value，若key=x不存在输出-1</p>
 * <p>若opt=3，接下来一个整数x，表示把加入过的所有的key对应的value都设置为x</p>
 * <p>输出描述：</p>
 * <p>对于每个查询操作，输出对应的value</p>
 * <p>示例1：</p>
 * <p>输入：</p>
 * <p>6</p>
 * <p>1 1 2</p>
 * <p>2 1</p>
 * <p>2 2</p>
 * <p>3 4</p>
 * <p>2 1</p>
 * <p>2 2</p>
 * <p>输出：</p>
 * <p>2</p>
 * <p>-1</p>
 * <p>4</p>
 * <p>-1</p>
 */
public class Demo_013_001_MyHashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        MyHashMap myMap = new MyHashMap();
        int n;
        in.nextToken();
        n = (int)in.nval;
        while(n-- !=0 && in.nextToken()!=StreamTokenizer.TT_EOF){
            int op = (int)in.nval;
            switch(op){
                case 1:
                    in.nextToken();
                    int key1 = (int)in.nval;
                    in.nextToken();
                    int value1 = (int)in.nval;
                    myMap.put(key1,value1);
                    break;
                case 2:
                    in.nextToken();
                    int key2 = (int)in.nval;
                    int value2 = myMap.get(key2);
                    out.println(value2);
                    break;
                case 3:
                    in.nextToken();
                    int value3 = (int)in.nval;
                    myMap.setAll(value3);
                    break;
            }
        }
        out.flush();
        out.close();
        br.close();
    }

    public static class MyHashMap{
        private final HashMap<Integer,int[]> map = new HashMap<>();
        private int stamp = 0;
        private int setAllValue = 0;
        private int setAllStamp = 0;

        public void put(int key,int value){
            map.put(key,new int[]{value,stamp++});
        }

        public int get(int key){
            if(containsKey(key)){
                int tempStamp = map.get(key)[1];
                if(tempStamp<setAllStamp) return setAllValue;
                else return map.get(key)[0];
            }else{
                return -1;
            }
        }

        public void setAll(int value){
            setAllValue = value;
            setAllStamp = stamp++;
        }

        public boolean containsKey(int key){
            return map.containsKey(key);
        }
    }
}
