package com.G01.onlineFishAuction.restApi;

import com.G01.onlineFishAuction.entities.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auction")
public class AuctionController {
    private IAuctionService iAuctionService;
    @Autowired
    public AuctionController(IAuctionService iAuctionService) {
        this.iAuctionService = iAuctionService;
    }

    @GetMapping("/fetchAuctions")
    public List<Auction> getAllAuctions(){
        return iAuctionService.getAll();
    }
}
