package rs.pscode.pomodorofire.service.shared;

public class RegisterUserInit {
  private final String userName;
  private final String callName;
  private final String email;

  public RegisterUserInit(String userName, String callName, String email) {
    super();
    this.userName = userName;
    this.callName = callName;
    this.email = email;
  }

  public String getUserName() {
    return userName;
  }

  public String getCallName() {
    return callName;
  }

  public String getEmail() {
    return email;
  }
}
