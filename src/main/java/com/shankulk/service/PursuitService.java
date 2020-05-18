package com.shankulk.service;

import com.shankulk.model.Objective;
import com.shankulk.model.Pursuit;

public interface PursuitService {

	Pursuit createPursuit(String pursuitName, Objective objective);
}
