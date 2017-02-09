package rs.pscode.pomodorofire.config.auth.firebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import rs.pscode.pomodorofire.service.UserService;
import rs.pscode.pomodorofire.service.exception.FirebaseUserNotExistsException;
import rs.pscode.pomodorofire.service.impl.UserServiceImpl;
import rs.pscode.pomodorofire.service.shared.RegisterUserInit;

@Component
public class FirebaseAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	@Qualifier(value = UserServiceImpl.NAME)
	private UserService userService;

	public boolean supports(Class<?> authentication) {
		return (FirebaseAuthenticationToken.class.isAssignableFrom(authentication));
	}

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if (!supports(authentication.getClass())) {
			return null;
		}

		FirebaseAuthenticationToken authenticationToken = (FirebaseAuthenticationToken) authentication;
		UserDetails details = userService.loadUserByUsername(authenticationToken.getName());
		if (details == null) {
			try {
				details = userService
						.registerUser(
								new RegisterUserInit(
										authenticationToken.getName(),
										((FirebaseTokenHolder) authentication.getCredentials()).getName(),
										((FirebaseTokenHolder) authentication.getCredentials()).getEmail()
								)
						);
			} catch (Exception ex) {
				throw new FirebaseUserNotExistsException();
			}
		}

		authenticationToken = new FirebaseAuthenticationToken(details, authentication.getCredentials(),
				details.getAuthorities());

		return authenticationToken;
	}

}
