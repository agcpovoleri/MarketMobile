
var Localizacao = Class.create({

	currentLocation : null,

	initialize: function(local){
		this.currentLocation = this.getCurrentLocation();
	},

	getCurrentLocation : function(){

		getLocation();
	},

	buscaEndereco : function(local){

		cordova.exec(function(winParam) {
			//var objJSON = eval("(" + winParam + "')");

			var cidades = winParam.cidades;
			alert(cidades);
			if (cidades){
				for (var i=0; i <= cidades.length; i++){
					var cidade = cidades[i];
					//alert(cidades[i].nome);
					//alert('nome: '+cidade.nome+', qtd: '+cidade.quantidadeEmpresa);
					var strHtml = "<li><a href='estabelecimentos.html'  data-transition='slidedown'> "+cidade.nome+" <span class='ui-li-count' > "+cidade.quantidadeEmpresa+" </span></a> </li>";
					//$("#listCities").append(strHtml);
				}
			}

		}, function(error) {
			alert('nothing');
		}, "LocalizacaoCliente", "busca_cep", [local]);

	},
});

var Empresa = Class.create({

	id: null,
	imagem: null,
	avaliacao: null,
	
	cardapio : null,
	informacoes : null,

	initialize: function(idEmpresa){
		this.id = idEmpresa;
		//this.informacoes = new InfoEmpresa(idEmpresa);
		//this.cardapio = new Cardapio(); 
	},

	getCardapio: function(){
		if (!this.cardapio) this.cardapio = new Cardapio();
		return this.cardapio;
	},
	
	getInfoEmpresa: function(){

		if (!this.informacoes) this.informacoes = new InfoEmpresa();
		return this.informacoes;


	},

});

var InfoEmpresa = Class.create({

	idEmpresa: null,
	nome: null,
	descricao : null,
	
	itensVendidos : [],
	galeriaImagens: [],
	
	website: null,
	linkMap : null,
	tel: null,

	initialize: function(idEmpresa){
		this.id = idEmpresa;
		this.getInformacoes();
		
	},
	
	getInformacoes: function(){
		if (this.idEmpresa){

			//TODO Obtem informações da empresa
			return;
			cordova.exec(function(infoempresa) {

				alert(infoempresa);
				this.setInfoEmpresa(infoempresa);

			}, function(error) {
				alert('nothing');
			}, "Estabelecimento", "info_empresa", [idEmpresa]);
		
		}
	},

	
	setInfoEmpresa: function(infoEmpresa){

		this.idEmpresa = infoEmpresa.id;
		this.nome = infoEmpresa.nome;
		this.descricao = infoEmpresa.descricao;
		this.itensVendidos = infoEmpresa.itensVendidos,
		this.galeriaImagens = infoEmpresa.galeriaImagens,
		this.website = infoEmpresa.website,
		this.linkMap = empresa.linkmap,
		this.tel = infoEmpresa.tel;
		
	}

});

var Cardapio = Class.create();
Cardapio.prototype = {

		categoria: [],
		items:[],

		initialize: function(idEmpresa){
			this.getItensCardapioEmpresa(idEmpresa); 
		},

		/**
		 * Busca itens do cardápio referente a empresa (estabelecimento).
		 */
		getItensCardapioEmpresa: function(idEmpresa){
			alert('GetCardapioEmpresa: '+idEmpresa);

			cordova.exec(function(winParam) {
				//var objJSON = eval("(" + winParam + "')");
				var estabelecimentos = eval(winParam);
				alert(winParam);
				alert(estabelecimentos);
				if (estabelecimentos){
					this.items
				}

			}, function(error) {
				alert('nothing');
			}, "Estabelecimento", "cardapio", [idEmpresa]);
		},
};

var Carrinho = Class.create({
		/*
		 * Lista de items do carrinho
		 */
		items: null,

		initialize: function() { 
			this.items = [];
		},
		
		adicionaItem: function(idItem){
			if (idItem) {
				var itemEncontrado = this.containItem(idItem);
				if (!itemEncontrado){
					this.items.push(new ItemCarrinho(idItem));
				}else itemEncontrado.quantidade += 1;
			}
		},
		
		adicionaItemCustomizado: function(idItem, form){
			if (idItem) {
				var itemEncontrado = this.containItem(idItem);
				if (!itemEncontrado){
					this.items.push(new ItemCarrinhoCustomizado(idItem));
				}else itemEncontrado.quantidade += 1;
			}
		},

		/**
		 * Remove item do carrinho se existir
		 */
		removeItem: function(idItem){
			if (idItem) {
				var itemEncontrado = containItem(idItem);
				if (itemEncontrado){
					this.items[itemEncontrado] = null;
				}else alert('item nao encontrado');
			}
		},
		/**
		 * Verifica se item já foi inserido no carrinho
		 */
		containItem : function(idItem) {
			
			if (idItem){
				for ( var indice = 0; indice < this.items.length; indice++) {
					if (this.items[indice].idItem === idItem){
						return this.items[indice];
					}
				}
				return false;
			}
		},
		
		size: function(){
			alert("Total de "+$(this.items).size()+" itens no carrinho.");
		},



		finalizar : function(){

		}
});

/**
 * Item do carrinho para armazenar a quantidade de items selecionados do mesmo
 */
var ItemCarrinho = Class.create();
ItemCarrinho.prototype = {

		idItem: null,
		quantidade: 0,

		initialize: function(idItem, quantidade) { 
			this.idItem = idItem;
			this.quantidade = (quantidade)?quantidade:1;
		}
};

/**
 * Item do carrinho para armazenar a quantidade de items selecionados do mesmo
 */
var ItemCarrinhoComum = Class.create(ItemCarrinho, {

		initialize: function($super) { 
			$super();
		}
});


var ItemCarrinhoCustomizado = Class.create(ItemCarrinho, {

	initialize: function($super) { 
		$super();
	}
});

