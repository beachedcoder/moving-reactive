package com.roi.demos.movingreactive.dao;

import com.roi.demos.movingreactive.dto.ItemDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ItemDao {

    public List<ItemDto> findAllItems(){
        return IntStream.rangeClosed(1,20)
                .peek(ItemDao::daoDelay)
                .peek(i-> System.out.printf("processing item %s%n",i))
                .mapToObj(i->new ItemDto(i,"SyncItem"))
                .collect(Collectors.toList());
    }

    private static void daoDelay(int i) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
