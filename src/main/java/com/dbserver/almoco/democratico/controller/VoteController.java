package com.dbserver.almoco.democratico.controller;

import com.dbserver.almoco.democratico.model.HungryUser;
import com.dbserver.almoco.democratico.model.Restaurant;
import com.dbserver.almoco.democratico.service.impl.RestaurantServiceImpl;
import com.dbserver.almoco.democratico.service.impl.VoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/votes")
@CrossOrigin({"http://localhost:3000"})
public class VoteController {
    private VoteServiceImpl voteService;
    private RestaurantServiceImpl restaurantService;
    @Autowired
    public VoteController(VoteServiceImpl voteService, RestaurantServiceImpl restaurantService) {
        this.voteService = voteService;
        this.restaurantService = restaurantService;
    }

    @PostMapping("/register")
    public void vote(@RequestBody VoteRequest voteRequest, HungryUser user) {
        Restaurant restaurant = restaurantService.findById(voteRequest.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found."));
        voteService.vote(user, restaurant, LocalDateTime.now());
    }

    public static class VoteRequest {
        private Long restaurantId;

        public Long getRestaurantId() {
            return restaurantId;
        }

        public void setRestaurantId(Long restaurantId) {
            this.restaurantId = restaurantId;
        }
    }
}
