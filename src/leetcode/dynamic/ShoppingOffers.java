package leetcode.dynamic;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingOffers {
    public static void main(String[] args) {
        List<Integer> price =new ArrayList<>();
        price.add(2);price.add(5);
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> price1 =new ArrayList<>();
        price1.add(3);price1.add(0);price1.add(5);
        List<Integer> price2 =new ArrayList<>();
        price2.add(1);price2.add(2);price2.add(10);
        special.add(price1);special.add(price2);
        List<Integer> needs =new ArrayList<>();
        needs.add(3);needs.add(2);

        System.out.println(shoppingOffers(price,special,needs));

    }

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<Integer> total = new ArrayList<>();
        dfs(price,special,needs,0,total);
        Collections.sort(total);
        if(total.size() > 0){
            return total.get(0);
        }
        return 0;
    }

    private static void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int totalPrice,
                            List<Integer> total) {
        if (isEmpty(needs)) {
            total.add(totalPrice);
            return;
        }

        for (List<Integer> list : special) {
            Integer tmp = isCanDo(list, needs);
            if (tmp != 0) {
                dfs(price, special, needs, totalPrice + tmp, total);
                revertDo(list,needs);
            }
        }
        List<Integer> revert = new ArrayList<>(needs);
        int tmp = single(price, needs);
        dfs(price, special, needs, totalPrice + tmp, total);
        needs.clear();
        needs.addAll(revert);
    }

    private static void revertDo(List<Integer> list, List<Integer> needs) {
        for(int i = 0;i < needs.size();i++){
            needs.set(i,needs.get(i)+list.get(i));
        }
    }

    private static int single(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for(int i = 0;i < needs.size();i++){
            total += needs.get(i)*price.get(i);
            needs.set(i,0);
        }
        return total;
    }

    private static int isCanDo(List<Integer> list, List<Integer> needs) {
        List<Integer> temp = new ArrayList<>(needs);
        for(int i = 0;i < needs.size();i++){
            int count = temp.get(i) - list.get(i);
            if(count >= 0){
                temp.set(i,count);
            }else {
                return 0;
            }
        }
        needs.clear();
        needs.addAll(temp);
        return list.get(list.size()-1);
    }

    private static boolean isEmpty(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != 0)
                return false;
        }
        return true;
    }
}
