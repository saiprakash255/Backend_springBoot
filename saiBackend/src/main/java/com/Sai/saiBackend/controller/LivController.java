package com.Sai.saiBackend.controller;

import com.Sai.saiBackend.entity.Load;
import com.Sai.saiBackend.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivController {

    @Autowired
    private LoadService loadService;

    @GetMapping("/loads")
    public List<Load> getLoads(){
        return this.loadService.getLoads();
    }

    @GetMapping(path = "/loads/{shipperId}")
//    public Load getLoad(@PathVariable String shipperId){
//        return this.loadService.getLoad(Long.parseLong(shipperId));
//    }
    public ResponseEntity<HttpStatus> getLoad(@PathVariable String shipperId){
        try{
            this.loadService.getLoad(Long.parseLong(shipperId));
            return new ResponseEntity<>(HttpStatus.OK);
            }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(path = "/loads", consumes ="application/json")
    public Load addLoad(@RequestBody Load load){

        return this.loadService.addLoad(load);
    }

    @PutMapping(path = "/loads/{shipperId}")
//    public Load updateLoad(@RequestBody String shipperId){
//        return this.loadService.updateLoad(Long.parseLong(shipperId));
//    }
    public ResponseEntity<HttpStatus> updateLoad(@PathVariable String shipperId){
        try{
            this.loadService.updateLoad(Long.parseLong(shipperId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/loads/{shipperId}")
    public ResponseEntity<HttpStatus> deleteLoad(@PathVariable String shipperId){
        try{
            this.loadService.deleteLoad(Long.parseLong(shipperId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}
