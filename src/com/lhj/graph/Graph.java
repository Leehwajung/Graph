package com.lhj.graph;

import java.util.List;

public interface Graph<E> {
	
	/**
	 * 정점 추가
	 * @param vertex    the Vertex to add
	 */
	public void addVertex(E vertex);
	
	/**
	 * 엣지 추가
	 * @param tail  Tail Vertex (v)
	 * @param head  Head Vertex (w)
	 */
	public void addEdge(E tail, E head);
	
	/**
	 * Adjacency Matrix
	 * @return Adjacency Matrix
	 */
//	public E[][] getMatrix();
	
	/**
	 * 깊이 우선 탐색
	 * @param s 탐색을 시작하는 정점 s ∈ V
	 */
	public List<SearchedInfo<E>> depthFirstSearch(E s);
	
	/**
	 * 깊이 우선 탐색 (모든 정점 탐색)
	 */
	public List<SearchedInfo<E>> depthFirstSearch();
	
	/**
	 * 너비 우선 탐색
	 * @param s 탐색을 시작하는 정점 s ∈ V
	 */
	public List<SearchedInfo<E>> breadthFirstSearch(E s);
	/**
	 * 너비 우선 탐색 (모든 정점 탐색)
	 */
	public List<SearchedInfo<E>> breadthFirstSearch();
}
