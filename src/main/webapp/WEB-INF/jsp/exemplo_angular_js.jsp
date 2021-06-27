
<html>
<!-- adicao do angular na pagina -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<body>


<script>
// busca o modulo
var app = angular.module('myApp', []);

// busca o controlador
app.controller('myCtrl', function($scope,$http) {   
	
	$scope.dados = "";
	
	// criacao do um variavel vetor
   $scope.records = [
       {
            "nome" : "Lucas Oliveira",
            "cidade" : "Gravatai",
            "pais": "Brasil"
        },{
            "nome" : "Maria Soares",
            "cidade" : "Cachoeirinha",
            "pais": "Brasil"
        },{
            "nome" : "Pedro da Silva",
            "cidade" : "Canoas",
            "pais": "Brasil"
        }
    ];
	
	// craicao de uma funcao;
	$scope.addItem = function () {
		
		$scope.records.push({nome:$scope.records.nome,cidade:$scope.records.cidade,pais:$scope.records.pais});
	
		$scope.records.nome = "";
		$scope.records.cidade="";	
		$scope.records.pais="";
		
  }
  
  $scope.buscaDados = function() {
	$http({

	method: 'GET',

	url: 'dados.html',

	}).then(function success(response) {
		$scope.dados = response.data;

	}, function error(response) {
		$scope.dados = "ERROR ao buscar os dados. " + response.data;

	});

	}
  
});


</script>

<!-- declaracao do modulo e contralador -->
<div ng-app="myApp" ng-controller="myCtrl">
<table>
<tr>
	<td>
	Nome: 
	</td>
	<td>
	<input type="text" ng-model="records.nome"><br>
	</td>
</tr>
	<tr>
	<td>
	cidade: 
	</td>
	<td>
	<input type="text" ng-model="records.cidade"><br>
	</td>
</tr>
	<tr>
	<td>
	pais: 
	</td>
	<td>
	<input type="text" ng-model="records.pais"><br>
	</td>
</tr>
<table>
<button ng-click="addItem()">Adicionar</button>
<br>
<br>
Você está digitando o nome : {{records.nome }} 
<br>
Você está digitando a cidade: {{records.cidade }}
<br>
Você está digitando o país: {{records.pais }}

<br><br>

<table  border="1">
    <tr>
		<td>Nome</td>
		<td>Cidade</td>
		<td>Cidade</td>
	</tr>
	<tr ng-repeat="x in records">
        <td>{{x.nome}}</td>
        <td>{{x.cidade}}</td>
        <td>{{x.pais}}</td>
    </tr>
</table>

<br>
<br>


<button ng-click="buscaDados()">Busca dados via GET no servidor</button> 
<br>
{{dados}}

</div>







</body>
</html>
