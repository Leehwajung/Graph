package com.lhj.graph;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class AbstractGraph<E> implements Graph<E> {
	
	protected static enum Color {
		white,
		gray,
		black;
	}
	
	/**
	 * 깊이 우선 탐색
	 * @param startVertex   시작 정점
	 */
	public void depthFirstSearch(E startVertex) {
		// G의 모든 정점을 "미발견"이라고 초기화한다.
		LinkedHashMap<E, Color> color = createColorMap();
		
		// 선택한 정점에 대하여 DFS를 수행한다.
		depthFirstSearch(startVertex, color);
	}
	
	/**
	 * 깊이 우선 탐색
	 * @param v     현재 정점
	 * @param color 모든 정점의 현재 탐색 상태
	 */
	private void depthFirstSearch(E v, LinkedHashMap<E, Color> color) {
		color.replace(v, Color.gray);	// v가 "발견되었다"고 표시한다.
		
		for (E w : getHeads(v)) {	// vw가 G의 에지인 각 정점 w에 대하여
			if (color.get(w) == Color.white) {	// 만약 w가 미방문되었으면,
				depthFirstSearch(w, color);	// vw를 탐사하고, w를 방문하며, 거기서 가능한 최대로 탐사하고, w에서 v로 퇴각한다.
			}
			else {	// 그렇지 않으면,
				// w를 방문하지 않고 vw를 "체크"한다.
			}
		}
		
		color.replace(v, Color.black);	// v가 "종료되었다"고 표시한다.
	}
	
	/**
	 * 깊이 우선 탐색 (모든 정점 탐색)
	 */
	public void depthFirstSearch() {	// Sweep
		// G의 모든 정점을 "미발견"이라고 초기화한다.
		LinkedHashMap<E, Color> color = createColorMap();
		
		// G의 각 정점 v에 대하여,
		for (E v : getAllVertices()) {
			if (color.get(v) == Color.white) {	// 만약 v가 미발견이라면,
				depthFirstSearch(v, color);	// v에서 시작하는 (그리고 끝나는) 깊이 우선 탐색을 수행한다.
				// 전에 수행한 깊이 우선 탐색에서 방문한 정점은 재방문하지 않는다.
				// DFS 동안 방문된 모든 정점을 "발견되었다"고 표시한다.
			}
		}
	}
	
	/**
	 * 너비 우선 탐색
	 * @param startVertex   탐색을 시작하는 정점 s ∈ V
	 */
	public void breadthFirstSearch(E startVertex) {
		/*
		 * 맵 color는 모든 정점의 현재 탐색 상태를 나타낸다. 
		 * 미발견된 정점은 흰색, 발견되었지만 큐에서 처리되지 않은 것은 회색, 처리가 끝난 정점은 검은색이다.
		 */
		LinkedHashMap<E, Color> color = createColorMap();	// 전체 color를 white로 초기화한다.
		Queue<E> pending = new LinkedList<>();
		
		color.replace(startVertex, Color.gray);
		pending.add(startVertex);
		
		while (!pending.isEmpty()) {	// pending이 비어 있지 않을 때
			E v = pending.poll();
			// 리스트 adjVertices[v]의 각 정점 w에 대해서,
			for (E w : getHeads(v)) {
				if (color.get(w) == Color.white) {
					color.replace(w, Color.gray);
					pending.add(w);
				}
				// 리스트 처리를 계속한다.
			}
			// 정점 v를 여기서 처리한다.
			color.replace(v, Color.black);
		}
	}
	
	/**
	 * @return Color Map
	 */
	private final LinkedHashMap<E, Color> createColorMap() {
		LinkedHashMap<E, Color> color = new LinkedHashMap<>();
		for (E v : getAllVertices()) {
			color.put(v, Color.white);
		}
		return color;
	}
	
	/**
	 * @return All Vertices
	 */
	protected abstract List<E> getAllVertices();
	
	/**
	 * @param tail  Tail Vertex (v)
	 * @return Head Vertices (List of ws)
	 */
	protected abstract List<E> getHeads(E tail);
}
