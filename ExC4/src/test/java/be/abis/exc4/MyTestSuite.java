package be.abis.exc4;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(JUnitPlatform.class)
@SelectClasses( { TestPerson.class, TestAddress.class} )
public class MyTestSuite {
}
