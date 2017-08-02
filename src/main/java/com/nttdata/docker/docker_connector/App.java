package com.nttdata.docker.docker_connector;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.BuildResponseItem;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.Ports;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.command.BuildImageResultCallback;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		final String certPath = StringUtils.join(
				new String[] { System.getProperty("user.home"), ".docker", "machine", "machines", "default" },
				File.separatorChar);

		DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
				// .withDockerHost("tcp://192.168.99.100:2376").withDockerTlsVerify(true)
				.withDockerCertPath(certPath)
				// .withRegistryEmail(registryEmail)
				// .withRegistryPassword("WHY_IS_MY_PWD_IN_PLAIN")
				// .withRegistryEmail("alex.ciocan.lx@gmail.com")
				// .withRegistryUrl(registryUrl)
				.build();

		DockerClient client = DockerClientBuilder.getInstance(config).build();

		System.out.println("Docker Info Command " + client.infoCmd().exec());

		System.out.println("Info cmd" + client.listContainersCmd().exec());
		System.out.println("ListImages cmd" + client.listImagesCmd().exec());

		try {

			String imageId = client.buildImageCmd(new ClassPathResource("Dockerfile").getFile())
					.exec(new BuildImageResultCallback() {
						@Override
						public void onNext(BuildResponseItem item) {
							System.out.println("buildImage" + item);
							super.onNext(item);
						}

					}).awaitImageId();

			System.out.println("Image Id" + imageId);

			ExposedPort tcp8080 = ExposedPort.tcp(8080);

			Ports portBindings = new Ports();
			portBindings.bind(tcp8080, Ports.Binding.bindPort(2222));

			CreateContainerResponse container = client.createContainerCmd(imageId).withExposedPorts(tcp8080)
					.withPortBindings(portBindings)
					// .withCmd("touch", "/test")
					.exec();

			client.startContainerCmd(container.getId()).exec();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(clientBuilder.);

	}
}
