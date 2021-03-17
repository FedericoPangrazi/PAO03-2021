/**
 * 
 */
package com.openweather.project;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.jupiter.api.*;
/**
 * @author frede
 *
 */
public class tests {
private String q;
private JSONObject object;
private String path;

@BeforeEach
void setUp() throws Exception{
	q=new String();
	object=new JSONObject();
	path= new String();
}

@AfterEach
void tearDown() throws Exception{
}
/**
 * test per verificare che la città inserita sia corretta
 * @throws IOException
 */
@Test
void cityAccepted() throws IOException{
	String city1= "London";
	assertEquals(city1,q);
	
}
/**
 * test per verificare che il jsonobject restituito non sia vuoto
 */
@Test
void ObjectNotFound(){
	 assertNull(object);
}
/**
 * test per verifcare il corretto percorso del file dove salvare i dati correnti
 */
@Test 
void AcceptedPath() {
	String percorso=System.getProperty("user.dir")+q+".txt";
	assertEquals(percorso,path);
}
}
