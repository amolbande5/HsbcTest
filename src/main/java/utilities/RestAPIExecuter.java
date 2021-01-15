package utilities;

import base.TestConfig;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;


public class RestAPIExecuter extends TestConfig {

    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;

    public RestAPIExecuter(String uri, String method) {

        this.url = config.getProperty("baseURI") + uri;
        this.method = method;
        builder.setContentType(ContentType.JSON);
        builder.setRelaxedHTTPSValidation();

    }

    private ResponseOptions<Response> executeAPI() {


        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.spec(requestSpecification);

        if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.POST))
            return request.post(this.url);
        else if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.PUT))
            return request.put(this.url);
        else if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.GET))
            return request.get(this.url);
        return null;

    }


    public ResponseOptions<Response> getCall() {

        return executeAPI();
    }


}
