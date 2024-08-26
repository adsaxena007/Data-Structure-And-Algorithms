package leet_code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_RandomizedSet {

    private Map<Integer,Integer> set;

    public _17_RandomizedSet() {
        set = new HashMap(10);
    }

    public boolean insert(int val) {
        if(set.containsKey(val))
            return false;

        set.put(val,val);
        return true;
    }

    public boolean remove(int val) {
        if(set.containsKey(val)){
            set.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        List<Integer> arr= set.values().stream().toList();
        return arr.get(((int)Math.ceil(Math.random()*arr.size()-1)));
    }

    public static void main(String[] args) {
        _17_RandomizedSet obj = new _17_RandomizedSet();
        boolean param_1 = obj.insert(1);
        int param_3 = obj.getRandom();
    }
}

