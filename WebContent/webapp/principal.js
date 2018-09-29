/**
 * 
 */
function popularTabela() {
    $.ajax({
    	method: "GET",
        url: "http://localhost:8080/ProjetoRest/rest/pessoas"
    }).then(function(data) {
       populaAbaItens(data)
       
    });
};

function populaAbaItens(result) {
    var dataSet = [];
    $.each(result, function(index, data) {
       dataSet.push([
              data.id,
              data.nome,
              data.cpf,
              data.rg, 
              data.numContato,
              null
       ]);
    })
    var table = $("#table").DataTable({
    	select: 'single',
    	paging: false,
        scrollY: 400,
          data: dataSet,
          columns: [
                 { title: 'ID' },
                 { title: 'Nome' },
                 { title: 'CPF' },
                 { title: 'RG' },
                 { title: 'Numero Contato' },
                 { title: 'Opções'}
                 
          ]
    });
    const tr = document.querySelectorAll('tbody > tr');
    var td;
    for (var i = 0; i < tr.length; i++){
    	td = tr[i].getElementsByTagName('td');
    	td[5].innerHTML = "<input type='button' value='Excluir' id='btnexcluir' onclick='excluirPessoa(this);'>";
    }
}

function excluirPessoa(data){
	parente = data.parentElement;
	irmao = parente.previousSibling.previousElementSibling.previousSibling.previousSibling.previousSibling;
	
	 $.ajax({
		    type: 'POST',
		    url: "http://localhost:8080/ProjetoRest/rest/pessoas/remover",

		    data: 'id='+irmao.innerText,
		    contentType: "application/x-www-form-urlencoded",
		    crossDomain : true,
		    dataType: 'application/json',

		});
	 linha = parente.parentElement;
	 linha.style.display = "NONE";
	 //window.location.reload();
}

function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
function chamar(){
	window.location.reload();
}
//function addElement () { 
//	  const newDiv = document.createElement("div");
//	  newDiv.setAttribute("id", "divdelete"); 
//
//	  const currentDiv = document.getElementById("table_filter"); 
//	  currentDiv.appendChild(newDiv);
//	}


