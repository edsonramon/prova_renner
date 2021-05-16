<< Nome do projeto >>: 
DesafioWeb

<< Descrição do projeto >>:
Projeto desenvolvido para a criação de dois cenários de testes através do site http://automationpractice.com/

<< Iniciando o projeto >>:
Necessário a instalação da jre 8.
Link para download: https://www.oracle.com/br/java/technologies/javase-jre8-downloads.html

Obs.: após a importação do projeto, verificar se a jre 8 é a selecionada.
	  Botão direito do mouse em cima do projeto > menu Build Path > submenu Configure Build Path, acessar aba Libraries.
	  
	  Caso não seja, remova a versão, clicar uma vez com o botão esquerdo do mouse para selecionar e clicar no botão Remove.
	  
	  Na mesma aba Libraries, clicar no botão Add Library..., selecionar JRE System Library e clicar em Next, selecionar a Workspace default jre ( que deverá estar na versão 8), clicar em Finish e clicar no botão Apply and Close.

Necessário a instalação de uma IDE, a atualizada foi o Eclipse.
Link para download: https://www.eclipse.org/downloads/

<< Possíveis problemas >> 
Caracteres Especiais
Botão direito do mouse em cima do projeto > menu Properties > menu lateral esquerdo Resource > escolher o encoding selecionando em Other UTF-8 e clicar em Apply and Close.

Não reconhece a String utilizada dentro do switch
Clicar no ícone da lâmpada com um x e clicar na opção Change project compliance and JRE to 1.7

Não reconhece os steps dentro da feature (fica amarelo)
Botão direito do mouse em cima do projeto > menu Configure > Converto to Cucumber Project
Botão direito do mouse em cima do projeto > menu Maven > Update Project e clicar no botão OK

Navegador (utilizadao foi o Chrome)
Caso o ambiente local possua já uma versão instalada, o chromedriver deverá ser na mesma versão ou versão anterior. Versões futuras darão "problema binário".
Para verificar a versão instalada, abrir o Chrome, acessar o menu Ajuda e clicar em Sobre o Google Chrome.
Alterar a linha 31 da classe FazerComprasComUsuarioCadastradoSteps, conforme caminho src/test/java/br/df/edsonramon/steps e informar o local aonde está o driver da execução.
Link do chromedriver: https://chromedriver.chromium.org/downloads
Link do geckodriver: https://github.com/mozilla/geckodriver/releases

<< Execução >>:
Para realizar a execução da suíte de teste, abrir e executar o arquivo FazerComprasComUsuarioCadastradoRunner, conforme o caminho src/test/java/br/df/edsonramon/runners

Para verificar os screenshots da execução, acessar a pasta target e subpasta screenshots.

<< Licença >>:
Não se aplica
