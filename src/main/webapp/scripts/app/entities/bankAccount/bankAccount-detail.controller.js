'use strict';

angular.module('sampledtoApp')
    .controller('BankAccountDetailController', function ($scope, $rootScope, $stateParams, entity, BankAccount, User, Operation) {
        $scope.bankAccount = entity;
        $scope.load = function (id) {
            BankAccount.get({id: id}, function(result) {
                $scope.bankAccount = result;
            });
        };
        $rootScope.$on('sampledtoApp:bankAccountUpdate', function(event, result) {
            $scope.bankAccount = result;
        });
    });
