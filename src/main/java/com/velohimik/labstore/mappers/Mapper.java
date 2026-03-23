package com.velohimik.labstore.mappers;

public interface Mapper<Dto, Entity> {

    Entity mapToEntity(Dto dto);

    Dto mapToDto(Entity entity);
}
