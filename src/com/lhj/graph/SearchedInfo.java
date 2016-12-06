package com.lhj.graph;

public class SearchedInfo<E> {
	
	private E vertex;
	private int layer;
	private int discoverTime;
	private int FinishTime;
	
	/**
	 * @param vertex
	 * @param layer
	 */
	public SearchedInfo(E vertex, int layer) {
		this.vertex = vertex;
		this.layer = layer;
	}
	
	/**
	 * @param vertex
	 * @param layer
	 * @param discoverTime
	 * @param finishTime
	 */
	public SearchedInfo(E vertex, int layer, int discoverTime) {
		this(vertex, layer);
		this.discoverTime = discoverTime;
	}
	
	/**
	 * @param vertex
	 * @param layer
	 * @param discoverTime
	 * @param finishTime
	 */
	public SearchedInfo(E vertex, int layer, int discoverTime, int finishTime) {
		this(vertex, layer, discoverTime);
		this.FinishTime = finishTime;
	}
	
	/**
	 * @return the vertex
	 */
	public E getVertex() {
		return vertex;
	}
	
	/**
	 * @return the layer
	 */
	public int getLayer() {
		return layer;
	}
	
	/**
	 * @return the discoverTime
	 */
	public int getDiscoverTime() {
		return discoverTime;
	}
	
	/**
	 * @param discoverTime the discoverTime to set
	 */
	public void setDiscoverTime(int discoverTime) {
		this.discoverTime = discoverTime;
	}
	
	/**
	 * @return the finishTime
	 */
	public int getFinishTime() {
		return FinishTime;
	}
	
	/**
	 * @param finishTime the finishTime to set
	 */
	public void setFinishTime(int finishTime) {
		FinishTime = finishTime;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String r = new String();
		for (int i = 0; i < layer; i++) {
			r += "• ";
		}
		r += vertex;
		if (discoverTime > 0 && FinishTime > 0) {
			return r + " (" + discoverTime + "/" + FinishTime + ")";
		}
		return r;
	}
}
