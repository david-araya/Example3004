package core;

import junit.framework.TestCase;

public class ArithmeticSolverTest extends TestCase{

	
	public void testAdd() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(4, solver.add(2, 2)); // 2 + 2 = 4
	}
	
	public void testSubstract() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(2, solver.substract(4, 2)); // 4 - 2 = 2
	}
	
	public void testMultiply() {
		ArithmeticSolver solver = new ArithmeticSolver();
	
		assertEquals(16, solver.multiply(8, 2)); // 8 * 2 = 8
	}

	public void testDivide() {
		ArithmeticSolver solver = new ArithmeticSolver();
	
		assertEquals(3, solver.divide(9, 3)); // 9 / 3 = 3
	}
	
	public void testModulus() {
		ArithmeticSolver solver = new ArithmeticSolver();
	
		assertEquals(1, solver.modulus(5, 2)); // 5 % 2 = 1
	}
}
