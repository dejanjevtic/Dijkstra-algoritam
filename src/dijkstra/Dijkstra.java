/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.*;
import java.lang.*; 
import java.io.*; 
/**
 *
 * @author dejan
 */
public class Dijkstra {
        static final int V = 6; 
        int minDistance(int dist[], Boolean sptSet[]) 
        { 
            // Initialize min value 
            int min = Integer.MAX_VALUE, min_index = -1; 

            for (int v = 0; v < V; v++) 
                if (sptSet[v] == false && dist[v] <= min) { 
                    min = dist[v]; 
                    min_index = v; 
                } 

            return min_index; 
        } 
        
       void printResenje(int dist[]) 
        { 
            System.out.println("Vertex \t\t Distance from Source"); 
            for (int i = 0; i < V; i++) 
                System.out.println(i + " \t\t " + dist[i]); 
        }  
        
       void dijkstra(int graph[][], int src) 
        { 
            int dist[] = new int[V]; // The output array. dist[i] will hold 
            // the shortest distance from src to i 
            //System.out.println(Arrays.toString(dist)); 
            //System.exit(0);
            // sptSet[i] will true if vertex i is included in shortest 
            // path tree or shortest distance from src to i is finalized 
            Boolean sptSet[] = new Boolean[V]; 
            //System.out.println(Arrays.toString(sptSet)); 
            //System.exit(0);
            // Initialize all distances as INFINITE and stpSet[] as false 
            for (int i = 0; i < V; i++) { 
                dist[i] = Integer.MAX_VALUE; 
                sptSet[i] = false; 
                
            } 
            
            /*System.out.println(Arrays.toString(dist)); // beskonacna vrednost za nesto sto ne vidimo
                System.out.println(Arrays.toString(sptSet));
                System.exit(0);*/
            //System.out.println(Arrays.toString(dist));
            
            
            // Distance of source vertex from itself is always 0 
            dist[src] = 0;  //System.out.println(Arrays.toString(dist));
                            //System.exit(0);
            // Find shortest path for all vertices 
            for (int count = 0; count < V - 1; count++) { 
                // Pick the minimum distance vertex from the set of vertices 
                // not yet processed. u is always equal to src in first 
                // iteration. 
                
                //System.out.println(Arrays.toString(dist));
                //System.exit(0);
                int u = minDistance(dist, sptSet); //System.out.println(u);
                    
                // Mark the picked vertex as processed 
                sptSet[u] = true; //System.out.println(sptSet[u]);

                // Update dist value of the adjacent vertices of the 
                // picked vertex. 
                for (int v = 0; v < V; v++) {

                    // Update dist[v] only if is not in sptSet, there is an 
                    // edge from u to v, and total weight of path from src to 
                    // v through u is smaller than current value of dist[v] 
                    if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
                
                //System.out.println(dist[v]);
                
            } 
}
            // print the constructed distance array 
            printResenje(dist); 
        } 
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int graph[][] = new int[][] { { 0, 5, 1, 0, 0, 0}, 
                                      { 0, 0, 0, 15, 20, 0 }, 
                                      { 0, 0, 0, 30, 35, 0 }, 
                                      { 0, 0, 0, 0, 0, 20 }, 
                                      { 0, 0, 0, 0, 0, 10 }, 
                                      { 0, 0, 0, 0, 0, 0 }}; 
        
        /*for (int i = 0; i < 5; i++)
            {
               for (int j = 0; j < 5; j++)
               {
                  System.out.printf("%5d ", graph[i][j]);
               }
               System.out.println();
            }*/
        //System.exit(0);
        
        Dijkstra t = new Dijkstra(); 
        t.dijkstra(graph, 0); 
    }
    
}
