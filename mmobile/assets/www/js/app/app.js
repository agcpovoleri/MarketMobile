
var empresaCurrent;
var carrinhoCliente; 
	

var startApp = function(){
	
	/**
	 * Pagina inicial
	 */
	alert('firstpage');
	$("#btnSearch").live('click',function(event){
		
		event.preventDefault();
		/**
		 * Carrega os estabelecimentos da cidade/endereco selecionada
		 */
		cordova.exec(
			function(winReturn) {
				alert(winReturn);
	       	}, function(error) {
	       		alert('nothing');
	       	}, "Localizacao", "busca_cep", ["36026450"]);
				
	});
	
	
	$(".geolocation-link").live("click", function(evt){
		
		alert(navigator.geolocation);
		if(navigator.geolocation){
			
			var onSuccess = function(position) {
        	    alert('Latitude: '          + position.coords.latitude          + '\n' +
        	          'Longitude: '         + position.coords.longitude         + '\n' +
        	          'Altitude: '          + position.coords.altitude          + '\n' +
        	          'Accuracy: '          + position.coords.accuracy          + '\n' +
        	          'Altitude Accuracy: ' + position.coords.altitudeAccuracy  + '\n' +
        	          'Heading: '           + position.coords.heading           + '\n' +
        	          'Speed: '             + position.coords.speed             + '\n' +
        	          'Timestamp: '         + position.timestamp                + '\n');
        	};
        	// onError Callback receives a PositionError object
        	//
        	function onError(error) {
        	    if(error.code == 1) {
        	        alert("Error: Access is denied!");
        	    }else if( error.code == 2) {
        	        alert("Error: Position is unavailable!");
        	    }else if( error.code == 3) {
        	        alert("Error: Timeout!");
        	    }else alert('code: '    + error.code    + '\n' +
	        	          'message: ' + error.message + '\n');
        	}
			// timeout at 60000 milliseconds (60 seconds)
	      	var options = {timeout:60000};
	      	navigator.geolocation.getCurrentPosition(
		    		  onSuccess, 
		    		  onError,
		    		  options);
		    }else{
		      alert("Sorry, browser does not support geolocation!");
		    }
		// onSuccess Callback
    	//   This method accepts a `Position` object, which contains
    	//   the current GPS coordinates
	});
	
	$("#store-locator-form").submit(function(evt) {
		var $input = $(this).find("input[name=origin]");
		if($input.val() == "" || $input.val() == "Enter Zip or City, State") {
			$inputError = $input.parent().find(".input-error");
			if(!$inputError.length) {
				$inputError = $("<span class=\"input-error\" />");
				$input.parent().append($inputError);
			}
			$inputError.html("This field is required.");

			return false;
		}

		return true;
	});
	
	$(document).delegate("#choice_estabelecimento", "pageinit", function(){
		
	 
		alert('Localizar estabelecimento');
		/**
		 * Carrega os estabelecimentos da cidade/endereco selecionada
		 */
		cordova.exec(
				function(winReturn) {
					var obj = JSON.parse(winReturn, function (key, value) {
		       		    var type;
		       		    if (value && typeof value === 'object') {
		       		        type = value.type;
		       		        if (typeof type === 'string' && typeof window[type] === 'function') {
		       		            return new (window[type])(value);
		       		        }
		       		    }
		       		    return value;
       		  		});
       		  		if (obj.nameValuePairs.estabelecimentos.values){
       		  			/**
       		  			 * Preenche estabelecimentos com o conteudo retornado do servidor
       		  			 */
       		  			var estabelecimentos = obj.nameValuePairs.estabelecimentos.values;
	       		  		for (var i=0; i <= estabelecimentos.length; i++){
	       	    			var estabelecimento = estabelecimentos.values[i];
	       	    			//alert('nome: '+cidade.nome+', qtd: '+cidade.quantidadeEmpresa);
	       	    			var strHtml = 
	       	    					"<li >" +
	       	    					"<a href='detalhe_estabelecimento.html' ide='"+estabelecimento.id+"' data-transition='slidedown'> " +
	       	        					"<img src='"+estabelecimento.imagem+"'/> " +
	       	        					"<h2> "+estabelecimento.nome+ "</h2> " +
	       	        					"<p class='classement four'>"+estabelecimento.avaliacao+" stars  </p>" +
	       	    					"</a>" +
	       	    					"</li>";
	       					$("ul#listEstabelecimentos").append(strHtml);
	       					$("ul#listEstabelecimentos").listview('refresh');
	       	    		}
       		  		}
       		}, function(error) {
	       		alert('nothing');
	       	}, "Localizacao", "busca_cep", [36026450]);
				
		/**
		 * Atribui o click no item da lista
		 */
		$("ul#listEstabelecimentos a").live('click',function(){
			alert('Buscando informacoes da empresa selecionada: '+$(this).attr('ide'));
			//empresaCurrent = new Empresa($(this).attr('ide'));
			//alert('getCardapio: '+ empresaCurrent);
		});
	});
	
	
	$(document).delegate("#restau","pageinit", function(){
		
		alert('Informaçoes sobre a empresa');
		$("div#buy_buttons a").click(function(){
			alert(empresaCurrent);
			if (empresaCurrent) {
				alert(empresaCurrent.getCardapio());
			}
		});
	});
	
	$( document ).delegate("#content_item", "pageinit", function() {
		alert('fortypage');
		
		if (empresaCurrent) empresaCurrent.getCardapio();
		
		$(".btnRemover").click(function(){
  			var id = $(this).closest('div.content_button').attr('id');
	   		id = id.reverse().split("_")[0];
	   		var qtdItem = parseInt($("#quantidade_"+id).val()) - 1;
	   		(qtdItem>0)?$("#quantidade_"+id).val(qtdItem):$("#quantidade_"+id).val(0);
	   	});
	   	
	   	$(".btnAdicionar").click(function(){
	   		var id = $(this).closest('div.content_button').attr('id');
	   		id = id.reverse().split("_")[0];
	   		var qtdItem = parseInt($("#quantidade_"+id).val()) + 1;
	   		(qtdItem>0)?$("#quantidade_"+id).val(qtdItem):$("#quantidade_"+id).val(0);
	   	});
	   	
	   	$("a.adicionar-cart").click(function(){
			if(!this.carrinhoCliente) {
				this.carrinhoCliente = new Carrinho();
				alert('Nenhum carrinho associado');
			}else{
				this.carrinhoCliente.adicionaItem(idItem);
			}
		});
		
	   	
	});
	
	
	
};


String.prototype.reverse= function(){
	var s= '', L= this.length;
	while(L){
		s+= this[--L];
	}
	return s;
}
