package com.lhj.main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.lhj.graph.Graph;
import com.lhj.graph.SearchedInfo;
import com.lhj.graph.UnweightedGraph;

public class Main {
	
	public static void main(String[] args) {
		
		UnweightedGraph<Integer> g = new UnweightedGraph<>();
		try (Scanner s = new Scanner(new File("quiz"))) {
			int v = -1, w;
			while (s.hasNext()) {
				String line = s.nextLine();
				String[] inputs = line.split(" ");
				v = Integer.valueOf(inputs[0]);
				
				for (String input : Arrays.copyOfRange(inputs, 2, inputs.length)) {
					w = Integer.valueOf(input);
					g.addEdge(v, w);
				}
			}
		} catch (NoSuchElementException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("### Depth First Search ###");
		List<SearchedInfo<Integer>> infos = g.depthFirstSearch();
		System.out.println(getNLStringOf(infos));
		
		System.out.println("### Breadth First Search ###");
		infos = g.breadthFirstSearch();
		System.out.println(getNLStringOf(infos));
		
		System.out.println("### Adjacency Matrix ###");
		g.printAdjacencyMatrix();
		
	}
	
	private static <E> String getNLStringOf(Collection<E> collection) {
		Iterator<E> it = collection.iterator();
		if (!it.hasNext())
			return "";
		
		StringBuilder sb = new StringBuilder();
		for (;;) {
			E e = it.next();
			sb.append(e == collection ? "(this Collection)" : e);
			if (!it.hasNext())
				return sb.toString();
			sb.append('\n');
		}
	}
	
	private <E> void printActiveTime(List<SearchedInfo<E>> info) {
		
	}
	
	private <E> void getActiveTimeList(List<SearchedInfo<E>> info) {
		HashMap<E, Integer> map = new HashMap<>();
		for (SearchedInfo<E> i : info) {
			map.put(i.getVertex(), 1);
		}
	}
}
