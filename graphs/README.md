# *Graphs:*

## Use:
### Run Graphs to run a sample adjacency list with outputs of the different operations.

<table>
  <tr>
    <th>Type</th><th>Storage</th><th>Add Vertex</th><th>Add Edge</th><th>Remove Vertex</th><th>Remove Edge</th><th>Query</th>
  </tr>
  <tr>
    <td>Adjacency List</td><td>O(|V|+|E|)</td><td>O(1)</td><td>O(1)</td><td>O(|E|)</td><td>O(|E|)</td><td>O(|V|)</td>
  </tr>
  <tr>
    <td>Adjacency Matrix</td><td>O(|V|^2)</td><td>O(|V|^2)</td><td>O(1)</td><td>O(|V|^2)</td><td>O(1)</td><td>O(1)</td>
  </tr>
  <tr>
    <td>Incidence List</td><td>O(|V|+|E|)</td><td>O(1)</td><td>O(1)</td><td>O(|E|)</td><td>O(|E|)</td><td>O(|E|)</td>
  </tr>
  <tr>
    <td>Incidence Matrix</td><td>O(|V|*|E|)</td><td>O(|V|*|E|)</td><td>O(|V|*|E|)</td><td>O(|V|*|E|)</td><td>O(|V|*|E|)</td><td>O(|E|)</td>
  </tr>
</table>

## *Adjacency List:*
- Vertices are stored in an arraylist. Each vertex has an arraylist of edges to neighoring vertices. 
- Supports directed graphs.

### *Operations:*
- addVertex
- addEdge
- removeVertex
- removeEdge
- updateEdge
- copyGraph
- deleteGraph

### *Algorithm:*
*Breadth First Search*
- traverseBFS
- shortestPath

*Depth First Search*
- DAG test
- traverseDFS
- topological sort
- Classification of edges into (in comments): 
1)Tree Edges 
2)Back Edges 
3)Forward/Cross Edges

## *Adjacency Matrix:*
- Not Implemented

## *Incidence List:*
- Not Implemented

## *Incidence Matrix:*
- Not Implemented

