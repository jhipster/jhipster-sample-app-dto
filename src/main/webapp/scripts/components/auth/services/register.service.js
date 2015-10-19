'use strict';

angular.module('sampleDTOApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


