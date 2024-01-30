package com.Sai.saiBackend.service;

import com.Sai.saiBackend.entity.Load;

import java.util.List;

public interface LoadService {

    public List<Load> getLoads();

    public Load getLoad(long shipperId);

    public Load addLoad(Load load);

    public Load updateLoad(long shipperId);

    public void deleteLoad(long shipperId);
 }
