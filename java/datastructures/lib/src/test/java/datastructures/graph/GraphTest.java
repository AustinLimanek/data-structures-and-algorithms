package datastructures.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    fullGraph.addEdge(ver1, ver2, 150);
    fullGraph.addEdge(ver2, ver1, 150);
    fullGraph.addEdge(ver2, ver3, 99);
    fullGraph.addEdge(ver2, ver4, 42);
    fullGraph.addEdge(ver3, ver2, 99);
    fullGraph.addEdge(ver3, ver4, 105);
    fullGraph.addEdge(ver3, ver5, 37);
    fullGraph.addEdge(ver3, ver6, 26);
    fullGraph.addEdge(ver4, ver2, 42);
    fullGraph.addEdge(ver4, ver3, 105);
    fullGraph.addEdge(ver4, ver6, 73);
    fullGraph.addEdge(ver5, ver3, 37);
    fullGraph.addEdge(ver5, ver6, 250);
    fullGraph.addEdge(ver6, ver3, 26);
    fullGraph.addEdge(ver6, ver4, 73);
    fullGraph.addEdge(ver6, ver5, 250);
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

  @Test
  public void twoCityTrip(){
    Graph<String> fullGraph = initfullGraph();
    ArrayList<String> expected = new ArrayList<>(List.of("Pandora", "Arendelle"));
    assertEquals(150, fullGraph.costOfTrip(expected));
  }

  @Test
  public void threeCityTrip(){
    Graph<String> fullGraph = initfullGraph();
    ArrayList<String> expected = new ArrayList<>(List.of("Pandora", "Arendelle", "Metroville"));
    assertEquals(249, fullGraph.costOfTrip(expected));
  }

  @Test
  public void impossibleTrip(){
    Graph<String> fullGraph = initfullGraph();
    ArrayList<String> expected = new ArrayList<>(List.of("Pandora", "Arendelle", "Metroville", "Monstropolis", "Narnia", "Naboo"));
    assertNull(fullGraph.costOfTrip(expected));
  }

  @Test
  public void roundTrip(){
    Graph<String> fullGraph = initfullGraph();
    ArrayList<String> expected = new ArrayList<>(List.of("Pandora", "Arendelle", "Pandora"));
    assertEquals(300, fullGraph.costOfTrip(expected));
  }

  @Test
  public void noTrip(){
    Graph<String> fullGraph = initfullGraph();
    ArrayList<String> expected = new ArrayList<>();
    assertNull(fullGraph.costOfTrip(expected));
  }

  @Test
  public void longTrip(){
    Graph<String> fullGraph = initfullGraph();
    ArrayList<String> expected = new ArrayList<>(List.of("Pandora", "Arendelle", "Metroville", "Monstropolis", "Naboo", "Narnia"));
    assertEquals(677, fullGraph.costOfTrip(expected));
  }

  @Test
  public void unknownTrip(){
    Graph<String> fullGraph = initfullGraph();
    ArrayList<String> expected = new ArrayList<>(List.of("Seattle", "Arendelle"));
    assertNull(fullGraph.costOfTrip(expected));
  }

  @Test
  public void stayVacation(){
    Graph<String> fullGraph = initfullGraph();
    ArrayList<String> expected = new ArrayList<>(List.of("Pandora"));
    assertNull(fullGraph.costOfTrip(expected));
  }

  @Test
  public void depthFirst(){
    Graph<String> fullGraph = initfullGraph();
    ArrayList<String> expected = new ArrayList<>(List.of("Pandora", "Arendelle", "Metroville", "Monstropolis", "Naboo", "Narnia"));
    assertEquals(expected, fullGraph.depthFirstPrint("Pandora"));
  }

  @Test
  public void depth(){

    Graph<String> fullGraph = new Graph<>(10);
    Vertex<String> a = fullGraph.addVertex("A");
    Vertex<String> b = fullGraph.addVertex("B");
    Vertex<String> c = fullGraph.addVertex("C");
    Vertex<String> d = fullGraph.addVertex("D");
    Vertex<String> e = fullGraph.addVertex("E");
    Vertex<String> f = fullGraph.addVertex("F");
    Vertex<String> g = fullGraph.addVertex("G");
    Vertex<String> h = fullGraph.addVertex("H");
    fullGraph.addEdge(a, b);
    fullGraph.addEdge(a, d);
    fullGraph.addEdge(b, a);
    fullGraph.addEdge(b, c);
    fullGraph.addEdge(b, d);
    fullGraph.addEdge(c, b);
    fullGraph.addEdge(c, g);
    fullGraph.addEdge(d, a);
    fullGraph.addEdge(d, b);
    fullGraph.addEdge(d, e);
    fullGraph.addEdge(d, h);
    fullGraph.addEdge(d, f);
    fullGraph.addEdge(e, d);
    fullGraph.addEdge(h, d);
    fullGraph.addEdge(h, f);
    fullGraph.addEdge(f, d);
    fullGraph.addEdge(f, h);
    fullGraph.addEdge(g, c);

    ArrayList<String> expected = new ArrayList<>(List.of("A", "B", "C", "G", "D", "E", "H", "F"));
    assertEquals(expected, fullGraph.depthFirstPrint("A"));
  }

  @Test
  public void depthEmptyGraph(){
    Graph<String> fullGraph = new Graph<>(10);
    assertNull(fullGraph.depthFirstPrint("Pandora"));
  }

  @Test
  public void wrongGraph(){
    Graph<String> fullGraph = initfullGraph();
    assertNull(fullGraph.depthFirstPrint("Seattle"));
  }

}
