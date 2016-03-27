(function() {

var App = angular.module('SKUedApp', []);

App.controller('SKUedController', function($scope, $http) {

  var skuService = this;
  skuService.orders = [];
  skuService.purchaseOrders = [];
  skuService.marketRequirements = [];

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

    this.loadRequirements = function() {
        $http.get('/servlet/rest/marketRequirement')
               .then(function(res){
                  skuService.marketRequirements = res.data;
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

   this.postRequirement = function(market, marketGroup, skuType) {
        $http.post('/servlet/rest/marketRequirement',{market:market, marketGroup: marketGroup, skuType: skuType})
                       .then(function(res){skuService.loadRequirements();});
   }

  this.loadOrders();
  this.loadPurchaseOrders();
  this.loadRequirements();

    this.tab = 2;

    this.setTab = function(newValue){
      this.tab = newValue;
      if(newValue === 3){this.loadPurchaseOrders()}
    };

    this.isSet = function(tabName){
      return this.tab === tabName;
    };

});


})();
