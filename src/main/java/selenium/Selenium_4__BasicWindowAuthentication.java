package selenium;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v143.emulation.Emulation;
import org.openqa.selenium.devtools.v143.fetch.Fetch;
import org.openqa.selenium.devtools.v143.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v143.network.Network;
import org.openqa.selenium.devtools.v143.network.model.BlockPattern;
import org.openqa.selenium.devtools.v143.network.model.ErrorReason;
import org.openqa.selenium.devtools.v143.network.model.Request;
import org.openqa.selenium.devtools.v143.network.model.Response;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

public class Selenium_4__BasicWindowAuthentication {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		
		Predicate<URI> uriPredicate =uri ->  uri.getHost().contains("httpbin.org");
		
		//((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
		
		//driver.get("http://httpbin.org/basic-auth/foo/bar");
		
		driver.get("http://foo:bar@httpbin.org/basic-auth/foo/bar");


	}

}
