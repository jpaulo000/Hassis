$(document).ready(function(){
	$('#cadastro').validate({
		rules: {
			nomeAssistido: {
				required: true
			},
			cpf:{
				required: false,
				cpfBR: true,
				digits: true,
				minlength: 11				
			},
			dtNascimento:{
	    		dateBR: true
	    	},
	    	cidade:{
				required: true
			},
			estado:{
				required: true
			},
			cep:{
				postalcodeBR: true
			},
			email:{
				email: true
			},
			numeroFilhos:{
				number: true
			},
			quandoComecou:{
				number:true
			}
		  
	    },
	    messages:{
	    	nomeAssistido:{
	    		required: "O nome do assistido &eacute; necess&aacute;rio."
	    	},
	    	cpf:{
	    		cpfBR: "Por favor, especifique um n&uacute;mero de CPF v&aacute;lido.",
	    		digits: "Por favor, insira apenas n&uacute;meros.",
	    		minlength: $.validator.format("Por favor, o CPF deve conter {0} d&iacute;gitos.")
	    	},
	    	dtNascimento:{
	    		dateBR: "Informe uma data v&aacute;lida."
	    	},
	    	cidade:{
	    		required: "O nome da cidade &eacute; necess&aacute;rio."
	    	},
	    	estado:{
	    		required: "O nome do estado &eacute; necess&aacute;rio."
	    	},
	    	cep: {
	    		postalcodeBR:"Informe um CEP v&aacute;lido."
	    	},
	    	email:{
	    		email: "Por favor, forne&ccedil;a um endere&ccedil;o de email v&aacute;lido."
	    	},
	    	numeroFilhos:{
				number: "Por favor, insira um n&uacute;mero v&aacute;lido."
			},
			quandoComecou:{
				number:"Por favor, insira um n&uacute;mero v&aacute;lido."
			}
	    	
    	},
		highlight: function(element) {
			$(element).closest('.control-group').removeClass('success').addClass('error');
		},
		success: function(element) {
			element
				.text('OK!').addClass('valid')
				.closest('.control-group').removeClass('error').addClass('success');
			}
	  });

}); // end document.ready