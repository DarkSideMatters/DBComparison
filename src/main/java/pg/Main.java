/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author darkSideMatters
 */
public class Main {
    
    public static void main(String[] args) {
        
        PostDepthSearch pds = new PostDepthSearch();
        NeoDepthSearch nds = new NeoDepthSearch();
        Calculator cal = new Calculator();
        
        List<String> names;
        names = nds.get20RandomIndexes();
        
        
        HashMap<Integer, ArrayList<Double>> neo4jMap = new HashMap<>();
        neo4jMap.put(1, new ArrayList<>());
        neo4jMap.put(2, new ArrayList<>());
        neo4jMap.put(3, new ArrayList<>());
        neo4jMap.put(4, new ArrayList<>());
        neo4jMap.put(5, new ArrayList<>());
        
       
        nds.getDepthOne(names, neo4jMap);
        nds.getDepthTwo(names, neo4jMap);
        nds.getDepthThree(names, neo4jMap);
        nds.getDepthFour(names, neo4jMap);
        nds.getDepthFive(names, neo4jMap);
        
        
        HashMap<Integer, ArrayList<Double>> postMap = new HashMap<>();
        postMap.put(1, new ArrayList<>());
        postMap.put(2, new ArrayList<>());
        postMap.put(3, new ArrayList<>());
        postMap.put(4, new ArrayList<>());
        postMap.put(5, new ArrayList<>());
        
        
        pds.depthOne(names, postMap);
        pds.depthTwo(names, postMap);
        pds.depthThree(names, postMap);
        pds.depthFour(names, postMap);
        pds.depthFive(names, postMap);
        
        
        pds.closePost();
        nds.closeDrive();

       
        
        System.out.println("------------ Depth One ------------");
        System.out.println("------------  Median ------------ ");
        System.out.println("Neo time: " + cal.getMedian(neo4jMap.get(1)));
        System.out.println("Post time: " + cal.getMedian(postMap.get(1)));
        System.out.println("------------  Average ------------ ");
        System.out.println("Neo time: " + cal.getAverage(neo4jMap.get(1)));
        System.out.println("Post time: " + cal.getAverage(postMap.get(1)));
        
        System.out.println("------------ Depth Two ------------");
        System.out.println("------------  Median ------------ ");
        System.out.println("Neo time: " + cal.getMedian(neo4jMap.get(2)));
        System.out.println("Post time: " + cal.getMedian(postMap.get(2)));
        System.out.println("------------  Average ------------ ");
        System.out.println("Neo time: " + cal.getAverage(neo4jMap.get(2)));
        System.out.println("Post time: " + cal.getAverage(postMap.get(2)));
        
        System.out.println("------------ Depth Three ------------");
        System.out.println("------------  Median ------------ ");
        System.out.println("Neo time: " + cal.getMedian(neo4jMap.get(3)));
        System.out.println("Post time: " + cal.getMedian(postMap.get(3)));
        System.out.println("------------  Average ------------ ");
        System.out.println("Neo time: " + cal.getAverage(neo4jMap.get(3)));
        System.out.println("Post time: " + cal.getAverage(postMap.get(3)));
        
        System.out.println("------------ Depth Four ------------");
        System.out.println("------------  Median ------------ ");
        System.out.println("Neo time: " + cal.getMedian(neo4jMap.get(4)));
        System.out.println("Post time: " + cal.getMedian(postMap.get(4)));
        System.out.println("------------  Average ------------ ");
        System.out.println("Neo time: " + cal.getAverage(neo4jMap.get(4)));
        System.out.println("Post time: " + cal.getAverage(postMap.get(4)));
        
        System.out.println("------------ Depth Five ------------");
        System.out.println("------------  Median ------------ ");
        System.out.println("Neo time: " + cal.getMedian(neo4jMap.get(5)));
        System.out.println("Post time: " + cal.getMedian(postMap.get(5)));
        System.out.println("------------  Average ------------ ");
        System.out.println("Neo time: " + cal.getAverage(neo4jMap.get(5)));
        System.out.println("Post time: " + cal.getAverage(postMap.get(5)));
    }
    
}
