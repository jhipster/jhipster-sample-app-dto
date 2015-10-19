 'use strict';

angular.module('sampleDTOApp')
    .factory('notificationInterceptor', function ($q, AlertService) {
        return {
            response: function(response) {
                var alertKey = response.headers('X-sampleDTOApp-alert');
                if (angular.isString(alertKey)) {
                    AlertService.success(alertKey, { param : response.headers('X-sampleDTOApp-params')});
                }
                return response;
            }
        };
    });
