package datastructures.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

  @Test
  public void checkVertexAdd(){
    Graph<Integer> graph = new Graph<>(10);
    Vertex<Integer> ver1 = graph.addVertex(1);
    assertEquals(1, graph.size());
  }

  @Test
  public void checkSingleEdgeAdd(){
    Graph<Integer> graph = new Graph<>(10);
    Vertex<Integer> ver1 = graph.addVertex(1);
    graph.addEdge(ver1, ver1);
    assertEquals(1, graph.adjacencyLists.get(ver1).size());
  }

  @Test
  public void collectionOfVertexRetrieve(){
    Graph<Integer> graph = new Graph<>(10);
    Vertex<Integer> ver1 = graph.addVertex(1);
    Vertex<Integer> ver2 = graph.addVertex(2);
    Vertex<Integer> ver3 = graph.addVertex(3);
    assertEquals(3, graph.getVertices().size());
  }

  @Test
  public void neighborsOfVertexRetrieve(){
    Graph<Integer> graph = new Graph<>(10);
    Vertex<Integer> ver1 = graph.addVertex(1);
    Vertex<Integer> ver2 = graph.addVertex(2);
    Vertex<Integer> ver3 = graph.addVertex(3);
    graph.addEdge(ver1, ver2);
    graph.addEdge(ver1, ver3);
    graph.addEdge(ver2, ver1);
    assertEquals(2, graph.getNeighbors(ver1).size());
    assertEquals(1, graph.getNeighbors(ver2).size());
  }

  @Test
  public void weightsOnVertices(){
    Graph<Integer> graph = new Graph<>(10);
    Vertex<Integer> ver1 = graph.addVertex(1);
    Vertex<Integer> ver2 = graph.addVertex(2);
    Vertex<Integer> ver3 = graph.addVertex(3);
    graph.addEdge(ver1, ver2, 2);
    graph.addEdge(ver1, ver3, 3);
    assertEquals(2, graph.getNeighbors(ver1).peek().weight);
  }

  @Test
  public void graphSize(){
    Graph<Integer> graph = new Graph<>(10);
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(3);
    graph.addVertex(3);
    assertEquals(5, graph.size());
  }

  @Test
  public void oneVertexOneEdge(){
    Graph<Integer> graph = new Graph<>(10);
    Vertex<Integer> ver1 = graph.addVertex(1);
    graph.addEdge(ver1, ver1, 100);
    assertEquals(1, graph.size());
    assertEquals(1, graph.getNeighbors(ver1).size());
    assertEquals(100, graph.getNeighbors(ver1).getFirst().weight);
  }

}
