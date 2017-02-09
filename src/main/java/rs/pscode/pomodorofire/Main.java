package rs.pscode.pomodorofire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		String [] argsWithDebugFlag = new String[args.length + 1];
		System.arraycopy(args, 0, argsWithDebugFlag, 0, args.length);
		argsWithDebugFlag[args.length] = "--debug";
		SpringApplication application = new SpringApplication(Main.class);
		application.run(argsWithDebugFlag);
	}
}
