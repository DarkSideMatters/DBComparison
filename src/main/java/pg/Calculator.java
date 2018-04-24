/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pg;

import java.util.ArrayList;

/**
 *
 * @author darkSideMatters
 */
public class Calculator {
    
    public Double getMedian(ArrayList<Double> list) {
        int middle = list.size()/2;
        middle = middle % 2 == 0? middle - 1 : middle;
        return list.get(middle);
    }
    
    public Double getAverage(ArrayList<Double> list){
        Double totaltime = 0.0;
        for (Double dub : list) {
            totaltime += dub;
        }
        return totaltime/20;
    }
}
