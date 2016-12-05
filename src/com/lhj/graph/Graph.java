package com.lhj.graph;

public interface Graph<E> {
	public void addVertex(E vertex);
	public void addEdge(E tail, E head);
	public void depthFirstSearch(E startVertex);
	public void depthFirstSearch();
	public void breadthFirstSearch(E startVertex);
}
