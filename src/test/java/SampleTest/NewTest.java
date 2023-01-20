package SampleTest;

import org.testng.annotations.Test;

public class NewTest {
  @Test(priority=0)
  public void create() {
	  
	  System.out.println("created");
	  
  }
  
  @Test(invocationCount =2,dependsOnMethods= "create")
  public void update()
  {
	System.out.println("updated");  
  }
  
  @Test(priority=1)
  public void delete()
  {
	  System.out.println("deleted");
  }
  
  
}
