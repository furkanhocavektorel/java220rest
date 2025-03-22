package com.java220.Trendiva.service;

import com.java220.Trendiva.dto.request.StoreSaveRequestDto;
import com.java220.Trendiva.entity.Store;
import com.java220.Trendiva.exception.custom.TokenException;
import com.java220.Trendiva.mapper.StoreMapper;
import com.java220.Trendiva.repository.IStoreRepository;
import com.java220.Trendiva.util.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final IStoreRepository repository;
    private final JwtTokenManager jwtTokenManager ;


    public void save(StoreSaveRequestDto dto){

        Optional<Long> id=jwtTokenManager.getIdByToken(dto.getToken());

        // isEmpty metodu null kontrolü yapmaz

        if ( id==null || id.isEmpty()){
            throw new TokenException("tokendan boş id geldi",2005);
        }

        Store store= StoreMapper.INSTANCE.toStore(dto);

        repository.save(store);

    }

}
