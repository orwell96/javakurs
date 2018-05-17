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
		int id = b.getId();
		assertTrue(id != -1);
		
		Medium m = lib.getMedium(id);
		assertSame(m, b);
		
		assertTrue(m instanceof Book);
		Book pm = (Book) m;
		assertEquals(pm.getTitle(), "Titel");
		assertEquals(pm.getAuthor(), "Autor");
	}
	@Test
	public void testAddJournal(){
		Journal b = new Journal("FAZ", "2/2018");
		assertEquals(b.toString(), "FAZ");
		
		lib.addMedium(b);
		
		int id = b.getId();
		assertTrue(id != -1);
		
		assertSame(lib.getMedium(id), b);
	}
	
	@Test
	public void testAddCopy(){
		Book b = new Book("CopyTest", "Autor", "1234567");
		lib.addMedium(b);
		Copy c = new Copy(125, b, "R11");
		lib.addCopy(c);
		
		assertSame(lib.getCopy(125), c);
		
		try{
			Copy d = new Copy(125, b, "R23");
			lib.addCopy(d);
			fail();
		}catch(DuplicateIdException e){
			
		}catch(Exception e){
			fail();
		}
	}
	
}
