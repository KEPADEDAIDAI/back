package com.example.back.server;

import com.example.back.entity.Tes;
import com.example.back.repository.TesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesService {
    private TesRepository tesRepository;
    public List<Tes> findByTxtPages(PageRequest pageRequest, String txt)
    {
        Page<Tes> page = tesRepository.getTessByTxt(pageRequest, txt);
        return page.getContent();
    }
}
