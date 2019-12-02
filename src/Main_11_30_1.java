import java.util.*;

public class Main_11_30_1 {
    //使用Map
    //到底买不买
    // have为商家有的珠子，need为想要买的珠子，如果自己要的珠子商家都有 那么输出Yes和商家多余的柱子
    // 如果自己要的商家没有则输出 No + 商家缺少的珠子
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String have = scanner.nextLine();
        String need = scanner.nextLine();
        Map<Character,Integer> h = new HashMap<>();
        for(char c : have.toCharArray()){
            if(h.containsKey(c)){
                h.put(c,h.get(c)+1);
            }else{
                h.put(c,1);
            }
        }
        Map<Character,Integer> n = new HashMap<>();
        for(char c : need.toCharArray()){
            if(n.containsKey(c)){
                n.put(c,n.get(c)+1);
            }else{
                n.put(c,1);
            }
        }
        boolean weatherBy = true;
        int lack = 0;
        for(Map.Entry<Character,Integer> en : n.entrySet()){
            char k = en.getKey();
            int v = en.getValue();
            if(h.containsKey(k) && h.get(k)<v){
                weatherBy = false;
                lack += v-h.get(k);
            }else if(!h.containsKey(k)){
                weatherBy = false;
                lack += v;
            }
        }
        if(weatherBy){
            System.out.println("Yes"+((have.length()) - need.length()));

        }else{
            System.out.println("No" + lack);
        }
        //使用链表
        Main_11_30_1.useList();
    }
    public static void useList(){
        Scanner scanner= new Scanner(System.in);
        String have = scanner.nextLine();
        String need = scanner.nextLine();
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < have.length() ; i++){
            list.add(have.charAt(i));
        }
        int count =0 ;
        for(int i = 0 ; i < need.length() ; i++){
            char c = need.charAt(i);
            for(int j = 0 ; j < list.size() ; j++){
                if(c == list.get(j)){
                    list.remove(j);
                    count ++;
                    break;
                }
            }
        }
        if(count == need.length()){
            System.out.println("Yes"+ (have.length() - count));
        }else{
            System.out.println("No" + (need.length() - count));
        }

    }
}
