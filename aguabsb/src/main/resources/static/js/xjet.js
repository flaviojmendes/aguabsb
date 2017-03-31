angular.module('xjet', [])
    .controller('home', function($scope, $http) {
        $http.get('/searchFlights/').success(function(data) {
            $scope.flights = data;
        })
    });
