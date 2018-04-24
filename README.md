# Databases Comparison

## Requirements

-Java 8
-Maven
-Docker


## Setup

### Neo4j
The following docker commands are used to fill your database with data

First you need to get the file we will work with.
The file can be downloaded from here: https://github.com/datsoftlyngby/soft2018spring-databases-teaching-material/blob/master/data/archive_graph.tar.gz

In order to work with it, we will give it our own header names:
```
sed -i -E '1s/.*/:ID,name,job,birthday/' social_network_nodes.csv
sed -i -E '1s/.*/:START_ID,:END_ID/' social_network_edges.csv
```

Then we use docker to create a container with neo4j in it and populate it with data.
```
// Step 1
docker run \
    -d --name neo4j \
    --rm \
    --publish=7474:7474 \
    --publish=7687:7687 \
    --volume=$(pwd)/import:/import \
    --volume=$(pwd)/plugins:/plugins \
    --env NEO4J_AUTH=neo4j/class \
    --env=NEO4J_dbms_security_procedures_unrestricted=apoc.\\\*,algo.\\\* \
    --env=NEO4J_dbms_memory_pagecache_size=6G \
    --env=NEO4J_dbms_memory_heap_max__size=10G \
    neo4j

// Step 2
docker exec neo4j sh -c 'neo4j stop'

// Step 3
docker exec neo4j sh -c 'rm -rf data/databases/graph.db''

// Step 4
docker exec neo4j sh -c 'neo4j-admin import \
    --nodes:Person /import/social_network_nodes.csv \
    --relationships:ENDORSES /import/social_network_edges.csv \
    --ignore-missing-nodes=true \
    --ignore-duplicate-nodes=true \
    --id-type=INTEGER'

// Step 5
docker restart neo4j
```

### PostgreSQL

```
docker run -p 5432:5432 --name data jegp/soft2018-data
```

## Running the Example

Run the Main class from the project.

## Results
| Depth | PostgreSQL Median | PostgreSQL Average  | Neo4j Median | Neo4j Average |
| ----- |:---------------:| :----------------:|:------------:|:-------------:|
|   1   |      0.898      |       1.120       |    0.303     |     0.304     |
|   2   |      1.904      |       1.803       |    0.307     |     0.278     |
|   3   |      3.205      |       2.913       |    0.536     |     0.382     |
|   4   |      5.877      |       5.530       |    4.742     |     2.497     |
|   5   |                 |                   |              |               |

The difference in graph and relational databases is that relational databases work with sets while graph databases work with paths. Hence, graph databases are faster at searching for nested relations, but SQL based databases will work faster in on straight value searches and less deep layers.
