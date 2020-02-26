package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.model.Sezona;
import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.service.SezoniService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sezoni")
@CrossOrigin(origins = "http://localhost:3000")
public class SezoniController {

    private final SezoniService sezoniService;

    public SezoniController(SezoniService sezoniService) {
        this.sezoniService = sezoniService;
    }

    @GetMapping
    public List<Sezona> getSezoni() {
        return this.sezoniService.getAllSezoni();
    }

    @PostMapping
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Sezona createSezona(String godina
            , String pretsedatel) {
        return this.sezoniService.createSezona(godina, pretsedatel);
    }

    @GetMapping(path = "/{idSezona}/ligi")
    public List<Liga> findAllLigiInSezona(@PathVariable int idSezona){
        return this.sezoniService.getAllLigiInSezona(idSezona);
    }

    @GetMapping(path = "/{idSezona}/turniri")
    public List<Turnir> findAllTurniriInSezona(@PathVariable int idSezona){
        return this.sezoniService.getAllTurniriInSezona(idSezona);
    }

}
