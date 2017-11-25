package domain;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sanmu.
 * @date 11/25/2017
 * @email 1215148017@qq.com
 */
public class DomainTest {


    private TestDomain testCase;

    @Before
    public void before() {
        this.testCase = new TestDomain();
        testCase.name = "jack";
        testCase.age = 11;
    }

    @Test
    public void testToString() {
        System.out.println(testCase.toString());
    }

}

class TestDomain extends Domain {
    String name;
    int age;
}