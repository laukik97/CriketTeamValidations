package stepDefinition;

import Utils.jsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class stepDefinition {
    private static Logger LOGGER = LoggerFactory.getLogger(stepDefinition.class);
    //Create json parser object and pass the file location
    private static final String fileLocation="src\\test\\resources\\TestData\\RCBTeam.json";
    private static final jsonParser js=new jsonParser(fileLocation);
    private JSONArray playerArray;
    Map <String,String> hmap=new HashMap<>();
    JSONObject jsonObject;
   //To DO :add logger here;
    @Given("The RCB team member details is present")
    public void the_RCB_team_member_details_is_present() {
        // Below is the code to validate the team name
        try {
             LOGGER.info("Validating the Team Name");
             jsonObject=js.getParserObject();
             String teamName=(String)jsonObject.get("name");
             LOGGER.debug("Team name is {}",teamName);
             Assert.assertEquals("Royal Challengers Bangalore",teamName);

        } catch (IOException e) {
            fail("Test Case Failure Reason: "+e.getMessage());
            LOGGER.error("Failure Message {}",e.getMessage());
            e.printStackTrace();

        } catch (ParseException e) {
            fail("Test Case Failure Reason: "+e.getMessage());
            LOGGER.error("Failure Message {}",e.getMessage());
            e.printStackTrace();
        }

    }
    @When("Performing the count validations")
    public void performing_the_count_validations() {
        // Write code here that turns the phrase above into concrete actions
        //team should have at least 11 players
        try {
            LOGGER.info("Validating The Player Count in the Teams");
            jsonObject=js.getParserObject();
            playerArray= (JSONArray) jsonObject.get("player"); //get te json array size and it should be >=11
            LOGGER.debug("Team size is {}",playerArray.size());
            Assert.assertTrue(playerArray.size()>=11);

        } catch (IOException e) {
            fail("Test Case Failure Reason: "+e.getMessage());
            LOGGER.error("Failure Message {}",e.getMessage());
            e.printStackTrace();

        } catch (ParseException e) {
            fail("Test Case Failure Reason: "+e.getMessage());
            LOGGER.error("Failure Message {}",e.getMessage());
            e.printStackTrace();
        }


    }
    @Then("Team should have only four foreign players")
    public void team_should_have_only_four_foreign_players() {
        // Write code here that turns the phrase above into concrete actions
        int fPlayerCount=0;
        try {
            LOGGER.info("Validating The Foreign Players Count in the Teams");
            jsonObject=js.getParserObject();
            playerArray= (JSONArray) jsonObject.get("player");
            /**Enable (Uncomment) below log if any particular object needs to be printed
             (please replace value of i with the index value)
             **/
            //LOGGER.debug("Player Information is {}",playerArray.get(i));
            LOGGER.debug("Team size is {}",playerArray.size());
            for(int i=0;i<playerArray.size();i++){
                JSONObject jsonArrayobject= (JSONObject) playerArray.get(i);
                LOGGER.debug("Player Name is {} and Player Country is {}",jsonArrayobject.get("name"),jsonArrayobject.get("country"));
                hmap.put((String) jsonArrayobject.get("name"), (String) jsonArrayobject.get("country"));
            }

            Iterator<Map.Entry<String, String>> itr = hmap.entrySet().iterator();

            while(itr.hasNext())
            {
                Map.Entry<String, String> entry = itr.next();
                //System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
                if(!entry.getValue().equalsIgnoreCase("India")){
                    fPlayerCount++;
                }
            }
            LOGGER.debug("Foreign Player count is {}",fPlayerCount);
            Assert.assertTrue(fPlayerCount==4);

        } catch (IOException e) {
            fail("Test Case Failure Reason: "+e.getMessage());
            LOGGER.error("Failure Message {}",e.getMessage());
            e.printStackTrace();

        } catch (ParseException e) {
            fail("Test Case Failure Reason: "+e.getMessage());
            LOGGER.error("Failure Message {}",e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("Team should have at least one wicketkeeper")
    public void teamShouldHaveAtLeastOneWicketkeeper() {
        int wicketKeeperCount=0;
        try {
            LOGGER.info("Validating The Wicket-Keeper Count in the Teams");
            jsonObject=js.getParserObject();
            playerArray= (JSONArray) jsonObject.get("player");
            LOGGER.debug("Team size is {}",playerArray.size());
            for(int i=0;i<playerArray.size();i++){
                JSONObject jsonArrayobject= (JSONObject) playerArray.get(i);
                LOGGER.debug("Player Name is {} and Player Country is {}",jsonArrayobject.get("name"),jsonArrayobject.get("country"));
                hmap.put((String) jsonArrayobject.get("name"), (String) jsonArrayobject.get("role"));
            }
            Iterator<Map.Entry<String, String>> itr = hmap.entrySet().iterator();

            while(itr.hasNext())
            {
                Map.Entry<String, String> entry = itr.next();
                //System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
                if(entry.getValue().equalsIgnoreCase("wicket-keeper")){
                    wicketKeeperCount++;
                }
            }
            LOGGER.debug("Wicket Keeper count is {}",wicketKeeperCount);
            Assert.assertTrue(wicketKeeperCount>=1);

        } catch (IOException e) {
            fail("Test Case Failure Reason: "+e.getMessage());
            LOGGER.error("Failure Message {}",e.getMessage());
            e.printStackTrace();

        } catch (ParseException e) {
            fail("Test Case Failure Reason: "+e.getMessage());
            LOGGER.error("Failure Message {}",e.getMessage());
            e.printStackTrace();
        }

    }
}
