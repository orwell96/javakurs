import static org.junit.Assert.*;

import org.junit.*;


public class TestLibrary {
	private Library lib;
	
	@Before
	public void prepare(){
		lib = new Library(10);
	}
	
	@Test
	public void testAddBook(){
		Book b = new Book("Titel", "Autor", "123456");
		assertEquals(b.toString(), "Titel");
		
		lib.addMedium(b);
		assertTrue(b.getId() != -1);
		
		assertNotNull(lib.getMedium(b.getId()));
	}
	
}
