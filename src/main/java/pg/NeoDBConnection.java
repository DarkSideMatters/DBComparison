/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pg;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

/**
 *
 * @author darkSideMatters
 */
public class NeoDBConnection {

    private static Driver instance;
    private static String url = "bolt://localhost:7687";
    private static String username = "neo4j";
    private static String password = "class";

    public static Driver getInstance() {
        if (instance == null) {
            instance = GraphDatabase.driver(url, AuthTokens.basic( username, password));;
        }
        return instance;
    }

    public static void closeDriver() {
        instance.close();
        instance = null;
    }

}

