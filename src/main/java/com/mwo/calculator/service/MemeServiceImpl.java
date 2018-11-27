package com.mwo.calculator.service;

import java.util.ArrayList;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateusz
 */
@Service
public class MemeServiceImpl implements MemeService {

    ArrayList<String> memes;

    @Autowired
    public void setMemes() {
        memes = new ArrayList();
        memes.add("https://blog.praiseworthy.co/wp-content/uploads/2017/10/meme-twenty-four.png");
        memes.add("https://images6.memedroid.com/images/UPLOADED1/50c8732f45203.jpeg");
        memes.add("https://img.washingtonpost.com/news/the-intersect/wp-content/uploads/sites/32/2015/04/putin-meme.jpg");
    }
    
    @Override
    public String getRandomMemeUrl() {
        Random r = new Random();
        return memes.get(r.nextInt(memes.size()));
    }
    
}
