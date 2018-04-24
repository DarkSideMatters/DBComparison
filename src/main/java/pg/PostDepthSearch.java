/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darkSideMatters
 */
public class PostDepthSearch {
    
    public void depthOne(List<String> names, HashMap<Integer, ArrayList<Double>> map){
        Connection con = PostDBConnection.getConnection();
        ResultSet a;
        try {
            for (String name : names) {
                long startTime = System.nanoTime();
                a = con.createStatement().executeQuery("SELECT * FROM social_network.social_network_nodes AS sn\n" +
                                                       "JOIN social_network.social_network_edges AS se ON sn.name = '"+ name +"' \n" +
                                                       "AND sn.node_id = se.source_node_id;");
                long estimatedTime = System.nanoTime() - startTime;
                ArrayList<Double> times = map.get(1);
                times.add((double) estimatedTime/1000000000.0);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PostDepthSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void depthTwo(List<String> names, HashMap<Integer, ArrayList<Double>> map){
        Connection con = PostDBConnection.getConnection();
        ResultSet a;
        try {
            for (String name : names) {
                long startTime = System.nanoTime();
                a = con.createStatement().executeQuery("SELECT * FROM social_network.social_network_nodes AS sn\n" +
                                                       "JOIN social_network.social_network_edges AS se ON sn.name = '"+ name +"' \n" +
                                                       "AND sn.node_id = se.source_node_id\n" +
                                                       "JOIN social_network.social_network_edges AS se2 ON se.target_node_id = se2.source_node_id;");
                long estimatedTime = System.nanoTime() - startTime;
                ArrayList<Double> times = map.get(2);
                times.add((double) estimatedTime/1000000000.0);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PostDepthSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void depthThree(List<String> names, HashMap<Integer, ArrayList<Double>> map){
        Connection con = PostDBConnection.getConnection();
        ResultSet a;
        try {
            for (String name : names) {
                long startTime = System.nanoTime();
                a = con.createStatement().executeQuery("SELECT * FROM social_network.social_network_nodes AS sn\n" +
                                                       "JOIN social_network.social_network_edges AS se ON sn.name = '"+ name +"' \n" +
                                                       "AND sn.node_id = se.source_node_id\n" +
                                                       "JOIN social_network.social_network_edges AS se2 ON se.target_node_id = se2.source_node_id\n" +
                                                       "JOIN social_network.social_network_edges AS se3 ON se2.target_node_id = se3.source_node_id;");
                long estimatedTime = System.nanoTime() - startTime;
                ArrayList<Double> times = map.get(3);
                times.add((double) estimatedTime/1000000000.0);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PostDepthSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void depthFour(List<String> names, HashMap<Integer, ArrayList<Double>> map){
        Connection con = PostDBConnection.getConnection();
        ResultSet a;
        try {
            for (String name : names) {
                long startTime = System.nanoTime();
                a = con.createStatement().executeQuery("SELECT * FROM social_network.social_network_nodes AS sn\n" +
                                                       "JOIN social_network.social_network_edges AS se ON sn.name = '"+ name +"' \n" +
                                                       "AND sn.node_id = se.source_node_id\n" +
                                                       "JOIN social_network.social_network_edges AS se2 ON se.target_node_id = se2.source_node_id\n" +
                                                       "JOIN social_network.social_network_edges AS se3 ON se2.target_node_id = se3.source_node_id\n" +
                                                       "JOIN social_network.social_network_edges AS se4 ON se3.target_node_id = se4.source_node_id;");
                long estimatedTime = System.nanoTime() - startTime;
                ArrayList<Double> times = map.get(4);
                times.add((double) estimatedTime/1000000000.0);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PostDepthSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void depthFive(List<String> names, HashMap<Integer, ArrayList<Double>> map){
        Connection con = PostDBConnection.getConnection();
        ResultSet a;
        try {
            for (String name : names) {
                long startTime = System.nanoTime();
                a = con.createStatement().executeQuery("SELECT * FROM social_network.social_network_nodes AS sn\n" +
                                                       "JOIN social_network.social_network_edges AS se ON sn.name = '"+ name +"' \n" +
                                                       "AND sn.node_id = se.source_node_id\n" +
                                                       "JOIN social_network.social_network_edges AS se2 ON se.target_node_id = se2.source_node_id\n" +
                                                       "JOIN social_network.social_network_edges AS se3 ON se2.target_node_id = se3.source_node_id\n" +
                                                       "JOIN social_network.social_network_edges AS se4 ON se3.target_node_id = se4.source_node_id\n" +
                                                       "JOIN social_network.social_network_edges AS se5 ON se4.target_node_id = se5.source_node_id;");
                long estimatedTime = System.nanoTime() - startTime;
                ArrayList<Double> times = map.get(5);
                times.add((double) estimatedTime/1000000000.0);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PostDepthSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closePost(){
        PostDBConnection.closeConnection();
    }
}
