package com.udemy.principles;

public class LiskovSubstitutionPrinciple {

	//you should be able to substitute the sub class before base class
	// you should be able to stick to sub class without breaking to base class
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle r = new Rectangle(2,3);
		userIt(r);
		
		Rectangle sq = new Square();
		sq.setWidth(5);
		userIt(sq);
		
	}
	
	static void userIt(Rectangle r) {
		int width = r.getWidth();
		r.setHeight(10);
		System.out.println( "Expected area of "+ (width * 10) + ", got "+r.getArea() );
	}
	

}

class Rectangle{
	
	protected int width, height;

	public Rectangle() {
		
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}


	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getArea() {return width*height;}
	
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
	public boolean isSquare() {
		return width == height;
	}
}


class Square extends Rectangle{

	public Square() {
		
	}

	public Square(int size) {

		width = height = size;
	}
	
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}
	
	public void setHeight(int height) {
	    super.setWidth(height);
	    super.setHeight(height);
	}
	
}

class RectangleFactory{
	public static Rectangle newRectangle(int width, int height) {
		return new Rectangle(width, height);
	}
	
	public static Rectangle newSquare(int side) {
		return new Rectangle(side, side);
	}
	
}