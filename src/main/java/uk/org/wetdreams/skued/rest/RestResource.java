package uk.org.wetdreams.skued.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.org.wetdreams.skued.service.SKUedService;
import uk.org.wetdreams.skued.service.domain.MarketReqirement;
import uk.org.wetdreams.skued.service.domain.Order;
import uk.org.wetdreams.skued.service.domain.PurchaseOrder;

@Component
@Path("/rest")
public class RestResource {

    Logger log = Logger.getLogger(RestResource.class);

    @Autowired
    private SKUedService service;

    @GET
    @Path("/marketRequirement")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<MarketReqirement> marketReqirements() {
        return service.getAllMarketRequirements();
    }

    @GET
    @Path("/order")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Order> getOrder() {
        log.info("Order requested");
        return service.getAllOrders();
    }

    @POST
    @Path("/order")
    @Consumes(MediaType.APPLICATION_JSON)
    public void postOrder(Order order) {
        log.info("Order upserted: " + order);
        service.addOrder(order);
    }

    @DELETE
    @Path("/order/{market}")
    public void deleteOrder(@PathParam("market") String market) {
        log.info("Order deleted: " + market);
        service.deleteOrder(new Order(market,0));
    }

    @GET
    @Path("/purchaseOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<PurchaseOrder> purchaseOrders() {
        return service.generatePurchaseOrders();
    }

}