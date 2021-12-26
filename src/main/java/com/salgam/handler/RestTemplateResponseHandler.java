package com.salgam.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RestTemplateResponseHandler implements ResponseErrorHandler {

	private final String REMOTE_SERVER_ERROR = "remote server error";
	
	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
		return (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
				 || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {
		log.info(REMOTE_SERVER_ERROR);
		if (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
			log.info("restemplate server error");
			showErrorLog(httpResponse);
			throw new HttpServerErrorException(httpResponse.getStatusCode());
		} else if(httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
			log.info("restemplate client error");
			showErrorLog(httpResponse);
			throw new HttpServerErrorException(httpResponse.getStatusCode());
		}
		
	}
	
	private void showErrorLog(ClientHttpResponse httpResponse) throws IOException {
		log.info("headers {}",httpResponse.getHeaders());
		log.info("statusText {}",httpResponse.getStatusText());
		log.info("statusCode {}",httpResponse.getStatusCode());
	}
}
