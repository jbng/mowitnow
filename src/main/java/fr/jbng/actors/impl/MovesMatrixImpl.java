package fr.jbng.actors.impl;

import fr.jbng.actors.api.MovesMatrix;

public class MovesMatrixImpl implements MovesMatrix {
	private int n;
	private int m;
	
	public MovesMatrixImpl(int n, int m){
		this.setDimension(n, m);
	}
	
	/* (non-Javadoc)
	 * @see fr.jbng.logic.MovesMatrix#setDimension(int, int)
	 */
	@Override
	public void setDimension(int n, int m){
		this.n = n;
		this.m = m;
	}
	
	/* (non-Javadoc)
	 * @see fr.jbng.logic.MovesMatrix#getWidth()
	 */
	@Override
	public int getWidth(){
		return n;
	}
	
	/* (non-Javadoc)
	 * @see fr.jbng.logic.MovesMatrix#getHeight()
	 */
	@Override
	public int getHeight(){
		return m;
	}
}
