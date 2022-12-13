package datastructures.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

  public Graph<String> initfullGraph(){
    Graph<String> fullGraph = new Graph<>(10);
    Vertex<String> ver1 = fullGraph.addVertex("Pandora");
    Vertex<String> ver2 = fullGraph.addVertex("Arendelle");
    Vertex<String> ver3 = fullGraph.addVertex("Metroville");
    Vertex<String> ver4 = fullGraph.addVertex("Monstropolis");
    Vertex<String> ver5 = fullGraph.addVertex("Narnia");
    Vertex<String> ver6 = fullGraph.addVertex("Naboo");
    fullGraph.addEdge(ver1, ver2);
    fullGraph.addEdge(ver2, ver1);
    fullGraph.addEdge(ver2, ver3);
    fullGraph.addEdge(ver2, ver4);
    fullGraph.addEdge(ver3, ver2);
    fullGraph.addEdge(ver3, ver4);
    fullGraph.addEdge(ver3, ver5);
    fullGraph.addEdge(ver3, ver6);
    fullGraph.addEdge(ver4, ver2);
    fullGraph.addEdge(ver4, ver3);
    fullGraph.addEdge(ver4, ver6);
    fullGraph.addEdge(ver5, ver3);
    fullGraph.addEdge(ver5, ver6);
    fullGraph.addEdge(ver6, ver3);
    fullGraph.addEdge(ver6, ver4);
    fullGraph.addEdge(ver6, ver5);
    return fullGraph;
  }

  @Test
  public void fullGraphSizeCheck(){
    Graph<String> fullGraph = initfullGraph();
    assertEquals(6, fullGraph.size());
  }

  @Test
  public void fullGraphPrintBFSSizeCheck(){
    Graph<String> fullGraph = initfullGraph();
    assertEquals(6, fullGraph.printBFS(fullGraph.getVertices().peek()).size());
  }

  @Test
  public void fullGraphPrintBFSPrint(){
    Graph<String> fullGraph = new Graph<>(10);
    Vertex<String> ver1 = fullGraph.addVertex("Pandora");
    Vertex<String> ver2 = fullGraph.addVertex("Arendelle");
    Vertex<String> ver3 = fullGraph.addVertex("Metroville");
    Vertex<String> ver4 = fullGraph.addVertex("Monstropolis");
    Vertex<String> ver5 = fullGraph.addVertex("Narnia");
    Vertex<String> ver6 = fullGraph.addVertex("Naboo");
    fullGraph.addEdge(ver1, ver2);
    fullGraph.addEdge(ver2, ver1);
    fullGraph.addEdge(ver2, ver3);
    fullGraph.addEdge(ver2, ver4);
    fullGraph.addEdge(ver3, ver2);
    fullGraph.addEdge(ver3, ver4);
    fullGraph.addEdge(ver3, ver5);
    fullGraph.addEdge(ver3, ver6);
    fullGraph.addEdge(ver4, ver2);
    fullGraph.addEdge(ver4, ver3);
    fullGraph.addEdge(ver4, ver6);
    fullGraph.addEdge(ver5, ver3);
    fullGraph.addEdge(ver5, ver6);
    fullGraph.addEdge(ver6, ver3);
    fullGraph.addEdge(ver6, ver4);
    fullGraph.addEdge(ver6, ver5);

    ArrayList<String> expected = new ArrayList<>(List.of("Pandora", "Arendelle", "Metroville", "Monstropolis", "Narnia", "Naboo"));
    ArrayList<String> result = new ArrayList<>(fullGraph.printBFS(ver1));
    assertEquals(expected, result);
  }

}
