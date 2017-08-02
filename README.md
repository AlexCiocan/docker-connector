# docker-connector poc project

TODO client-key based configuration for docker
  ->Generate client keys
  ->update dockerd/docker machine with keys
  ->Implement RestTemplate to use *.pem for auth
  Documentation:
  http://www.robinhowlett.com/blog/2016/01/05/everything-you-ever-wanted-to-know-about-ssl-but-were-afraid-to-ask/
  https://docs.docker.com/engine/security/https/#secure-by-default #client-keys
  https://docs.docker.com/docker-for-mac/faqs/#how-do-i-add-custom-ca-certificates
  https://integratedcode.us/2015/07/29/using-tls-with-the-docker-engine/
  https://docs.microsoft.com/en-us/virtualization/windowscontainers/management/manage_remotehost
  
  
  
  Misc:
  How do I plain ssh into the docker machine? ssh -p 2222 docker@localhost /password tcuser
  How to use ca_certs with curl ?http://blog.arungupta.me/docker-remote-api-mac-windows-osx/ curl --cert /c/Users/alexandru.ciocan/.docker/machine/machines/default/cert.pem --cacert /c/Users/alexandru.ciocan/.docker/machine/machines/default/ca.pem --key /c/Users/alexandru.ciocan/.docker/machine/machines/default/key.pem https://192.168.99.100:2376/images/json
  Expose all docker posts ?https://docs.docker.com/engine/userguide/networking/default_network/binding/
  Socket options for dockerd and docker https://docs.docker.com/engine/reference/commandline/dockerd/#daemon-socket-option
  Docker config daemon.json file https://docs.microsoft.com/en-us/virtualization/windowscontainers/manage-docker/configure-docker-daemon
  Note DOCKER_TLS_VERFY, DOCKER_HOST 

