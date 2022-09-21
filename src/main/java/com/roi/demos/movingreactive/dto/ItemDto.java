package com.roi.demos.movingreactive.dto;

import java.util.Objects;
import java.util.UUID;

public class ItemDto {
    private UUID id;
    private int catalogId;
    private String title;

    public ItemDto() {
        this.id = UUID.randomUUID();
    }

    public ItemDto(int catalogId, String title) {
        this.catalogId = catalogId;
        this.title = title + " " + catalogId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemDto itemDto)) return false;
        return getCatalogId() == itemDto.getCatalogId() && getId().equals(itemDto.getId()) && getTitle().equals(itemDto.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCatalogId(), getTitle());
    }
}
