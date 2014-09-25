package test.java.com.project.devtest.wangh;

import java.io.File;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

public class NashornTest {
	
	private final String baseDirStr = "src/test/resources/jstest/";
	
	@Test
	public void mytest() throws ScriptException{
	
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName( "JavaScript" );
		
		System.out.println( engine.getClass().getName() );
		try {
			System.out.println( "Result:" + engine.eval( "function f() { return 1; }; f() + 1;" ) );
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String js;
		js = "var map = Array.prototype.map \n";
		js += "var names = [\"john\", \"jerry\", \"bob\"]\n";
		js += "var a = map.call(names, function(name) { return name.length() })\n";
		js += "print(a)";
		engine.eval(js);

		
	}
	
	@Test
	public void testHelloWorld() throws Exception {
		String helloDir = baseDirStr + "hello/";

		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("nashorn");

		File helloJS = new File(helloDir,"hello.js");
		engine.eval(new FileReader(helloJS));
	}
	

}
