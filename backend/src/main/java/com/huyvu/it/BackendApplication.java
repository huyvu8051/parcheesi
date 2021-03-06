package com.huyvu.it;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;

@SpringBootApplication
@EnableJpaAuditing
public class BackendApplication {
	private String host = "";
	private Integer port = 8082;

	@Bean
	public SocketIOServer socketioserver() {

		try {
			InetAddress IP=InetAddress.getLocalHost();
			this.host = IP.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Configuration config = new Configuration();
		config.setHostname(host);
		config.setPort(port);

		// This can be used for authentication
		config.setAuthorizationListener(new AuthorizationListener() {

			@Override
			public boolean isAuthorized(HandshakeData data) {
				return true;
			}
		});

		final SocketIOServer server = new SocketIOServer(config);
		return server;
	}

	@Bean
	public SpringAnnotationScanner springannotationscanner(SocketIOServer socketserver) {
		return new SpringAnnotationScanner(socketserver);
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
