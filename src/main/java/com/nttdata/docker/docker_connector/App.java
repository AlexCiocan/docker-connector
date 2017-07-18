package com.nttdata.docker.docker_connector;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.AsyncDockerCmd;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// DockerClientConfig config =
		// DefaultDockerClientConfig.createDefaultConfigBuilder()
		// .withDockerHost("tcp://localhost:2375").build();

		DockerClient clientBuilder = DockerClientBuilder.getInstance("tcp://localhost:4243").build();

		System.out.println("Docker Info Command " + clientBuilder.infoCmd().exec());

		System.out.println(clientBuilder.listContainersCmd().exec());

//		System.out.println(clientBuilder.);
		

	}
}
