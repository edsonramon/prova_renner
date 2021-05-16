#language: pt
#encoding: utf-8

Funcionalidade: Fazer Compras Com Usuário Cadastrado
  	Como um cliente cadastrado no automationpractice.com
  	Eu quero fazer a compra de ao menos três produtos
  	Para que eu possa estar bem vestida

	Contexto: 
		Dado que realizo o acesso ao site do desafio
			
  Cenario: Cadastrar Novo Usuário		
    Quando clico em Sign in
    E informo o e-mail para criar nova conta
    E clico no botão Create an account
    E preencho as informações pessoais
    E preencho o endereço
    E clico no botão Register
    Então visualizo a mensagem "Welcome to your account. Here you can manage all of your personal information and orders."
    
  Cenario: Fazer Compras Com Usuário Cadastrado
  	Quando clico em Sign in
  	E informo minhas credenciais de acesso
  	Então visualizo a mensagem "Welcome to your account. Here you can manage all of your personal information and orders."
  	E pesquiso o produto "Printed Chiffon Dress"
  	E tamanho "M"
  	E seleciono a cor "verde"
  	E clico no botão Add to cart
  	E clico no botão Continue shopping
  	E pesquiso o produto "Faded Short Sleeve T-shirts"
  	E seleciono a cor "azul"
  	E clico no botão Add to cart
  	E clico no botão Continue shopping
  	E pesquiso o produto "Blouse"
  	E adiciono a quantidade "2"
  	E clico no botão Add to cart
  	E clico no botão Continue shopping
  	E pesquiso o produto "Printed Dress"
  	E adiciono a quantidade "1"
  	E clico no botão Add to cart
  	E clico no link Proceed to checkout
  	E clico no botão Proceed to checkout
  	E clico no botão Proceed to checkout
  	E marco que aceito todos os termos
  	E seleciono o método de pagamento "Pay by bank wire"
  	E clico no botão I confirm my order
  	Então visualizo a mensagem de sucesso "Your order on My Store is complete."
  	