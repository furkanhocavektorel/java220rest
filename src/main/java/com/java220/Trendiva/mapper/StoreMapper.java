package com.java220.Trendiva.mapper;

import com.java220.Trendiva.dto.request.StoreSaveRequestDto;
import com.java220.Trendiva.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper( StoreMapper.class );

    Store toStore(StoreSaveRequestDto dto);
}
