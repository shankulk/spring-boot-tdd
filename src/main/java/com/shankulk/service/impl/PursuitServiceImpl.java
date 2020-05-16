package com.shankulk.service.impl;

import com.shankulk.dao.PursuitDao;
import com.shankulk.model.Pursuit;
import com.shankulk.service.PursuitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PursuitServiceImpl implements PursuitService {

    private final PursuitDao pursuitDao;

    @Override
    public Pursuit createPursuit() {
        var pursuit = Pursuit.createPursuit();
        pursuitDao.save(pursuit);
        return pursuit;
    }
}
