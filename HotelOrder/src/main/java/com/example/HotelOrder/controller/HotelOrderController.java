package com.example.HotelOrder.controller;

import com.example.HotelOrder.Exception.IDNotFoundException;
import com.example.HotelOrder.entity.Hotel;
import com.example.HotelOrder.entity.Order;
import com.example.HotelOrder.repository.HotelRepo;
import com.example.HotelOrder.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelOrderController {
    @Autowired
    private HotelRepo hotelrepo;
    @Autowired
    private OrderRepo orderrepo;
    @PostMapping("/addhotel")
    public ResponseEntity<Hotel>createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.ok().body(hotelrepo.save(hotel));
    }
    @PostMapping("/addorder")
    public ResponseEntity<Order>createOrder(@RequestBody Order order){
        return ResponseEntity.ok().body(orderrepo.save(order));
    }
    @GetMapping("/gethotel")
    public ResponseEntity<List<Hotel>>getallHotel(){
        return ResponseEntity.ok().body(hotelrepo.findAll());
    }
    @GetMapping("/getorder")
    public ResponseEntity<List<Order>>getallOrder(){
        return ResponseEntity.ok().body(orderrepo.findAll());
    }
    @GetMapping("/gethotel/{id}")
    public ResponseEntity<Hotel>getByHotelId(@PathVariable Integer id){
        Optional<Hotel>h1=hotelrepo.findById(id);
        if(h1.isPresent()) {
            return ResponseEntity.ok().body(hotelrepo.findById(id).orElse(null));
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/getorder/{id}")
    public ResponseEntity<Order>getByOrderId(@PathVariable Integer id){
        return ResponseEntity.ok().body(orderrepo.findById(id).orElse(null));
    }
    @DeleteMapping("/deletehotel/{id}")
    public ResponseEntity<String>deleteByHotelId(@PathVariable Integer id)throws IDNotFoundException{
        Optional<Hotel>h2=hotelrepo.findById(id);
        if(h2.isPresent()) {
            hotelrepo.deleteById(id);
            return ResponseEntity.ok().body("deleted hotelid");
        }else{
            throw new IDNotFoundException("hotel with this id is not found:");
        }

    }
    @DeleteMapping("/deleteorder/{id}")
        public ResponseEntity<String>deleteByOrderId(@PathVariable Integer id){
            orderrepo.deleteById(id);
            return ResponseEntity.ok().body("deleted orderid:");

        }
    @PutMapping("/updatehotel/{id}")
    public ResponseEntity<Hotel>updateByHotelId(@RequestBody Hotel hotel,@PathVariable Integer id){
        Hotel old=null;
        Optional<Hotel>h=hotelrepo.findById(id);
        if(h.isPresent()) {
            old = h.get();
            old.setId(id);
            old.setHotelName(hotel.getHotelName());
            return ResponseEntity.ok().body(hotelrepo.save(old));
        }else{
            throw new IDNotFoundException("hotel with this id not found, cannot update");
        }
    }
    @PutMapping("/updateorder/{id}")
    public ResponseEntity<Order>updateByOrderId(@RequestBody Order order, @PathVariable Integer id){
        Order old=null;
        Optional<Order>o=orderrepo.findById(id);
        old=o.get();
        old.setId(id);
        old.setOrderName(order.getOrderName());
        return ResponseEntity.ok().body(orderrepo.save(old));
    }

}
