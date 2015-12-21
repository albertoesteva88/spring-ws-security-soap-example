package com.wandrell.demo.ws.soap.spring.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.wandrell.demo.ws.generated.entity.GetEntityRequest;
import com.wandrell.demo.ws.generated.entity.GetEntityResponse;

/**
 * The Class WeatherClient.
 */
public class EntityClient extends WebServiceGatewaySupport {

    public GetEntityResponse getEntity(final Integer id) {
        GetEntityRequest request;

        request = new GetEntityRequest();
        request.setId(id);

        GetEntityResponse response = (GetEntityResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        request,
                        new SoapActionCallback(
                                "http://localhost:9966/ws-security-simple/ws/samples"));

        return response;
    }

}