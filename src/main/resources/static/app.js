(function() {

var App = angular.module('SKUedApp', []);

App.controller('SKUedController', function($scope, $http) {

  var skuService = this;
  skuService.orders = [];
  skuService.purchaseOrders = [];

  this.loadOrders = function() {
      $http.get('/servlet/rest/order')
             .then(function(res){
                skuService.orders = res.data;
              });
  }

    this.loadPurchaseOrders = function() {
        $http.get('/servlet/rest/purchaseOrders')
               .then(function(res){
                  skuService.purchaseOrders = res.data;
                });
    }

   this.postOrder = function(marketName, qty) {
        $http.post('/servlet/rest/order', {market: marketName, qty: qty})
                       .then(function(res){skuService.loadOrders();});
   }

   this.deleteOrder = function(marketName) {
        $http.delete('/servlet/rest/order/'+marketName)
                       .then(function(res){skuService.loadOrders();});


   }

  this.loadOrders();
  this.loadPurchaseOrders();

    this.tab = 2;

    this.setTab = function(newValue){
      this.tab = newValue;
    };

    this.isSet = function(tabName){
      return this.tab === tabName;
    };

});


})();
