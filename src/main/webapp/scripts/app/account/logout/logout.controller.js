'use strict';

angular.module('sampledtoApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
