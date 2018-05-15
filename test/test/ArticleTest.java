package test;

import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

import wiki.Section;
import wiki.Article;

public class ArticleTest {

    @Test
    public void sectionTitleTest() {
        Section tester = new Section();
        tester.setTitle("testTitle");
        String expResult = "testTitle";
        String result = tester.getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void sectionContentTest() {
        Section tester = new Section();
        tester.setTitle("testTitle");
        tester.setContent("testContent");
        String expResult = "testContent";
        String result = tester.getContent();
        assertEquals(expResult, result);
    }

    @Test
    public void sectionOrderTest() {
        Section tester = new Section();
        tester.setOrder(1);
        int expResult = 1;
        int result = tester.getOrder();
        assertEquals(expResult, result);
    }

    @Test
    public void ArticleIdTest() {
        Article tester = new Article();
        tester.setId(1);
        int expResult = 1;
        int result = tester.getId();
        assertEquals(expResult, result);
    }
    
    @Test
    public void ArticleNameTest() {
        Article tester = new Article();
        tester.setName("testName");
        String expResult = "testName";
        String result = tester.getName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void ArticleTagsTest() {
        Article tester = new Article();
        ArrayList<String> testTags = new ArrayList<>();
        testTags.add("testTag1");
        testTags.add("testTag2");
        tester.setTags(testTags);

        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("testTag1");
        expResult.add("testTag2");
        ArrayList<String> result = tester.getTags();
        assertEquals(expResult, result);
    }
    
    @Test
    public void ArticleRateTest() {
        Article tester = new Article();
        tester.setRate(1);
        double expResult = 1;
        double result = tester.getRate();
        assertEquals(expResult, result);
    }
    
}
