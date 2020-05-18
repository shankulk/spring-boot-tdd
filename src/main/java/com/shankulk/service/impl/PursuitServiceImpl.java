package com.shankulk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankulk.dao.PursuitDao;
import com.shankulk.model.Objective;
import com.shankulk.model.Pursuit;
import com.shankulk.service.PursuitService;

@Service
//@RequiredArgsConstructor
public class PursuitServiceImpl implements PursuitService {

	private final PursuitDao pursuitDao;

	/**
	 * @param pursuitDao
	 */
	@Autowired
	public PursuitServiceImpl(PursuitDao pursuitDao) {
		super();
		this.pursuitDao = pursuitDao;
	}

	@Override
	public Pursuit createPursuit(String pursuitName, Objective objective) {
		var pursuit = Pursuit.createPursuit(objective);
		pursuitDao.save(pursuit);
		return pursuit;
	}

}
