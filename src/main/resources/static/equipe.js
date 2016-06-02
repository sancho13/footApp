/**
 * Created by Marseillais on 01/06/2016.
 */
var app = angular.module('helloJS', []);





// Déclarer le service EquipeService pour centraliser les accès aux APIs
app.factory('EquipeService', function ($http) {

    // Une factory doit renvoyer un object qui contient les méthodes du service
    return {

        // La méthode qui récupère la liste des équipes
        list: function () {
            return $http.get("/api/equipes");
        },

        // La méthode qui récupère une équipe par son ID
        get: function (equipeId) {
            return $http.get("/api/equipes/" + equipeId);
        }
    };

});

// Ce controlleur dépend de $scope et de EquipeService pour pouvoir appeler les méthodes list et get
app.controller('Hello', function ($scope, EquipeService) {

    $scope.test= function()
    {
            console.log("Test ngClick");
    }

    // Get la liste des équipes
    EquipeService.list().success(function (data) {

        console.log('Retour de EquipeService.list():');
        console.log(data);

        $scope.equipes = data;
    });

    // Get l'équipe numéro 1
    EquipeService.get(1).success(function (data) {
        console.log('Retour de EquipeService.get(1):');
        console.log(data);

        $scope.equipe = data;
    });

});