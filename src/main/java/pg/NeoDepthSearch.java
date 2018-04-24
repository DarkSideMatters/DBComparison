package pg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 *
 * @author darkSideMatters
 */

public class NeoDepthSearch {

    public List get20RandomIndexes() {
        List<String> names = new ArrayList<String>();
        Driver driver = NeoDBConnection.getInstance();

        Session session = driver.session();

        StatementResult result = session.run(
                "MATCH(a:Person) WITH a, rand() AS number RETURN a.name as name ORDER BY number LIMIT 20");

        while( result.hasNext() ) {
            Record record = result.next();
            names.add(record.get("name").asString());
        }

        session.close();
        NeoDBConnection.closeDriver();


        return names;

    }

    public void closeDrive(){
        NeoDBConnection.closeDriver();
    }
    
    public void getDepthOne(List<String> names, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = NeoDBConnection.getInstance();

        Session session = driver.session();
        
        for (String name : names) {
            
            long startTime = System.nanoTime();

            StatementResult result = session.run(
                "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES]->(p:Person)\n" +
                        "RETURN p");
            
            long estimatedTime = System.nanoTime() - startTime;
            ArrayList<Double> times = map.get(1);
            times.add((double) estimatedTime/1000000000.0);
            
        }
        session.close();

    }

    public void getDepthTwo(List<String> names, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = NeoDBConnection.getInstance();

        Session session = driver.session();
        
        for (String name : names) {
            
            long startTime = System.nanoTime();

            StatementResult result = session.run(
                "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*..2]->(p:Person)\n" +
                        "RETURN p");
            
            long estimatedTime = System.nanoTime() - startTime;
            ArrayList<Double> times = map.get(2);
            times.add((double) estimatedTime/1000000000.0);
            
        }
        session.close();

    }

    public void getDepthThree(List<String> names, HashMap<Integer, ArrayList<Double>> map) {
        
        Driver driver = NeoDBConnection.getInstance();
        
        Session session = driver.session();

        for (String name : names) {
            
            long startTime = System.nanoTime();

            StatementResult result = session.run(
                "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*..3]->(p:Person)\n" +
                        "RETURN p");
            
            long estimatedTime = System.nanoTime() - startTime;
            ArrayList<Double> times = map.get(3);
            times.add((double) estimatedTime/1000000000.0);
            
        }
        session.close();

    }

    public void getDepthFour(List<String> names, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = NeoDBConnection.getInstance();

        Session session = driver.session();
        for (String name : names) {
            long startTime = System.nanoTime();

            StatementResult result = session.run(
                "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*..4]->(p:Person)\n" +
                        "RETURN p");
            
            long estimatedTime = System.nanoTime() - startTime;
            ArrayList<Double> times = map.get(4);
            times.add((double) estimatedTime/1000000000.0);
            
        }
        session.close();

    }

    public void getDepthFive(List<String> names, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = NeoDBConnection.getInstance();

        Session session = driver.session();
        for (String name : names) {
            long startTime = System.nanoTime();

            StatementResult result = session.run(
                "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*..5]->(p:Person)\n" +
                        "RETURN p");
            
            long estimatedTime = System.nanoTime() - startTime;
            ArrayList<Double> times = map.get(5);
            times.add((double) estimatedTime/1000000000.0);
            
        }
        session.close();

    }


}
