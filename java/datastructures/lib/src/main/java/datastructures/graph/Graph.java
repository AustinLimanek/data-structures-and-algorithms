package datastructures.graph;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import datastructures.graph.Edge;
import datastructures.graph.Vertex;
import datastructures.queue.Queue;

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

  public LinkedHashSet<T> printBFS(Vertex<T> start){

    Queue<Vertex<T>> line = new Queue<>();
    LinkedHashSet<Vertex<T>> visited = new LinkedHashSet<>();
    LinkedHashSet<T> visitedT = new LinkedHashSet<>();

    line.enqueue(start);
    visited.add(start);
    visitedT.add(start.value);

    while(!line.isEmpty()){
      for(Edge<T> edge : this.getNeighbors(line.dequeue())){
        if(!visited.contains(edge.getDestination())){
          visited.add(edge.getDestination());
          visitedT.add(edge.getDestination().value);
          line.enqueue(edge.getDestination());
        }
      }
    }
    return visitedT;
  }

  public Integer costOfTrip(ArrayList<T> vertices){

    if(vertices.size() < 2) return null;

    Vertex<T> current = null;
    int cost = 0;

    for(Vertex<T> vertex : this.getVertices()){
      if(vertex.value.equals(vertices.get(0))){
        current = vertex;
        break;
      }
    }

    if(current == null) return null;

    Queue<Vertex<T>> line = new Queue<>();
    int nextNode = 1;

    line.enqueue(current);
    boolean state;

    while(!line.isEmpty()){

      state = false;

      for(Edge<T> edge : this.getNeighbors(line.dequeue())){
        if(edge.destination.value.equals(vertices.get(nextNode))){
          cost += edge.weight;
          nextNode += 1;
          line.enqueue(edge.getDestination());
          state = true;
          break;
        }
      }

      if (!state) return null;
      if(nextNode == vertices.size()) break;

    }

    return cost;
  }

  public ArrayList<T> depthFirstPrint(T value){
    List<Vertex<T>> check = this.getVertices().stream().filter(v-> v.value.equals(value)).toList();
    if (check.size() < 1) return null;
    Vertex<T> start = check.get(0);
    HashSet<Vertex<T>> visited = new HashSet<>();
    ArrayList<T> order = new ArrayList<>();
    visited.add(start);
    order.add(start.value);

    depthFirst(start, visited, order);

    return order;
  }

  private void depthFirst(Vertex<T> vertex, HashSet<Vertex<T>> visited, ArrayList<T> order){
    if (visited.containsAll(this.getNeighbors(vertex).stream().map(v->v.destination).collect(Collectors.toList()))) return;

    for(Edge<T> edge : this.getNeighbors(vertex)){

        if(!visited.contains(edge.destination)){
          visited.add(edge.destination);
          order.add(edge.destination.value);
          depthFirst(edge.destination, visited, order);
        }
    }
  }

}
