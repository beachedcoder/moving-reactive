package com.roi.demos.movingreactive.ctlr;

import com.roi.demos.movingreactive.dto.ItemDto;
import com.roi.demos.movingreactive.svc.ItemService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService svc;

    public ItemController(ItemService svcRef) {
        this.svc = svcRef;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDto> getItems(){
        return this.svc.getCurrentItems();
    }

}
