package datastructures.graph;


import java.beans.VetoableChangeListener;
import java.util.HashMap;
import java.util.LinkedList;

import datastructures.graph.Edge;
import datastructures.graph.Vertex;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>>  // just in case you have Comparable data structures
{
  public HashMap<Vertex<T>, LinkedList<Edge<T>>> adjacencyLists;
  private int numberOfVertices = 0;

  public Graph(int maxNumberOfVertices)
  {
    adjacencyLists = new HashMap<>(maxNumberOfVertices);
  }

  public Vertex<T> addVertex(T value)  // addNode()
  {
    Vertex<T> newVertex = new Vertex<>(value);
    adjacencyLists.put(newVertex, new LinkedList<>());
    numberOfVertices += 1;
    return newVertex;
  }

  public void addEdge(Vertex<T> start, Vertex<T> destination)
  {
    addEdge(start, destination, 0);
  }

  public void addEdge(Vertex<T> start, Vertex<T> destination, int weight)
  {
    Edge<T> newEdge = new Edge<>(destination, weight);
    adjacencyLists.get(start).add(newEdge);
  }

  public LinkedList<Vertex<T>> getVertices()  // getNodes()
  {
    return new LinkedList<>(adjacencyLists.keySet());
  }

  public LinkedList<Edge<T>> getNeighbors(Vertex<T> vertex)
  {
    return adjacencyLists.get(vertex);
  }

  public int size()
  {
    return numberOfVertices;
  }

  @Override
  public int compareTo(Graph<T> o)
  {
    throw new UnsupportedOperationException("Graph does not implement compareTo()");
  }

  @Override
  public String toString()
  {
    StringBuilder output = new StringBuilder();
    for (Vertex<T> vertex : adjacencyLists.keySet()){
      output.append("{").append(vertex.value).append("}");
      for( Edge<T> edge : adjacencyLists.get(vertex)){
        output.append("-(").append(edge.weight).append(")->").append(edge.destination.value);
      }
      output.append("\n");
    }
    return output.toString();
  }

}
