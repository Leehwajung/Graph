package com.lhj.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class UnweightedGraph<E extends Comparable<E>> extends AbstractGraph<E> {
	
	private final HashMap<E, LinkedList<E>> adjInfo = new HashMap<>();	// 인접 리스트 구조로 표현된 그래프 G = (V, E)
	private final Comparator<E> comparator = new Comparator<E>() {
		@Override
		public int compare(E o1, E o2) {
			return o1.compareTo(o2);
		}
	};
	
	public UnweightedGraph() {
	}
	
	@Override
	public void addVertex(E vertex) {
		if (!adjInfo.containsKey(vertex)) {
			adjInfo.put(vertex, new LinkedList<>());
		}
	}
	
	@Override
	public void addEdge(E tail, E head) {
		if (adjInfo.containsKey(tail)) {
			LinkedList<E> subList = adjInfo.get(tail);
			if (subList.contains(head)){
				return;	// 이미 존재
			}
			subList.add(head);
			subList.sort(comparator);
		} else {
			LinkedList<E> subList = new LinkedList<>();
			adjInfo.put(tail, subList);
			subList.add(head);
		}
		addVertex(head);
	}
	
	@Override
	protected List<E> getAllVertices() {
		LinkedList<E> vertices = new LinkedList<>(adjInfo.keySet());
		vertices.sort(comparator);
		return vertices;
	}
	
	@Override
	protected List<E> getHeads(E tail) {
		return adjInfo.get(tail);
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return adjInfo.toString();
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adjInfo == null) ? 0 : adjInfo.hashCode());
		return result;
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UnweightedGraph<?>)) {
			return false;
		}
		UnweightedGraph<?> other = (UnweightedGraph<?>) obj;
		if (adjInfo == null) {
			if (other.adjInfo != null) {
				return false;
			}
		} else if (!adjInfo.equals(other.adjInfo)) {
			return false;
		}
		return true;
	}
}
