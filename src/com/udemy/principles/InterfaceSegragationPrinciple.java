package com.udemy.principles;

public class InterfaceSegragationPrinciple {
// how to split interface into small interfaces
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Document{
	
}

interface Machine{
	void print(Document d);
	void fax(Document d);
	void scan(Document d);
}

class MultiFucntionPrinter implements Machine{

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fax(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}

class OldFashionedPrinter implements Machine {

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fax(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}

interface Printer {
	void print(Document d);
}

interface Scanner {
	void scan(Document d);
}

//YAGNI = You Ain't Going To Needed it


class JustAPrinter implements Printer {

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}

class PhotoCopier implements Printer, Scanner {

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}
}

interface MultiFunctionDevice extends Printer, Scanner{}

class MultiFunctionMachine implements MultiFunctionDevice {

	private Printer printer;
	private Scanner scanner;
	
	public MultiFunctionMachine() {
		
	}
	
	public MultiFunctionMachine(Printer printer, Scanner scanner) {
		this.printer = printer;
		this.scanner = scanner;
	}
	
	
	
	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
	printer.print(d);	
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		scanner.scan(d);
	}
	
}