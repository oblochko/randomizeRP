package com.example.randomizerp;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Roll {
    private List<String> metropolis = new ArrayList<>();
    private List<String> commonwealth = new ArrayList<>();
    private List<String> boon = new ArrayList<>();
    private List<String> neutral = new ArrayList<>();
    private List<String> pernicious = new ArrayList<>();

    public Roll() {

    }

    public String getRollMetropolis(int len) {
        return "Метрополия:\n" + randomInList(metropolis, len);
    }

    public String getRollCommonwealth(int len) {
        return "Содружество:\n" + randomInList(commonwealth, len);
    }

    public String getRollBoon(int len) {
        return "Благая:\n" + randomInList(boon, len);
    }

    public String getRollNeutral(int len) {
        return "Нейтральная:\n" + randomInList(neutral, len);
    }

    public String getRollPernicious(int len) {
        return "Пагубная:\n" + randomInList(pernicious, len);
    }

    public String getAllRoll(int len) {
        return getRollMetropolis(len) + getRollCommonwealth(len) + getRollBoon(len) + getRollNeutral(len) + getRollPernicious(len);
    }

    private String randomInList(List<String> mite, int len) {
        StringBuilder builder = new StringBuilder();
        int size = mite.size();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            Integer rand = null;
            boolean flag = false;
            while(!flag){
                final Integer finalRand = randomBetween(size);
                flag = list.stream().noneMatch(s -> s.equals(finalRand));
                rand = finalRand;
            };
            list.add(rand);
            builder.append("\t" + mite.get(rand) + "\n");
        }
        return builder.toString();
    }

    private int randomBetween(int roll) {
        Random r = new Random();
        return r.nextInt(roll);
    }

}
