package com.lhj.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph<E> {
	
	private static final int white = -1;
	private static final int gray = 0;
	private static final int black = 1;
	
	/**
	 * 깊이 우선 탐색
	 * @param adjVertices   인접 리스트 구조로 표현된 그래프 G = (V, E)
	 * @param color         모든 정점의 현재 탐색 상태
	 * @param v             현재 정점
	 */
	public void depthFirstSearch(List<Integer>[] adjVertices, int[] color, int v) {
		color[v] = gray;	// v가 "발견되었다"고 표시한다.
		
		for (Integer w : adjVertices[v]) {	// vw가 G의 에지인 각 정점 w에 대해서
			if (color[w] == white) {		// 만약 w가 미방문되었으면,
				depthFirstSearch(adjVertices, color, w);	// vw를 탐사하고, w를 방문하며, 거기서 가능한 최대로 탐사하고, w에서 v로 퇴각한다.
			}
			else {	// 그렇지 않으면,
				// w를 방문하지 않고 vw를 "체크"한다.
			}
		}
		
		color[v] = black;	// v가 "종료되었다"고 표시한다.
	}
	
	/**
	 * 깊이 우선 탐색 (모든 정점 탐색)
	 * @param adjVertices   인접 리스트 구조로 표현된 그래프 G = (V, E)
	 * @param n             정점의 개수 V = {1, 2, ..., n}
	 */
	public void depthFirstSearchSweep(List<Integer>[] adjVertices, int n) {
		// G의 모든 정점을 "미발견"이라고 초기화한다.
		int[] color = new int[n + 1];
		for (List<Integer> subList : adjVertices) {
			for (Integer v : subList) {
				color[v] = white;
			}
		}
		
		// G의 각 정점 v에 대해서,
		for (List<Integer> subList : adjVertices) {
			for (Integer v : subList) {
				if (color[v] == white) {	// 만약 v가 미발견이라면,
					depthFirstSearch(adjVertices, color, v);	// v에서 시작하는 (그리고 끝나는) 깊이 우선 탐색을 수행한다.
					// 전에 수행한 깊이 우선 탐색에서 방문한 정점은 재방문하지 않는다.
					// DFS 동안 방문된 모든 정점을 "발견되었다"고 표시한다.
				}
			}
		}
	}
	
	/**
	 * 너비 우선 탐색
	 * @param adjVertices   인접 리스트 구조로 표현된 그래프 G = (V, E)
	 * @param n             정점의 개수 V = {1, 2, ..., n}
	 * @param s             탐색을 시작하는 정점 s ∈ V
	 * @param parent        [output] 너비 우선 스패닝 트리, 이 배열을 인수로 넘겨 받아 알고리즘에서 계산한다.
	 */
	public void breadthFirstSearch(List<Integer>[] adjVertices, int n, int s, int[] parent) {
		/* 주의
		 * 배열 color[1], ..., color[n]은 모든 정점의 현재 탐색 상태를 나타낸다. 
		 * 미발견된 정점은 흰색, 발견되었지만 큐에서 처리되지 않은 것은 회색, 처리가 끝난 정점은 검은색이다.
		 */
		int[] color = new int[n + 1];
		Queue<Integer> pending = new LinkedList<>();
		// color[1], ..., color[n]을 white로 초기화한다.
		for (int i = 1; i < color.length; i++) {
			color[i] = white;
		}
		
		parent[s] = -1;
		color[s] = gray;
		pending.add(s);
		while (!pending.isEmpty()) {	// pending이 비어 있지 않을 때
			Integer v = pending.poll();
			// 리스트 adjVertices[v]의 각 정점 w에 대해서,
			for (List<Integer> subList : adjVertices) {
				for (Integer w : subList) {
					if (color[w] == white) {
						color[w] = gray;
						pending.add(w);
						parent[w] = v;	// 에지 vw를 처리한다.
					}
				}
				// 리스트 처리를 계속한다.
			}
			// 정점 v를 여기서 처리한다.
			color[v] = black;
		}
	}
}
