package fr.jbng.utils;

public class GrassMap {
	private int n;
	private int m;
	
	public GrassMap(int n, int m){
		this.setDimension(n, m);
	}
	
	public void setDimension(int n, int m){
		this.n = n;
		this.m = m;
	}
	
	public int getWidth(){
		return n;
	}
	
	public int getHeight(){
		return m;
	}
}
