# desafio-amcom



## Rodando localmente

1- Clone o projeto

```bash
  git clone git@github.com:MRobertoMv/desafio-amcom.git
```

2- Abrir projeto na IDE de preferência e configurar [JDK 21](https://www.oracle.com/java/technologies/downloads/#java21)

3-instalar docker ou alternativas que permitam rodar comandos docker:

### instalar docker
https://docs.docker.com/desktop/setup/install/windows-install/

### alternativas ao docker
https://oneuptime.com/blog/post/2026-01-16-docker-desktop-alternatives/view

4- Configuração DB
* acessar a pasta docker e rodar o comando docker compose up
```bash
  cd docker
  docker compose up
```

4- Executar a aplicação e quando a aplicação estiver startando, ela vai criar as tabelas utilizando os migrations do flyway

5-para inserir um pedido, basta executar o comando:
```bash
curl --request POST \
  --url http://localhost:9080/v1/order \
  --header 'authorization: Basic {gerar informando usuario user e a senha dinâmica gerada}}' \
  --header 'content-type: application/json' \
  --data '{
  "nrOrder": "PED0099",
  "items": [
    {
      "nrItem": 1,
      "codProduct": 87654,
      "qty": 10,
      "vlUnit": 1045.87
    }
  ]
}'
```

resultado:
```bash
{
  "nrOrder": "PED0099",
  "status": "NEW_ORDER",
  "items": [
    {
      "nrItem": 1,
      "codProduct": 87654,
      "qty": 10.0,
      "vlUnit": 1045.87
    }
  ],
  "createdAt": "2026-01-30T21:12:24.01721786"
}
```