package test;

import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

import wiki.User;
import wiki.Profile;
import wiki.Article;
import wiki.Newsfeed;

public class UserTest {
    
    @Test
    public void userUsernameTest() {
        User tester = new User();
        tester.setUsername("testUsername");
        String expResult = "testUsername";
        String result = tester.getUsername();
        assertEquals(expResult,result);
    }
    
    @Test
    public void userIdTest() {
        User tester = new User();
        tester.setId(1);
        int expResult = 1;
        int result = tester.getId();
        assertEquals(expResult,result);
    }
    
    @Test
    public void userPasswordTest() {
        User tester = new User();
        tester.setPassword("testPassword");
        String expResult = "testPassword";
        String result = tester.getPassword();
        assertEquals(expResult,result);
    }
    
    @Test
    public void userFavouriteTest() {
        User tester = new User();
        Article test = new Article();
        test.setName("testFavourite");
        ArrayList<Article> testFavourite= new ArrayList<>();
        testFavourite.add(test);
        tester.setFavourite(testFavourite);
        
        String expResult = "testFavourite";
        ArrayList<Article> result = tester.getFavourite();
        String results = result.get(0).getName();
        
        assertEquals(expResult, results);
    }
    
    @Test
    public void userBasketTest() {
        User tester = new User();
        Article test = new Article();
        test.setName("testBasket");
        ArrayList<Article> testBasket = new ArrayList<>();
        testBasket.add(test);
        tester.setBasket(testBasket);
        
        String expResult = "testBasket";
        ArrayList<Article> result = tester.getBasket();
        String results = result.get(0).getName();
        
        assertEquals(expResult, results);
    }
    
    @Test
    public void userNewsfeedTest() {
        User tester = new User();
        Newsfeed test = new Newsfeed();
    }
    
    @Test
    public void profileNameTest() {
        Profile tester = new Profile();
        tester.setName("testName");
        String expResult = "testName";
        String result = tester.getName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void profileEmailTest() {
        Profile tester = new Profile();
        tester.setEmail("testEmail");
        String expResult = "testEmail";
        String result = tester.getEmail();
        assertEquals(expResult, result);
    }
    
    @Test
    public void profileContributedTest() {
        Profile tester = new Profile();
        Article test = new Article();
        test.setName("testContributed");
        ArrayList<Article> testContributed = new ArrayList<>();
        testContributed.add(test);
        tester.setContributed(testContributed);
        
        String expResult = "testContributed";
        ArrayList<Article> result = tester.getContributed();
        String results = result.get(0).getName();
        
        assertEquals(expResult, results);
    }
    
    @Test
    public void profileRateTest() {
        Profile tester = new Profile();
        tester.setRate(1);
        int expResult = 1;
        int result = tester.getRate();
        assertEquals(expResult, result);
    }
    
    @Test
    public void profileRateupTest() {
        Profile tester = new Profile();
        tester.rateup();
        int expResult = 1;
        int result = tester.getRate();
        assertEquals(expResult, result);
    }
    
    @Test
    public void profileRatedownTest() {
        Profile tester = new Profile();
        tester.ratedown();
        int expResult = -1;
        int result = tester.getRate();
        assertEquals(expResult, result);
    }
}
