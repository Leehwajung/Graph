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
		adjInfo.put(vertex, new LinkedList<>());
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
}
