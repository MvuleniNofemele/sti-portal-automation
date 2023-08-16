package testCases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.slf4j.Logger;
import sapiens.claims.Claims;
import sapiens.contact.Contact;
import sapiens.login.Login;
import sapiens.policies.Idirect.Absa_Idirect;
import sapiens.policies.absavalueplus.AbsaValuePlus;
import sapiens.policies.personallines.PersonalLines;
import sapiens.policies.extendedcover.ExtendedCover;
import sapiens.searches.Searches;
import sapiens.usercreation.CreateUserProfile;
import utility.WebDr;

import static org.slf4j.LoggerFactory.getLogger;

public class testFlow extends WebDr {

    private static final Logger logger = getLogger(testFlow.class);


    public testFlow(ExtentTest test, ExtentReports extent) {
        this.test = test;
        this.extent = extent;
    }

    public void executeTC(String flowName,String preferBrowser) throws Exception
    {
        try {
            switch (flowName) {
                case "flow_NewContactCreation":
                    logger.info("The current scenario is: " + flowName);
                    sapiens_NewContactCreation(preferBrowser);
                    break;
                case "absa_Idirect_Flow":
                    System.err.print("It working fine");
                    logger.info("The current scenario is: " + flowName);
                    absa_Idirect_Flow(preferBrowser);
                    break;
            }
        } catch (Exception e) {
            WriteStep(wdriver,flowName + " Status: ",flowName + " should be executed successfully",flowName + " didn't execute successfully","FAIL");
            wdriver.quit();
            logger.info(String.valueOf(e));
        }
    }

    /**
     * Flow for Creating a New Contact into Sapiens application
     * @param preferBrowser -   Chrome
     */
    public void sapiens_NewContactCreation(String preferBrowser) {
    	try{
            setup(preferBrowser);
            new Login(wdriver, test).applicationLogin();
            new Contact(wdriver, test).generalDetails();
            new Contact(wdriver, test).addresses();
            new Contact(wdriver, test).additionalData();
            new Contact(wdriver, test).paymentMeans();
            new Login(wdriver, test).applicationLogOut();
        }catch(Exception e){
            logger.info("Exception in sapiens_NewContactCreation is : " + e);
    	}
    }

    /**
     * Flow for Creating a New AbsaPlus Policy into Sapiens application
     * @param preferBrowser : Chrome
     */
    public void personalLines_PolicyCreation(String preferBrowser) {
        try{
            setup(preferBrowser);
            new Login(wdriver, test).applicationLogin();
            new PersonalLines(wdriver, test).selectRecentContact();
            new PersonalLines(wdriver, test).generalDetails();
            new PersonalLines(wdriver, test).linesOfBusiness();
            String policyNumber = new PersonalLines(wdriver, test).paymentsDetails();
            new Searches(wdriver, test).searchPolicy(policyNumber);
            new Claims(wdriver, test).claimThroughPolicy(policyNumber);
            new Login(wdriver, test).applicationLogOut();
        }catch(Exception e){
            logger.info("Exception in sapiens_NewPolicyCreation is : " + e);
        }
    }

    /**
     * Flow for Creating a New Extended Cover Policy into Sapiens application
     * @param preferBrowser : Chrome
     */
    public void extendedCover_PolicyCreation(String preferBrowser) {
        try{
            setup(preferBrowser);
            new Login(wdriver, test).applicationLogin();
            new ExtendedCover(wdriver, test).selectRecentContact();
            new ExtendedCover(wdriver, test).generalDetails();
            new ExtendedCover(wdriver, test).motorcarDetails();
            String policyNumber = new ExtendedCover(wdriver, test).paymentsDetails();
            new Searches(wdriver, test).searchPolicy(policyNumber);
            new Claims(wdriver, test).claimThroughPolicy(policyNumber);
            new Login(wdriver, test).applicationLogOut();
        }catch(Exception e){
            logger.info("Exception in sapiens_NewPolicyCreation is : " + e);
        }
    }

    /**
     * Flow for Creating a New Absa Value Plus Policy into Sapiens application
     * @param preferBrowser : Chrome
     */
    public void absaValuePlus_PolicyCreation(String preferBrowser) {
        try{
            setup(preferBrowser);
            new Login(wdriver, test).applicationLogin();
            new AbsaValuePlus(wdriver, test).selectRecentContact();
            new AbsaValuePlus(wdriver, test).generalDetails();
            new AbsaValuePlus(wdriver, test).motorcarDetails();
            String policyNumber = new AbsaValuePlus(wdriver, test).paymentsDetails();
            new Searches(wdriver, test).searchPolicy(policyNumber);
            new Claims(wdriver, test).claimThroughPolicy(policyNumber);
            new Login(wdriver, test).applicationLogOut();
        }catch(Exception e){
            logger.info("Exception in sapiens_NewPolicyCreation is : " + e);
        }
    }

    /**
     * Flow for Creating a New User Profile in Sapiens application
     * @param preferBrowser -   Chrome
     */
    public void sapiens_UserProfileCreation(String preferBrowser) {
        try{
            setup(preferBrowser);
            new Login(wdriver, test).applicationLogin();
            new CreateUserProfile(wdriver, test).createContact();
            new CreateUserProfile(wdriver, test).createProfile();
            new Login(wdriver, test).applicationLogOut();
        }catch(Exception e){
            logger.info("Exception in sapiens_UserProfileCreation is : " + e);
        }
    }

    /**
     * Flow for Creating a New AbsaPlus Policy into Sapiens application
     * @param preferBrowser : Chrome
     */
    public void updateContactDetails(String preferBrowser) {
        try{
            setup(preferBrowser);
            new Login(wdriver, test).applicationLogin();
            new Contact(wdriver, test).selectRecentContact();
            new Contact(wdriver, test).updateContact();
            new Login(wdriver, test).applicationLogOut();
        }catch(Exception e){
            logger.info("Exception in sapiens_NewPolicyCreation is : " + e);
        }
    }

    //Method For IDIRECT POlicies

    public void absa_Idirect_Flow(String preferBrowser){

        try{
            System.out.print("It working fine ");
            setup(preferBrowser);
            new Login(wdriver, test).applicationLogin();
            new Absa_Idirect(wdriver, test).selectRecentContact();
            new Absa_Idirect(wdriver, test).generalDetails();
            new Absa_Idirect(wdriver, test).linesOfBusiness();
           // new Absa_Idirect(wdriver,test).multiCovers();
            String policyNumber = new Absa_Idirect(wdriver, test).paymentsDetails();
            new Searches(wdriver, test).searchPolicy(policyNumber);
//            new Claims(wdriver, test).claimThroughPolicy(policyNumber);
//            new Login(wdriver, test).applicationLogOut();

        }catch (Exception e){
            logger.info("Exception in sapiens_Absa Idirect Flow is : "+e);
        }

    }

    
}
