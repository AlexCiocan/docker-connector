package com.nttdata.docker.docker_connector;

import java.io.File;

import org.apache.commons.lang.StringUtils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// DockerClient clientBuilder =
		// DockerClientBuilder.getInstance("tcp://192.168.99.100:2376")
		//
		//
		// .build();
		// AuthConfig config=

		final String certPath = StringUtils
				.join(new String[] { System.getProperty("user.home"), ".docker", "machine", "machines", "default"

		}, File.separatorChar);

		DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
				.withDockerHost("tcp://192.168.99.100:2376").withDockerTlsVerify(true).withDockerCertPath(certPath)
				// .withRegistryUsername(registryUser)
				// .withRegistryPassword(registryPass)
				// .withRegistryEmail(registryMail)
				// .withRegistryUrl(registryUrl)
				.build();

		DockerClient client = DockerClientBuilder.getInstance(config).build();

		System.out.println("Docker Info Command " + client.infoCmd().exec());

		System.out.println(client.listContainersCmd().exec());
		System.out.println(client.listImagesCmd().exec());

		// System.out.println(clientBuilder.);

	}
}
