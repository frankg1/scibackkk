package com.fdu.sciback.service;

import com.fdu.sciback.entity.DblpEntity;
import java.util.List;

public interface IDblpService {
    List<DblpEntity> queryAll();

    DblpEntity getPaperById(String id);

}
