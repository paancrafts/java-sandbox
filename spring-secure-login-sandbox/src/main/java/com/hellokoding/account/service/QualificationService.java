package com.hellokoding.account.service;

import java.util.List;

import com.hellokoding.account.model.Qualification;

public interface QualificationService {
	void save(Qualification qual);

    Qualification findById(long id);
    
    List<Qualification> getAllQualifications();
    
    void delete(Qualification qual);
}
