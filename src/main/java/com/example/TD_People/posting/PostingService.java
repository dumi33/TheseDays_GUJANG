package com.example.TD_People.posting;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostingService {
    private final PostingDao postingDao;
    private final PostingProvider postingProvider;

    @Autowired
    public PostingService(PostingDao postingDao, PostingProvider postingProvider) {
        this.postingDao = postingDao;
        this.postingProvider = postingProvider;

    }






}
