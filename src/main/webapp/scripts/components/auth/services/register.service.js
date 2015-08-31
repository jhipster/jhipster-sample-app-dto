'use strict';

angular.module('sampledtoApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


