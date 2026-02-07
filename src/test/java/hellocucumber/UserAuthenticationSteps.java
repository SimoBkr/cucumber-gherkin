package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class UserAuthenticationSteps {
    private String username;
    private String password;
    private String errorMessage;
    private boolean isLoggedIn;
    private boolean isPasswordResetLinkSent;
    private boolean isAccountBlocked;

    @Given("the application is running")
    public void the_application_is_running() {
        this.isLoggedIn = false;
        this.isAccountBlocked = false;
    }

    @When("the user enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        this.username = "validUser"; // Replace with actual valid username
        this.password = "validPassword"; // Replace with actual valid password
        this.isLoggedIn = login(username, password);
    }

    @Then("the user should be connected to the application")
    public void the_user_should_be_connected_to_the_application() {
        assertThat(isLoggedIn).isTrue();
    }

    @When("the user enters an invalid username or password")
    public void the_user_enters_an_invalid_username_or_password() {
        this.username = "invalidUser"; // Replace with an invalid username
        this.password = "invalidPassword"; // Replace with an invalid password
        isLoggedIn = login(username, password);
        errorMessage = getErrorMessage();
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        assertThat(errorMessage).isNotNull();
    }

    @Then("an appropriate error message should be displayed")
    public void an_appropriate_error_message_should_be_displayed() {
        String expectedErrorMessage = "Invalid credentials"; // Replace with your application's expected message
        errorMessage = getErrorMessage();
        assertThat(errorMessage).isEqualTo(expectedErrorMessage);
    }

    @When("the user enters an invalid username and password three times")
    public void the_user_attempts_multiple_failed_logins() {
        for (int i = 0; i < 3; i++) {
            this.username = "invalidUser"; // Replace with an invalid username
            this.password = "invalidPassword"; // Replace with an invalid password
            login(username, password);
        }
        isAccountBlocked = checkAccountBlocked();
    }

    @Then("the account should be temporarily blocked")
    public void the_account_should_be_temporarily_blocked() {
        assertThat(isAccountBlocked).isTrue();
    }

    @Given("the user has forgotten their password")
    public void the_user_has_forgotten_their_password() {
        this.username = "validUser"; // Replace with valid username
    }

    @When("the user requests a password reset")
    public void the_user_requests_a_password_reset() {
        isPasswordResetLinkSent = sendPasswordResetLink(username);
    }

    @Then("a reset link should be sent to the user's registered email")
    public void a_reset_link_should_be_sent_to_the_user_registered_email() {
        assertThat(isPasswordResetLinkSent).isTrue();
    }

    @Given("the user is connected to the application")
    public void the_user_is_connected_to_the_application() {
        this.username = "validUser"; // Replace with valid username
        this.password = "validPassword"; // Replace with actual valid password
        this.isLoggedIn = login(username, password);
        assertThat(isLoggedIn).isTrue();
    }

    @When("the user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
        isLoggedIn = logout();
    }

    @Then("the user should be logged out of the application")
    public void the_user_should_be_logged_out_of_the_application() {
        assertThat(isLoggedIn).isFalse();
    }

    @Then("the login screen should be displayed")
    public void the_login_screen_should_be_displayed() {
        assertThat(isLoggedIn).isFalse();
    }

    @Given("the password is stored securely")
    public void the_password_is_stored_securely() {
        // Simulate secure storage
    }

    @Given("the application is accessed via HTTPS")
    public void the_application_is_accessed_via_https() {
        // Simulate secure connection
    }

    @When("the user attempts to log in")
    public void the_user_attempts_to_log_in() {
        // Logic can be handled in previous steps
    }

    @Then("the connection should be secure")
    public void the_connection_should_be_secure() {
        // Verify that the connection type is secure
    }

    // Placeholder methods for actual logic
    private boolean login(String username, String password) {
        return "validUser".equals(username) && "validPassword".equals(password);
    }

    private String getErrorMessage() {
        return "Invalid credentials"; // Placeholder for actual error message logic
    }

    private boolean checkAccountBlocked() {
        return true; // Placeholder for actual account blocking logic
    }

    private boolean sendPasswordResetLink(String username) {
        return true; // Placeholder for actual email sending logic
    }

    private boolean logout() {
        return false; // Assuming logout is successful; true means logged in
    }
}