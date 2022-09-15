# web-route-spring-boot-starter

Web Route Spring Book Edition

[中文](./README_zh_CN.md)

Support Function:
- [x] WebRoute

# WebRoute:
Make Web Clustering More Selective  
If You Use The spring-boot-starter-web Framework, You Need To Replace The Container With Jetty Or Undertow  
The Project Uses HttpHeader For Routing  

## Quick Start

```xml
<!--Adding dependencies to pom. XML-->
        <dependency>
            <artifactId>web-route-spring-boot-starter</artifactId>
            <groupId>com.github.thierrysquirrel</groupId>
            <version>1.0.1.4-RELEASE</version>
        </dependency>
``` 

### configuration file

 ```properties
 ## application.properties
web.route.url=127.0.0.1:9090
web.route.relays[0].header-route-value=userRoute
web.route.relays[0].relay-bean-name=userRoute
 ```

# Start WebRoute
 ```java
 @SpringBootApplication
 public class WebRouteApplication{
     public static void main(String[] args){
         SpringApplication.run(WebRouteApplication.class, args);
     }
 }
 ```

# Getting Started WebRoute
```java
@Component
public class UserRoute implements WebRelayTemplate {
	private static final List<String> WEB_SERVER_URL = new ArrayList<>();

	static {
		/**
		 * You Can Use The RPC Tool To Obtain The Cluster URL Address Periodically
		 * For Example, Use HTTP To Request URL Storage Server (HttpServer+Redis)
		 */
		WEB_SERVER_URL.add("127.0.0.1:8080");
		WEB_SERVER_URL.add("127.0.0.1:8081");
		WEB_SERVER_URL.add("127.0.0.1:8082");
	}

	public static String getLocalUrl(int offset) {
		return WEB_SERVER_URL.get(offset);
	}

	@Override
	public WebRelayMessage relay(HttpRequestMessage httpRequestMessage) {
		HttpHeaders headers = httpRequestMessage.getHeaders();
		int offset = Integer.getInteger(headers.get("offset"));
		String url = getLocalUrl(offset);
		headers.add("Hello", "World");

		String uri = httpRequestMessage.getUri();
		var path = "";
		var relayErrorMessage = "relayError";
		try {
			Map<String, String> uriParam = UriUtils.uriConvertMap(uri);
			uriParam.put("hello", "world");
			path = UriUtils.mapConvertUri(uri, uriParam);

		} catch (UnsupportedEncodingException e) {
			log.error("relayError", e);
		}
		return WebRelayMessageBuilder.builderWebRelayMessage(url, path, headers, relayErrorMessage);
	}
}
```

![Russian flag](https://user-images.githubusercontent.com/49895274/190374195-c5b580a8-5da5-4d69-9ba7-7018e4b22b7a.png)

