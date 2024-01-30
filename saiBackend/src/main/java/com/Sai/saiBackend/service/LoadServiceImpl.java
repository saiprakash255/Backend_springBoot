package com.Sai.saiBackend.service;

import com.Sai.saiBackend.dao.LoadDao;
import com.Sai.saiBackend.entity.Load;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoadServiceImpl implements LoadService{

    @Autowired
    private LoadDao loadDao;

    @Override
    public List<Load> getLoads(){
        return loadDao.findAll();
    }

    @Override
    public Load getLoad(long shipperId) {
        return (Load)(loadDao).getReferenceById(shipperId);
    }

    @Override
    public Load addLoad(Load load) {
        loadDao.save(load);
        return load;
    }

    @Override
    public Load updateLoad(long shipperId) {
        Load entity = loadDao.getOne(shipperId);
        return (Load)(loadDao).save(entity);
    }

    @Override
    public void deleteLoad(long shipperId) {
        Load entity = loadDao.getOne(shipperId);
        loadDao.delete(entity);
    }


}
