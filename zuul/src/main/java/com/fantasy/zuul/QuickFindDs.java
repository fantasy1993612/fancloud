package com.fantasy.zuul;

/**
 * @author: xiangming
 * @date: 2020/03/01 21:49
 * @describetion:
 */
public class QuickFindDs implements DisjoinSets {

    private int ids[];

    @Override
    public void connect(int p, int q) {
        int pid = ids[p];
        int qid = ids[q];

        for(int i = 0; i < ids.length;i++){
            if(ids[i] == pid){
                ids[i] = qid;
            }
        }
    }

    @Override
    public boolean isConnect(int p, int q) {
        return ids[p] == ids[q];
    }
}
