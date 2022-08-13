# web-route-spring-boot-starter

Web Route Spring Book Edition

[English](./README.md)

支持功能:
- [x] Web路由

# Web路由:
使Web群集更有选择性  
如果您使用spring-boot-starter-web框架,则需要将容器替换为jetty或undertow  
该项目使用HttpHeader进行路由  

## Quick Start

```xml
<!--在pom.xml中添加依赖-->
        <dependency>
            <artifactId>web-route-spring-boot-starter</artifactId>
            <groupId>com.github.thierrysquirrel</groupId>
            <version>1.0.1.4-RELEASE</version>
        </dependency>
``` 

### 配置文件

 ```properties
 ## application.properties
web.route.url=127.0.0.1:9090
web.route.relays[0].header-route-value=userRoute
web.route.relays[0].relay-bean-name=userRoute
 ```

# 启动 WebRoute
 ```java
 @SpringBootApplication
 public class WebRouteApplication{
     public static void main(String[] args){
         SpringApplication.run(WebRouteApplication.class, args);
     }
 }
 ```

# 开始使用 WebRoute
```java
@Component
public class UserRoute implements WebRelayTemplate {
	private static final List<String> WEB_SERVER_URL = new ArrayList<>();

	static {
		/**
		 * 您可以使用RPC工具定期获取集群URL地址,
		 * 例如,使用http去请求Url存储服务器 (HttpServer+redis)
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

![AmericanFlag](https://user-images.githubusercontent.com/49895274/184471211-f6e2fd1b-c355-46a2-8991-55b936ce8e6f.jpeg)  

