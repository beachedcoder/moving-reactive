package com.roi.demos.movingreactive.svc;

import com.roi.demos.movingreactive.dao.ItemDao;
import com.roi.demos.movingreactive.dto.ItemDto;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class ItemService {
    private final ItemDao dao;

    private long start, stop;

    public ItemService(ItemDao daoRef) {
        this.dao = daoRef;
    }

    public List<ItemDto> getCurrentItems(){
        start = System.currentTimeMillis();
        List<ItemDto> itemList = dao.findAllItems();
        stop = System.currentTimeMillis();
        System.out.printf("Svc call duration: %s%n", Duration.ofMillis(stop-start));
        return itemList;
    }

}
