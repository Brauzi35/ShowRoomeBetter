package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ LoginArtist.class, TestRegistration1.class, DescriptionTest.class,TestHostEvent1.class,EmailTest.class,TestReview1.class})
public class AllTests {

}
