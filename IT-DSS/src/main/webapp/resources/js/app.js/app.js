var app = angular.module('myApp',['ngTable','ngCsv','angularjs-dropdown-multiselect']);


//Basae URL and Port for Application

var getUrl = window.location;
var baseUrl = getUrl.protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
console.log(baseUrl+ "/");
app.value('url', baseUrl + "/");


/*myApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);*/