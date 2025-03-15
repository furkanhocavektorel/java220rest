package com.java220.Trendiva.service;

import com.java220.Trendiva.dto.request.StoreSaveRequestDto;
import com.java220.Trendiva.entity.Store;
import com.java220.Trendiva.mapper.StoreMapper;
import com.java220.Trendiva.repository.IStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final IStoreRepository repository;


    public void save(StoreSaveRequestDto dto){

        Store store= StoreMapper.INSTANCE.toStore(dto);

        repository.save(store);

    }

}
