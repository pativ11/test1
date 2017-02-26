package com.whirlpool.wcloud.model.testcase;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
//import static org.junit.n

public class TestJunit2 {

   String message = "Robert";	
   MessageUtil messageUtil = new MessageUtil(message);
 
   @Test
   public void testSalutationMessage() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + "Robert";
      
      assertEquals(message,messageUtil.salutationMessage());
   }
}