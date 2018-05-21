package suite;
import TestMath.MyTestMathTool;
import interfacerestAssured.TestAppLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	TestAppLogin.class
})

public class DomeSuite {

}
